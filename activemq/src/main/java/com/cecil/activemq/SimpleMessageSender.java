/**
 * @ProjectName:
 * @Copyright: 2014 ShangHai DJ HealthUnion Systems Co., Ltd. All Right Reserved.
 * @address: http://www.djhealthunion.com/
 * @date: 2016-11-10 11:48
 * @Description:
 */
package com.cecil.activemq;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * @author LiMingChi 2016-11-10 11:48
 * @version V1.0
 */
@Component
public class SimpleMessageSender {

    private JmsTemplate jmsTemplate;

    public void sendMessage(final String message) {
        jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage();
            }
        });
    }

}