package com.main_message.model;

import java.sql.Timestamp;

import com.sun.xml.internal.ws.api.message.Message;

public class Main_messageVO implements java.io.Serializable{
	
	private String mainmsg_id;     //大留言id MM12345
	private String class_id;       //課程編號    CLA12345
	private String member_id;      //會員編號    MEM12345
	private Timestamp mainmsg_time;//時間
	private String mainmsg_text;   //留言文字
	private String msg_source;     //留言來源
	private Integer msg_status;    //訊息顯示狀態 預設1 , 0隱藏 1顯示
	
	
	public String getMainmsg_id() {
		return mainmsg_id;
	}
	public void setMainmsg_id(String mainmsg_id) {
		this.mainmsg_id = mainmsg_id;
	}
	public String getClass_id() {
		return class_id;
	}
	public void setClass_id(String class_id) {
		this.class_id = class_id;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public Timestamp getMainmsg_time() {
		return mainmsg_time;
	}
	public void setMainmsg_time(Timestamp mainmsg_time) {
		this.mainmsg_time = mainmsg_time;
	}
	public String getMainmsg_text() {
		return mainmsg_text;
	}
	public void setMainmsg_text(String mainmsg_text) {
		this.mainmsg_text = mainmsg_text;
	}
	public String getMsg_source() {
		return msg_source;
	}
	public void setMsg_source(String msg_source) {
		this.msg_source = msg_source;
	}
	public Integer getMsg_status() {
		return msg_status;
	}
	public void setMsg_status(Integer msg_status) {
		this.msg_status = msg_status;
	}
	
	//將狀態改為文字顯示method
	public String getMsg_statusword() {
		if(msg_status==1) {
			return "隱藏";
		}else {
			return "顯示";
		}
	}

	
	
}
