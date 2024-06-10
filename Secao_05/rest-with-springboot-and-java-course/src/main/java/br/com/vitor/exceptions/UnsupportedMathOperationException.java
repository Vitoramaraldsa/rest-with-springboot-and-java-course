package br.com.vitor.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class UnsupportedMathOperationException extends RuntimeException {
	
	public UnsupportedMathOperationException(String message) {
		super(message);
	}

}
