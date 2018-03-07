package com.wen.jedies.test;

import org.junit.jupiter.api.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JdiesTest {
	// 单实例连接
	@Test
	public void single() {
		Jedis jd = new Jedis("127.0.0.1", 6379);
		jd.set("s3", "3");
		System.out.println(jd.get("s3"));
	}

	// 连接池
	@Test
	public void manySingle() {
		JedisPool jp = new JedisPool("127.0.0.1", 6379);
		Jedis jedis = jp.getResource();
		jedis.set("s3", "4");
		System.out.println(jedis.get("s3"));
	}
}
