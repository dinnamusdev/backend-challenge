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
public class CheckMinimumTextSizeValidationUnitTest2 {

		
	@InjectMocks
	private CheckMinimumTextSizeValidation checkMinimumTextSizeValidation;
		
	
	
	//checkMinimumTextSize	
	@Test
	public void deveRetornarTrueParaValoresValidos(){
		
		Assertions.assertTrue(checkMinimumTextSizeValidation.isValid(StringUtils.repeat("A", 10)));
		
		
	}
		
	@ParameterizedTest
	@ValueSource(strings = {"","32","123456", "1234567" } )
	public void deveRetornarFalseParaValorInvalido(String value){
		Assertions.assertFalse(checkMinimumTextSizeValidation.isValid(value));		
	}
	
		
}
