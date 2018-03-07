package cn.strong.Proxy;

public class GunDog implements Dog {

	@Override
	public void info() {
		System.out.println("我是蝴蝶犬");
	}

	@Override
	public void run() {
		System.out.println("蝴蝶犬在跑");
	}

}
