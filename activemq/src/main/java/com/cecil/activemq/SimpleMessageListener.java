/**
 * @ProjectName:
 * @Copyright: 2014 ShangHai DJ HealthUnion Systems Co., Ltd. All Right Reserved.
 * @address: http://www.djhealthunion.com/
 * @date: 2016-11-10 11:27
 * @Description:
 */
package com.cecil.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;
import java.util.List;

/**
 * @author LiMingChi 2016-11-10 11:27
 * @version V1.0
 */
@Component
public class SimpleMessageListener{


    @JmsListener(destination = "mailbox")
    @SendTo("mailbox2")
    public String receiveMailbox(Message message) {
        ObjectMessage msg = (ObjectMessage) message;
        try {
            List<Person> persons = (List<Person>) msg.getObject();
            Person person = (Person) persons.get(1);
            System.out.println(person.getName());
        } catch (JMSException e) {
            e.printStackTrace();
        }
        return "GOTCHA";
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