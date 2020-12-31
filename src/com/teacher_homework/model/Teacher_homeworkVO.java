package com.teacher_homework.model;

import java.util.Arrays;
import java.sql.Date;
import java.sql.Timestamp;

public class Teacher_homeworkVO {
	private String teacherhw_id;
	private String unit_id;
	private String hw_name;
	private String hw_content;
	private byte[] file_data;
	private Timestamp hw_uploadtime;
	private Timestamp hw_updatetime;
	@Override
	public String toString() {
		return "Teacher_homeworkVO [teacherhw_id=" + teacherhw_id + ", unit_id=" + unit_id + ", hw_name=" + hw_name
				+ ", hw_content=" + hw_content + ", file_data=" + Arrays.toString(file_data) + ", hw_uploadtime="
				+ hw_uploadtime + ", hw_updatetime=" + hw_updatetime + "]";
	}
	public String getTeacherhw_id() {
		return teacherhw_id;
	}
	public void setTeacherhw_id(String teacherhw_id) {
		this.teacherhw_id = teacherhw_id;
	}
	public String getUnit_id() {
		return unit_id;
	}
	public void setUnit_id(String unit_id) {
		this.unit_id = unit_id;
	}
	public String getHw_name() {
		return hw_name;
	}
	public void setHw_name(String hw_name) {
		this.hw_name = hw_name;
	}
	public String getHw_content() {
		return hw_content;
	}
	public void setHw_content(String hw_content) {
		this.hw_content = hw_content;
	}
	public byte[] getFile_data() {
		return file_data;
	}
	public void setFile_data(byte[] file_data) {
		this.file_data = file_data;
	}
	public Timestamp getHw_uploadtime() {
		return hw_uploadtime;
	}
	public void setHw_uploadtime(Timestamp hw_uploadtime) {
		this.hw_uploadtime = hw_uploadtime;
	}
	public Timestamp getHw_updatetime() {
		return hw_updatetime;
	}
	public void setHw_updatetime(Timestamp hw_updatetime) {
		this.hw_updatetime = hw_updatetime;
	}

}
