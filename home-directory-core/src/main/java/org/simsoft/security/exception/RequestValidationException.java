package org.simsoft.security.exception;

public class RequestValidationException extends RequestException {
	
	private static final long serialVersionUID = 1L;
	
	private RequestValidationException() {}

	public static RequestValidationException notAuthorizedPrincipal() {
		return new RequestValidationException();
	}
	
}