package com.backend.services;

public interface PasswordContentVerify {
	boolean checkMinimumTextSize(String value);

	boolean checkPresenceAtLessOneDigit(String value);

	boolean checkPresenceAtLessOneLowerLetter(String value);

	boolean checkPresenceAtLessOneUpperLetter(String value);

	boolean checkPresenceAtLessOneSpecialCharacter(String value);

	boolean checkPresenceEmptySpaces(String value);

	boolean checkPresenceOfRepeatedCharacters(String value);
	
	boolean checkMaximumTextSize(String value);
}
