package com.wen.day0103;

public enum Gender {
	// MALE, FEMALE;
	// private String name;
	//
	// public void setName(String s) {
	// switch (this) {
	// case MALE:
	// if (s.equals("男")) {
	// this.name = s;
	// } else {
	// System.out.println("参数错误");
	// }
	// break;
	// case FEMALE:
	// if (s.equals("女")) {
	// this.name = s;
	// } else {
	// System.out.println("参数错误");
	// }
	// break;
	// }
	// }

	MALE("男"), FEMALE("女");
	private final String name;

	private Gender(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
}
