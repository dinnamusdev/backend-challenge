package com.backend.services;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service

public class PasswordValidationService implements PasswordValidation {


	
	private PasswordContentVerify passwordContentVerify;
	
	public PasswordValidationService(final PasswordContentVerify passwordContentVerify) {
		this.passwordContentVerify=passwordContentVerify;
	}

	@Override
	public boolean passwordValidation(String value) {

		boolean isValid = false;

		try {
			if (value != null) {

				value = value.trim();

				isValid = passwordContentVerify.checkMinimumTextSize(value)
						&& passwordContentVerify.checkMaximumTextSize(value)
						&& passwordContentVerify.checkPresenceAtLessOneDigit(value)
						&& passwordContentVerify.checkPresenceAtLessOneLowerLetter(value)
						&& passwordContentVerify.checkPresenceAtLessOneUpperLetter(value)
						&& passwordContentVerify.checkPresenceAtLessOneSpecialCharacter(value)
						&& !passwordContentVerify.checkPresenceEmptySpaces(value)
						&& !passwordContentVerify.checkPresenceOfRepeatedCharacters(value);
				
			}

		} catch (Exception e) {
			// TODO: handle exception
			log.error("method(passwordValidation)",e);
		}
				
		return isValid;

	}

}
