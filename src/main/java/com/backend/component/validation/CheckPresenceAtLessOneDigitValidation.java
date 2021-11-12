package com.backend.component.validation;

public class CheckPresenceAtLessOneDigitValidation implements Validation {

	@Override
	public boolean isValid(String value) {
		if (value != null && !value.isEmpty() ) {
			for (char ch : value.toCharArray()) {
				if (Character.isDigit(ch)) {
					return true;					
				}
			}			
		}
		return false;
	}

}
