package com.gana.patient.Exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(value=NoDataFound.class)
	public ExceptionResponse<?> noDataFound(NoDataFound nodatafound, WebRequest request){
		
		ExceptionResponse<?> response = new ExceptionResponse<>();
		
		response.setStatus(HttpStatus.NOT_FOUND);
		response.setError(nodatafound.getMessage());
		response.setPath(request.getDescription(false));
		
		return response;
		
	}

}
