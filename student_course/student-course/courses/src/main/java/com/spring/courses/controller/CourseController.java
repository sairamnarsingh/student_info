package com.spring.courses.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.courses.model.Book;
import com.spring.courses.model.Courses;
import com.spring.courses.service.CourseService;
import com.spring.courses.util.FindAllBooksByCourse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("course")
@SecurityRequirement(name="course")
public class CourseController {

	//Course Controller 
	
	
	@Autowired
	private CourseService service;

	@Operation(summary = "This is to Fetch All Courses from Database")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = " Fetches all Course from database", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "404", description = " Page Not Found", content = @Content) })

	@GetMapping("/allcourses")
	public ResponseEntity<?> findAllStudent() {
		return new ResponseEntity<List<Courses>>(service.getAllCourses(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable(value = "id") long courseId) {
		Courses findCourseById = service.findCourseById(courseId);
		if (findCourseById == null) {
			return new ResponseEntity<String>("No Course Found With Id " + courseId, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Courses>(findCourseById, HttpStatus.OK);
	}

	
	@GetMapping("/findBookByCourse/{id}")
	public ResponseEntity<?> findAllStudent(@PathVariable long id) {
		
		
		//return new ResponseEntity<List<Courses>>(service.), HttpStatus.OK);
		List<Courses> findBooksByCourse = service.getAllCourses();
	Set<Set<Book>> findBooks = FindAllBooksByCourse.findBooks(id , findBooksByCourse);
		if(findBooks.size()>0) {
			return new ResponseEntity<Set<Set<Book>>>(findBooks, HttpStatus.OK);
		}
		return new ResponseEntity<String>("No Books Found For Course "+id, HttpStatus.NOT_FOUND);
		
	}
	
	

}
