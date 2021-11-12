package com.backend.component.validation;

public class CheckAbsentEmptySpacesValidation implements Validation {

	@Override
	public boolean isValid(String value) {

		return value != null && value.indexOf(' ') < 0;

	}

}
