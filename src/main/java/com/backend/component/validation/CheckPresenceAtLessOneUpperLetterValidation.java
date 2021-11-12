package com.backend.component.validation;

import com.backend.util.StringsUtil;

public class CheckPresenceAtLessOneUpperLetterValidation implements Validation {

	@Override
	public boolean isValid(String value) {
		if (value != null && !value.isEmpty()) {
			for (char ch : value.toCharArray()) {
				if (StringsUtil.isAlpha(ch) && Character.isUpperCase(ch)) {
					return true;
				}
			}
		}
		return false;
	}
}
