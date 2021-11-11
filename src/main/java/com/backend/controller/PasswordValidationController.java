package com.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.dto.PasswordDTO;
import com.backend.dto.PasswordValidationResponseDTO;
import com.backend.services.PasswordValidation;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/v1/public")

public class PasswordValidationController {

	private PasswordValidation passwordValidationService;

	public PasswordValidationController(final PasswordValidation passwordValidationService) {
		this.passwordValidationService = passwordValidationService;
	}


	@RequestMapping(value = "/password", method = RequestMethod.POST)
	public ResponseEntity<?> passwordValidate(@RequestBody PasswordDTO passwordDTO) {

			boolean resultadoValidacaoSenha = passwordValidationService.passwordValidation(passwordDTO.getPassword());

			return new ResponseEntity<>(new PasswordValidationResponseDTO(resultadoValidacaoSenha), HttpStatus.OK);
			
	}

}
