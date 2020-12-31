package com.member_info.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.class_chapter.model.Class_chapterVO;
import com.class_info.model.Class_infoService;
import com.class_info.model.Class_infoVO;
import com.member_info.model.Member_infoService;
import com.member_info.model.Member_infoVO;
import com.order_list.model.Order_listService;
import com.order_list.model.Order_listVO;
import com.video_record.model.Video_recordService;
import com.video_record.model.Video_recordVO;

@WebServlet("/member_info/LoginHandler")
public class LoginHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String checkmail;
	String checkpassword;

	// 【檢查使用者輸入的帳號(account) 密碼(password)是否有效】
	// 【實際上應至資料庫搜尋比對】
	protected boolean allowUser(String account, String password) {
//		System.out.println("捕捉使用者帳密");
//		System.out.println(account);
//		System.out.println(password);

		if (account.equals(checkmail) && password.equals(checkpassword))
			return true;
		else
			return false;
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("Big5");
		res.setContentType("text/html; charset=Big5");
		PrintWriter out = res.getWriter();
		String action = req.getParameter("action");
		//action=login登入
		if ("login".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			// 驗證碼訊息
			String insrand=req.getParameter("insrand");
			HttpSession session=req.getSession();
			String rand=(String) session.getAttribute("rand");
			
		
			if(rand==null) {
				errorMsgs.add("驗證逾時,請重新登入");
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/sign_in/sign_in.jsp");
				failureView.forward(req, res);
				return;
			}
			if(!(insrand.trim().equals(rand))) {
				errorMsgs.add("驗證碼錯誤,請重新輸入");
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/sign_in/sign_in.jsp");
				failureView.forward(req, res);
				return;
			}
			
			try {
				/*************************** 1.接收請求參數 ****************************************/
				String account = new String(req.getParameter("account"));
				String password = new String(req.getParameter("password"));
				if (account == null || (account.trim()).length() == 0) {
					errorMsgs.add("請輸入帳號");
				}

				if (password == null || (password.trim()).length() == 0) {
					errorMsgs.add("請輸入密碼");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/front-end/sign_in/sign_in.jsp");
					failureView.forward(req, res);
					return;
				} // 程式中斷

				/*************************** 2.開始查詢資料 ****************************************/
				Member_infoService member_infoSvc = new Member_infoService();
				Member_infoVO member_infoVO = member_infoSvc.getAccountPassword(account);
				checkmail = member_infoVO.getMember_email();
				checkpassword = member_infoVO.getMember_password();

				// 【檢查該帳號 , 密碼是否有效】

				if (!allowUser(account, password)) { //【帳號 , 密碼無效時】
					out.println("<HTML><HEAD><TITLE>Access Denied</TITLE></HEAD>");
					out.println("<BODY>你的帳號 , 密碼無效!<BR>");
					out.println(
							"請按此重新登入 <A HREF=" + req.getContextPath() + "/front-end/sign_in/sign_in.jsp>重新登入</A>");
					out.println("</BODY></HTML>");
				} else { // 【帳號 , 密碼有效時, 才做以下工作】
					session.setAttribute("account", account); // *工作1: 才在session內做已經登入過的標識

					try {
						String location = (String) session.getAttribute("location");
						if (location != null) {
							session.removeAttribute("location"); // *工作2: 看看有無來源網頁 (-->如有來源網頁:則重導至來源網頁)
							res.sendRedirect(location);
							return;
						}
					} catch (Exception ignored) {
					}
					//產生judgement MAP物件
					Map<String,String> judgement=new HashMap<String,String>();
					//取出會員資料(account傳入參數，上面是用這個查)
					String member_role=member_infoVO.getMember_role()+"";
					judgement.put("role", member_role);		
					
					/**影片觀看紀錄(博雅)*************************************************/
					Map<String, List<Video_recordVO>> member_Video_record = new HashMap<String, List<Video_recordVO>>();
					List<Video_recordVO> member_Video_record_list = new Video_recordService().getMemberAll(member_infoVO.getMember_id());
					member_Video_record = new Video_recordService().getMemberAll(member_infoVO.getMember_id()).stream().collect(Collectors.groupingBy(Video_recordVO::getMember_id));
					session.setAttribute("member_Video_record", member_Video_record);
					System.out.println(member_Video_record);
					
					
					/**學習課程(博雅)*************************************************/
					List<Order_listVO> member_class = new Order_listService().getMemberClass(member_infoVO.getMember_id());
					session.setAttribute("member_class", member_class);
					
					System.out.println(member_class);
					
					/**教授課程(博雅)*************************************************/
					List<Class_infoVO> member_teach = new Class_infoService().getTeachAll(member_infoVO.getMember_id());						
					session.setAttribute("member_teach", member_teach);
					
					System.out.println(member_teach);

					session.setAttribute("judgement", judgement);
					session.setAttribute("member_infoVO", member_infoVO);
					
					
					System.out.println(member_infoVO);
					System.out.println(member_infoVO.getMember_email());
//					session.invalidate();
					
									
					res.sendRedirect(req.getContextPath() + "/index.jsp"); // *工作3:
																											// (-->如無來源網頁:則重導至login_success.jsp)
				}
			} catch (Exception e) {
				errorMsgs.add("無此帳號，請先註冊" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/sign_in/sign_in.jsp");
				failureView.forward(req, res);
			}
		}
		//action=logout登出
		if ("logout".equals(action)) {
			HttpSession session = req.getSession();
			session.invalidate();
			res.sendRedirect(req.getContextPath() + "/index.jsp");		
		}
	}
	
	
}