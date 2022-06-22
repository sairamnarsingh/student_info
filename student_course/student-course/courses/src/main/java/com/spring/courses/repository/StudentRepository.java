package com.spring.courses.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.courses.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
