package com.spring.courses.util;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.spring.courses.model.Book;
import com.spring.courses.model.Courses;
import com.spring.courses.model.Student;

public class FindBooksByStudent {

	public static List<Set<Book>> findBooksByStudent(Student student ) {
		Set<Courses> courses = student.getCourses();
		List<Set<Book>> collect = courses.stream().map(Courses::getBook).collect(Collectors.toList());
		return collect;
		
		
	}

}
