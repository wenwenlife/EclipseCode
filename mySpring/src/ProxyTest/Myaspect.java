package ProxyTest;

/**
 * 
 * @Description:切面类
 */
public class Myaspect {
	public void before() {
		System.out.println("before");
	}

	public void after() {
		System.out.println("after");
	}
}
