package com.class_info.model;

import java.util.*;


public interface Class_info_interface {

	public void insert(Class_infoVO class_infoVO);
    public void update(Class_infoVO class_infoVO);
    public void delete(String class_id);
    public Class_infoVO findByPrimaryKey(String class_id);
    public List<Class_infoVO> getAll();
    public List<Class_infoVO> getTeachAll(String member_id);
	public List<Class_infoVO> get_ROWNUM_8();
    //萬用複合查詢(傳入參數型態Map)(回傳 List)
	public List<Class_infoVO> getAll(Map<String, String[]> map);
	public byte[] findByPrimaryKey_video(String class_infoVO);
	public byte[] findByPrimaryKey_pic(String class_infoVO);
	
}
