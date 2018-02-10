package org.simsoft.security.request;

import javax.servlet.http.HttpServletRequest;

public interface RequestValidator {

	void validate(HttpServletRequest request);
	
}