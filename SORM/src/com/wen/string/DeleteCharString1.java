package com.wen.string;

/**
 * 
 * 
 * @Description: String 中删除指定字符 方式二
 */
public class DeleteCharString1{
	public static void main(String[] args) {
		System.out.println(DeleteCharString1.deleteCharString1("abcdefaghijk", 'a'));
	}
	public static String deleteCharString1(String sourceString, char chElemData) {
		String deleteString = "";
		int iIndex = 0;
		for (int i = 0; i < sourceString.length(); i++) {
			if (sourceString.charAt(i) == chElemData) {
				if (i > 0) {
					deleteString += sourceString.substring(iIndex, i);
				}
				iIndex = i + 1;
			}
		}
		if (iIndex <= sourceString.length()) {
			deleteString += sourceString.substring(iIndex, sourceString.length());
	        }
		return deleteString;
	    }
}

