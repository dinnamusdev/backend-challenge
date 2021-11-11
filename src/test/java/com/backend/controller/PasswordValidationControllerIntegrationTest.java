package com.backend.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.backend.dto.PasswordDTO;
import com.backend.dto.PasswordValidationResponseDTO;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PasswordValidationControllerIntegrationTest {
	
		
	@Autowired
	TestRestTemplate testRestTemplate;  
	
	private Boolean chamaPasswordValidateUrl(PasswordDTO passwordDTO) {
		boolean result = false;
		try {
		
			HttpEntity<PasswordDTO> request = new HttpEntity<>(passwordDTO);		
			ResponseEntity<PasswordValidationResponseDTO> response=null;	

			
			response= testRestTemplate.exchange("/v1/public/password", HttpMethod.POST , request , PasswordValidationResponseDTO.class);

			if(response.getStatusCode()==HttpStatus.OK) {
				result = response.getBody().getPasswordValidation();
			}

		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		
		return result;
	}
	
	
	@ParameterizedTest()
	@ValueSource(strings = {"","aa","ab", "AAAbbbCc","AbTp9!foo" ,"AbTp9!foA","AbTp9 fok","AbTp9!f1k~",
			"AbTp9*f1kº","AbTp9)f1k§§'´","AbTp9(f1k]","AbTp9-]f1k","AbTp9+f1k["} )
	public void passwordValidate_DeveRetornarFalseParaValoresInvalidos(){
			
		Assertions.assertFalse(chamaPasswordValidateUrl(new PasswordDTO(null)));
		
	}
	
	@ParameterizedTest()
	@ValueSource(strings = {"AbTp9!f1k","AbTp9@f1k","AbTp9#f1k","AbTp9$f1k","AbTp9%f1k",
			"AbTp9&f1k","AbTp9&f1k","AbTp9*f1k","AbTp9*f1k","AbTp9)f1k","AbTp9(f1k","AbTp9-f1k","AbTp9+f1k","AbTp9^f1k"} )
	public void passwordValidate_DeveRetornarTrueParaValorValido(String value){
			
		Assertions.assertTrue(chamaPasswordValidateUrl(new PasswordDTO(value)));
		
	}
	
	
}
