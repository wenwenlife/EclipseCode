package com.wen;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dao {
	private static Connection conn;
	// private static String driver;
	// private static String url;
	// private static String user;
	// private static String pass;

	static {
		try {
			// init();
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/a", "root", "123");
			// String sql = "SELECT ?,? FROM USER";
			// PreparedStatement ps = conn.prepareStatement(sql);
			// ps.setObject(1, "李文");
			// ps.setObject(2, "123");
			// ResultSet rs = ps.executeQuery();
			// if(rs.next()) {
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// public static void init() throws Exception {
	// Properties pts = new Properties();
	// FileInputStream fis = new FileInputStream("mysql.ini");
	// pts.load(fis);
	// fis.close();
	// driver = pts.getProperty("driver");
	// url = pts.getProperty("url");
	// user = pts.getProperty("user");
	// pass = pts.getProperty("pass");
	//
	// }

	public Connection returnConn() {
		return conn;
	}

	// public static void main(String[] args) {
	// System.out.println(conn);
	// }
}
