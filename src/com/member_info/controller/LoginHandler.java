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

	// �i�ˬd�ϥΪ̿�J���b��(account) �K�X(password)�O�_���ġj
	// �i��ڤW���ܸ�Ʈw�j�M���j
	protected boolean allowUser(String account, String password) {
//		System.out.println("�����ϥΪ̱b�K");
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
		//action=login�n�J
		if ("login".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			// ���ҽX�T��
			String insrand=req.getParameter("insrand");
			HttpSession session=req.getSession();
			String rand=(String) session.getAttribute("rand");
			
		
			if(rand==null) {
				errorMsgs.add("���ҹO��,�Э��s�n�J");
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/sign_in/sign_in.jsp");
				failureView.forward(req, res);
				return;
			}
			if(!(insrand.trim().equals(rand))) {
				errorMsgs.add("���ҽX���~,�Э��s��J");
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/sign_in/sign_in.jsp");
				failureView.forward(req, res);
				return;
			}
			
			try {
				/*************************** 1.�����ШD�Ѽ� ****************************************/
				String account = new String(req.getParameter("account"));
				String password = new String(req.getParameter("password"));
				if (account == null || (account.trim()).length() == 0) {
					errorMsgs.add("�п�J�b��");
				}

				if (password == null || (password.trim()).length() == 0) {
					errorMsgs.add("�п�J�K�X");
				}
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/front-end/sign_in/sign_in.jsp");
					failureView.forward(req, res);
					return;
				} // �{�����_

				/*************************** 2.�}�l�d�߸�� ****************************************/
				Member_infoService member_infoSvc = new Member_infoService();
				Member_infoVO member_infoVO = member_infoSvc.getAccountPassword(account);
				checkmail = member_infoVO.getMember_email();
				checkpassword = member_infoVO.getMember_password();

				// �i�ˬd�ӱb�� , �K�X�O�_���ġj

				if (!allowUser(account, password)) { //�i�b�� , �K�X�L�Įɡj
					out.println("<HTML><HEAD><TITLE>Access Denied</TITLE></HEAD>");
					out.println("<BODY>�A���b�� , �K�X�L��!<BR>");
					out.println(
							"�Ы������s�n�J <A HREF=" + req.getContextPath() + "/front-end/sign_in/sign_in.jsp>���s�n�J</A>");
					out.println("</BODY></HTML>");
				} else { // �i�b�� , �K�X���Į�, �~���H�U�u�@�j
					session.setAttribute("account", account); // *�u�@1: �~�bsession�����w�g�n�J�L������

					try {
						String location = (String) session.getAttribute("location");
						if (location != null) {
							session.removeAttribute("location"); // *�u�@2: �ݬݦ��L�ӷ����� (-->�p���ӷ�����:�h���ɦܨӷ�����)
							res.sendRedirect(location);
							return;
						}
					} catch (Exception ignored) {
					}
					//����judgement MAP����
					Map<String,String> judgement=new HashMap<String,String>();
					//���X�|�����(account�ǤJ�ѼơA�W���O�γo�Ӭd)
					String member_role=member_infoVO.getMember_role()+"";
					judgement.put("role", member_role);		
					
					/**�v���[�ݬ���(�ն�)*************************************************/
					Map<String, List<Video_recordVO>> member_Video_record = new HashMap<String, List<Video_recordVO>>();
					List<Video_recordVO> member_Video_record_list = new Video_recordService().getMemberAll(member_infoVO.getMember_id());
					member_Video_record = new Video_recordService().getMemberAll(member_infoVO.getMember_id()).stream().collect(Collectors.groupingBy(Video_recordVO::getMember_id));
					session.setAttribute("member_Video_record", member_Video_record);
					System.out.println(member_Video_record);
					
					
					/**�ǲ߽ҵ{(�ն�)*************************************************/
					List<Order_listVO> member_class = new Order_listService().getMemberClass(member_infoVO.getMember_id());
					session.setAttribute("member_class", member_class);
					
					System.out.println(member_class);
					
					/**�б½ҵ{(�ն�)*************************************************/
					List<Class_infoVO> member_teach = new Class_infoService().getTeachAll(member_infoVO.getMember_id());						
					session.setAttribute("member_teach", member_teach);
					
					System.out.println(member_teach);

					session.setAttribute("judgement", judgement);
					session.setAttribute("member_infoVO", member_infoVO);
					
					
					System.out.println(member_infoVO);
					System.out.println(member_infoVO.getMember_email());
//					session.invalidate();
					
									
					res.sendRedirect(req.getContextPath() + "/index.jsp"); // *�u�@3:
																											// (-->�p�L�ӷ�����:�h���ɦ�login_success.jsp)
				}
			} catch (Exception e) {
				errorMsgs.add("�L���b���A�Х����U" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/sign_in/sign_in.jsp");
				failureView.forward(req, res);
			}
		}
		//action=logout�n�X
		if ("logout".equals(action)) {
			HttpSession session = req.getSession();
			session.invalidate();
			res.sendRedirect(req.getContextPath() + "/index.jsp");		
		}
	}
	
	
}