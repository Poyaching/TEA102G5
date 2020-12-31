package com.class_info.model;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public class Class_infoService {
	private Class_info_interface dao;
	
	public Class_infoService() {
		dao = new Class_infoJDBCDAO();
	}
	
	public Class_infoVO addClass_info(
	 String class_name,
	 String member_id,
	 Integer class_status,
	 String subclass_id,
	 Timestamp startfund_date,
	 Timestamp startclass_time,
	 String class_description,
	 byte[] class_picture,
	 Integer startfund_price,
	 Integer original_price,
	 Integer people_threshold,
	 String class_length,
	 byte[] video_fundraising,
	 Timestamp update_time,
	 String admin_id) {
		
		Class_infoVO ciVO = new Class_infoVO();
		ciVO.setClass_name(class_name);
		ciVO.setMember_id(member_id);
		ciVO.setClass_status(class_status);
		ciVO.setSubclass_id(subclass_id);
		ciVO.setStartfund_date(startfund_date);
		ciVO.setStartclass_time(startclass_time);
		ciVO.setClass_description(class_description);
		ciVO.setClass_picture(class_picture);
		ciVO.setStartfund_price(startfund_price);
		ciVO.setOriginal_price(original_price);
		ciVO.setPeople_threshold(people_threshold);
		ciVO.setClass_length(class_length);
		ciVO.setVideo_fundraising(video_fundraising);
		ciVO.setUpdate_time(update_time);
		ciVO.setAdmin_id(admin_id);
		dao.insert(ciVO);
		return ciVO;
		
	}
	
	public Class_infoVO updateClass_info(
			 String class_id,
			 String class_name,
			 String member_id,
			 Integer class_status,
			 String subclass_id,
			 Timestamp startfund_date,
			 Timestamp startclass_time,
			 String class_description,
			 byte[] class_picture,
			 Integer startfund_price,
			 Integer original_price,
			 Integer people_threshold,
			 String class_length,
			 byte[] video_fundraising,
			 Timestamp update_time,
			 String admin_id) {
				
				Class_infoVO ciVO = new Class_infoVO();
				
				ciVO.setClass_id(class_id);
				ciVO.setClass_name(class_name);
				ciVO.setMember_id(member_id);
				ciVO.setClass_status(class_status);
				ciVO.setSubclass_id(subclass_id);
				ciVO.setStartfund_date(startfund_date);
				ciVO.setStartclass_time(startclass_time);
				ciVO.setClass_description(class_description);
				ciVO.setClass_picture(class_picture);
				ciVO.setStartfund_price(startfund_price);
				ciVO.setOriginal_price(original_price);
				ciVO.setPeople_threshold(people_threshold);
				ciVO.setClass_length(class_length);
				ciVO.setVideo_fundraising(video_fundraising);
				ciVO.setUpdate_time(update_time);
				ciVO.setAdmin_id(admin_id);
				
				
				dao.update(ciVO);
				return ciVO;
				
			}	
	
	public void deleteClass_info(String class_id) {
    	dao.delete(class_id);
    }
    
    public Class_infoVO getOneClass_info(String class_id) {
    	return dao.findByPrimaryKey(class_id);
    }
    public List<Class_infoVO> getAll(){
    	return dao.getAll();
    }
	public List<Class_infoVO> get_ROWNUM_8(){
    	return dao.get_ROWNUM_8();
    }
	
	public byte[] getClassPic(String class_id){
    	return dao.findByPrimaryKey_pic(class_id);
    }
	
	public byte[] getClassVideo(String class_id){
    	return dao.findByPrimaryKey_video(class_id);
    }
	
	public List<Class_infoVO> getAll(Map<String,String[]> map){
    	return dao.getAll(map);
    }
	
    public List<Class_infoVO> getTeachAll(String member_id){
    	return dao.getTeachAll(member_id);
    }

}
