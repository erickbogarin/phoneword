package com.phone.converter;

import java.util.StringJoiner;

import com.phone.helpers.PhoneKeypad;


/**
 * Trata o lado esquerdo da cadeia (String), alterando letras para n�meros.
 * caso necess�rio.
 * 
 * @author Erick
 *
 */
public class NumberConverter {
	
	private static String leftSubstringNumber;
	
	private static String rightSubstringNumber;
	
	private static String rightSubstringChar;
	
	/**
	 * Considera-se o lado esquerdo os caracteres que est�o sujeitos 
	 * a conter letras, no caso a partir da posi��o[2] da cadeia (String).
	 * 
	 * @param unformatedPhoneNumber
	 * @return
	 */
	public static String convertStringToNumber(String unformatedPhoneNumber) {
		leftSubstringNumber = unformatedPhoneNumber.substring(0, 2);
		
		rightSubstringChar = unformatedPhoneNumber.substring(leftSubstringNumber.length());
		rightSubstringNumber = PhoneKeypad.keysFromNumber(rightSubstringChar);
		
		return join().toString();
	}

	/**
	 * Java8 StringJoiner
	 * @return
	 */
	private static String join() {
		StringJoiner joiner = new StringJoiner("");
		joiner.add(leftSubstringNumber);
		joiner.add(rightSubstringNumber);
		return joiner.toString();
	}
	
}
