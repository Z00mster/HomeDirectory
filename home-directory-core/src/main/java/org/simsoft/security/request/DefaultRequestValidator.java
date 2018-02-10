package org.simsoft.security.request;

import javax.servlet.http.HttpServletRequest;

import org.simsoft.security.exception.RequestValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultRequestValidator implements RequestValidator {
	
	private static final Logger LOG = LoggerFactory.getLogger(DefaultRequestValidator.class);

	@Override
	public void validate(HttpServletRequest request) {
		Object object = request.getSession().getAttribute("authorized");
		boolean result = object != null;
		if (!result) {
			LOG.error("object is null");
		}
		result = result && object.getClass().isAssignableFrom(Boolean.class);
		if (!result) {
			LOG.error("object not a string");
		}
		result = result && (boolean) object;
		if (!result) {
			throw RequestValidationException.notAuthorizedPrincipal();
		}
	}
	
}