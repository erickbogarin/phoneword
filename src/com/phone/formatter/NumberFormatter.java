package com.phone.formatter;

import com.phone.validator.NumberValidator;

public class NumberFormatter implements Formatter{
	
	private final BaseFormatter base;
	
	public NumberFormatter() {
		this.base = new BaseFormatter(NumberValidator.FORMATED, NumberValidator.UNFORMATED, "$1$2$3");
	}
	
	public String unformat(String value) {
		return base.unformat(value);
	}
	
}	
