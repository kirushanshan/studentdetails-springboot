package com.sgic.student.manage.service;

import java.util.List;

import com.sgic.student.manage.entities.Student;

public interface StudentService {
	void saveStudentDetails(Student student);
	
	StudentDetailDto getStudentById(int id);
	
	String deleteStudentDetail(int id);
	
	String updateStudentDetail(Student student);

	List<Student> getAllStudentDetails();
}
