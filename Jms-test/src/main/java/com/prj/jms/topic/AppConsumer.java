package com.prj.jms.topic;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * 消费者——消费主题消息(需要提前订阅，要不接受不到)
 */
public class AppConsumer {
	private static final String url = "tcp://localhost:61616";
	private static final String topicName = "topic-test";

	public static void main(String[] args) {
		// 1.创建连接工厂connectionFactory
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
		try {
			// 2.创建连接connection
			Connection connection = connectionFactory.createConnection();
			// 3.启动连接
			connection.start();
			// 4.创建会话
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			// 5.创建一个目标
			Destination destination = session.createTopic(topicName);
			// 6.创建一个消费者
			MessageConsumer consumer = session.createConsumer(destination);
			// 7.创建一个监听器(异步接受)
			consumer.setMessageListener(new MessageListener() {
				@Override
				public void onMessage(Message message) {
					TextMessage textMessage = (TextMessage) message;
					try {
						System.out.println("接受消息：" + textMessage.getText());
					} catch (JMSException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			});
			//

			// 8.关闭连接
			// connection.close();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
