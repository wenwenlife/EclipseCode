package SpringAspectAnnotion;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 
 * @Description:切面类
 */

@Aspect
public class Myaspect {
	@Before("execution(* SpringAspectAnnotion.*.*(..))")
	public void s() {
		System.out.println("模拟权限");
	}
	// public void myBefore(JoinPoint joinPoint) {
	// System.out.println("前置通知: " + joinPoint.getSignature().getName());
	// }
	//
	// public void myAfterReturning(JoinPoint joinPoint, Object ret) {
	// System.out.println("后置通知 ： " + joinPoint.getSignature().getName() + " , -->"
	// + ret);
	// }
	//
	// public Object myAround(ProceedingJoinPoint joinPoint) throws Throwable {
	// System.out.println("前");
	// // 手动执行目标方法
	// Object obj = joinPoint.proceed();
	//
	// System.out.println("后");
	// return obj;
	// }
	//
	// public void myAfterThrowing(JoinPoint joinPoint, Throwable e) {
	// System.out.println("抛出异常通知 ： " + e.getMessage());
	// }
	//
	// public void myAfter(JoinPoint joinPoint) {
	// System.out.println("最终通知");
	// }
}
