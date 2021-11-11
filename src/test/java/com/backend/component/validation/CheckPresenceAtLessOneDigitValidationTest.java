package com.backend.component.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class CheckPresenceAtLessOneDigitValidationTest {

	@InjectMocks
	CheckPresenceAtLessOneDigitValidation checkPresenceAtLessOneDigitValidation;
	
	
	@ParameterizedTest
	@ValueSource(strings = {"1NNMN3KKDJ","111222","1B", "1" } )
	public void deveRetornarTrDueParaValoresValidos(String value){
		
		Assertions.assertTrue(checkPresenceAtLessOneDigitValidation.isValid(value));
		
		
	}
		
	@ParameterizedTest
	@ValueSource(strings = {"AAA","BBBBBCC","PKKSqade", "LLOOLLaaa" } )
	public void deveRetornarFalseParaValorInvalido(String value){
		
		Assertions.assertFalse(checkPresenceAtLessOneDigitValidation.isValid(value));		
	}
	
	
}
