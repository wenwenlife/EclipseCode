package com.wen.day0103;

public class equalsTest {
	String name;
	String id;

	public equalsTest(String name, String id) {
		this.name = name;
		this.id = id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	// 重写equals方法
	public boolean equals(Object obj) {
		// 判断两个对象是否是同一对象
		if (this == obj) {
			return true;
		}
		// 当当前对象属于equalsTest
		if (obj != null && obj.getClass() == equalsTest.class) {
			equalsTest objp = (equalsTest) obj;
			// 当id值相等的时候才相等
			if (this.getId().equals(objp.getId())) {
				return true;
			}
		}
		return false;
	}
}
