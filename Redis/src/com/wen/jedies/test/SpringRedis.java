package com.wen.jedies.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class SpringRedis {
	@Test
	public void springRedisTest() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/application-config-redis.xml");
		JedisPool jedisPool = (JedisPool) ac.getBean("jedisPool");
		// 获取jedis
		Jedis jedis = jedisPool.getResource();
		jedis.set("s3", "56");
		jedisPool.close();
		jedis.close();
	}
}
