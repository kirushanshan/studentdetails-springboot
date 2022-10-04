package com.sgic.student.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.student.manage.entities.Student;
import com.sgic.student.manage.service.StudentDetailDto;
import com.sgic.student.manage.service.StudentService;

@RestController
public class StudentDetailsController {

	@Autowired
	StudentService studentService;
	
	@PostMapping("student/details")
	public ResponseEntity<Object> getStudentDetails(@RequestBody StudentDetailDto std) {
		Student student = new Student();
		student.setId(std.getId());
		student.setFullName(std.getFullName());
		student.setEmail(std.getEmail());
		student.setAge(std.getAge());
		student.setGender(std.getGender());
		student.setAddress(std.getAddress());
		

			studentService.saveStudentDetails(student);
			return ResponseEntity.ok("Sucessfully Added");
	
		
		
	}
	
	@GetMapping("/student/{id}")
	public ResponseEntity<Object> getStudentDetailById(@PathVariable int id) {
		
		return ResponseEntity.ok(studentService.getStudentById(id));
	}
}







