package com.wen.demo7;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AuthAspect {

	@Before("execution(* com.wen.demo7.*.*(..))")
	public void atuo() {
		System.out.println("模拟执行检查");
	}
}
