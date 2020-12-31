package com.filters;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class teacher_filter implements Filter {

	private FilterConfig config;

	public void init(FilterConfig config) {
		this.config = config;
	}

	public void destroy() {
		config = null;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		// 【取得 session】
		HttpSession session = req.getSession();
		// 【從 session 判斷此user是否登入過】
		if (session.getAttribute("judgement") == null) {
//			session.setAttribute("location", req.getRequestURI());
			res.sendRedirect(req.getContextPath() + "/front-end/member_info/login.jsp");
		} else {
			Map<String, String> map = (Map<String, String>) session.getAttribute("judgement");
			if ("1".equals(map.get("role"))) {
//			res.sendRedirect(req.getContextPath()+"/front-end/member_info/teacher.jsp");
				chain.doFilter(request, response);
			}else {
				res.sendRedirect(req.getContextPath() + "/front-end/member_info/allmember.jsp");
			}
		}
	}
}
