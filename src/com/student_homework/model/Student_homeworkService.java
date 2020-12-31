package com.student_homework.model;

import java.sql.Timestamp;
import java.util.List;

import com.class_chapter.model.Class_chapterService;
import com.class_chapter.model.Class_chapterVO;

public class Student_homeworkService {
	private Student_homeworkDAO_interface dao;
	public Student_homeworkService() {
		dao = new Student_homeworkJDBCDAO();
	}
	
	public Student_homeworkVO insert(String teacherhw_id,String member_id,byte[] file_data) {
		Student_homeworkVO vo = new Student_homeworkVO();
		vo.setTeacherhw_id(teacherhw_id);
		vo.setMember_id(member_id);
		vo.setFile_data(file_data);
		vo.setHw_uploadtime(new Timestamp(System.currentTimeMillis()));
		vo.setHw_updatetime(new Timestamp(System.currentTimeMillis()));
		dao.insert(vo);
		return vo;
	}
	public Student_homeworkVO update(String studenthw_id,String teacherhw_id,String member_id,byte[] file_data,Timestamp hw_uploadtime) {
		Student_homeworkVO vo = new Student_homeworkVO();
		vo.setStudenthw_id(studenthw_id);
		vo.setTeacherhw_id(teacherhw_id);
		vo.setMember_id(member_id);
		vo.setFile_data(file_data);
		vo.setHw_uploadtime(hw_uploadtime);
		vo.setHw_updatetime(new Timestamp(System.currentTimeMillis()));
		dao.update(vo);
		return vo;
	}
	public void delete(String studenthw_id) {
		dao.delete(studenthw_id);
	}
	public Student_homeworkVO select(String studenthw_id) {
		return dao.select(studenthw_id);
	}
	public List<Student_homeworkVO> getAll(){
		return dao.getAll();
	}
	public static void main(String[] args) {
		Student_homeworkService service = new Student_homeworkService();
		service.insert("TH00003","MEM00007",null);
		Student_homeworkVO vo_select = service.select("SH00011");
		System.out.println("teacherhw_id:"+vo_select.getTeacherhw_id());
		System.out.println("member_id:"+vo_select.getMember_id());
		System.out.println("file_data:"+vo_select.getFile_data());
		System.out.println("hw_uploadtime:"+vo_select.getHw_uploadtime());
		System.out.println("hw_updatetime:"+vo_select.getHw_updatetime());
		System.out.println("==============");
		service.update("SH00011","TH00002","MEM00006",null,Timestamp.valueOf("2020-10-11 20:08:32"));
		Student_homeworkVO vo_select2 = service.select("SH00011");
		System.out.println("teacherhw_id:"+vo_select2.getTeacherhw_id());
		System.out.println("member_id:"+vo_select2.getMember_id());
		System.out.println("file_data:"+vo_select2.getFile_data());
		System.out.println("hw_uploadtime:"+vo_select2.getHw_uploadtime());
		System.out.println("hw_updatetime:"+vo_select2.getHw_updatetime());
		System.out.println("==============");
		service.delete("SH00011");
		System.out.println("==============");
		List<Student_homeworkVO> test_list = service.getAll();
		for(Student_homeworkVO temp_vo: test_list) {
			System.out.println(temp_vo.getStudenthw_id());
			System.out.println(temp_vo.getTeacherhw_id());
			System.out.println(temp_vo.getMember_id());
			System.out.println(temp_vo.getFile_data());
			System.out.println(temp_vo.getHw_uploadtime());
			System.out.println(temp_vo.getHw_updatetime());
			System.out.println("=======================================");
		}
	}
	
}
