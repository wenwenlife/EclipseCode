package com.wen.demo7;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class JointPointTest {
	@Pointcut
  @Around("Execution(* com.wen.demo7.*.*(..))")
	public Object processTx(ProceedingJoinPoint jp) throws Throwable {

		System.out.println("Around增强:执行目标方法之前,模拟开始事务...");
		// 访问执行目标方法的参数
		Object[] args = jp.getArgs();
		// 当执行目标方法是字符串且第一个参数是字符串时
		if (args != null && args.length > 0 && args[0].getClass() == String.class) {
			// 修改目标方法,调用参数的第一个参数
			args[0] = "增加的前缀" + args[0];
		}
		// 执行目标方法,并保存目标方法执行后的返回值
		Object rvt = jp.proceed(args);
		System.out.println("@Around增强:执行方法后,模拟结束事务");
		if (rvt != null && rvt instanceof Integer) {
			rvt = (Integer) rvt * (Integer) rvt;
		}
		return rvt;

	}
  
}
