package org.simsoft.validator;

import javax.servlet.http.HttpServletRequest;

import org.simsoft.security.Principal;

public interface RequestValidator {

	Principal validateAndReturn(HttpServletRequest request);
	
}