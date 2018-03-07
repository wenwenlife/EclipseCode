package com.wen.day0106;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class a {
	public static void main(String[] args) {
		Pattern p = Pattern.compile("\\d+");
		Matcher matcher = p.matcher("123This is wo");
		while (matcher.find()) {
			System.out.println(matcher.group());
		}
	}
}
