package com.student.custom.exception.classes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Component
public class HandleCustomException extends ResponseEntityExceptionHandler{
	@ExceptionHandler(value=StudentAlreadyExistException.class)
	public ResponseEntity handleEmployeeAlreadyExistexception(StudentAlreadyExistException enf) {
		return new ResponseEntity("Student Already Exist in database", HttpStatus.CONFLICT);
	}

	@ExceptionHandler(value=StudentNotFoundException.class)
	public ResponseEntity handleEmployeeNotFoundexception(StudentNotFoundException enf) {
		return new ResponseEntity("Student Not Found in database", HttpStatus.NOT_FOUND);
	}

}
