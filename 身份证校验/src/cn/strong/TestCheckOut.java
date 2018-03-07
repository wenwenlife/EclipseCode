package cn.strong;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;

import org.junit.Test;

public class TestCheckOut {
	@Test
	public void test() throws ParseException {

		// assertFalse("false", CheckOut.check(null)); // null值
		// assertFalse("false", CheckOut.check("41142419950811805")); //少一位
		// assertFalse("false", CheckOut.check("411424399508118052")); //生日年份不对
		// assertFalse("false", CheckOut.check("111111199518118052")); // 生日月份不对
		// assertFalse("false", CheckOut.check("411424199508328052")); // 生日日不对
		// assertFalse("false", CheckOut.check("111111299508118052")); // 生日大于当前日期

		assertTrue("true", CheckOut.check("411424199508118052"));

	}
}
