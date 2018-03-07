package com.wen;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class register
 */
@WebServlet(name = "")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		String errormsg = "";
		String username = request.getParameter("username");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		String email = request.getParameter("email");
		String birthday = request.getParameter("birthday");

		if (username != null && password1 != null && password2 != null && email != null && birthday != null) {
			// 判断两次输入密码是否相同
			if (password1.equals(password2)) {
				Dao d = new Dao();
				Connection conn = d.returnConn();
				String sql = "INSERT INTO USER" + "(username,PASSWORD,email,birthdy)" + "VALUES(?,?,?,?)";
				try {
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setObject(1, username);
					ps.setObject(2, password1);
					ps.setObject(3, email);
					ps.setObject(4, birthday);
					ps.executeUpdate();

				} catch (SQLException e) {
					e.printStackTrace();
				}
				// 密码不相同
			} else {
				errormsg = "两次输入密码不同";
			}
			// 有没填的
		}else{
			errormsg = "信息不完善";
	}
		if (!errormsg.equals("")) {
			rd = request.getRequestDispatcher("/register.jsp");
			request.setAttribute("err", errormsg);
			rd.forward(request, response);
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
