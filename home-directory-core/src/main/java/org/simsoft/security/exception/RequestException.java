package org.simsoft.security.exception;

public abstract class RequestException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return "Failed because of: [" + getClass() + "]";
	}
	
}