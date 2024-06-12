package br.com.vitor.utils;

import br.com.vitor.exceptions.DefaultException;

public class StringOperations {

	// converte uma string em um valor Double
	public static Double stringToDouble(String value) throws Exception {
		if (value == null) {
			return 0D;
		}
		value = value.replaceAll(",", ".");
		return Double.parseDouble(value);
	}

	// verifica se o valor de entrada é numérico
	public static boolean isNumeric(String value) throws Exception {
		if (value == null) {
			throw new DefaultException("Insira um valor");
		}
		value = value.replaceAll(",", ".");
		// verifica se é um valor negativo,positivo de 0 a 9 ou com um ponto flutuante
		// de 0 a 9.
		return value.matches("[-+]?[0-9]*\\.?[0-9]+");
	}

}
