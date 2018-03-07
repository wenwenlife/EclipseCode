package cn.strong.Factory;

/**
 * 
 * 
 * @Description: 生成Output对象
 */
public class OutputFactory {

	public OutPut getOutput() {
		return new Printer();
	}
}
