package com.wen.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wen.Exception.UserException;
import com.wen.domain.User;
import com.wen.service.UserService;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginServlet() {
        super();
    }

	@SuppressWarnings("all")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取账号密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try {
			UserService us = new UserService();
			User login = us.login(username, password);
			String path = "/myAccount.jsp";
			User user=new User();
			if ("管理员".equals(login.getRole())) {
				path = "/admin/login/home.jsp";
			}
			// Map allMsg=new HashMap();
			// allMsg.put("user", login.getUsername());
			// allMsg.put("role", login.getRole());
			// allMsg.put("email", login.getEmail());
			// allMsg.put("id", login.getId());
			// request.getSession().setAttribute("loginAll", allMsg);
			request.getSession().setAttribute("user", login.getUsername());
			request.getSession().setAttribute("role", login.getRole());
			request.getSession().setAttribute("email", login.getEmail());
			request.getSession().setAttribute("id", login.getId());
			request.getRequestDispatcher(path).forward(request, response);

		} catch (UserException e) {
			e.printStackTrace();
			request.setAttribute("loginErr", e.getMessage());
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
