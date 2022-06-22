package com.spring.courses.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Error {

	private Date timestamp;
	private String message;
	private String details;
}
