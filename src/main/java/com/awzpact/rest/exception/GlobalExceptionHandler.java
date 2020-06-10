package com.awzpact.rest.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	//handle specific exception
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest) {
		
		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), webRequest.getDescription(false),HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.NOT_FOUND);
	}
	
	
	//handle api exception
	@ExceptionHandler(ApiException.class)
	public ResponseEntity<?> handleApiException(ApiException exception, WebRequest webRequest) {
		
		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), webRequest.getDescription(false), HttpStatus.BAD_REQUEST.value());
		
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.OK);
	}
	
	
	//handle global exception
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleGlobalException(Exception exception, WebRequest webRequest) {
		
		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), webRequest.getDescription(false),HttpStatus.INTERNAL_SERVER_ERROR.value());
		
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
	} 
	
}
