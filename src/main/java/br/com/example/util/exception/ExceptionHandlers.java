package br.com.example.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class ExceptionHandlers {

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = BusinessException.class)
	public JsonError handleGenericException(BusinessException e) {
		return new JsonError(e.getMessage());
	}
	
}
