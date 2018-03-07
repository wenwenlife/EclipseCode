package com.wen.demo6;

import java.util.List;
import java.util.Set;

@SuppressWarnings("all")
public class Chinese implements person {

	private Axe axe;
	private int age;
	private List schools;
	private Set axes;

	public Axe getAxe() {
		return axe;
	}
	public void setAxe(Axe axe) {
		this.axe = axe;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List getSchools() {
		return schools;
	}

	public void setSchools(List schools) {
		this.schools = schools;
	}

	public Set getAxes() {
		return axes;
	}

	public void setAxes(Set axes) {
		this.axes = axes;
	}

	public void useAxe() {
		System.out.println(axe.chop());
		System.out.println("age属性值" + age);
		System.out.println(schools);
		System.out.println(axes);
	}

}
