package com.phone.reader;


/**
 * Solu��o matem�tica para calcular os resultados da cadeia (String).
 * 
 * Foi identificado que h� tr�s chaves por n�mero para todas as teclas, com excess�o
 * para a tecla 7, e, em seguida, h� um caso de exce��o com a entrada Z, que � considerado um estouro.
 *
 * Se calcularmos um 'valor' e um 'desvio' para cada letra, e em seguida, fazer um truncamento 
 * inteiro nele, podemos convert�-lo diretamente para um n�mero espec�fico.
 *
 *O truque foi encontrar as constantes necess�rias obtidas pelos c�lculos.
 */
public class PhoneKeypad {
	
	private static final double SPAN = (1.0 / 3.0) - (1.0 / 260.0);

	private static final double OFFSET = 7.0 - (SPAN * 15);

	public static final char charForKey(final char letter) {
		final int comp = Character.toUpperCase(letter) - 'A';
		if (comp < 0 || comp >= 26) {
			return letter;
		}
		char key = (char) ('0' + OFFSET + comp * SPAN);
		
		//Z overflow: 10
		return key > '9' ? '9' : key;
	}
	
	/**
	 * Java 8 lambda expressions
	 * @param input
	 * @return
	 */
	public static final String keysFromNumber(String input) {
		StringBuilder sb = new StringBuilder(input.length());
		input.chars().forEach(c -> sb.append(charForKey((char) c)));
		return sb.toString();
	}

}
