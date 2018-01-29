package com.prj.jms.queue.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 接受队列消息
 *
 */
public class AppConsumer {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/consumer.xml");

	}
}
