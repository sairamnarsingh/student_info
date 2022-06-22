package com.spring.courses.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.courses.model.Book;
import com.spring.courses.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepo;

	@Override
	public List<Book> findBooksByCourse() {
		List<Book> findAll = bookRepo.findAll();
		return findAll;
	}

}
