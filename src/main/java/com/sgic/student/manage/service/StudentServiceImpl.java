package com.sgic.student.manage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.student.manage.entities.Student;
import com.sgic.student.manage.repositories.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepositry;

	@Override
	public void saveStudentDetails(Student student) {
		studentRepositry.save(student);
	
	}

	@Override
	public StudentDetailDto getStudentById(int id) {
		Student student = studentRepositry.findById(id).get();
		
		StudentDetailDto stDto = new StudentDetailDto();
		stDto.setId(student.getId());
		stDto.setFullName(student.getFullName());
		stDto.setEmail(student.getEmail());
		stDto.setAge(student.getAge());
		stDto.setGender(student.getGender());
		stDto.setAddress(student.getAddress());
		
		return stDto;
	}

}
