package org.simsoft.security.exception;

public class FileException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public static FileException pathDoesntExist() { 
		return new FileException();
	}
	
}