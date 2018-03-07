package com.wen.demo4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class beanTest {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean4.xml");
		ExampBean bean = ac.getBean("exbean", ExampBean.class);
		System.out.println(bean.getA());
		System.out.println(bean.getB());
		ExampBean bean2 = (ExampBean) ac.getBean("exbean2", ExampBean.class);
		System.out.println(bean2.toString());
	}
}
