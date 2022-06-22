package com.spring.courses.service;

import java.util.List;

import com.spring.courses.model.Courses;

public interface CourseService {
	
	public List<Courses> getAllCourses();
	public Courses findCourseById(long courseId);

}
