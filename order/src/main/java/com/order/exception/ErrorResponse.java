package com.order.exception;

import java.util.List;

public class ErrorResponse {
	//General error message about nature of error
    private String message;
 
    //Specific errors in API request processing
    private List<String> details;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getDetails() {
		return details;
	}

	public void setDetails(List<String> details) {
		this.details = details;
	}
    
	public ErrorResponse(String message, List<String> details) {
        super();
        this.message = message;
        this.details = details;
    }

	public ErrorResponse(String message2, String string) {
		// TODO Auto-generated constructor stub
	}
}
