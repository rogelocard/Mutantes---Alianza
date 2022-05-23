package com.alianza.mutantes.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alianza.mutantes.exception.ServiceException;
import com.alianza.mutantes.model.Estadisticas;
import com.alianza.mutantes.service.EstadisticasService;


@RestController
public class EstadisticasController {
	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(MutantController.class);

    @Autowired
    private EstadisticasService servicioEstadistica;

    /**
     * Metodo que retorna las estadisticas de las secuencias de ADN que fueron analizadas
     *
     * @return a json document with the statistics which are quantity of Humans, Mutants and the Ratio
     */
    @RequestMapping(value = "/stats", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public Estadisticas getStatics() {

        Estadisticas stats = null;

        try {
            stats = servicioEstadistica.getStats();
            logger.info("La cantidad de Humanos es: {}, la de Mutantes es: {} y el Ratio es de: {}  ", servicioEstadistica.getStats().getcontar_adn_humano(), servicioEstadistica.getStats().getcontar_adn_mutante(), servicioEstadistica.getStats().getradio());
        } catch (ServiceException e) {
            logger.error(e.getMessage());
        }

        return stats;
    }
}
