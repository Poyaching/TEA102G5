package com.class_info.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.class_info.model.Class_infoService;
import com.class_info.model.Class_infoVO;
import com.image.ImageUtil;


/**
 * Servlet implementation class Class_infoServlet
 */
@WebServlet("/Class_info/Class_Introduction")
public class Class_IntroductionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Class_IntroductionServlet() {
	}
	

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		//�ҵ{�d�߭���
		if ("search".equals(action)) {
			String Category = req.getParameter("Category");
			if("class_list_search".equals(Category)) {
				String class_name = req.getParameter("class_name");
				String class_status = req.getParameter("class_status");
				Class_infoService Srv = new Class_infoService(); // �I�sService��k
				Map<String , String[]> map = new HashMap<String , String[]>();
				String[] class_name_map = {class_name};
				String[] class_status_map_3 = {class_status};
				map.put("class_name", class_name_map);
				map.put("class_status", class_status_map_3);
//				map.put("class_name", class_status_map_4);
				List<Class_infoVO> class_infoVO = Srv.getAll(map);
				if(!class_infoVO.isEmpty()) {
					req.setAttribute("class_infoVO", class_infoVO);
					RequestDispatcher failureView = req.getRequestDispatcher("/front-end/class_info/class_list.jsp");
					failureView.forward(req, res);
					return;
				}else{
					RequestDispatcher failureView = req.getRequestDispatcher("/front-end/class_info/class_list_noitme.jsp");
					failureView.forward(req, res);
				}
			}else if("subclass".equals(Category)){
				String subclass_id = req.getParameter("subclass_id");
				Class_infoService Srv = new Class_infoService(); // �I�sService��k
				Map<String , String[]> map = new HashMap<String , String[]>();
				String[] subclass_id_map = {subclass_id};
				map.put("subclass_id", subclass_id_map);
				List<Class_infoVO> class_infoVO = Srv.getAll(map);
				if(!class_infoVO.isEmpty()) {
					req.setAttribute("class_infoVO", class_infoVO);
					RequestDispatcher failureView = req.getRequestDispatcher("/front-end/class_info/class_list.jsp");
					failureView.forward(req, res);
					return;
				}else{
					RequestDispatcher failureView = req.getRequestDispatcher("/front-end/class_info/class_list_noitme.jsp");
					failureView.forward(req, res);
				}
			}
		}
		if ("class_pic_sm".equals(action)) {
			res.setContentType("image/jpeg"); // �]�w�^������
			String class_id = req.getParameter("class_id");
			Class_infoService Srv = new Class_infoService(); // �I�sService��k
			byte[] getClassPic = Srv.getClassPic(class_id);
			OutputStream out = res.getOutputStream(); // �إ߿�X�y
			int sm = 200;
			try {
				if (getClassPic != null || getClassPic.length != 0) { // �P�_�ɮ׬O�_�s�b
					byte[] scaledPic = ImageUtil.shrink(getClassPic, sm);
					res.setContentLength(scaledPic.length); // �q���s�����ɮת���
					InputStream in = new ByteArrayInputStream(scaledPic); // �Nbyte[]�ഫ��InputStream
					byte[] buf = new byte[scaledPic.length]; // 4K buffer //�]�wbyte[]�j�p
					int len;
					while ((len = in.read(buf)) != -1) {
						out.write(buf, 0, len); // �N��ƿ�X
					}
				} else {
					// �d�߭Ȥ��s�b

					InputStream in = getServletContext().getResourceAsStream("/img/NoResult/unnamed.jpg");
					byte[] b = new byte[in.available()];
					in.read(b);
					out.write(b);
					in.close();
				}
			} catch (Exception e) {
				
				// �S����J�d�߭�
				InputStream in = getServletContext().getResourceAsStream("/img/NoResult/unnamed.jpg");
				byte[] b = new byte[in.available()];
				in.read(b);
				out.write(b);
				in.close();
			} finally {
				out.close();
			}
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	}

}
