package cn.strong.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler{

	//需要被代理的对象
	private Object target;
	public void setTarget(Object target) {
		this.target=target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		TxUtil tx = new TxUtil();
		tx.beginTx();
		Object result = method.invoke(target, args);
		tx.endTx();
		return result;
	}
}
