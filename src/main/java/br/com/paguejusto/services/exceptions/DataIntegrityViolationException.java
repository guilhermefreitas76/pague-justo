package br.com.paguejusto.services.exceptions;

public class DataIntegrityViolationException extends RuntimeException{

	
	private static final long serialVersionUID = 1L;
	
	public DataIntegrityViolationException(String msg) {
		super(msg);
	}
	public DataIntegrityViolationException(String msg, Throwable throwable) {
		super(msg,throwable);
	}

}
