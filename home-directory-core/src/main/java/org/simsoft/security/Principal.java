package org.simsoft.security;

import java.io.Serializable;

public class Principal implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private final boolean isAuthenticated;
	
	public Principal(boolean isAuthenticated) {
		this.isAuthenticated = isAuthenticated;
	}

	public boolean isAuthenticated() {
		return isAuthenticated;
	}
	
}