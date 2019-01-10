package br.com.projeto.api.handler;

public class ClienteNotFoundException extends RuntimeException{

	public ClienteNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
