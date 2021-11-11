package com.backend.component.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class CheckPresenceAtLessOneLowerLetterValidationTest {

	@InjectMocks
	CheckPresenceAtLessOneLowerLetterValidation checkPresenceAtLessOneLowerLetterValidation;
	
	
	@ParameterizedTest
	@ValueSource(strings = {"1NNMN3aKKDJ","111a222","a1B", "1a" } )
	public void deveRetornarTrDueParaValoresValidos(String value){
		
		Assertions.assertTrue(checkPresenceAtLessOneLowerLetterValidation.isValid(value));
		
		
	}
		
	@ParameterizedTest
	@ValueSource(strings = {"AAA","BBBBBCC","PKKS323%%#", "LLOOL" } )
	public void deveRetornarFalseParaValorInvalido(String value){
		
		Assertions.assertFalse(checkPresenceAtLessOneLowerLetterValidation.isValid(value));		
	}
}
