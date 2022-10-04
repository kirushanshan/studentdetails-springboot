package com.sgic.student.manage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.student.manage.entities.Student;

public interface StudentRepository extends JpaRepository<Student,Integer> {

}
