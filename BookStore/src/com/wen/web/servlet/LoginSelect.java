package com.wen.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginSelect", urlPatterns = "/Select")
public class LoginSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginSelect() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Object user = request.getSession().getAttribute("user");
	
		if (user == null) {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		} else {
			Object role = request.getSession().getAttribute("role");
			if ("普通用户".equals(role)) {
				request.getRequestDispatcher("/myAccount.jsp").forward(request, response);
				return;
			}
			request.getRequestDispatcher("/admin/login/home.jsp").forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
