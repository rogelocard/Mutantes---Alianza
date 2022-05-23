package com.alianza.mutantes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alianza.mutantes.dao.MutantsDAO;
import com.alianza.mutantes.exception.DbException;
import com.alianza.mutantes.exception.ServiceException;
import com.alianza.mutantes.model.Estadisticas;

@Service
public class EstadisticasServiceImpl implements EstadisticasService{
	
	@Autowired
    private MutantsDAO daoService;

    /**
     * Metodo para obtener las estadisticas de la APP
     *
     * @return las estadisticas de la APP
     * @throws ServiceException si hay un problema con el servicio
     */
	@Override
    public Estadisticas getStats() throws ServiceException {

        Estadisticas stats;

        try {

            stats = new Estadisticas(daoService.getContadorMatantes(), daoService.getContadorHumanos());

        } catch (DbException e) {
            throw new ServiceException(e.getMessage());
        }
        return stats;
    }
}
