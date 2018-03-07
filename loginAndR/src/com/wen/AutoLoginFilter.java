
package com.wen;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AutoLoginFilter implements Filter {

	@SuppressWarnings("unused")

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		// 获取cookie
		Cookie[] cookies = req.getCookies();
		String loginCookie = "";
		String username = "";
		String password = "";
		for (int i = 0; cookies != null && i < cookies.length; i++) {
			if ("user".equals(cookies[i].getName())) {
				// 李文:123
				loginCookie = cookies[i].getValue();
				String[] value = loginCookie.split(":");
				username = value[0];
				password = value[1];
				request.getRequestDispatcher("welcome.jsp").forward(request, response);
			}
		}
		chain.doFilter(request, response);
	}

}
