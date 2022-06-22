package com.spring.courses.service;

import java.util.List;

import com.spring.courses.model.Student;

public interface StudentService {

	public Student addStudent(Student s);

	public Student updateStudent(Student s, long id);

	public List<Student> allStudents();

	public Student byStudnetId(long id);

	public void deleteStudent(long id);

	//ublic List<Student> findAllStudents();
}
