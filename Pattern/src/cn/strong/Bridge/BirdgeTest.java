package cn.strong.Bridge;

/**
 * 
 * 
 * @Description: 测试面条味道
 */
public class BirdgeTest {
	public static void main(String[] args) {
		// 辣味猪肉面
		AbstractClassNoodle pn = new PorkyNoodle(new PepperyStyle());
		pn.eat();
	}

}
