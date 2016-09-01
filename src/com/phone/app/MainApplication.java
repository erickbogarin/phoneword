package com.phone.app;

import com.phone.reader.InputNumberReader;

/**
 * Valids input patterns: 
 * eg. 
 * 		55AFZEFA 
 * 		1-800-ACFSF
 * 
 * @see com.phone.validator.NumberValidator
 * 
 * @author Erick Bogarin
 *
 */
public class MainApplication {

	public static void main(String[] args) {
		String phone = "1-800-111111";

		String limpa = new InputNumberReader().limpa(phone);
		System.out.println(phone + " => " + limpa);
	}

}
