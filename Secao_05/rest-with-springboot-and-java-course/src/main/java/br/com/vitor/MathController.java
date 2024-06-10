package br.com.vitor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vitor.exceptions.DefaultException;
import br.com.vitor.exceptions.UnsupportedMathOperationException;

@RestController
public class MathController{

	@GetMapping(value = "/sum/{firstParam}/{secondParam}")
	Double sum(@PathVariable(value = "firstParam") String param1, @PathVariable(value = "secondParam") String param2)
			throws Exception {
		
		if (isNumeric(param1) == false || isNumeric(param2) == false) {
			throw new UnsupportedMathOperationException("Please, set a numeric value");
		}

		
		return stringToDouble(param1) + stringToDouble(param2);
	}

	
	//converte uma string em um valor Double
	private Double stringToDouble(String value) throws Exception {
		if (value == null) {
			throw new DefaultException("Insira um valor");
		}

		value = value.replaceAll(",", ".");

		return Double.parseDouble(value);
	}

	//verifica se o valor de entrada é numérico
	private boolean isNumeric(String value) throws Exception {
		
		if (value == null) {
			throw new DefaultException("Insira um valor");
		}

		value = value.replaceAll(",", ".");

		// verifica se é um valor negativo,positivo de 0 a 9 ou com um ponto flutuante
		// de 0 a 9.
		return value.matches("[-+]?[0-9]*\\.?[0-9]+");
	}

}
