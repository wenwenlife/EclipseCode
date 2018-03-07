package com.wen.demo7;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAspect {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean7.xml");
		Hello bean = ac.getBean("Hello", Hello.class);
		bean.foo();
		bean.addUser("李文", 18);
		World bean2 = ac.getBean("World", World.class);
		bean2.bar();
	}
}
