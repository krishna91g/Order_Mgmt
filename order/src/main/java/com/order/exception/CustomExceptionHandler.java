package com.order.exception;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import feign.FeignException;

@ControllerAdvice
@ResponseBody
public class CustomExceptionHandler extends ResponseEntityExceptionHandler  {
		
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<Object> myMessage(CustomException ex){
		List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse("Record Not Found !!!", details);
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(RecordNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(RecordNotFoundException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse("Record Not Found !!!", details);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
	@Override
	  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
	      HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> details = new ArrayList<>();
        for(ObjectError error : ex.getBindingResult().getAllErrors()) {
            details.add(error.getDefaultMessage());
        }
		ErrorResponse errorDetails = new ErrorResponse("Validation Failed !!!!", details);
	    return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	  } 
	
	@ExceptionHandler(FeignException.class)  
    public ResponseEntity<Object> handleFeignStatusException(FeignException ex, HttpServletResponse response) {
        response.setStatus(ex.status());
        List<String> details = new ArrayList<>();
        ErrorResponse errorDetails = new ErrorResponse("Record Not Found !!!", "No Records received from OrderItem MS !!!");
	    return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST); 
    }
}
