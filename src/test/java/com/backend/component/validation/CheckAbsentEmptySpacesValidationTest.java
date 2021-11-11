package com.backend.component.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
class CheckAbsentEmptySpacesValidationTest {

	@InjectMocks
	CheckAbsentEmptySpacesValidation checkPresenceEmptySpacesValidation;
	
	@ParameterizedTest
	@ValueSource(strings = {"1NNMN3a KK DJ","11 1A222","1 B", " " } )
	public void deveRetornarFalseParaValoresComEspaco(String value){
		
		Assertions.assertFalse(checkPresenceEmptySpacesValidation.isValid(value));
		
		
	}
		
	@ParameterizedTest
	@ValueSource(strings = {"aaaaas","fsdfsdfsd","!@@#@#ssss", "a" } )
	public void deveRetornarTrueParaValoresSemEspaco(String value){
		
		Assertions.assertTrue(checkPresenceEmptySpacesValidation.isValid(value));		
	}
}
