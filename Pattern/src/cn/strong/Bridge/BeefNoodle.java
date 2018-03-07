package cn.strong.Bridge;

public class BeefNoodle extends AbstractClassNoodle {

	public BeefNoodle(Peppery style) {
		super(style);
	}

	@Override
	public void eat() {
		System.out.println(super.style.style() + "牛肉面条");
	}

}
