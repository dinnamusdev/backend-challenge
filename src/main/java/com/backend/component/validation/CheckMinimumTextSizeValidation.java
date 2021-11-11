package com.backend.component.validation;

public class CheckMinimumTextSizeValidation implements Validation {

	@Override
	public boolean isValid(String value) {
		
		if(value != null) {
				
			return value.length() >= 9;
			
		}else {
			
			return false;
		}
	
	}

}
