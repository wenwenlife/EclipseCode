package cn.strong.Singleton;

/**
 * 
 * 
 * @Description: 懒汉式
 */
public class Singleton1 {
	// 使用一个类变量缓存创建的实例
	private static Singleton1 instance;

	// 构造器私有
	private Singleton1() {
	}

	// 提供公共静态访问方法
	public static Singleton1 getInstance() {
		if (instance == null) {
			instance = new Singleton1();
		}
		return instance;
	}
}
