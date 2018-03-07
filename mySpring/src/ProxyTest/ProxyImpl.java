package ProxyTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyImpl {
	public static Service createService() {
		final Service service = new ServiceImpl();
		final Myaspect myaspect = new Myaspect();
		
		Service s = (Service) Proxy.newProxyInstance(ProxyImpl.class.getClassLoader(),
				service.getClass().getInterfaces(), new InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						myaspect.before();
						Object obj = method.invoke(service, args);
						myaspect.after();
						return obj;
					}
				});
		
		return s;
	}

}
