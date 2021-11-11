package com.backend.component.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class CheckPresenceAtLessOneSpecialCharacterValidationTest {

	@InjectMocks
	CheckPresenceAtLessOneSpecialCharacterValidation checkPresenceAtLessOneSpecialCharacterValidation;
	//
	@ParameterizedTest
	@ValueSource(strings = {"343!4SDS","DF@DF","2CD#FD","cxc$2323SD","fdf%df","554^545","1NNM+$N3aKK-DJ","11)1A222","1(B", "2*323","2323&23" } )
	public void deveRetornarTrDueParaValoresValidos(String value){
		
		Assertions.assertTrue(checkPresenceAtLessOneSpecialCharacterValidation.isValid(value));
		
		
	}
//{"~343!4SDS","<DF@DF",">2CD#FD","/cxc$2323SD","?fdf%df","´554545","[1NNM$N3aKKDJ","]11)1A222",		
	@ParameterizedTest
	@ValueSource(strings = { "1ºB", "{º2323","§§}2323&23","ºº"  } )
	public void deveRetornarFalseParaValorInvalido(String value){
		
		Assertions.assertFalse(checkPresenceAtLessOneSpecialCharacterValidation.isValid(value));		
	}
	 
}
