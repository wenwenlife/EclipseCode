package cn.strong.Factory;

/**
 * 
 * 
 * @Description: 调用Printer方法输入数据并打印
 */
public class Computer {
	private OutPut out;

	public Computer() {
		System.out.println("我被创建了");
	}
	public Computer(OutPut out) {
		this.out = out;
	}

	// 模拟输入字符串方法
	public void keyIn(String msg) {
		out.getData(msg);
	}

	// 模拟打印的方法
	public void print() {
		out.out();
	}

	// public static void main(String[] args) {
	// OutputFactory opf = new OutputFactory();
	// Computer com = new Computer(opf.getOutput());
	// com.keyIn("吃饭");
	// com.print();
	// }
}
