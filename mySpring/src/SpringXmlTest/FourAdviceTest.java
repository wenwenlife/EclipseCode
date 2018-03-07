package SpringXmlTest;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 
 * 
 * @Description: XML配置切面
 */
public class FourAdviceTest {
	public Object processTx(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("Around增强之前,开启事务");
		// 访问执行目标方法的参数
		Object[] args = jp.getArgs();
		// 当目标方法参数存在
		// 且第一个参数是字符串类型
		if (args[0] != null && args.length > 0 && args[0].getClass() == String.class) {
			args[0] = "增强的前缀" + args[0];
		}
		// 执行目标方法,并保存目标方法执行后得返回值
		Object rvt = jp.proceed(args);
		System.out.println("Around方法增强之后,模拟结束事务");
		if (rvt != null && rvt instanceof Integer) {
			rvt = (Integer) rvt * (Integer) rvt;
		}
		return rvt;

	}

}
