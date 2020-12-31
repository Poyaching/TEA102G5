package com.chat.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.member_info.model.Member_infoService;
import com.member_info.model.Member_infoVO;

@WebServlet("/chat/NameServlet")
public class NameServlet extends HttpServlet {

	String loginUser;
	String serviceUser;
	String allmemberUser;
	String serviceUserName;
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
//		String userName = req.getParameter("userName");
		
		Member_infoService member_infosev = new Member_infoService();
		List<Member_infoVO> list = (List<Member_infoVO>)member_infosev.getAll();
		Iterator<Member_infoVO> it = list.iterator();
		while(it.hasNext()){
			String member = it.next().getMember_email();{
				if(member.equals(loginUser)) {
					it.remove();
				}
			}
		}
		
//		
//		for(int i=0;i<list.size();i++) {
//			allmemberUser = list.get(i).getMember_email()+"";
//			System.out.println(allmemberUser);
//		}

		HttpSession session = req.getSession();
		session.setAttribute("memberlist", list);
		loginUser = (String) session.getAttribute("account");
		serviceUser = "ccps920167@gmail.com"; //客服帳號
		serviceUserName = "Tomato客服";

		if (!loginUser.equals("ccps920167@gmail.com")) {
			req.setAttribute("userName", loginUser);
			req.setAttribute("userName2", serviceUser);
			

			System.out.println("客服不在線");
			RequestDispatcher dispatcher = req.getRequestDispatcher("/front-end/chat/chat.jsp");
			dispatcher.forward(req, res);
		}if(loginUser.equals("ccps920167@gmail.com")) {
			req.setAttribute("userName", loginUser);
			req.setAttribute("userName2", serviceUser);

			System.out.println("客服進來了");
			RequestDispatcher dispatcher = req.getRequestDispatcher("/front-end/chat/chat.jsp");
			dispatcher.forward(req, res);
			}
		}

	}
