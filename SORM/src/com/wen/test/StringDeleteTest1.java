package com.wen.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.wen.string.DeleteCharString0;
import com.wen.string.DeleteCharString1;

public class StringDeleteTest1 {

	@Test
	public void test() {
		assertEquals("bcdefghijk", DeleteCharString1.deleteCharString1("abcdefaghijk", 'a'));

	}

}
