package com.oliveira.jonas.devhelp.resouces.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.oliveira.jonas.devhelp.services.exceptions.DataIntegrationViolationException;
import com.oliveira.jonas.devhelp.services.exceptions.ObjectNotFoundException;
import com.oliveira.jonas.devhelp.services.exceptions.StandardError;

@ControllerAdvice
public class ResourceExceptionHandle {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFoundException (ObjectNotFoundException ex,
			HttpServletRequest request) {
		
		StandardError error = new StandardError(System.currentTimeMillis(), 
				HttpStatus.NOT_FOUND.value(), "Object Not Found",
				ex.getMessage(),
				request.getRequestURI()
				 
				);
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ExceptionHandler(DataIntegrationViolationException.class)
	public ResponseEntity<StandardError> dataIntegrationViolationException (DataIntegrationViolationException ex,
			HttpServletRequest request) {
		
		StandardError error = new StandardError(System.currentTimeMillis(), 
				HttpStatus.BAD_REQUEST.value(), "Violação de dados!",
				ex.getMessage(),
				request.getRequestURI()
				 
				);
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> dataIntegrationViolationException (MethodArgumentNotValidException ex,
			HttpServletRequest request) {
		
		ValidationError erros = new ValidationError(System.currentTimeMillis(),
			  HttpStatus.BAD_REQUEST.value(),  "Validation Erros!",  "Erro na validação dos campos!",request.getRequestURI());
				 
				 for(FieldError x : ex.getBindingResult().getFieldErrors() ) {
					 erros.addErros(x.getField(), x.getDefaultMessage());
				 }
				
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erros);
	}
}
