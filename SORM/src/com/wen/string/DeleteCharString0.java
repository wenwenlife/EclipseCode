package com.wen.string;

/**
 * 
 * 
 * @Description: String 中删除指定字符 方式一
 */
public class DeleteCharString0{
	// public static void main(String[] args) {
	// String a = "abcdefghijk";
	// String b = "";
	// for (int i = 0; i < a.length(); i++) {
	// b += a.charAt(i);
	// }
	// }
	
	public static String DeleteCharString(String sourceString, char chElemData) {
	    String deleteString = "";
	    for (int i = 0; i < sourceString.length(); i++) {
	        if (sourceString.charAt(i) != chElemData) {
	            deleteString += sourceString.charAt(i);
	        }
	    }
	    return deleteString;
	}
}

