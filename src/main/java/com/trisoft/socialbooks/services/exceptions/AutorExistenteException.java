package com.trisoft.socialbooks.services.exceptions;

public class AutorExistenteException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8913064137291891632L;

	public AutorExistenteException(String mensagem) {
		super(mensagem);		
	}
	
	public AutorExistenteException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
