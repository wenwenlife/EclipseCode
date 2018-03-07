package com.wen.service;

import java.sql.SQLException;

import com.wen.Exception.UserException;
import com.wen.dao.UserDao;
import com.wen.domain.User;

public class UserService {
	UserDao dao = new UserDao();

	// 注册
	public void regist(User user) throws UserException {
		try {
			dao.addUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UserException("注册失败");
		}
	}

	// 激活邀请码
	public void activeUser(String activeCode) throws UserException {
		try {
			User findUserByActiveCode = dao.findUserByActiveCode(activeCode);
			if (findUserByActiveCode != null) {
				dao.activeUser(activeCode);
				return;
			}
			throw new UserException("激活失败");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UserException("激活失败");
		}
	}

	// 登录
	public User login(String username, String password) throws UserException {
		User user=null;
		try {
			user = dao.findUserByNameAndPassword(username,password);
			if(user==null){
				throw new UserException("用户名或密码错误!");
			}
			if(user.getState()==0){
				throw new UserException("用户未激活!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UserException("用户名或密码错误!");
		}
		return user;
	}

	// 修改个人信息
	public void updateMsg(String password1, User user, Object id) throws UserException {
		try {
			dao.updateMsg(password1, user, id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UserException("个人信息修改失败");
		}
	}
}
