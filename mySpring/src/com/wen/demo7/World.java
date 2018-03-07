package com.wen.demo7;

import org.springframework.stereotype.Component;

@Component("World")
public class World implements Worlds {
	public void bar() {
		System.out.println("World的World方法");
	}
}
