package br.com.paguejusto.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.paguejusto.services.exceptions.DataIntegrityViolationException;
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

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<StandardError> dataIntegrityViolationException(DataIntegrityViolationException e,
			HttpServletRequest httpServletRequest) {

		StandardError standardError = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(),
				System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standardError);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> validation(MethodArgumentNotValidException e,
			HttpServletRequest httpServletRequest) {

		ValidationError validationError = new ValidationError(HttpStatus.BAD_REQUEST.value(), "Erro de Validação!",
				System.currentTimeMillis());

		for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {

			validationError.addError(fieldError.getField(), fieldError.getDefaultMessage());

		}

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validationError);
	}

}
