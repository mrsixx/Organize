package com.es.agriculturafamiliar.exception.handler;

import java.time.LocalDateTime;

import com.es.agriculturafamiliar.dto.ExceptionPayloadDTO;
import com.es.agriculturafamiliar.exception.ResourceNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {ResourceNotFoundException.class})
	protected ResponseEntity<Object> handleUserAlreadyExistsException(ResourceNotFoundException exception) {
		ExceptionPayloadDTO exceptionPayload = ExceptionPayloadDTO.builder()
				.timestamp(LocalDateTime.now())
				.title("Resource not found")
				.statusCode(HttpStatus.NOT_FOUND.value())
				.description(exception.getMessage()) 
				.build();
		
		return new ResponseEntity<>(exceptionPayload, HttpStatus.NOT_FOUND);
	}
    
}