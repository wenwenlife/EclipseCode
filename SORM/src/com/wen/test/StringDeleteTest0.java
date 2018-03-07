package com.wen.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.wen.string.DeleteCharString0;

public class StringDeleteTest0 {

	@Test
	public void test() {
		assertEquals("bcdefghijk", DeleteCharString0.DeleteCharString("abcdefghijk", 'a'));

	}

}
