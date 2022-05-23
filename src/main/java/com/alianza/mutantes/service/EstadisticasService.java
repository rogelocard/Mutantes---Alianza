package com.alianza.mutantes.service;

import com.alianza.mutantes.exception.ServiceException;
import com.alianza.mutantes.model.Estadisticas;

/**
 * The user of this interface has control to access the statistics of the app.
 * 
 * @author cardo
 *
 */
public interface EstadisticasService {
	
	/**
     * Obtains the statistics of the app
     *
     * @return the statistics of the app
     * @throws ServiceException if there is a problem with the Service
     */
    Estadisticas getStats() throws ServiceException;
}
