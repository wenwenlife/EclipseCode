package com.wen.secondDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class personTest {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean2.xml");
		person p = ac.getBean("chinese", Chinese.class);
		p.useAxe();
	}
}
