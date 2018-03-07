package cn.strong;

import java.util.regex.Pattern;

/**
 * Title:身份证号码校验函数 Description:只能处理1900到2099年的出生日期，并且没有实现闰年二月多一天的情况，长度校验，验证码校验
 * Company:施强教育科技有限公司
 * 
 * @Author：王锋 @Date：2018/2/18 18:18:18
 */

public class aa {

	private static final int ID_LENGTH = 18;// 身份证字符串正常的长度
	private static final char ASCII_0 = '0';
	private static final Pattern PAT_ID = Pattern.compile("^\\d{6}(19|20)\\d{2}\\d{7}\\w{1}$");
	/**
	 * 
	 * 
	 */
	public static boolean idcheck(String id) {
		if(id == null || id.length() != ID_LENGTH) {
			return false;
		}
		if (!PAT_ID.matcher(id).matches()) {
			return false;
		}

		int b = 0;// 余数
		for (int i = 0; i < ID_LENGTH - 1; i++) {
			b = (b + (id.charAt(i) - ASCII_0)) * 2 % 11;
		}
		char ch = id.charAt(ID_LENGTH - 1);
		int font18 = (ch == 'x' || ch == 'X') ? 10 : ch - ASCII_0;
		return ((b + font18) % 11) == 1;
	}

}
