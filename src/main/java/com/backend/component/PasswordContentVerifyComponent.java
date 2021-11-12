package com.backend.component;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.backend.component.validation.CheckMaximumTextSizeValidation;
import com.backend.component.validation.CheckMinimumTextSizeValidation;
import com.backend.component.validation.CheckPresenceAtLessOneDigitValidation;
import com.backend.component.validation.CheckPresenceAtLessOneLowerLetterValidation;
import com.backend.component.validation.CheckPresenceAtLessOneSpecialCharacterValidation;
import com.backend.component.validation.CheckPresenceAtLessOneUpperLetterValidation;
import com.backend.component.validation.CheckAbsentEmptySpacesValidation;
import com.backend.component.validation.CheckAbsentOfRepeatedCharactersValidation;
import com.backend.component.validation.Validation;


@Component
public class PasswordContentVerifyComponent  {
	
	@Bean
	@Scope("application")
	List<Validation> listOfValidation(){
	
		List<Validation> listValidation = new ArrayList<>();
		
		
		listValidation.add(new CheckMaximumTextSizeValidation());
		listValidation.add(new CheckMinimumTextSizeValidation());
		listValidation.add(new CheckPresenceAtLessOneDigitValidation());
		listValidation.add(new CheckPresenceAtLessOneDigitValidation());
		listValidation.add(new CheckPresenceAtLessOneLowerLetterValidation());
		listValidation.add(new CheckPresenceAtLessOneSpecialCharacterValidation());
		listValidation.add(new CheckPresenceAtLessOneUpperLetterValidation());
		listValidation.add(new CheckAbsentEmptySpacesValidation());
		listValidation.add(new CheckAbsentOfRepeatedCharactersValidation());
		
		return listValidation;
		
		
		
		
	}

	
}
