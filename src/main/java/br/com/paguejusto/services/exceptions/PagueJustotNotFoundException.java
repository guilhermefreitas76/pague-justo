package br.com.paguejusto.services.exceptions;

public class PagueJustotNotFoundException extends RuntimeException{

	
	private static final long serialVersionUID = 1L;
	
	public PagueJustotNotFoundException(String msg) {
		super(msg);
	}
	public PagueJustotNotFoundException(String msg, Throwable throwable) {
		super(msg,throwable);
	}

}
