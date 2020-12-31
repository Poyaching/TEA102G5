package com.class_info.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.class_chapter.model.Class_chapterService;
import com.class_chapter.model.Class_chapterVO;
import com.class_info.model.Class_infoService;
import com.class_info.model.Class_infoVO;
import com.class_unit.model.Class_unitService;
import com.class_unit.model.Class_unitVO;

/**
 * Servlet implementation class Class_infoServlet
 */
@WebServlet("/Class_info/Class_learnServlet")
public class Class_learnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Class_learnServlet() {
	}
	

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		//課程學習頁面
		if ("class_Introduction".equals(action)) {
			String class_id = req.getParameter("class_id");
			Class_infoService Srv = new Class_infoService(); // 呼叫Service方法
			Class_infoVO class_infoVO = Srv.getOneClass_info(class_id); // 利用id得到物件
			if (class_infoVO != null) { // 判斷檔案是否存在
				req.setAttribute("class_infoVO", class_infoVO);
				System.out.println(class_infoVO.getClass_id());
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/class_info/classlearn.jsp");  //classOnly.jsp classlearn.jsp
				failureView.forward(req, res);
				return;
			}
		}

		if ("class_pic_sm".equals(action)) {
			res.setContentType("image/jpeg"); // 設定回應類型
			String class_id = req.getParameter("class_id");
			Class_infoService Srv = new Class_infoService(); // 呼叫Service方法
			byte[] getClassPic = Srv.getClassPic(class_id);
			OutputStream out = res.getOutputStream(); // 建立輸出流
			int sm = 200;
			try {
				if (getClassPic != null || getClassPic.length != 0) { // 判斷檔案是否存在
					byte[] scaledPic = com.image.ImageUtil.shrink(getClassPic, sm);
					res.setContentLength(scaledPic.length); // 通知瀏覽器檔案長度
					InputStream in = new ByteArrayInputStream(scaledPic); // 將byte[]轉換成InputStream
					byte[] buf = new byte[scaledPic.length]; // 4K buffer //設定byte[]大小
					int len;
					while ((len = in.read(buf)) != -1) {
						out.write(buf, 0, len); // 將資料輸出
					}
				} else {
					// 查詢值不存在

					InputStream in = getServletContext().getResourceAsStream("/img/NoResult/unnamed.jpg");
					byte[] b = new byte[in.available()];
					in.read(b);
					out.write(b);
					in.close();
				}
			} catch (Exception e) {
				
				// 沒有輸入查詢值
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
