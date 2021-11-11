package com.backend.component.validation;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CheckAbsentOfRepeatedCharactersValidation implements Validation {

	@Override
	public boolean isValid(String value) {
		
		if(value==null ) {
			log.error("informado valor nulo");			
		}else {
		
			char[] charArray = value.toCharArray();
			
			for (int i = 0; i < charArray.length; i++) {			
				
				for (int j = 0; j < charArray.length; j++) {
					
					if(i!=j && charArray[j]==charArray[i]) {
						 return false;
					}
				}
			}
		}
		
		return true;

	}
	

}
