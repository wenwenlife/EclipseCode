package com.wen.gjp;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JdbcUtils {
	private static String driver;
	private static String url;
	private static String user;
	private static String pass;
	private static Connection connection;

	static {
		// 加载驱动
		try {
			initp();
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, pass);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void initp() throws Exception {
		Properties pts = new Properties();
		FileInputStream fis = new FileInputStream("mysql.ini");
		pts.load(fis);
		fis.close();
		driver = pts.getProperty("driver");
		url = pts.getProperty("url");
		user = pts.getProperty("user");
		pass = pts.getProperty("pass");
	}

	public static Connection getConnection() {
		return connection;
	}
}
