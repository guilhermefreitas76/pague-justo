package br.com.paguejusto.resources.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

	private static final long serialVersionUID = 1L;

	private List<FieldMessage> fieldError = new ArrayList<FieldMessage>();

	public ValidationError(Integer status, String msg, Long timeStamp) {
		super(status, msg, timeStamp);
	}

	public List<FieldMessage> getErros() {
		return fieldError;
	}

	public void addError(String fieldName, String message) {
		fieldError.add(new FieldMessage(fieldName, message));
	}
}
