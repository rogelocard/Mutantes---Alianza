package com.alianza.mutantes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alianza.mutantes.dao.MutantsDAO;
import com.alianza.mutantes.exception.DbException;
import com.alianza.mutantes.exception.InputValidationException;
import com.alianza.mutantes.exception.ServiceException;
import com.alianza.mutantes.model.Individuo;
import com.alianza.mutantes.utils.Detector;
import com.alianza.mutantes.utils.DetectorMutante;

/**
 * Clase que implementa el servicio mutante para determinar
 * si un individuo es Humano o mutante, asi mismo para guardar en la base de datos.
 * 
 * @author cardo
 *
 */

@Service
public class MutantServiceImpl implements MutantService {
	
	@Autowired
	private MutantsDAO mutantsDAO;
	
	/**
	 * Metodo para analizar si la secuencia de un ADN pertenece a un mutante o humano y si se guarda en la BD
	 * 
	 * @param dna | Secuencia de ADN para evaluar si el individuo es mutante o no
	 * @return True si el individuo es mutante o FALSE si este es un Humano.
	 * @throws InputValidationException si el adn no corresponde al de un Humano o Alien
	 * @throws Service Exception si hay algun problema con el servicio.
	 */
	@Override
	public boolean isMutant(String[] dna) throws ServiceException, InputValidationException {
		
		Detector detectorMutante = new DetectorMutante();
		boolean isMutant;
		final String MUTANTE = "Mutant";
		final String HUMANO = "Human";
		
		try {
			isMutant = detectorMutante.isMutant(dna);
			
			if (isMutant) {
				Individuo mutante = new Individuo(dna, MUTANTE);
				mutantsDAO.insert(mutante);
			} else {
				Individuo humano =  new Individuo(dna, HUMANO);
				mutantsDAO.insert(humano);
			}
			
		} catch (DbException e) {
			throw new ServiceException(e.getMessage());
		}
		
		return isMutant;
	}

}
