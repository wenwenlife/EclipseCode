package com.wen;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginin
 */
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("text");
		String password = request.getParameter("password");
		String autoLogin = request.getParameter("auto");
        String errorMsg="";
        RequestDispatcher rd;
		Dao d = new Dao();
		Connection conn = d.returnConn();
		String sql = "SELECT username,password FROM USER WHERE username=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setObject(1, username);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				if (rs.getObject("username").equals(username) && rs.getObject("password").equals(password)) {
					if (autoLogin != null) {
						Cookie cookie = new Cookie("user", username + ":" + password);
						cookie.setMaxAge(60 * 60 * 14);
						// cookie.setPath("/");
						response.addCookie(cookie);
					} else {
						rd = request.getRequestDispatcher("welcome.jsp");
						rd.forward(request, response);
					}
				} else {
					errorMsg = "密码错误";
				}
			}else {
				errorMsg = "账户不存在";
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (!errorMsg.equals("")) {
			rd = request.getRequestDispatcher("/loginShow.jsp");
			request.setAttribute("err", errorMsg);
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
