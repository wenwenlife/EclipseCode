package cn.strong.Proxy;

import java.lang.reflect.Proxy;

public class MyProxyFactory {
	public static Object getProxy(Object target) {
	  MyInvocationHandler handler =new MyInvocationHandler();
	  //为MyInvocationHandler设置target对象
	  handler.setTarget(target);
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);
  }
}
