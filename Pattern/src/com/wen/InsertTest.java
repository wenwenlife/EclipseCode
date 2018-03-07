package com.wen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class InsertTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		final String url = "jdbc:mysql://127.0.0.1/testmore";
		final String name = "com.mysql.jdbc.Driver";
		final String user = "root";
		final String password = "123";
		Connection conn = null;
		Class.forName(name);// 指定连接类型
		conn = DriverManager.getConnection(url, user, password);// 获取连接
		if (conn != null) {
			System.out.println("获取连接成功");
			insert(conn);
		} else {
			System.out.println("获取连接失败");
		}

	}

	public static void insert(Connection conn) {
		// 开始时间
		Long begin = new Date().getTime();
		// sql前缀
		String prefix = "INSERT INTO teacher (t_name,t_password,sex,escription,pic_url,school_name,regist_date,remark) VALUES ";
		try {
			// 保存sql后缀
			StringBuffer suffix = new StringBuffer();
			// 设置事务为非自动提交
			conn.setAutoCommit(false);
			PreparedStatement pst = (PreparedStatement) conn.prepareStatement("");// 准备执行语句
			// 外层循环，总提交事务次数
			for (int i = 1; i <= 100; i++) {
				suffix = new StringBuffer();

				// 第j次提交步长
				for (int j = 1; j <= 120; j++) {
					// 构建SQL后缀
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String dateNow = sdf.format(new Date());
					suffix.append("('" + i * j * 7 + "','1234567'" + ",'1'" + ",'教师'" + ",'www.qq.com'" + ",'清华大学'"
							+ ",'" + dateNow + "','" + j + "'" + "),");
				}
				// 构建完整SQL
				String sql = prefix + suffix.substring(0, suffix.length() - 1);
				// 添加执行SQL
				pst.addBatch(sql);
				// 执行操作
				pst.executeBatch();
				// 提交事务
				conn.commit();
				// 清空上一次添加的数据
				suffix = new StringBuffer();
			}
			// 头等连接
			pst.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 结束时间
		Long end = new Date().getTime();
		// 耗时
		System.out.println("花费时间 : " + (end - begin) / 1000 + " s");
		System.out.println("插入完成");
	}
}
