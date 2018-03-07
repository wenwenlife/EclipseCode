package com.wen.demo8;

import java.lang.reflect.InvocationTargetException;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class demo8Test {
	@Test
	public void demo8test() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException {
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean8.xml");
		man m = ac.getBean("man", man.class);
		m.addUser();
	}
}
