package com.stock.model;

import java.io.Serializable;

public class GenericResponse implements Serializable{
	private static final long serialVersionUID = 1L;
	
	String message;
	String response;
	
	public GenericResponse(String message, String response) {
		super();
		this.message = message;
		this.response = response;
	}
	
	public String getMessage() {
		return message;
	}

	public String getResponse() {
		return response;
	}

}
