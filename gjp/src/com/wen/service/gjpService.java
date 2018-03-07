package com.wen.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.wen.bean.gjpBean;
import com.wen.dao.gjpDao;

/* 接收命令并传给dao*/
public class gjpService {
	// service调用dao
	// private gjpDao gjpdao = new gjpDao();

	public static ResultSet selectAll() throws Exception {
		return gjpDao.selectAll();
		
	}

	public static ResultSet selectCoditions(String start, String end) throws SQLException {
		return gjpDao.selectCoditions(start, end);
	}

	public static boolean addZhangWu(gjpBean zw) throws SQLException {
		return gjpDao.addZhangwu(zw);
	}

	public static int deleteZhangwu(int id) throws SQLException {
		return gjpDao.deleteZhangwu(id);
	}
}
