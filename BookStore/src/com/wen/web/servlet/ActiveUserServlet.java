package com.wen.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wen.Exception.UserException;
import com.wen.service.UserService;

@WebServlet(name = "ActiveUserServlet", urlPatterns = "/active")
public class ActiveUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ActiveUserServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String activeCode = request.getParameter("activeCode");
		UserService us = new UserService();
		try {
			us.activeUser(activeCode);
			request.setAttribute("activeSuccess", "帐户激活成功");
			request.getRequestDispatcher("/activesuccess.jsp").forward(request, response);
		} catch (UserException e) {
			e.printStackTrace();
			request.setAttribute("activeError", e.getMessage());
			request.getRequestDispatcher("/activesuccess.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
