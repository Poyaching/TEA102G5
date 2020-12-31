package com.teacher_homework.model;

import java.sql.Timestamp;
import java.util.List;

public class Teacher_homeworkService {
	private Teacher_homeworkDAO_interface dao;
	public Teacher_homeworkService() {
		dao = new Teacher_homeworkJDBCDAO();
	}
	
	public Teacher_homeworkVO insert(String unit_id,String hw_name,String hw_content,byte[] file_data) {
		Teacher_homeworkVO vo = new Teacher_homeworkVO();
		Timestamp hw_uploadtime = new Timestamp(System.currentTimeMillis());
		Timestamp hw_updatetime = new Timestamp(System.currentTimeMillis());
		vo.setUnit_id(unit_id);
		vo.setHw_name(hw_name);
		vo.setHw_content(hw_content);
		vo.setFile_data(file_data);
		vo.setHw_uploadtime(hw_uploadtime);
		vo.setHw_updatetime(hw_updatetime);
		dao.insert(vo);
		return vo;
	}
	public Teacher_homeworkVO update(String teacherhw_id,String unit_id,String hw_name,String hw_content,byte[] file_data,Timestamp hw_uploadtime) {
		Teacher_homeworkVO vo = new Teacher_homeworkVO();
		Timestamp hw_updatetime = new Timestamp(System.currentTimeMillis());
		vo.setTeacherhw_id(teacherhw_id);
		vo.setUnit_id(unit_id);
		vo.setHw_name(hw_name);
		vo.setHw_content(hw_content);
		vo.setFile_data(file_data);
		vo.setHw_uploadtime(hw_uploadtime);
		vo.setHw_updatetime(hw_updatetime);
		dao.update(vo);
		return vo;
	}
	public void delete(String teacherhw_id) {
		dao.delete(teacherhw_id);
	}
	public Teacher_homeworkVO select(String teacherhw_id) {
		return dao.select(teacherhw_id);
	}
	public List<Teacher_homeworkVO> getAll(){
		return dao.getAll();
	}
	
	public static void main(String[] args) {
		Teacher_homeworkService service = new Teacher_homeworkService();
		service.insert("UNI00001","DAO test","DAO insert test seccess",null);
		Teacher_homeworkVO vo_select = service.select("TH00011");
		System.out.println("unit_id:"+vo_select.getUnit_id());
		System.out.println("hw_name:"+vo_select.getHw_name());
		System.out.println("hw_content:"+vo_select.getHw_content());
		System.out.println("file_data:"+vo_select.getFile_data());
		System.out.println("hw_uploadtime:"+vo_select.getHw_uploadtime());
		System.out.println("hw_updatetime:"+vo_select.getHw_updatetime());
		System.out.println("==============");
		service.update("TH00011","UNI00001","DAO test2","DAO update test seccess",null,Timestamp.valueOf("1998-03-21 03:41:22"));
		Teacher_homeworkVO vo_select2 = service.select("TH00011");
		System.out.println("unit_id:"+vo_select2.getUnit_id());
		System.out.println("hw_name:"+vo_select2.getHw_name());
		System.out.println("hw_content:"+vo_select2.getHw_content());
		System.out.println("file_data:"+vo_select2.getFile_data());
		System.out.println("hw_uploadtime:"+vo_select2.getHw_uploadtime());
		System.out.println("hw_updatetime:"+vo_select2.getHw_updatetime());
		System.out.println("==============");
		service.delete("TH00011");
		System.out.println("==============");
		List<Teacher_homeworkVO> test_list = service.getAll();
		for(Teacher_homeworkVO temp_vo: test_list) {
			System.out.println(temp_vo.getTeacherhw_id());
			System.out.println(temp_vo.getUnit_id());
			System.out.println(temp_vo.getHw_name());
			System.out.println(temp_vo.getHw_content());
			System.out.println(temp_vo.getFile_data());
			System.out.println(temp_vo.getHw_uploadtime());
			System.out.println(temp_vo.getHw_updatetime());
			System.out.println("=======================================");
		}
	}
}
