package com.backend.component.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class CheckAbsentOfRepeatedCharactersValidationTest {

	@InjectMocks
	CheckAbsentOfRepeatedCharactersValidation checkPresenceOfRepeatedCharactersValidation;
	
	@ParameterizedTest
	@ValueSource(strings = {"ABCDEF ","1234A[]0","1", "" ,"AbTp9!f1k"} )
	public void deveRetornarTrueParaValoresNaoRepetidos(String value){
		
		Assertions.assertTrue(checkPresenceOfRepeatedCharactersValidation.isValid(value));
		
		
	}
		
	@ParameterizedTest
	@ValueSource(strings = {"ABCDEFA","12341A[]0","11", "bbbbbb" } )
	public void deveRetornarFalseParaValoresRepetidos(String value){
		
		Assertions.assertFalse(checkPresenceOfRepeatedCharactersValidation.isValid(value));		
	}

}
