package com.wen.day0103;

public class danli {
	private static danli instance;

	public danli() {
	}

	public static danli getIntance() {
		if (instance == null) {
			return new danli();
		}
		return instance;
	}
}
