package com.phone.converter;

import com.phone.exception.InvalidNumberException;
import com.phone.formatter.Formatter;
import com.phone.formatter.NumberFormatter;
import com.phone.validator.NumberValidator;
import com.phone.validator.Validator;

/**
 * Limpa a cadeia (String) de um numero telefonico caso este seja valido. 
 * 
 * @author Erick Bogarin
 */
public final class PhonewordConverter {
	
	private final static Validator NUMBER_VALIDATOR = new NumberValidator();
	private final static Formatter NUMBER_FORMATTER = new NumberFormatter();
	
	private String clear = null;
	
	public String clear(String telefone) {
		clear = clearUp(telefone);
		return clear;
	}
	
	/**
	 * Checks if the number sent is valid  
	 * 
	 * @param phoneNumber
	 * @return unformatedPhoneNumber
	 */
	public String clearUp(String phoneNumber) {
		String unformatedPhoneNumber;
		
		if(NUMBER_VALIDATOR.isValid(phoneNumber)) {
			
			unformatedPhoneNumber = NUMBER_FORMATTER.unformat(phoneNumber);
			
			return NumberConverter.convertStringToNumber(unformatedPhoneNumber);
			
		} else { 
			throw new InvalidNumberException("missing digits");
		}
		
	}
	
}
