package com.wen.demo4;

public class ExampBean {
	private int a;
	private double b;
	private String name;

	public ExampBean() {

	}
	public ExampBean(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ExampBean [name=" + name + "]";
	}
	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}
}
