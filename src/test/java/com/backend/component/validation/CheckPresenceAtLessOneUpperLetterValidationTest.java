package com.backend.component.validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class CheckPresenceAtLessOneUpperLetterValidationTest {

	@InjectMocks
	CheckPresenceAtLessOneUpperLetterValidation checkPresenceAtLessOneUpperLetterValidation;
	
	
	@ParameterizedTest
	@ValueSource(strings = {"1NNMN3aKKDJ","111A222","1B", "A" } )
	public void deveRetornarTrDueParaValoresValidos(String value){
		
		Assertions.assertTrue(checkPresenceAtLessOneUpperLetterValidation.isValid(value));
		
		
	}
		
	@ParameterizedTest
	@ValueSource(strings = {"aaaaas","fsdfsdfsd","!@@#@#ssss", "a" } )
	public void deveRetornarFalseParaValorInvalido(String value){
		
		Assertions.assertFalse(checkPresenceAtLessOneUpperLetterValidation.isValid(value));		
	}

}
