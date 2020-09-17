package com.order.item.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomException extends RuntimeException  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param exception
	 */
	public CustomException(String exception) {
        super(exception);
    }
}
