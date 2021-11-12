package com.backend.exeception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.backend.dto.ValidationErrorDTO;
import com.backend.dto.ValidationErrorDTO.FieldValidation;

@ControllerAdvice
public class GlobalHandleException {
	@ExceptionHandler(MethodArgumentNotValidException.class)	
	public ResponseEntity<ValidationErrorDTO> handle(MethodArgumentNotValidException ex,  WebRequest request) {				
		List<FieldValidation> fieldErrors = new ArrayList<>();
		
		ex.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName =  ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();	        
	        fieldErrors.add(new FieldValidation(fieldName,errorMessage));	        
		});						
		
		return new ResponseEntity<ValidationErrorDTO>(
				new ValidationErrorDTO(
						"Validation failed", 
						fieldErrors , 
						LocalDateTime.now(),
						request.getContextPath()), HttpStatus.BAD_REQUEST);
	}
}
