package com.wen.service;

import com.wen.dao.Dao;

public class ServiceImpl implements Service {
	private Dao dao;

	public void setDao(Dao dao) {
		this.dao = dao;
	}

	@Override
	public void accountService(String inner, String outer, int money) {
		dao.addMoney(inner, money);
		dao.lessMoney(outer, money);
	}

}
