package com.wen.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * 
 * 
 * @Description:Dao的实现类
 */
@Repository
public class DaoImpl implements Dao {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void addMoney(String inner, int Money) {
		jdbcTemplate.update("UPDATE person SET money=money+? WHERE name=?;", Money, inner);
	}

	@Override
	public void lessMoney(String outer, int Money) {
		jdbcTemplate.update("UPDATE person SET money=money-? WHERE name=?;", Money, outer);
	}





}
