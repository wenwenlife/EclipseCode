package com.wen.core;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.wen.bean.Configuration;

/**
 * 根据配置信息对连接对象进行管理
 * @author 李文
 *2018年1月10日下午6:56:18
 *
 */
public class DBManage {
	private static Configuration conf;

	// 读取配置文件
	static {
		Properties prop =new Properties();
		try {
			prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 创建Configuration对象
		conf = new Configuration();
		
		// 读取配置文件内容
		conf.setDriver(prop.getProperty("driver"));
		conf.setPoPackage(prop.getProperty("poPackage"));
		conf.setPwd(prop.getProperty("pwd"));
		conf.setSrcPath(prop.getProperty("srcPath"));
		conf.setUrl(prop.getProperty("url"));
		conf.setUser(prop.getProperty("user"));
		conf.setUsingDB(prop.getProperty("usingDB"));
	}

	// 获取与数据库连接
		public static Connection getConn(){
			try {
				Class.forName(conf.getDriver());
				return DriverManager.getConnection(conf.getUrl(),
						conf.getUser(),conf.getPwd());     //直接建立连接，后期增加连接池处理，提高效率！！！
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		
	// 关闭资源
		public static void close(ResultSet rs,Statement ps,Connection conn){
			try {
				if(rs!=null){
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(ps!=null){
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn!=null){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public static void close(Statement ps,Connection conn){
			try {
				if(ps!=null){
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn!=null){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		public static void close(Connection conn){
			try {
				if(conn!=null){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		/**
		 * 返回Configuration对象
		 * @return
		 */
		public static Configuration getConf(){
			return conf;
		}
		
}
