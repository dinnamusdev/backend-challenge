package com.backend.component.validation;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CheckAbsentEmptySpacesValidation implements Validation {

	@Override
	public boolean isValid(String value) {
		if (value == null) {
			log.error("informado valor nulo");
			return false;
		} else {
			return !value.contains(" ");
		}
		
	}

}
