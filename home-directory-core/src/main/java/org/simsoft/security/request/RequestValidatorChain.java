package org.simsoft.security.request;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class RequestValidatorChain implements RequestValidator {
	
	private final List<RequestValidator> requestValidators;

	public RequestValidatorChain(List<RequestValidator> requestValidators) {
		super();
		this.requestValidators = requestValidators;
	}

	@Override
	public void validate(HttpServletRequest request) {
		for (RequestValidator validator : requestValidators) {
			validator.validate(request);
		}
	}
	
}