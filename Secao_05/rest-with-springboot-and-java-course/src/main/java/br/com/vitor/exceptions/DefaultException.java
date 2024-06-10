package br.com.vitor.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class DefaultException extends Exception {
	
	public DefaultException(String message) {
		
		super(message);
	}

}
