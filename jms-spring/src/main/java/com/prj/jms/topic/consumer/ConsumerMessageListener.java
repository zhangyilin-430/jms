package com.prj.jms.topic.consumer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * 消息监听者
 */
public class ConsumerMessageListener implements MessageListener {

	@Override
	public void onMessage(Message message) {
		TextMessage textmessage = (TextMessage) message;
		try {
			System.out.println("接受消息：" + textmessage.getText());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
