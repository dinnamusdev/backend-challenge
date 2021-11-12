package com.backend.component.validation;

public class CheckMaximumTextSizeValidation implements Validation {

	@Override
	public boolean isValid(String value) {

		return value != null && value.length() <= 255;

	}

}
