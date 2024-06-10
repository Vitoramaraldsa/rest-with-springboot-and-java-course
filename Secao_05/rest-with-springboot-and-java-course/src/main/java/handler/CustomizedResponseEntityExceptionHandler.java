package handler;
import java.util.Date;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.vitor.exceptions.DefaultException;
import br.com.vitor.exceptions.ExceptionResponse;
import br.com.vitor.exceptions.UnsupportedMathOperationException;

@Controller
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	
    // Handler para erros genéricos
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value=DefaultException.class)
    public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request){
    	System.out.println("entrei 1");
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                new Date(), 
                ex.getMessage(), 
                request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    // Handler para tratamento personalizado do erro de operação matemática
    @ResponseStatus(value=HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value=UnsupportedMathOperationException.class)
    public final ResponseEntity<ExceptionResponse> handleBadRequestsExceptions(RuntimeException ex, WebRequest request){
    	System.out.println("entrei 2");
    	System.out.println();
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                new Date(), 
                ex.getMessage(), 
                request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
