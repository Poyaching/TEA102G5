package com.class_chapter.model;

import java.util.List;
import java.util.Map;

public class Class_chapterService {
	private Class_chapterDAO_interface dao;
	public Class_chapterService() {
		dao = new Class_chapterJDBCDAO();
	}
	
	public Class_chapterVO insert(String class_id,String chapter_name) {
		Class_chapterVO vo = new Class_chapterVO();
		vo.setClass_id(class_id);
		vo.setChapter_name(chapter_name);
		dao.insert(vo);
		return vo;
	}
	public Class_chapterVO update(String chapter_id,String class_id,String chapter_name) {
		Class_chapterVO vo = new Class_chapterVO();
		vo.setChapter_id(chapter_id);
		vo.setClass_id(class_id);
		vo.setChapter_name(chapter_name);
		dao.update(vo);
		return vo;
	}
	public void delete(String chapter_id) {
		dao.delete(chapter_id);
	}
	public Class_chapterVO select(String chapter_id) {
		return dao.select(chapter_id);
	}
	public List<Class_chapterVO> getAll(){
		return dao.getAll();
	}
	public List<Class_chapterVO> getAll(Map<String,String[]> map){
		return dao.getAll(map);
	}
	
	public List<Class_chapterVO> getClassAll(String class_id){
		return dao.getClassAll(class_id);
	}
	
//	public static void main(String[] args) {
//		Class_chapterService service = new Class_chapterService();
//		service.insert("CLA00010","service„insert•¦");
//		System.out.println(service.select("CLC00117").getClass_id());
//		System.out.println(service.select("CLC00117").getChapter_name());
//		System.out.println("==============");
//		service.update("CLC00117","CLA00011","service„upadte•¦");
//		service.select("CLC00117");
//		System.out.println(service.select("CLC00117").getClass_id());
//		System.out.println(service.select("CLC00117").getChapter_name());
//		System.out.println("==============");
//		service.delete("CLC00117");
//		System.out.println("==============");
//		List<Class_chapterVO> test_list = service.getAll();
//		for(Class_chapterVO test_vo: test_list) {
//			System.out.println("class_id:"+test_vo.getChapter_id());
//			System.out.println("class_id:"+test_vo.getClass_id());
//			System.out.println("chapter:"+test_vo.getChapter_name());
//		}
//	}
}
