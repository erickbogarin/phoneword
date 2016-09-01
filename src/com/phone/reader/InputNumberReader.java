package com.phone.reader;

import com.phone.converter.NumberConverter;
import com.phone.exception.InvalidNumberException;
import com.phone.formatter.Formatter;
import com.phone.formatter.NumberFormatter;
import com.phone.validator.NumberValidator;
import com.phone.validator.Validator;

/**
 * Limpa a cadeia (String) de um n�mero telefonico caso este seja v�lido. 
 * 
 * @author Erick Bogarin
 */
public final class InputNumberReader {
	
	private final static Validator NUMBER_VALIDATOR = new NumberValidator();
	private final static Formatter NUMBER_FORMATTER = new NumberFormatter();
	
	private String limpa = null;
	
	public String limpa(String telefone) {
		limpa = clearUp(telefone);
		return limpa;
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
