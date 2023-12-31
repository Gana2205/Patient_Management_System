package com.gana.patient.Exeption;

import org.springframework.http.HttpStatus; 

import lombok.Data;

@Data
public class ExceptionResponse<T> {
	
	private HttpStatus status;
	private String error;
	private String path;
	
}		
	
	
	


