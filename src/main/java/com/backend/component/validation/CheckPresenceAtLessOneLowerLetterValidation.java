package com.backend.component.validation;

import com.backend.util.StringsUtil;

import lombok.extern.slf4j.Slf4j;

public class CheckPresenceAtLessOneLowerLetterValidation implements Validation {

	@Override
	public boolean isValid(String value) {		
		if (value != null && !value.isEmpty() ) {
			for (char ch : value.toCharArray()) {
				if (StringsUtil.isAlpha(ch) && Character.isLowerCase(ch) ) {
					return true;					
				}
			}			
		}
		return false;		
	}
}
