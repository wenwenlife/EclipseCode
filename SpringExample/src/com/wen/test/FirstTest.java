package com.wen.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wen.service.Service;

/**
 * 
 * 
 * @Description:测试转账
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class FirstTest {
	@Resource(name = "service")
	private Service service;

	@Test
	public void demo01() {
		service.accountService("存钱", "取钱", 1000);
	}
}
