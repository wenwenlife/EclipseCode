package com.wen.firstDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class teacherTest {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean1.xml");
		Teacher th = ac.getBean("teacher", Teacher.class);
		th.useS();
	}
}
