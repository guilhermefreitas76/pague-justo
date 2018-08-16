package br.com.paguejusto.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.paguejusto.services.exceptions.PagueJustotNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(PagueJustotNotFoundException.class)
	public ResponseEntity<StandardError> pagueJustotNotFoundException(PagueJustotNotFoundException e,
			HttpServletRequest httpServletRequest) {

		StandardError standardError = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(),
				System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardError);
	}

}