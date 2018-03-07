package com.wen.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.wen.domain.User;
import com.wen.utils.C3P0Util;

public class UserDao {

	// 注册
	public void addUser(User user) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql = "INSERT INTO USER(username,PASSWORD,gender,email,telephone,introduce,activecode,state,registtime) "
				+ "VALUES(?,?,?,?,?,?,?,?,?)";
		qr.update(sql, user.getUsername(), user.getPassword(), user.getGender(), user.getEmail(), user.getTelephone(),
				user.getIntroduce(), user.getActiveCode(), user.getState(), user.getRegistTime());

	}

	// 根据邀请码查找用户
	public User findUserByActiveCode(String activeCode) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select * from user where activecode=?", new BeanHandler<User>(User.class), activeCode);
	}

	// 根据邀请码修改状态
	public void activeUser(String activeCode) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		qr.update("update user set state=1 where activecode=?", activeCode);
	}

	public User findUserByNameAndPassword(String username, String password) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select * from user where username=? and password=?", new BeanHandler<User>(User.class),
				username, password);
	}

	// 修改个人信息
	public void updateMsg(String password1, User user, Object id) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		qr.update("update user set password=? , gender=?, telephone=? where id=?", password1, user.getGender(),
				user.getTelephone(), id);
	}

}
