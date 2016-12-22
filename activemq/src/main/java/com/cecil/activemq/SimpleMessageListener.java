/**
 * @ProjectName:
 * @Copyright: 2014 ShangHai DJ HealthUnion Systems Co., Ltd. All Right Reserved.
 * @address: http://www.djhealthunion.com/
 * @date: 2016-11-10 11:27
 * @Description:
 */
package com.cecil.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;
import java.io.IOException;
import java.util.List;

/**
 * @author LiMingChi 2016-11-10 11:27
 * @version V1.0
 */
@Component
public class SimpleMessageListener{

    @JmsListener(destination = "mailbox",containerFactory = "myListenerContainerFactory")
//    @SendTo("mailbox2")
    public void receiveMailbox(Message message) throws Exception{
        ObjectMessage msg = (ObjectMessage) message;
        try {
            List<Person> persons = (List<Person>) msg.getObject();
            Person person = (Person) persons.get(0);
            System.out.println(person.getName());
        } catch (JMSException e) {
            e.printStackTrace();
            throw new IOException(e);
        }

//        return "GOTCHA";
    }

    @JmsListener(destination = "mailbox2")
    public void receiveMailbox2(Message message) {
        TextMessage msg = (TextMessage) message;
        try {
            System.out.println(msg.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}