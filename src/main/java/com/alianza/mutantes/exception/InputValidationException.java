package com.alianza.mutantes.exception;

/** 
 * Clase que lanza una excepcion de el tipo InputValidationException
 * Cuando una secuencia incorrecta de ADN se carga en la Aplicacion.
 * la cual es llamada Alien ADN
 *
 * @author cardo
 */
public class InputValidationException extends Exception{
	
	private String message;

    public InputValidationException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
