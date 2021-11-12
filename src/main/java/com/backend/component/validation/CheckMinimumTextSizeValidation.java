package com.backend.component.validation;

public class CheckMinimumTextSizeValidation implements Validation {

	@Override
	public boolean isValid(String value) {

		return value != null && value.length() >= 9;

	}

}
