package com.spring.courses.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.courses.model.Student;
import com.spring.courses.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository repository;

	@Override
	public Student addStudent(Student s) {
		return repository.save(s);
	}

	@Override
	public Student updateStudent(Student s, long id) {
		return repository.save(s);
	}

	@Override
	public List<Student> allStudents() {
		return repository.findAll();
	}

	@Override
	public Student byStudnetId(long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	@Override
	public void deleteStudent(long id) {
		// TODO Auto-generated method stub

	}

}
