package com.order_info.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/order_info/CheckoutServlet")
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.getWriter().append("Served at: ").append(req.getContextPath());
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	req.setCharacterEncoding("UTF-8");
	String action = req.getParameter("action");
	
	if("ADD".equals(action)) {
		List<String>error=new ArrayList<String>();
		List<String>errory=new ArrayList<String>();
		try {
			String pan_no1=req.getParameter("pan_no1");
			String pan_no2=req.getParameter("pan_no2");
			String pan_no3=req.getParameter("pan_no3");
			String pan_no4=req.getParameter("pan_no4");
			String pan_no="[0-9]{4}";
			if(pan_no1.length()==0||pan_no2.length()==0||pan_no3.length()==0||pan_no4.length()==0) {
				error.add("請輸入卡號");
				pan_no1="000";pan_no2="123";pan_no3="456";pan_no4="789";
				errory.add(pan_no1);errory.add(pan_no2);errory.add(pan_no3);errory.add(pan_no4);
				}
				else if(!pan_no1.matches(pan_no)||!pan_no2.matches(pan_no)||!pan_no3.matches(pan_no)||!pan_no4.matches(pan_no)) {
				error.add("卡號請輸入數字");
				pan_no1="000";pan_no2="123";pan_no3="456";pan_no4="789";
				errory.add(pan_no1);errory.add(pan_no2);errory.add(pan_no3);errory.add(pan_no4);		
			}
				String period=req.getParameter("period");
				String period1=req.getParameter("period1");
				String period2="[0-9]{2}";
				String period3="[0-9]{4}";
			if(period.length()==0||period1.length()==0) {
				error.add("請輸入卡片有效期限");
			}
			else if(!period.matches(period2)||!period1.matches(period3)) {
				error.add("卡片有效期限輸入錯誤");
			}
			String Securityc=req.getParameter("Securityc");
			String Security1="[0-9]{3}";
			if(Securityc.length()==0) {
				System.out.println("xxxxxxxx");
				error.add("請輸入安全碼");
			}else if(!Securityc.matches(Security1)) {
				error.add("安全碼格式錯誤");
			}
			String account1=req.getParameter("account1");
			if(account1.length()==0) {
				error.add("請輸入匯款帳號");
			}
			String name1=req.getParameter("name1");
			if(name1.length()==0) {
				error.add("請輸入姓名");
			}
			errory.add(pan_no1); 
			errory.add(pan_no2); 
			errory.add(pan_no3); 
			errory.add(pan_no4);
			errory.add(period);  
			errory.add(period1);
			errory.add(Securityc);
			errory.add(account1);
			errory.add(name1);
			if(!error.isEmpty()) {
				req.setAttribute("error", error);
				req.setAttribute("errory",errory);
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/order_info/Checkout.jsp");
				failureView.forward(req, res);
				return;
				}	
			}catch(Exception e) {
				req.setAttribute("error", error);
				req.setAttribute("errory",errory);
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/order_info/Checkout.jsp");
				failureView.forward(req, res);
				return;
			}
		}
	}
}
