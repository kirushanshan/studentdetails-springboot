package com.sgic.student.manage.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.student.manage.entities.Student;
import com.sgic.student.manage.service.StudentDetailDto;
import com.sgic.student.manage.service.StudentService;

@RestController
public class StudentDetailsController {
	private static final Logger logger = LogManager.getLogger(StudentDetailsController.class);

	@Autowired
	StudentService studentService;
	
	@PostMapping("student/details")
	public ResponseEntity<Object> getStudentDetails(@RequestBody StudentDetailDto std) {
		logger.warn("error");
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
	
	@DeleteMapping("/student/delete/{id}")
	public ResponseEntity<Object> deleteStudentDetailById(@PathVariable int id) {
		
		return ResponseEntity.ok(studentService.deleteStudentDetail(id));
	}
	
	@PutMapping("/student/update/{id}")
	public ResponseEntity<Object> updateStudentDetail(@PathVariable int id, @RequestBody StudentDetailDto std) {
		Student student = new Student();
		student.setId(id);
		student.setFullName(std.getFullName());
		student.setEmail(std.getEmail());
		student.setAge(std.getAge());
		student.setGender(std.getGender());
		student.setAddress(std.getAddress());
		
		return ResponseEntity.ok(studentService.updateStudentDetail(student));
	}
	
	@GetMapping("/student/all/details")
	public ResponseEntity<Object> getAllStudentDetails() {
		return ResponseEntity.ok(studentService.getAllStudentDetails());
	}
}







