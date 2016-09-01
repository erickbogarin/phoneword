package com.phone.formatter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Limpa uma cadeia (String) formatada
 * 
 * @author Erick
 */
public class BaseFormatter {
	
	private final Pattern formatted;

	private final Pattern unformatted;
    
	private final String unformattedReplacement;
	
	public BaseFormatter(Pattern formatted, Pattern unformatted, String unformattedReplacement) {
		this.formatted = formatted;
		this.unformatted = unformatted;
		this.unformattedReplacement = unformattedReplacement;
	}
	
	public String unformat(String value) throws IllegalArgumentException {
		String result;
		if(value == null) {
			throw new IllegalArgumentException("Value may not be null");
		}
		
		Matcher unformattedMatcher = unformatted.matcher(value);
		if(unformattedMatcher.matches()) {
			return value;
		}
		
		Matcher matcher = formatted.matcher(value);
		result = machAndReplace(matcher, unformattedReplacement);
		
		return result;
	}

	private String machAndReplace(Matcher matcher, String replacement) {
		String result = null;
		if(matcher.matches()) {
			result = matcher.replaceAll(replacement);
		}
		else {
			throw new IllegalArgumentException("Value is not properly formatted.");
		}
		// TODO Auto-generated method stub
		return result;
	}
	
}
