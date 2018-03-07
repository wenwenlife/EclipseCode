package com.wen;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 
 * 
 * @Description: 计算你出生多少天
 */
public class Birthday {
	public static void main(String[] args) throws ParseException {
		System.out.println("请输入你的生日");
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

		if (sc.hasNext()) {
			Date birthday = sdf.parse(sc.nextLine());
			System.out.println(
					"你出生  " + ((System.currentTimeMillis() - birthday.getTime()) / 1000 / 60 / 60 / 24) + " 天");
		}

	}
}
