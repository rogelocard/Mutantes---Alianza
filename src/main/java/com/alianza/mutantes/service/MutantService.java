package com.alianza.mutantes.service;


import com.alianza.mutantes.exception.InputValidationException;
import com.alianza.mutantes.exception.ServiceException;

/**
 * A través de el servicio de esta interface se determina si el adn del sujeto
 * es Humano o Mutante o ninguna de las dos
 * 
 * @author cardo
 */

public interface MutantService{

	/*
	 * Determina por el ADN dado si un individuo es Humano o Mutante.
	 * 
	 * @param dna La secuencia de ADN a ser evaluada para saber si un individuo es
	 * mutante o no.
	 * 
	 * @return True Si el individuo es mutante, de lo contrario retornara un FALSE.
	 * 
	 * @throws InputValidationException si el adn no es ni de un humano ni un
	 * mutante.
	 * 
	 * @throws ServiceException Si hay un problema con el servicio
	 * 
	 */
	boolean isMutant(String[] dna) throws ServiceException, InputValidationException;
}
