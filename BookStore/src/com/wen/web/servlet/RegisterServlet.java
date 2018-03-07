package com.wen.web.servlet;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.wen.Exception.UserException;
import com.wen.domain.User;
import com.wen.service.UserService;
import com.wen.utils.SendJMail;

@SuppressWarnings("all")
@WebServlet(name = "RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 校验验证码
          String captcha= request.getParameter("captcha"); //表单输入数据
		String checkcode_session = (String) request.getSession().getAttribute("checkcode_session");// 生成的验证码
		System.out.println(checkcode_session);
		if (captcha == null) {
			request.setAttribute("errorMsg", "请输入验证码");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;
		} else if (!captcha.equals(checkcode_session)) {
			request.setAttribute("errorMsg", "验证码错误");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;
		}
		// 调用业务逻辑
		User user = new User();
		try {
			// 将请求信息转为user
			BeanUtils.populate(user, request.getParameterMap());
			// 手动设置激活码
			user.setActiveCode(UUID.randomUUID().toString());
			// 调用Service
			UserService us = new UserService();
			us.regist(user);
			// 发送激活邮件
			String emailMsg = "注册成功，请<a href='http://localhost:8080/BookStore/active" + user.getActiveCode()
					+ "'>激活</a>后登录";
			SendJMail.sendMail(user.getEmail(), emailMsg);
			// 分发转向
			request.getSession().setAttribute("user", user);
			request.getRequestDispatcher("/registersuccess.jsp").forward(request, response);
		} catch (UserException u) {
			request.setAttribute("exceptionMsg", u.getMessage());
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException
	    {
		doGet(request, response);
	}
}
