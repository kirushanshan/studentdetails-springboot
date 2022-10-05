package com.sgic.student.manage.service;

import java.util.List;

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

	@Override
	public String deleteStudentDetail(int id) {
		String response;
		try {
			studentRepositry.deleteById(id);
			response = "Sucessfully delete student detail";
		}catch (Exception e) {
			response = "unSucessfully delete student detail";
		}
		
		return response;
	}

	@Override
	public String updateStudentDetail(Student student) {
		String response;
		try {
			studentRepositry.saveAndFlush(student);
			response = "sucessfully updated";
		}catch(Exception e) {
			response = "unsucessfully updated";
		}
		
		return response;
	}

	@Override
	public List<Student> getAllStudentDetails() {
		
		return studentRepositry.findAll();
	}

}
