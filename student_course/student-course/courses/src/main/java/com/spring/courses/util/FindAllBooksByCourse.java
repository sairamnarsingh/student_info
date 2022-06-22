package com.spring.courses.util;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.spring.courses.model.Book;
import com.spring.courses.model.Courses;

public class FindAllBooksByCourse {


	public static Set<Set<Book>>  findBooks(long id, List<Courses> findBooksByCourse) {
		Set<Set<Book>> collect2 = findBooksByCourse.stream().filter(c-> c.getCourseid()==id).
				 map(c->c.getBook()).collect(Collectors.toSet());
		return collect2;
	}
	 
}
