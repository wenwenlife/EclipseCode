package cn.strong.Bridge;

public class PorkyNoodle extends AbstractClassNoodle {

	public PorkyNoodle(Peppery style) {
		super(style);
	}

	@Override
	public void eat() {
		System.out.println(super.style.style() + "猪肉面条");
	}

}
