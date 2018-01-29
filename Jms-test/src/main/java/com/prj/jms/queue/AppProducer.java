package com.prj.jms.queue;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * 生产者——发送队列
 */
public class AppProducer {
	// private static final String url = "tcp://localhost:61616";
	// private static final String queueName = "queue-test";
	// 集群环境中
	private static final String url = "failover:(tcp://127.0.0.1:61617,tcp://127.0.0.1:61618)?randomize=true";
	private static final String queueName = "test";

	public static void main(String[] args) throws JMSException {
		// 1.创建连接工厂connectionFactory
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
		// 2.创建连接connection
		Connection connection = connectionFactory.createConnection();
		// 3.启动连接
		connection.start();
		// 4.创建会话
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		// 5.创建一个目标
		Destination destination = session.createQueue(queueName);
		// 6.创建一个生产者
		MessageProducer producer = session.createProducer(destination);

		for (int i = 0; i < 100; i++) {
			// 7.创建消息
			TextMessage textMessage = session.createTextMessage("test" + i);
			// 8.发布消息
			producer.send(textMessage);

			System.out.println("发送队列消息：" + textMessage.getText());
		}
		// 9.关闭连接
		connection.close();

	}

}
