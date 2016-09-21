package com.phone.app;

import com.phone.PhoneWord;

/**
 * Valids input patterns: 
 * eg. 
 * 		55AFZEFA 
 * 		1-800-ACFSFF
 * 
 * @see com.phone.validator.NumberValidator
 * 
 * @author Erick Bogarin
 *
 */
public class MainApplication {

	public static void main(String[] args) {
		String phoneNumber = "1-800-111111";

		String limpa = new PhoneWord().clear(phoneNumber);
		System.out.println(phoneNumber + " => " + limpa);
	}

}
