package com.backend.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.component.validation.Validation;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PasswordValidationService implements PasswordValidation {


	
	private List<Validation> listOfValidation;
	
	public PasswordValidationService(List<Validation> listOfValidation) {
		this.listOfValidation=listOfValidation;
	}

	@Override
	public boolean passwordValidation(String value) {

	
		if(value==null) return false;
		
		value=value.trim();
		
		for (Validation validation : listOfValidation) {
			
			if(!validation.isValid(value)) {
				log.info("Problema na validação do valor : "  +value +  " - validação : " +validation.toString() );
				return false;
			}
		}
					
		return true;
	
	}

}
