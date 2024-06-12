package br.com.vitor.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.vitor.exceptions.UnsupportedMathOperationException;
import br.com.vitor.utils.StringOperations;

@RestController
public class MathController {
	
	@RequestMapping(value = "/sum/{firstParam}/{secondParam}", method = RequestMethod.GET)
	public Double sum(@PathVariable(value = "firstParam") String param1, @PathVariable(value = "secondParam") String param2)
			throws Exception {
		if (StringOperations.isNumeric(param1) == false || StringOperations.isNumeric(param2) == false){
			throw new UnsupportedMathOperationException("Please, set a numeric value");
		}
		
		return StringOperations.stringToDouble(param1) + StringOperations.stringToDouble(param2);
	}

	@RequestMapping(value = "/sub/{firstParam}/{secondParam}", method = RequestMethod.GET)
	Double sub(@PathVariable(value = "firstParam") String param1, @PathVariable(value = "secondParam") String param2)
			throws Exception {
		if (StringOperations.isNumeric(param1) == false || StringOperations.isNumeric(param2) == false) {
			throw new UnsupportedMathOperationException("Please, set a numeric value");
		}
		return StringOperations.stringToDouble(param1) - StringOperations.stringToDouble(param2);
	}
	
	@RequestMapping(value = "/multi/{firstParam}/{secondParam}", method = RequestMethod.GET)
	Double multi(@PathVariable(value = "firstParam") String param1, @PathVariable(value = "secondParam") String param2)
			throws Exception {
		if (StringOperations.isNumeric(param1) == false || StringOperations.isNumeric(param2) == false) {
			throw new UnsupportedMathOperationException("Please, set a numeric value");
		}
		return StringOperations.stringToDouble(param1) * StringOperations.stringToDouble(param2);
	}
	
	
	@RequestMapping(value = "/medi/{firstParam}/{secondParam}", method = RequestMethod.GET)
	Double medi(@PathVariable(value = "firstParam") String param1, @PathVariable(value = "secondParam") String param2)
			throws Exception {
		if (StringOperations.isNumeric(param1) == false || StringOperations.isNumeric(param2) == false) {
			throw new UnsupportedMathOperationException("Please, set a numeric value");
		}
		
		return StringOperations.stringToDouble(param1) * StringOperations.stringToDouble(param2)/2;
	}
	
	@RequestMapping(value = "/raiz/{firstParam}", method = RequestMethod.GET)
	Double raiz(@PathVariable(value = "firstParam") String param1)
			throws Exception {
		if (StringOperations.isNumeric(param1) == false) {
			throw new UnsupportedMathOperationException("Please, set a numeric value");
		}
		return Math.sqrt(StringOperations.stringToDouble(param1));
	}

}
