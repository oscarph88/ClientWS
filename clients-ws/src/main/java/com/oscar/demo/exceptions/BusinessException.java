package com.oscar.demo.exceptions;

import lombok.Getter;

/**
 * This exception should be thrown in all cases needed
 *
 */
public class BusinessException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Getter
	private String errorCode;
    /**
     *
     * @param message the message
     */
    public BusinessException(final String message) {
        super(message);
    }
    
    public BusinessException(String message, String errorCode) {
    	
        super(message);
        this.errorCode = errorCode;
    }
}
