package com.backend.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PasswordValidationServiceIntegrationTest {

	
	@Autowired
	PasswordValidationService passwordValidationService;  
	
	@ParameterizedTest
	@ValueSource(strings = {"","aa","ab", "AAAbbbCc","AbTp9!foo" ,"AbTp9!foA","AbTp9 fok","AbTp9!f1k~",
				"AbTp9*f1kº","AbTp9)f1k§§'´","AbTp9(f1k]","AbTp9-]f1k","AbTp9+f1k["} )
	void passwordValidation_RetornarFalseParaValorInvalido(String value) {
		Assertions.assertFalse(passwordValidationService.passwordValidation(value));
	}
	
	
	
	@ParameterizedTest
	@ValueSource(strings = {"AbTp9!f1k","AbTp9@f1k","AbTp9#f1k","AbTp9$f1k","AbTp9%f1k",
			"AbTp9&f1k","AbTp9&f1k","AbTp9*f1k","AbTp9*f1k","AbTp9)f1k","AbTp9(f1k","AbTp9-f1k"
			,"AbTp9+f1k","AbTp9^f1k"} )
	void passwordValidation_RetornarTrueParaValorValido(String value) {
		Assertions.assertTrue(passwordValidationService.passwordValidation(value));
	}

}
