package SpringAOP;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 
 * @Description:切面类
 */
public class Myaspect implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		System.out.println("前");
		Object obj = mi.proceed();
		System.out.println("后");

		return obj;
	}
}
