package com.wen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wen.bean.gjpBean;
import com.wen.gjp.JdbcUtils;

/*查询数据库*/
public class gjpDao {
	// 获取连接
	static Connection conn = JdbcUtils.getConnection();
	public static ResultSet selectAll() throws Exception {

		// 创建sql语句
		String sql = "select *from gjp_zhangwu";
		// 创建搬运工prepareStatement
		PreparedStatement pst = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = pst.executeQuery();
		return rs;

		
	}

	public static ResultSet selectCoditions(String start, String end) throws SQLException {
		// 创建sql语句
		String sql = "SELECT *FROM gjp_zhangwu WHERE zw_createtime BETWEEN ? AND ?";
		// 创建搬运工prepareStatement
		PreparedStatement pst = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_UPDATABLE);
		// 给?号赋值
		pst.setString(1, start);
		pst.setString(2, end);

		ResultSet rs = pst.executeQuery();
		return rs;
	}


	public static boolean addZhangwu(gjpBean zw) throws SQLException {
		String sql = "INSERT INTO gjp_zhangwu VALUES" + "(null,?,?,?,?,?);";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, zw.getZw_name());
			pst.setDouble(2, zw.getZw_money());
		pst.setString(3, zw.getZw_zhangHu());
		pst.setString(4, zw.getZw_createtime());
		pst.setString(5, zw.getZw_miaoshu());
		return pst.execute(sql);
		

	}

	public static int deleteZhangwu(int id) throws SQLException {
		Connection connection = JdbcUtils.getConnection();
		String sql = "DELETE  FROM gjp_zhangwu WHERE zw_id=?";
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setInt(1, id);
		return pst.executeUpdate();
	}
	
}
