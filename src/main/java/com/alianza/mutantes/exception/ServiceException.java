package com.alianza.mutantes.exception;


/**
 * Esta clase lanza una exepcion del tipo ServiceException
 * cuando algun servicio falle. 
 * 
 * @author cardo
 *
 */
public class ServiceException extends Exception {

	private String mensaje;
	
	public ServiceException(String mensaje) {
		this.mensaje = mensaje;
	}
	
	@Override
    public String getMessage() {
        return mensaje;
    }
}
