package com.wen.utils;

/**
 * username-->Username
 * 
 * @author 李文 2018年1月12日上午10:08:04
 *
 */
public class StringUtils {
	public static String firstCharToUpperCase(String columnName) {
		return columnName.toUpperCase().substring(0, 1) + columnName.substring(1);
	}
}
