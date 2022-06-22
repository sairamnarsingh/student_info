package com.spring.courses.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.courses.model.Book;
import com.spring.courses.model.Student;
import com.spring.courses.service.StudentService;
import com.spring.courses.util.FindBooksByStudent;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("student")
@SecurityRequirement(name="course")
public class StudentController {
	
	@Autowired
	private StudentService service;

    @Operation(summary = "This is to Courses  to the Student in the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
            description = " Student in the database",
            content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
            description = " Page Not Found",
            content = @Content)
    })

	
	
	
	@PostMapping("/add/student")
	public ResponseEntity<?> addStudent(@RequestBody Student student){
		Student addStudent = service.addStudent(student);
		return new ResponseEntity<String>("Student Added Successfully "+ addStudent.getStudentName(), HttpStatus.CREATED);
	}
    
    @GetMapping("/allstudents")
	public ResponseEntity<?> findAllStudent(){
    		return new ResponseEntity<List<Student>>(service.allStudents(), HttpStatus.OK);
		
		//return new ResponseEntity<String>("Student Added Successfully "+ addStudent.getStudentName(), HttpStatus.CREATED);
	}
	
    @GetMapping("/allstudents")
   	public ResponseEntity<?> findBooksByStudent(@PathVariable long id){
    	
    	Student byStudnetId = service.byStudnetId(id);
    	List<Set<Book>> books= FindBooksByStudent.findBooksByStudent(byStudnetId);
		return new ResponseEntity<List<Set<Book>>>(books, HttpStatus.OK);
    	
   	}
   	
}
