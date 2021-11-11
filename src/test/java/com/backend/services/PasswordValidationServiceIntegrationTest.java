package com.backend.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PasswordValidationServiceIntegrationTest {

	
	@Autowired
	PasswordValidationService passwordValidationService;  
	
	@Test
	void passwordValidation_RetornarFalseParaValorVazio() {
		Assertions.assertFalse(passwordValidationService.passwordValidation(""));
	}
	
	@Test
	void passwordValidation_RetornarFalseParaValoNulo() {
		Assertions.assertFalse(passwordValidationService.passwordValidation(null));
	}
	
	
	@Test
	void passwordValidation_RetornarTrueParaValorInvalido_1() {
		Assertions.assertFalse(passwordValidationService.passwordValidation("aa"));
	}

	@Test
	void passwordValidation_RetornarTrueParaValorInvalido_2() {
		Assertions.assertFalse(passwordValidationService.passwordValidation("ab"));
	}
	@Test
	void passwordValidation_RetornarTrueParaValorInvalido_3() {
		Assertions.assertFalse(passwordValidationService.passwordValidation("AAAbbbCc"));
	}
	
	@Test
	void passwordValidation_RetornarTrueParaValorInvalido_4() {
		Assertions.assertFalse(passwordValidationService.passwordValidation("AbTp9!foo"));
	}
	
	@Test
	void passwordValidation_RetornarTrueParaValorInvalido_5() {
		Assertions.assertFalse(passwordValidationService.passwordValidation("AbTp9!foA"));
	}

	@Test
	void passwordValidation_RetornarTrueParaValorInvalido_6() {
		Assertions.assertFalse(passwordValidationService.passwordValidation("AbTp9 fok"));
	}
	
	
	@Test
	void passwordValidation_RetornarTrueParaValorValido() {
		Assertions.assertTrue(passwordValidationService.passwordValidation("AbTp9!f1k"));
	}

}
