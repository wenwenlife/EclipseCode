package com.wen.demo8;

public class man implements Person {

	@Override
	public void addUser() {
		System.out.println("addUser执行了");
	}

	public void initMethod() {
		System.out.println("初始化方法");
	}

	public void destroyMethod() {
		System.out.println("销毁方法");
	}
}
