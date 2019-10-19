package com.trisoft.socialbooks.services.exceptions;

public class LivroNaoEncontradoException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8913064137291891632L;

	public LivroNaoEncontradoException(String mensagem) {
		super(mensagem);		
	}
	
	public LivroNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
