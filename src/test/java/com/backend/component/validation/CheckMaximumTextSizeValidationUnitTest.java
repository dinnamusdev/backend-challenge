package com.backend.component.validation;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.internal.util.StringUtil;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.backend.component.PasswordContentVerifyComponent;

@ExtendWith(SpringExtension.class)
public class CheckMaximumTextSizeValidationUnitTest {

		
	@InjectMocks
	private CheckMaximumTextSizeValidation checkMaximumTextSizeValidation;
		
	
	
	//checkMinimumTextSize	
	@ParameterizedTest
	@ValueSource(strings = {"", " ", "aaaaaaaammmmm" } )
	public void deveRetornarTrueParaValoresValidos(String value){
		Assertions.assertTrue(checkMaximumTextSizeValidation.isValid(value));
		
	}
	@Test
	public void deveRetornarFalseParaValorInvalido(){
		Assertions.assertFalse(checkMaximumTextSizeValidation.isValid(StringUtils.repeat("A", 256)));		
	}
	
		
}
