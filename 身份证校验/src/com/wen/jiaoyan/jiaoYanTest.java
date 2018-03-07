package com.wen.jiaoyan;

import org.junit.jupiter.api.Test;

public class jiaoYanTest {
	@Test
	public void ss() {
		Boolean check = jiaoYan.check("411424199508118052");
		if (check) {
			System.out.println("身份证号码正确");
		} else {
			System.out.println("身份证号码不正确");
		}
	}
}
