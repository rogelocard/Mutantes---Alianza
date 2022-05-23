package com.alianza.mutantes.exception;

/**
 * Esta clase lanza una excepcion del tipo DbException 
 * cuando una excepcion es lanzada desde el componente de Spring Boot Data MongoDB
 * 
 * @author cardo
 *
 */
public class DbException extends Exception {
	
	private String mensaje;
	
	public DbException(String mensaje) {
		this.mensaje = mensaje;
	}
	
	@Override
    public String getMessage() {
        return mensaje;
    }
}
