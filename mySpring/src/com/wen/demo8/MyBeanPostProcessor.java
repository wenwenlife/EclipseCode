package com.wen.demo8;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("初始化之前执行");
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("初始化后方法" + beanName);
		//loader:当前类的类加载器
		//interfaces代理类需要实现的所有接口
		return Proxy.newProxyInstance(
        		  bean.getClass().getClassLoader(), 
        		  bean.getClass().getInterfaces(), new InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						System.out.println("开启事务");
						Object obj = method.invoke(bean, args);
						System.out.println("结束事务");
						return obj;

					}});
	}
}
