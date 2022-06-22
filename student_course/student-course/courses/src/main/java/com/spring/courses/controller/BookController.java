package com.spring.courses.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.courses.model.Book;
import com.spring.courses.model.Courses;
import com.spring.courses.service.BookService;
import com.spring.courses.service.CourseService;
import com.spring.courses.util.FindAllBooksByCourse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("book")
@SecurityRequirement(name="book")
public class BookController {

	@Autowired
	private BookService service;

	@Operation(summary = "This is to Fetch All Books from Database")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = " Fetches all Books by Courses from database", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "404", description = " Page Not Found", content = @Content) })

	@GetMapping("/findBookByCourse/{id}")
	public ResponseEntity<?> findAllStudent(@PathVariable long id) {
		
		
		return null;
		
		
		/*
		 * //return new ResponseEntity<List<Courses>>(service.), HttpStatus.OK);
		 * List<Book> findBooksByCourse = service.findBooksByCourse();
		 * 
		 * List<Book> findBooks = FindAllBooksByCourse.findBooks(id ,
		 * findBooksByCourse); if(findBooks.size()>0) { return new
		 * ResponseEntity<List<Book>>(findBooksByCourse, HttpStatus.OK); } return new
		 * ResponseEntity<String>("No Books Found For Course", HttpStatus.NOT_FOUND);
		 */
	}

	
}
