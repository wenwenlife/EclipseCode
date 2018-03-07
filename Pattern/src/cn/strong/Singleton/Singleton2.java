package cn.strong.Singleton;

/**
 * 
 * 
 * @Description: 饿汉式
 */
public class Singleton2 {
	// 创建对象
	private static Singleton2 instance = new Singleton2();

	// 构造器私有
	private Singleton2() {
	}

	// 提供公共静态访问方法
	public static Singleton2 getInstance() {
		return instance;
	}
}
