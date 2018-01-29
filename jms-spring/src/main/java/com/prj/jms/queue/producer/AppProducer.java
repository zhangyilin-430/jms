package com.prj.jms.queue.producer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.prj.jms.queue.producer.ProducerService;

/**
 * 发送队列消息
 */
public class AppProducer {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/producer.xml");
		ProducerService service = context.getBean(ProducerService.class);
		for (int i = 0; i < 100; i++) {
			service.sendMessage("test" + i);
		}
		context.close();
	}
}
