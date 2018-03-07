package com.wen.gjp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class queryTest {
	public static void main(String[] args) throws Exception {
		// 获取连接
		Connection conn = JdbcUtils.getConnection();
		// 创建sql语句
		String sql = "select *from gjp_zhangwu where zw_id =?";
		// 创建搬运工prepareStatement
		PreparedStatement pst = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_UPDATABLE);
		pst.setInt(1, 2);
		ResultSet rs = pst.executeQuery();
		ResultSetMetaData data = rs.getMetaData();
		int count = data.getColumnCount();
		while (rs.next()) {
			for (int i = 0; i < count; i++) {
				System.out.print(rs.getString(i + 1) + "  ");
			}
			System.out.println();
		}

	}
}
