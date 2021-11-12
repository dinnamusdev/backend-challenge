package com.backend.component.validation;

import com.backend.util.StringsUtil;

public class CheckPresenceAtLessOneSpecialCharacterValidation implements Validation {

	@Override
	public boolean isValid(String value) {
		if (value != null && !value.isEmpty()) {
			for (char ch : value.toCharArray()) {

				if (!(StringsUtil.isAlpha(ch) || Character.isDigit(ch)) && !"!@#$%^&*()-+".contains(String.valueOf(ch)))
					return false;
			}
			return true;
		} else {
			return false;
		}
	}

}
