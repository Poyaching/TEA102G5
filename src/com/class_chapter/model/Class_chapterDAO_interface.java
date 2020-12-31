package com.class_chapter.model;

import java.util.List;
import java.util.Map;

import com.class_info.model.Class_infoVO;

public interface Class_chapterDAO_interface {
	public void insert(Class_chapterVO class_chapterVO);
	public void update(Class_chapterVO class_chapterVO);
	public void delete(String chapter_id);
	public Class_chapterVO select(String chapter_id);
	public List<Class_chapterVO> getClassAll(String class_id);
	public List<Class_chapterVO> getAll();
	public List<Class_chapterVO> getAll(Map<String, String[]> map);
}
