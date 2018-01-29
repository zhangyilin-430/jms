package com.prj.jms.queue.producer;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

/**
 * 生产者--发送队列消息实现类
 */
public class ProducerServiceImpl implements ProducerService {
	@Autowired
	JmsTemplate jmsTemplate;
	@Resource(name = "queueDestination")
	Destination destination;

	@Override

	public void sendMessage(final String message) {
		// 使用JmsTemplate发送消息
		jmsTemplate.send(destination, new MessageCreator() {
			// 创建一个消息
			@Override
			public Message createMessage(Session session) throws JMSException {
				TextMessage textMessage = session.createTextMessage(message);
				return textMessage;
			}
		});
		System.out.println("发送队列消息：" + message);
	}

}
