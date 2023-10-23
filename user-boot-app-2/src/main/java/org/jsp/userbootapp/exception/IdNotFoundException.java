package org.jsp.userbootapp.exception;

public class IdNotFoundException extends RuntimeException{
      
	private static final long serialVersionUID=1l;
	
        @Override
        public String getMessage() {
        	return "the id is invalid"; 
        }

}
