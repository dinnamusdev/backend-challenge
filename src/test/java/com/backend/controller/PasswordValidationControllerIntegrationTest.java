package com.backend.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
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
	
	
	@Test
	public void passwordValidate_DeveRetornarFalseParaValorNulo(){
			
		Assertions.assertFalse(chamaPasswordValidateUrl(new PasswordDTO(null)));
		
	}
	
	@Test
	public void passwordValidate_DeveRetornarFalseParaValorVazio(){
			
		Assertions.assertFalse(chamaPasswordValidateUrl(new PasswordDTO("")));
		
	}
	
	@Test
	public void passwordValidate_DeveRetornarFalseParaValorInvalido_1(){
			
		Assertions.assertFalse(chamaPasswordValidateUrl(new PasswordDTO("aa")));
		
	}
	
	@Test
	public void passwordValidate_DeveRetornarFalseParaValorInvalido_2(){
			
		Assertions.assertFalse(chamaPasswordValidateUrl(new PasswordDTO("ab")));
		
	}
	
	@Test
	public void passwordValidate_DeveRetornarFalseParaValorInvalido_3(){
			
		Assertions.assertFalse(chamaPasswordValidateUrl(new PasswordDTO("AAAbbbCc")));
		
	}
	
	@Test
	public void passwordValidate_DeveRetornarFalseParaValorInvalido_4(){
			
		Assertions.assertFalse(chamaPasswordValidateUrl(new PasswordDTO("AbTp9!foo")));
		
	}
	
	@Test
	public void passwordValidate_DeveRetornarFalseParaValorInvalido_5(){
			
		Assertions.assertFalse(chamaPasswordValidateUrl(new PasswordDTO("AbTp9!foA")));
		
	}
	
	@Test
	public void passwordValidate_DeveRetornarFalseParaValorInvalido_6(){
			
		Assertions.assertFalse(chamaPasswordValidateUrl(new PasswordDTO("AbTp9 fok")));
		
	}
	
	
	@Test
	public void passwordValidate_DeveRetornarTrueParaValorValido_7(){
			
		Assertions.assertTrue(chamaPasswordValidateUrl(new PasswordDTO("AbTp9!fok")));
		
	}
	
	
}
