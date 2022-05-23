package com.alianza.mutantes.dao;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alianza.mutantes.controller.MutantController;
import com.alianza.mutantes.exception.DbException;
import com.alianza.mutantes.model.Individuo;
import com.alianza.mutantes.repository.IndividuoRepository;

/**
 * Implementacion de la capa de acceso a datos(DAO) con MongoDB
 * 
 * @author cardo
 */

@Service
public class MutantsDAOImpl implements MutantsDAO{
	
	/**
	 * Framework slf4j para manejar logging 
	 */
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(MutantController.class);
	
	@Autowired
	private IndividuoRepository individuoRepository;
	
	public MutantsDAOImpl() {
		super();
	}
	
	/**
	 * Metodo para guardar un individuo en la Base de datos
	 * 
	 * @return un Integer que representa la cantidad de humanos en la tabla
	 */
	@Override
	public void insert(Individuo individuo) throws DbException {
		individuoRepository.save(individuo);
		logger.info("Se guardó en la Base de Datos el siguiente sujeto: " + individuo);
		
	}
	
	/**
	 *  Metodo que retorna la cantidad de Humanos
	 *  
	 *  @return un entero que representa la cantidad de Humanos de la BD
	 */
	@Override
	public int getContadorHumanos() throws DbException {
		
		return individuoRepository.countByTipoIndividuo("Human").intValue();
	}
	
	/**
	 * Metodo que retorna la cantidad de Mutantes de la base de datos
	 * 
	 * @return un integer que representa la cantidad de mutantes en la tabla.
	 */
	@Override
	public int getContadorMatantes() throws DbException {
		
		return individuoRepository.countByTipoIndividuo("Mutant").intValue();
	}
	
	
}
