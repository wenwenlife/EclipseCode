package com.wen.check;

import org.junit.Test;

public class TestCheckOut {
	@SuppressWarnings("unused")
	@Test
	public void ss() {
		// // checkOut小于18，等于18，大于18,null,空字符串
		// Boolean check = checkOut.check("12345678912345678");// 17
		// Boolean check1 = checkOut.check("123456789123456789");// 18
		// Boolean check2 = checkOut.check("1234567891234567890");// 19
		//
		// // checkOut前17位是否为数字
		// Boolean check3 = checkOut.check("123456789123456789");
		// Boolean check4 = checkOut.check("X23456789123456789");
		//
		// // checkOut前两位小于11大于91
		// Boolean check5 = checkOut.check("103456789123456789");// 10
		// Boolean check6 = checkOut.check("113456789123456789");// 11
		// Boolean check7 = checkOut.check("913456789123456789");// 91
		// Boolean check8 = checkOut.check("923456789123456789");// 92
		//
		// // 出生日期
		// Boolean check9 = checkOut.check("411424199508118001");// 19950811
		// Boolean check10 = checkOut.check("411424199513118000");// 19951311
		// Boolean check11 = checkOut.check("411424199508328000");// 19950832
		// Boolean check12 = checkOut.check("411424201801278000");// 20190832
		//
		// // 第18位
		// Boolean check13 = checkOut.check("411424199508118000");
		Boolean check14 = checkOut.check("411424199508118052");


		if (check14) {
			System.out.println("身份证合法");
		} else {
			System.out.println("身份证不合法");
		}
	}
}
