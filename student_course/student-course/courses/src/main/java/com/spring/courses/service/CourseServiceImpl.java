package com.spring.courses.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.courses.model.Courses;
import com.spring.courses.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseRepository courseRepo;
	
	@Override
	public List<Courses> getAllCourses() {
		List<Courses> findAll = courseRepo.findAll();
		return courseRepo.findAll();
	}

	@Override
	public Courses findCourseById(long courseId) {
		Optional<Courses> findById = courseRepo.findById(courseId);
		if (findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

}
