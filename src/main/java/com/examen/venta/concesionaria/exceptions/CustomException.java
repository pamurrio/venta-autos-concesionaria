package com.examen.venta.concesionaria.exceptions;

public class CustomException extends RuntimeException {
    /**
     * 
     */
    private static final long serialVersionUID = 5217995084519789684L;
    private String message;

    public CustomException(String message) {
	this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}
