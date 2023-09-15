package com.entity;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	   public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request){
	
		ErrorDeatials errorDetails=new ErrorDeatials(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
		
	}
	
	public ResponseEntity<?> globalExceptionHandler(Exception ex, WebRequest request){
		ErrorDeatials errorDeatils=new ErrorDeatials(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDeatils,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

}
