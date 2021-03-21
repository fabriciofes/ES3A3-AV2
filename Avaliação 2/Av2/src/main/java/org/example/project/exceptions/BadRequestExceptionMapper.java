package org.example.project.exceptions;

import jakarta.ws.rs.core.Response;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.ext.ExceptionMapper;

public class BadRequestExceptionMapper implements ExceptionMapper<ConstraintViolationException> {
	
	@Override 
	public Response toResponse(ConstraintViolationException exception) {
		
		return null;
	}

}
