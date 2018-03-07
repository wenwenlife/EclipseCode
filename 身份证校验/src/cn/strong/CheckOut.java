package cn.strong;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 默默无文
 * @Description:校验身份证是否合法
 */
public class CheckOut {

	private static final char CH_0 = '0';
	private static final char CARD_LENGTH = 18;
	private static final Pattern PATTERN = Pattern
			.compile("^[1-9]\\d{5}([12]\\d{3}(0[1-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1]))\\d{3}(\\d{1}|[xX])$");
	private static Matcher matcher;
	/**
	 * @param card
	 * @return 身份证是否合法
	 * @throws ParseException
	 */
	public static boolean check(String card) throws ParseException {

		// 判断身份证位数
		if (null == card || card.length() != CARD_LENGTH) {
			return false;
		}
		matcher = PATTERN.matcher(card);
		// 前17位是否为为数字,省份是否合法,生日格式是否正确
		if (!(matcher.matches())) {
			return false;
		}
		// 校验出生日期 校验最后一位
		if (!checkBirthday(card) || !checkLast(card)) {
			return false;
		}
		return true;
	}
	/**
	 * @param card
	 *            需要校验的身份证号码
	 * @return 如果出生日期大于当前日期,返回false,否则返回false
	 * @throws ParseException
	 */
	private static boolean checkBirthday(String card) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date birthday = sdf.parse(matcher.group(1));
		return System.currentTimeMillis() > birthday.getTime();
	}

	/**
	 * @param card
	 *            需要校验的身份证号码
	 * @return 最后一位合法则返回true,反之,返回false
	 */
	private static boolean checkLast(String card) {
		char[] cardCharArray = card.toCharArray();
		// 加权因子
		int remainder = 0;
		for (int i = 0, len = CARD_LENGTH - 1; i < len; i++) {
			remainder = (remainder + (cardCharArray[i] - CH_0)) * 2 % 11;
		}
		char card18 = cardCharArray[CARD_LENGTH - 1];
		int lastNum = (card18 == 'x' || card18 == 'X') ? 10 : card18 - CH_0;
		System.out.println(((remainder + lastNum) % 11) == 1);
		return ((remainder + lastNum) % 11) == 1;
	}
}
