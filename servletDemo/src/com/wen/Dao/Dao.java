package com.wen.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao {
	private String driver;
	private String url;
	private String root;
	private String password;
	private Connection conn;

	public Dao(String driver, String url, String root, String password) {
		super();
		this.driver = driver;
		this.url = url;
		this.root = root;
		this.password = password;
	}

	public Dao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getRoot() {
		return root;
	}

	public void setRoot(String root) {
		this.root = root;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	// 获取数据库连接
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		if (conn == null) {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, root, password);
		}
		return conn;
	}

	// 执行查询
	public ResultSet query(String sql, Object... args) throws ClassNotFoundException, SQLException {
		PreparedStatement ps = getConnection().prepareStatement(sql);
		for (int i = 0; i < args.length; i++) {
			ps.setObject(i + 1, args[i]);
		}
		return ps.executeQuery();

	}
}
