package org.simsoft.validator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.simsoft.security.Principal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultRequestValidator implements RequestValidator {
	
	private static final Logger LOG = LoggerFactory.getLogger(DefaultRequestValidator.class);

	@Override
	public Principal validateAndReturn(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Object principalObject = session.getAttribute("principal");
		
		if (principalObject == null) {
			LOG.info("Not logged in [principal null] - redirecting...");
			return null;
		}
		
		Principal principal = (Principal) principalObject;
		
		if (!principal.isAuthenticated()) {
			LOG.info("Not logged in [not authenticated] - redirecting...");
			return null;
		}
		
		return principal;
	}
	
}