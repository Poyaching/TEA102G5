package com.member_info.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.member_info.model.Member_infoService;
import com.member_info.model.Member_infoVO;

@WebServlet("/member_info/Member_Servlet")
@MultipartConfig(fileSizeThreshold = 10 * 1024 * 1024, maxFileSize = 30 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024
		* 1024)
public class Member_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		HttpSession session = req.getSession();
		System.out.println(action);
		System.out.println(req.getRequestURI());
		
		if("member_infoPage".equals(action)){
    	   	RequestDispatcher failureView = req.getRequestDispatcher("/front-end/member_info/memberHomepage.jsp");
    	   	failureView.forward(req, res);
			return;// 程式中斷
		}
		
		if("member_getinfoPage".equals(action)){
    	   	RequestDispatcher failureView = req.getRequestDispatcher("/front-end/member_info/listOneMember_info.jsp");
    	   	failureView.forward(req, res);
			return;// 程式中斷
		}
	}

}
