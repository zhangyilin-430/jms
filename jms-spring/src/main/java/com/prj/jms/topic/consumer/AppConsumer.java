package com.prj.jms.topic.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 接受主题消息
 *
 */
public class AppConsumer {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/consumer.xml");

	}
}
