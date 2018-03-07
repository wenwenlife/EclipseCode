package cn.strong.Bridge;

public abstract class AbstractClassNoodle {
	protected Peppery style;

	public AbstractClassNoodle(Peppery style) {
		this.style = style;
	}

	public abstract void eat();
}
