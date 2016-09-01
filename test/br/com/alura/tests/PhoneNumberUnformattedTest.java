package br.com.alura.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.phone.exception.InvalidNumberException;
import com.phone.reader.InputNumberReader;

/**
 * Bateria de testes para n�meros n�o formatados. 
 * 
 * @author Erick Bogarin
 *
 */
public class PhoneNumberUnformattedTest {

	InputNumberReader reader;
	
	@Before
	public void before() {
		 reader = new InputNumberReader();
	}
	
	@Test
	public void deveAceitarNumerosNaoFormatadosContentoNoMinimoSeteDigitos() {
		String telefone = "55ALURA";
		assertEquals("5525872", reader.limpa(telefone));
	}
	
	@Test(expected = InvalidNumberException.class)
	public void deveRejeitarNumerosNaoFormatadosMenoresDeSeteDigios() {
		String telefone = "5ALURA";
		reader.limpa(telefone);
	}
	
	@Test
	public void deveAceitarNumerosNaoFormatadosContentoAteNoveDigitos() {
		String telefone = "55CAELUM";
		assertEquals("55223586", reader.limpa(telefone));
	}
	
	@Test(expected = InvalidNumberException.class)
	public void deveAceitarNumerosNaoFormatadosMaioresDeNoveDigitos() {
		String telefone = "55CAELUMONLINE";
		reader.limpa(telefone);
	}
	
	@Test
	public void deveAceitarNumerosNaoFormatadosQueCemecemComNoMinimoDoisDigitos() {
		String telefone = "55ALURA";
		assertEquals("5525872", reader.limpa(telefone));
	}
	
	@Test
	public void deveAceitarNumerosNaoFormatadosQueCemecemComAteQuatroDigitos() {
		String telefone = "1800ALURA";
		reader.limpa(telefone);
	}
	
	@Test(expected = InvalidNumberException.class)
	public void deveRejeitarNumerosNulos() {
		String telefone = null;
		reader.limpa(telefone);
	}
	
	@Test(expected = InvalidNumberException.class)
	public void deveRejeitarCaracteresInvalidos() {
		String telefone = "*55/0?s$.";
		reader.limpa(telefone);
	}
	
}
