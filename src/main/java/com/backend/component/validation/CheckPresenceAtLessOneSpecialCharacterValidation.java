package com.backend.component.validation;





import com.backend.util.StringsUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CheckPresenceAtLessOneSpecialCharacterValidation implements Validation {
	
	@Override
	public boolean isValid(String value) {
		if (value == null) {
			log.error("informado valor nulo");
			return false;
		}else {			
						
			for (char ch : value.toCharArray()) {
				
				if ( !(StringsUtil.isAlpha(String.valueOf(ch)) || Character.isDigit(ch)) &&  !"!@#$%^&*()-+".contains(String.valueOf(ch)))	
			 	   return false;				
			}
			return true;			
		}	
	}

}
