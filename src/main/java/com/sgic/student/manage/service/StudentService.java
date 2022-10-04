package com.sgic.student.manage.service;

import com.sgic.student.manage.entities.Student;

public interface StudentService {
	void saveStudentDetails(Student student);
	
	StudentDetailDto getStudentById(int id);
}
