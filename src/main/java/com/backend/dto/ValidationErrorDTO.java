package com.backend.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ValidationErrorDTO {

	String mensage;
	List<FieldValidation> fieldErrors;
	LocalDateTime dateTime;
	String uri;

	@Getter
	@Setter
	@AllArgsConstructor
	public static class FieldValidation {
		String field;
		String message;
	}

}
