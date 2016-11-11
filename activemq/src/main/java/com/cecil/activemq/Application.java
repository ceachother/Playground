/**
 * @ProjectName:
 * @Copyright: 2014 ShangHai DJ HealthUnion Systems Co., Ltd. All Right Reserved.
 * @address: http://www.djhealthunion.com/
 * @date: 2016-05-18 14:31
 * @Description:
 */
package com.cecil.activemq;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LiMingChi 2016-05-18 14:31
 * @version V1.0
 */
@SpringBootApplication
@EnableJms
public class Application {

    public static void main(String[] args){
        // Launch the application
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

        JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);

        // Send a message with a POJO - the template reuse the message converter
        System.out.println("Sending an email message.");
        final List<Person> persons = new ArrayList<Person>();
        persons.add(new Person("name1"));
        persons.add(new Person("name2"));
        jmsTemplate.send("mailbox", new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                ObjectMessage objectMessage = session.createObjectMessage();
                objectMessage.setObject((Serializable) persons);
                return objectMessage;
            }
        });
        System.out.println("FINISH");
    }

}