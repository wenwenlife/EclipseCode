package com.wen.login;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wen.Dao.Dao;

public class LoginServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String errMsg = "";
		RequestDispatcher rd;
		// 获取请求参数
		String username = request.getParameter("username");
		String pass = request.getParameter("pass");
		// 获取与数据库连接
		Dao dao = new Dao("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/day01", "root", "123");
		// 查询结果集
		try {
			ResultSet rs = dao.query("SELECT score FROM student" + " WHERE name=?", username);
			if (rs.next()) {
				// 用户名与密码相同
				// System.out.println(rs.getString("score"));
				if (rs.getString("score").equals(pass)) {
					// 获取session对象
					HttpSession session = request.getSession(true);
					// 设置session属性,跟踪用户会话状态
					session.setAttribute("name", username);
					// 获取转发对象
					rd = request.getRequestDispatcher("/welcome.jsp");
					// 转发
					rd.forward(request, response);
				} else {
					// 用户名与密码不同
					errMsg = "你输入的密码错误";
				}

			} else {
				// 用户名错误
				errMsg = "用户名不存在";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		// 如果出错,转发到重新登录
		if (errMsg != null && !errMsg.equals("")) {
			rd = request.getRequestDispatcher("/loginF.jsp");
			request.setAttribute("err", errMsg);
			rd.forward(request, response);

		}
	}
}
