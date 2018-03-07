package com.wen.demo7;

import org.springframework.stereotype.Component;

@Component("Hello")
public class Hello implements Hellow {
	public void foo() {
		System.out.println("执行foo方法");
	}

	public int addUser(String name, int i) {
		System.out.println("addUser添加名字方法" + name);
		return 20;
	}

}
