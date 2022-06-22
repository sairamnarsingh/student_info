package com.spring.courses.service;

import java.util.List;

import com.spring.courses.model.Book;

public interface BookService {

	public List<Book> findBooksByCourse();
}
