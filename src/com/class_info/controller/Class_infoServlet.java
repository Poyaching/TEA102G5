package com.class_info.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.class_info.model.*;


@WebServlet("/class_info/class_infoServlet")
@MultipartConfig(maxFileSize =10*1024*1024,fileSizeThreshold = 1024*1024 , maxRequestSize = 5*5*1024*1024)
public class Class_infoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		doGet(req, res);
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException{
		
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		if ("SearchOne".equals(action)) {     // �d1      �Ӧ�select_pageClass_info.jsp���ШD

			List<String> erMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("erMsgs", erMsgs);

			try {
				/***************************1.�����ШD�Ѽ� - ��J�榡�����~�B�z**********************/
				String class_id = req.getParameter("class_id");
				System.out.println(class_id);
				if (class_id == null || (class_id.trim()).length() == 0) {
					erMsgs.add("�п�J�ҵ{�s��");
				}
				// Send the use back to the form, if there were errors
				if (!erMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/class_info/select_pageClass_info.jsp");
					failureView.forward(req, res);
					return;//�{�����_
				}
				
//				Integer num = null;
//				try {
//					num = new Integer(class_id);
//				} catch (Exception e) {
//					erMsgs.add("�ҵ{�s���榡�����T");
//				}
//				// Send the use back to the form, if there were errors
//				if (!erMsgs.isEmpty()) {
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/back-end/class_info/select_pageClass_info.jsp");
//					failureView.forward(req, res);
//					return;//�{�����_
//				}
				
				/***************************2.�}�l�d�߸��*****************************************/
				Class_infoService ciSvc = new Class_infoService();
				Class_infoVO Class_infoVO = ciSvc.getOneClass_info(class_id);
				if (Class_infoVO == null) {
					erMsgs.add("�d�L���");
				}
				// Send the use back to the form, if there were errors
				if (!erMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/class_info/select_pageClass_info.jsp");
					failureView.forward(req, res);
					return;//�{�����_
				}
				
				/***************************3.�d�ߧ���,�ǳ����(Send the Success view)*************/
				req.setAttribute("Class_infoVO", Class_infoVO); // ��Ʈw���X��Class_infoVO����,�s�Jreq
				String url = "/back-end/class_info/listOneClass_info.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // ���\��� listOneEmp.jsp
				successView.forward(req, res);

				/***************************��L�i�઺���~�B�z*************************************/
			} catch (Exception e) {
				erMsgs.add("�L�k���o���:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/class_info/select_pageClass_info.jsp");
				failureView.forward(req, res);
			}
		}
		
		
		if ("getOne_For_Update".equals(action)) { // �Ӧ�listAllClass_info.jsp���ШD

			List<String> erMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("erMsgs", erMsgs);
			
			try {
				/***************************1.�����ШD�Ѽ�****************************************/
				String class_id = req.getParameter("class_id");
				
				/***************************2.�}�l�d�߸��****************************************/
				Class_infoService ciSvc = new Class_infoService();
				Class_infoVO Class_infoVO = ciSvc.getOneClass_info(class_id);
								
				/***************************3.�d�ߧ���,�ǳ����(Send the Success view)************/
				req.setAttribute("Class_infoVO", Class_infoVO);         // ��Ʈw���X��Class_infoVO����,�s�Jreq
				String url = "/back-end/class_info/update_Class_info_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// ���\��� update_Class_info_input.jsp
				successView.forward(req, res);

				/***************************��L�i�઺���~�B�z**********************************/
			} catch (Exception e) {
				erMsgs.add("�L�k���o�n�ק諸���:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/class_info/listAllClass_info.jsp");
				failureView.forward(req, res);
			}
		}
		
		
		if ("update".equals(action)) { // �Ӧ�update_Class_info_input.jsp���ШD
			
			List<String> erMsgs = new LinkedList<String>();
			req.setAttribute("erMsgs", erMsgs);
		
			try {
				/***************************1.�����ШD�Ѽ� - ��J�榡�����~�B�z**********************/
				String class_id = req.getParameter("class_id").trim();
				String class_name = req.getParameter("class_name");
				if (class_name == null || class_name.trim().length() == 0) {
					erMsgs.add("�ҵ{�W��: �ФŪť�");
				}
				
				String member_id = req.getParameter("member_id");
				String memidReg = "^[(a-zA-Z0-9_)]{8}$";
				if (member_id == null || member_id.trim().length() == 0) {
					erMsgs.add("�|���s��: �ФŪť�");
				} 
				else if(!member_id.trim().matches(memidReg)) { //�H�U�m�ߥ��h(�W)��ܦ�(regular-expression)
					erMsgs.add("�|���s��: �u��O�^��r���M�Ʀr, �B���ץ�����10");
	            }
				String subclass_id = req.getParameter("subclass_id");
				String subclass_idReg = "^[(a-zA-Z0-9_)]{8}$";
				if (subclass_id == null || subclass_id.trim().length() == 0) {
					erMsgs.add("�����O�ҵ{�s��: �ФŪť�");
				} 
				else if(!subclass_id.trim().matches(subclass_idReg)) { //�H�U�m�ߥ��h(�W)��ܦ�(regular-expression)
					erMsgs.add("�����O�ҵ{�s��: �u��O�^��r���M�Ʀr, �B���ץ�����10");
	            }
				Timestamp startfund_date = null;
				try {					
					startfund_date = java.sql.Timestamp.valueOf(req.getParameter("startfund_date").trim());
				} catch (IllegalArgumentException e) {
					erMsgs.add("�п�J�}�l�Ҹ���");
					System.out.println(startfund_date);
				}				
				Timestamp startclass_time = null;
				try {
					startclass_time = java.sql.Timestamp.valueOf(req.getParameter("startclass_time").trim());
				} catch (IllegalArgumentException e) {
					erMsgs.add("�п�J�}�Ҥ��");
				}
				String class_description = req.getParameter("class_description");
				if (class_description == null || class_description.trim().length() == 0) {
					erMsgs.add("�ҵ{�y�z: �ФŪť�");
				} 
				Part part = req.getPart("class_picture");
				byte[] class_picture = null;
				InputStream fis = part.getInputStream();
				if(fis.available() != 0) {
					class_picture = new byte[fis.available()];
					fis.read(class_picture);
					fis.close();
				}else {
					erMsgs.add("�ФW�ǽҵ{�Ϥ�");
				}

				Integer startfund_price = Integer.valueOf(req.getParameter("startfund_price"));
				String startfund_priceReg = "^[(0-9)]";
				if (req.getParameter("startfund_price") == null || req.getParameter("startfund_price").trim().length() == 0) {
					erMsgs.add("�Ҹ���: �ФŪť�");
				} 
//				else if(!req.getParameter("startfund_price").trim().matches(startfund_priceReg) && startfund_price < 50) { //�H�U�m�ߥ��h(�W)��ܦ�(regular-expression)
//					erMsgs.add("�Ҹ���: �u��O�Ʀr, �B���B�����j��50");
//	            }
				Integer original_price = Integer.valueOf(req.getParameter("original_price"));
				String original_priceReg = "^[(0-9)]";
				if (req.getParameter("original_price") == null || req.getParameter("original_price").trim().length() == 0) {
					erMsgs.add("�w��: �ФŪť�");
				}
//				else if(!req.getParameter("original_price").trim().matches(original_priceReg) && original_price < 100) { //�H�U�m�ߥ��h(�W)��ܦ�(regular-expression)
//					erMsgs.add("�w��: �u��O�Ʀr, �B���B�����j��100");
//	            }
				Integer people_threshold = Integer.valueOf(req.getParameter("people_threshold"));
				String peopleTReg = "^[(0-9)]";
				if (req.getParameter("people_threshold") == null || req.getParameter("people_threshold").trim().length() == 0) {
					erMsgs.add("���e�H��: �ФŪť�");
				} 
//				else if(!req.getParameter("people_threshold").trim().matches(peopleTReg) && people_threshold < 30) { //�H�U�m�ߥ��h(�W)��ܦ�(regular-expression)
//					erMsgs.add("���e�H��: �u��O�Ʀr, �B�����j��30");
//	            }
				String class_length = req.getParameter("class_length");
//				String class_lengthReg = "^[(a-zA-Z0-9_)]{10}$";
//				int peopleT = Integer.parseInt(people_threshold);
				if (class_length == null || class_length.trim().length() == 0) {
					erMsgs.add("�ҵ{����: �ФŪť�");
				}
//				 else if(!people_threshold.trim().matches(peopleTReg) && peopleT >= 30) { //�H�U�m�ߥ��h(�W)��ܦ�(regular-expression)
//					erMsgs.add("���e�H��: �u��O�Ʀr, �B�����j��30");
//	            }		
				
				
				Part part_video = req.getPart("video_fundraising");
				byte[] video_fundraising = null;
				InputStream fisVF = part_video.getInputStream();
				if(fisVF.available() != 0) {
					video_fundraising = new byte[fisVF.available()];
					fisVF.read(video_fundraising);
					fisVF.close();
				}else {
					erMsgs.add("�ФW�ǶҸ�v��");
				}
				
				Timestamp update_time = null;
				update_time = new java.sql.Timestamp(System.currentTimeMillis());
				
				String admin_id = null;
				
				Integer class_status = 7;
				

				Class_infoVO class_infoVO = new Class_infoVO();
				class_infoVO.setClass_id(class_id);
				class_infoVO.setClass_name(class_name);
				class_infoVO.setMember_id(member_id);
				class_infoVO.setSubclass_id(subclass_id);
				class_infoVO.setStartfund_date(startfund_date);
				class_infoVO.setStartclass_time(startclass_time);
				class_infoVO.setClass_description(class_description);
				class_infoVO.setClass_picture(class_picture);
				class_infoVO.setStartfund_price(startfund_price);
				class_infoVO.setOriginal_price(original_price);
				class_infoVO.setPeople_threshold(people_threshold);
				class_infoVO.setClass_length(class_length);
				
				// Send the use back to the form, if there were errors
				if (!erMsgs.isEmpty()) {
					req.setAttribute("Class_infoVO", class_infoVO); // �t����J�榡���~��Class_infoVO����,�]�s�Jreq
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/class_info/update_Class_info_input.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************2.�}�l�s�W���***************************************/
				Class_infoService ciSvc = new Class_infoService();
				class_infoVO = ciSvc.updateClass_info(
						class_id, 
						class_name, 
						member_id, 
						class_status, 
						subclass_id, 
						startfund_date, 
						startclass_time, 
						class_description, 
						class_picture, 
						startfund_price, 
						original_price, 
						people_threshold, 
						class_length, 
						video_fundraising, 
						update_time, 
						admin_id);
						
				/***************************3.�s�W����,�ǳ����(Send the Success view)***********/
				
				String url = "/back-end/class_info/listAllClass_info.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // �s�W���\�����listAllClass_info.jsp
				successView.forward(req, res);				
				
				/***************************��L�i�઺���~�B�z**********************************/
			} catch (Exception e) {
				erMsgs.add(e.getMessage());
//				System.out.println(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/class_info/update_Class_info_input.jsp");
				failureView.forward(req, res);
			}
		}

        if ("insert".equals(action)) { // �Ӧ�addClass_info.jsp���ШD  
			
			List<String> erMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("erMsgs", erMsgs);
			
//			Map<String, String[]> map = req.getParameterMap();
//			Set<String> keySet = map.keySet();
//			for(String keyString : keySet) {
//				System.out.println(keyString);
//				System.out.println(map.get(keyString));
//			}
			
			

			try {
				/***********************1.�����ШD�Ѽ� - ��J�榡�����~�B�z*************************/
//String class_id = req.getParameter("class_id");
//				String enameReg = "^[(a-zA-Z0-9)]{10}$";
//				if (class_id == null || class_id.trim().length() == 0) {
//					erMsgs.add("�ҵ{�s��: �ФŪť�");
//				} else if(!class_id.trim().matches(enameReg)) { //�H�U�m�ߥ��h(�W)��ܦ�(regular-expression)
//					erMsgs.add("�ҵ{�s��: �u��O�^��r���M�Ʀr, �B���ץ�����10");
//	            }
				
				String class_name = req.getParameter("class_name");
				if (class_name == null || class_name.trim().length() == 0) {
					erMsgs.add("�ҵ{�W��: �ФŪť�");
				}
				
				String member_id = req.getParameter("member_id");
				String memidReg = "^[(a-zA-Z0-9_)]{8}$";
				if (member_id == null || member_id.trim().length() == 0) {
					erMsgs.add("�|���s��: �ФŪť�");
				} 
				else if(!member_id.trim().matches(memidReg)) { //�H�U�m�ߥ��h(�W)��ܦ�(regular-expression)
					erMsgs.add("�|���s��: �u��O�^��r���M�Ʀr, �B���ץ�����10");
	            }
				
				String subclass_id = req.getParameter("subclass_id");
				String subclass_idReg = "^[(a-zA-Z0-9_)]{8}$";
				if (subclass_id == null || subclass_id.trim().length() == 0) {
					erMsgs.add("�����O�ҵ{�s��: �ФŪť�");
				} 
				else if(!subclass_id.trim().matches(subclass_idReg)) { //�H�U�m�ߥ��h(�W)��ܦ�(regular-expression)
					erMsgs.add("�����O�ҵ{�s��: �u��O�^��r���M�Ʀr, �B���ץ�����10");
	            }
				
				Timestamp startfund_date = null;
				try {					
					startfund_date = java.sql.Timestamp.valueOf(req.getParameter("startfund_date").trim());
				} catch (IllegalArgumentException e) {
					erMsgs.add("�п�J�}�l�Ҹ���");
					System.out.println(startfund_date);
				}
				
//				java.sql.Date hiredate = null;
//				try {
//hiredate = java.sql.Date.valueOf(req.getParameter("hiredate").trim());
//				} catch (IllegalArgumentException e) {
//					hiredate=new java.sql.Date(System.currentTimeMillis());
//					errorMsgs.add("�п�J���!");
//				}
				
				
				Timestamp startclass_time = null;
				try {
					startclass_time = java.sql.Timestamp.valueOf(req.getParameter("startclass_time").trim());
//					System.out.println("1");
//					System.out.println(startclass_time);
				} catch (IllegalArgumentException e) {
//					startclass_time = new java.sql.Timestamp(System.currentTimeMillis());
					erMsgs.add("�п�J�}�Ҥ��");
//					System.out.println(startclass_time);
				}
				
				String class_description = req.getParameter("class_description");
				if (class_description == null || class_description.trim().length() == 0) {
					erMsgs.add("�ҵ{�y�z: �ФŪť�");
				} 
//				
				Part class_picture = req.getPart("class_picture");
				byte[] buffer = null;
				InputStream fis = class_picture.getInputStream();
				if(fis.available() != 0) {
					buffer = new byte[fis.available()];
					fis.read(buffer);
					fis.close();
				}else {
					erMsgs.add("�ФW�ǽҵ{�Ϥ�");
				}
				
				Integer startfund_price = Integer.valueOf(req.getParameter("startfund_price"));
				String startfund_priceReg = "^[(0-9)]";
				if (req.getParameter("startfund_price") == null || req.getParameter("startfund_price").trim().length() == 0) {
					erMsgs.add("�Ҹ���: �ФŪť�");
				} 
				else if(!req.getParameter("startfund_price").trim().matches(startfund_priceReg) && startfund_price < 50) { //�H�U�m�ߥ��h(�W)��ܦ�(regular-expression)
					erMsgs.add("�Ҹ���: �u��O�Ʀr, �B���B�����j��50");
	            }
				
				Integer original_price = Integer.valueOf(req.getParameter("original_price"));
				String original_priceReg = "^[(0-9)]";
				if (req.getParameter("original_price") == null || req.getParameter("original_price").trim().length() == 0) {
					erMsgs.add("�w��: �ФŪť�");
				}
				else if(!req.getParameter("original_price").trim().matches(original_priceReg) && original_price < 100) { //�H�U�m�ߥ��h(�W)��ܦ�(regular-expression)
					erMsgs.add("�w��: �u��O�Ʀr, �B���B�����j��100");
	            }
				
				Integer people_threshold = Integer.valueOf(req.getParameter("people_threshold"));
				String peopleTReg = "^[(0-9)]";
				if (req.getParameter("people_threshold") == null || req.getParameter("people_threshold").trim().length() == 0) {
					erMsgs.add("���e�H��: �ФŪť�");
				} 
				else if(!req.getParameter("people_threshold").trim().matches(peopleTReg) && people_threshold < 30) { //�H�U�m�ߥ��h(�W)��ܦ�(regular-expression)
					erMsgs.add("���e�H��: �u��O�Ʀr, �B�����j��30");
	            }
				
				String class_length = req.getParameter("class_length");
//				String class_lengthReg = "^[(a-zA-Z0-9_)]{10}$";
//				int peopleT = Integer.parseInt(people_threshold);
				if (class_length == null || class_length.trim().length() == 0) {
					erMsgs.add("�ҵ{����: �ФŪť�");
				}
//				 else if(!people_threshold.trim().matches(peopleTReg) && peopleT >= 30) { //�H�U�m�ߥ��h(�W)��ܦ�(regular-expression)
//					erMsgs.add("���e�H��: �u��O�Ʀr, �B�����j��30");
//	            }		
//				
				
				Part video_fundraising = req.getPart("video_fundraising");
				byte[] bufferVF = null;
				InputStream fisVF = video_fundraising.getInputStream();
				if(fisVF.available() != 0) {
					bufferVF = new byte[fisVF.available()];
					fisVF.read(bufferVF);
					fisVF.close();
				}else {
					erMsgs.add("�ФW�ǶҸ�v��");
				}
				
				Timestamp update_time = null;
				update_time = new java.sql.Timestamp(System.currentTimeMillis());
				
				String admin_id = null;
				
				Integer class_status = 7;
				

				Class_infoVO class_infoVO = new Class_infoVO();
				class_infoVO.setClass_name(class_name);
				class_infoVO.setMember_id(member_id);
				class_infoVO.setSubclass_id(subclass_id);
				class_infoVO.setStartfund_date(startfund_date);
				class_infoVO.setStartclass_time(startclass_time);
				class_infoVO.setClass_description(class_description);
				class_infoVO.setClass_picture(buffer);
				class_infoVO.setStartfund_price(startfund_price);
				class_infoVO.setOriginal_price(original_price);
				class_infoVO.setPeople_threshold(people_threshold);
				class_infoVO.setClass_length(class_length);
				

				// Send the use back to the form, if there were errors
				if (!erMsgs.isEmpty()) {
					req.setAttribute("Class_infoVO", class_infoVO); // �t����J�榡���~��Class_infoVO����,�]�s�Jreq
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/class_info/addClass_info.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************2.�}�l�s�W���***************************************/
				Class_infoService ciSvc = new Class_infoService();
				class_infoVO = ciSvc.addClass_info(class_name, member_id, class_status, subclass_id, startfund_date, startclass_time, class_description, buffer, startfund_price, original_price, people_threshold, class_length, bufferVF, update_time, admin_id);
				
				/***************************3.�s�W����,�ǳ����(Send the Success view)***********/
				String url = "/back-end/class_info/listAllClass_info.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // �s�W���\�����listAllEmp.jsp
				successView.forward(req, res);				
				
				/***************************��L�i�઺���~�B�z**********************************/
			} catch (Exception e) {
				erMsgs.add(e.getMessage());
//				System.out.println(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/class_info/addClass_info.jsp");
				failureView.forward(req, res);
			}
		}
		
		
		if ("delete".equals(action)) { // �Ӧ�listAllClass_info.jsp

			List<String> erMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("erMsgs", erMsgs);
	
			try {
				/***************************1.�����ШD�Ѽ�***************************************/
				String class_id = req.getParameter("class_id");
				System.out.println(class_id);
				
				/***************************2.�}�l�R�����***************************************/
				Class_infoService ciSvc = new Class_infoService();
				ciSvc.deleteClass_info(class_id);
				
				/***************************3.�R������,�ǳ����(Send the Success view)***********/								
				String url = "/back-end/class_info/listAllClass_info.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// �R�����\��,���^�e�X�R�����ӷ�����
				successView.forward(req, res);
				
				/***************************��L�i�઺���~�B�z**********************************/
			} catch (Exception e) {
				erMsgs.add("�R����ƥ���:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/class_info/listAllClass_info.jsp");
				failureView.forward(req, res);
			}
		}
		
		
		
	}


}
