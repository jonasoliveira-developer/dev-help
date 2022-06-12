package com.oliveira.jonas.devhelp.resouces.exceptions;

import java.util.ArrayList;
import java.util.List;

import com.oliveira.jonas.devhelp.services.exceptions.StandardError;

public class ValidationError extends StandardError {
	private static final long serialVersionUID = 1L;
	
	private List<FildMessage> erros = new ArrayList<>();

	public ValidationError() {
		super();
		
	}

	public ValidationError(Long timestamp, Integer status, String error, String message, String path) {
		super(timestamp, status, error, message, path);
		
	}

	public List<FildMessage> getErros() {
		return erros;
	}

	public void addErros(String fildName, String message) {
		this.erros.add(new FildMessage(fildName, message));
	}
	
	
	
	
}
