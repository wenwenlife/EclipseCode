package com.wen.thridDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ListenerTest {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean3.xml");
		EmailEvent ee = new EmailEvent("test", "111111@163.com", "第一个邮箱");
		System.out.println(ee.getTimestamp());
		ac.publishEvent(ee);
	}
}
