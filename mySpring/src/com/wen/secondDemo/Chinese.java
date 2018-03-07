package com.wen.secondDemo;

public class Chinese implements person {

	private Axe axe;

	public void setAxe(Axe axe) {
		this.axe = axe;
	}

	public void useAxe() {
		System.out.println(axe.chop());
	}

}
