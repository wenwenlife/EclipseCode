package com.wen.jiaoyan;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class jiaoYan {
	// 加权数
	private static int power[] = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };
	private static int sum = 0;
	private static String checkCode = "";

	public static Boolean check(String card) {
		// 判断身份证位数是否合法
		if (null == card || card.length() != 18) {
			return false;
		}
		/* 前17位 */
		if (card17Before(card) == false) {
			return false;
		}
		/* 判断前两位是否可以代表省份 */
		if (card12(card) == false) {
			return false;
		}

		/* 验证出生年月日是否合法 */
		// 411424199508118000
		if (checkBirthday(card) == false) {
			return false;
		}

		/* 验证第18位 */
		if (card18(card) == false) {
			return false;
		}

		return true;
	}


	public static boolean card17Before(String card) {
		// 判断前17位是否为数字
		String card17 = card.substring(0, 17);
		return card17.matches("^[0-9]*$");
	}

	// 前两位是否合法
	public static boolean card12(String card) {
		String twoCard = card.substring(0, 2);
		int twoCardNumber = Integer.parseInt(twoCard);
		if (twoCardNumber < 11 || twoCardNumber > 91) {
			return false;
		}
		return true;
	}

	// 判断日期
	public static boolean checkBirthday(String card) {
		String birthday = card.substring(6, 14);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		try {
			Date birthDate = sdf.parse(birthday);
			String tmpDate = sdf.format(birthDate);
			// 获取当前时间
			String systemTime = sdf.format(System.currentTimeMillis());
			// 把当前时间转为int类型
			int systemTimes = Integer.parseInt(systemTime);
			int birthdays = Integer.parseInt(birthday);
			if (!tmpDate.equals(birthday) || birthdays > systemTimes) {// 出生年月日不正确
				return false;
			}
		} catch (ParseException e1) {
			return false;
		}
		return true;
	}

	public static boolean card18(String card) {

		String card18 = card.substring(17);
		String card17 = card.substring(0, 17);
		// 把前17位转为int数组
		char c[] = card17.toCharArray();
		int[] a = new int[c.length];
		int k = 0;
		for (char temp : c) {
			a[k++] = Integer.parseInt(String.valueOf(temp));
		}
		int card17Array[] = a;
		// 获得系数相乘之和
		if (power.length == card17Array.length) {
			for (int i = 0; i < card17Array.length; i++) {
				for (int j = 0; j < power.length; j++) {
					if (i == j) {
						sum = sum + card17Array[i] * power[j];
					}
				}
			}
		}
		// 判断求余后的值
		int modulus = sum % 11;
		switch (modulus % 11) {
		case 10:
			checkCode = "2";
			break;
		case 9:
			checkCode = "3";
			break;
		case 8:
			checkCode = "4";
			break;
		case 7:
			checkCode = "5";
			break;
		case 6:
			checkCode = "6";
			break;
		case 5:
			checkCode = "7";
			break;
		case 4:
			checkCode = "8";
			break;
		case 3:
			checkCode = "9";
			break;
		case 2:
			checkCode = "x";
			break;
		case 1:
			checkCode = "0";
			break;
		case 0:
			checkCode = "1";
			break;
		}
		if (!card18.equalsIgnoreCase(checkCode)) {
			return false;
		}
		return true;

	}
}

