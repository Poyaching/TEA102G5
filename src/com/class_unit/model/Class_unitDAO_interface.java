package com.class_unit.model;

import java.util.List;

public interface Class_unitDAO_interface {
	public void insert(Class_unitVO class_unitVO);
	public void update(Class_unitVO class_unitVO);
	public void delete(String unit_id);
	public Class_unitVO findByPrimaryKey(String unit_id);
	public List<Class_unitVO> getAll();
	public List<Class_unitVO> getChapter_id(String chapter_id) ;
}
