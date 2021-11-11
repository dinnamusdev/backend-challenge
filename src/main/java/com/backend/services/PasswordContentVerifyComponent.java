package com.backend.services;

import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class PasswordContentVerifyComponent implements PasswordContentVerify {
	
	@Override
	public boolean checkMinimumTextSize(String value) {

		boolean isValid = false;

		try {
			isValid = value != null && value.length() >= 9;
		} catch (Exception e) {
			log.error("method(checkMinimumTextSize)", e);
		}

		return isValid;
	}

	@Override
	public boolean checkPresenceAtLessOneDigit(String value) {

		boolean isValid = false;

		try {
			isValid = value != null && value.matches("(?=.*[0-9]).*");

		} catch (Exception e) {
			// TODO: handle exception
			log.error("method(checkPresenceAtLessOneDigit)", e);
		}

		return isValid;
	}

	@Override
	public boolean checkPresenceAtLessOneLowerLetter(String value) {

		boolean isValid = false;

		try {
			isValid = value != null && value.matches("(?=.*[a-z]).*");
		} catch (Exception e) {
			log.error("method(checkPresenceAtLessOneLowerLetter)", e);
		}

		return isValid;
	}

	@Override
	public boolean checkPresenceAtLessOneUpperLetter(String value) {
		boolean isValid = false;

		try {

			isValid = value != null && value.matches("(?=.*[A-Z]).*");

		} catch (Exception e) {
			log.error("method(checkPresenceAtLessOneUpperLetter)", e);
		}

		return isValid;
	}

	@Override
	public boolean checkPresenceAtLessOneSpecialCharacter(String value) {
		boolean isValid = false;

		try {

			isValid = value != null && value.matches("(?=.*[!@#$%^&*()\\-+]).*");

		} catch (Exception e) {

			log.error("method(checkPresenceAtLessOneSpecialCharacter)", e);
		}

		return isValid;
	}

	@Override
	public boolean checkPresenceEmptySpaces(String value) {
		boolean isValid = false;

		try {

			isValid = value != null && value.matches("(?=.*[\\s]).*");
			
		} catch (Exception e) {
			log.error("method(checkAbsenceEmptySpaces)", e);
		}

		return isValid;
	}

	@Override
	public boolean checkPresenceOfRepeatedCharacters(String value) {

		boolean isValid = false;

		try {
			if (value != null && !value.isEmpty()) {

				Map<String, Long> collect = value.chars().mapToObj(i -> (char) i)
						.collect(Collectors.groupingBy(Object::toString, Collectors.counting()));

				collect.values().removeIf(new Predicate<Long>() {

					@Override
					public boolean test(Long value) {
						return value <= 1;
					}
				});

				isValid = (collect.size() >0 ? true : false);
			}

		} catch (Exception e) {
			log.error("method(checkAbsenceOfRepeatedCharacters)", e);
		}
		
		
		return isValid;

	}

	@Override
	public boolean checkMaximumTextSize(String value) {
		boolean isValid = false;

		try {
			isValid = value != null && value.length() <= 255;
		} catch (Exception e) {
			log.error("method(checkMinimumTextSize)", e);
		}

		return isValid;
	}

}
