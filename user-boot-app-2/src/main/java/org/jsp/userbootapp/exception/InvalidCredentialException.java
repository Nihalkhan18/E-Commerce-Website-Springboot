package org.jsp.userbootapp.exception;

public class InvalidCredentialException extends RuntimeException {
	
	private static final long serialVersionUID=1L;
	
	@Override
	public String getMessage() {
		return "invalid phone or email or password " ;
	}

}
