package br.com.projeto.api.handler;

public class FornecedorNotFoundException extends RuntimeException{
	
	public FornecedorNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
