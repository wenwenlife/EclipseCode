package com.wen.thridDemo;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class EmailNotifier implements ApplicationListener {

	@Override
	public void onApplicationEvent(ApplicationEvent evt) {

		if (evt instanceof EmailEvent) {
			EmailEvent ee = (EmailEvent) evt;
			System.out.println("需要发送邮件的接收地址" + ee.getAddress());
			System.out.println("需要发送邮件的邮件正文" + ee.getText());
		} else {
			System.out.println("其他事件" + evt);
		}
	}

}
