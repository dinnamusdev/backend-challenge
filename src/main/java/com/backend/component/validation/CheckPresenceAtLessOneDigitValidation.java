package com.backend.component.validation;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CheckPresenceAtLessOneDigitValidation implements Validation {

	@Override
	public boolean isValid(String value) {

		if (value == null) {
			log.error("informado valor nulo");
			return false;
		} else {
			boolean isValid = false;
			for (char ch : value.toCharArray()) {
				if (Character.isDigit(ch)) {
					isValid = true;
					break;
				}
			}
			return isValid;
		}

	}

}
