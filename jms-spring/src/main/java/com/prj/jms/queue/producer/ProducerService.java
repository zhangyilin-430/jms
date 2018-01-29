package com.prj.jms.queue.producer;

/**
 * 生产者--发送消息接口
 */
public interface ProducerService {
	void sendMessage(String message);

}
