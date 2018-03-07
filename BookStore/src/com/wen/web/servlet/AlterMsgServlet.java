package com.wen.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.wen.Exception.UserException;
import com.wen.domain.User;
import com.wen.service.UserService;

@SuppressWarnings("all")
@WebServlet(name = "AlterMsgServlet", urlPatterns = "/alterMsg")
public class AlterMsgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AlterMsgServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		User user = new User();
		try {
			BeanUtils.populate(user, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(password1.equals(password2)) {
			 UserService us= new UserService();
			try {
				Object id = request.getSession().getAttribute("id");
				us.updateMsg(password1, user, id);
				request.getSession().invalidate();
				request.getRequestDispatcher("/modifyUserInfoSuccess.jsp").forward(request, response);
			} catch (UserException e) {
				e.printStackTrace();
				request.setAttribute("errorAlter", e.getMessage());
				request.getRequestDispatcher("/modifyuserinfo.jsp").forward(request, response);

			}
		} else {
			request.setAttribute("errorMsg", "两次密码不一致");
			request.getRequestDispatcher("/modifyuserinfo.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
