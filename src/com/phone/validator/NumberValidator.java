package com.phone.validator;

import java.util.regex.Pattern;

import com.phone.exception.InvalidNumberException;

/**
 * Validates a chain of strings of a phone number 
 * 
 *  @author Erick Bogarin
 */
public final class NumberValidator implements Validator{

	public static final Pattern FORMATED = Pattern.compile("(\\d{1})-(\\d{3})-([a-zA-Z0-9]{5,6})");
	public static final Pattern UNFORMATED = Pattern.compile("([0-9]{2,4})([a-zA-Z]{5,6})");
	
	/* 
	 * Checks whether the string conforms to patterns
	 * 
	 * @see br.com.alura.validator.Validator#checkInvalidValues(java.lang.String)
	 */
	public boolean isValid(String number) {
		if(number != null && !number.isEmpty()) {
			return isCorrectlyFormatted(number) ? true : false;
		} 
		
		throw new InvalidNumberException("value may not be empty");
	}

	private boolean isCorrectlyFormatted(String number) {
		return FORMATED.matcher(number).matches() || UNFORMATED.matcher(number).matches();
	}

}
