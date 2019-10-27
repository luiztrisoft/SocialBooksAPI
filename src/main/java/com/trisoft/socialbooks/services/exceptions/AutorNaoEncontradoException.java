package com.trisoft.socialbooks.services.exceptions;

public class AutorNaoEncontradoException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8913064137291891632L;

	public AutorNaoEncontradoException(String mensagem) {
		super(mensagem);		
	}
	
	public AutorNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
