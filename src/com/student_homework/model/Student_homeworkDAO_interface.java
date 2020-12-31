package com.student_homework.model;

import java.util.List;

public interface Student_homeworkDAO_interface {
	public void insert(Student_homeworkVO student_homeworkVO);
	public void update(Student_homeworkVO student_homeworkVO);
	public void delete(String studenthw_id);
	public Student_homeworkVO select(String studenthw_id);
	public List<Student_homeworkVO> getAll();
}
