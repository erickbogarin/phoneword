package br.com.alura.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.phone.PhoneWord;
import com.phone.exception.InvalidNumberException;


/**
 * Bateria de testes para numeros formatados. 
 * 
 * @author Erick Bogarin
 *
 */
public class PhoneNumberFormattedTest {

	PhoneWord reader;
	
	@Before
	public void before() {
		 reader = new PhoneWord();
	}
	
	@Test
	public void deveAceitarNumerosFormatadosContendoNoMinimoNoveDigitos() {
		String telefone = "1-800-ALURA";
		assertEquals("180025872", reader.clear(telefone));
	}
	
	@Test(expected = InvalidNumberException.class)
	public void deveRejeitarNumerosFormatadosMenoresDeNove() {
		String telefone = "1-800-CASA";
		reader.clear(telefone);
	}
	
	@Test
	public void deveAceitarNumerosFormatadosContendoAteDezDigitos() {
		String telefone = "1-800-caelum";
		assertEquals("1800223586", reader.clear(telefone));
	}
	
	@Test(expected = InvalidNumberException.class)
	public void deveRejeitarNumerosFormatadosMaioresQueDez() {
		String telefone = "1-800-CASADOCODIGO";
		reader.clear(telefone);
	}
	
	@Test(expected = InvalidNumberException.class)
	public void deveRejeitarNumerosFormatadosComEspacoEmBranco() {
		String telefone = "1-8 0-ALUR ";
		reader.clear(telefone);
	}
	
	@Test(expected = InvalidNumberException.class)
	public void deveRejeitarNumerosComFormatoInvalido() {
		String telefone = "92-80-CAELUM";
		reader.clear(telefone);
	}

	@Test(expected = InvalidNumberException.class)
	public void deveRejeitarNumerosNulos() {
		String telefone = null;
		reader.clear(telefone);
	}
	
	@Test(expected = InvalidNumberException.class)
	public void deveRejeitarCaracteresInvalidos() {
		String telefone = "*-8/0-45.45";
		reader.clear(telefone);
	}
	
}
