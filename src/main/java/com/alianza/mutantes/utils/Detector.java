package com.alianza.mutantes.utils;

import com.alianza.mutantes.exception.InputValidationException;

/**
 * Al implementar esta interface se podra determinar si el ADN 
 * de un individuo es Humano, Mutante o Alien. 
 * 
 * @author cardo
 *
 */
public interface Detector {
	
	/*
	 * Determina por el ADN dado si un individuo es Humano o Mutante. 
	 * 
	 * @param dna  La secuencia de ADN a ser evaluada para saber si un individuo es mutante o no. 
	 * @return True  Si el individuo es mutante, de lo contrario retornara un FALSE.
	 * 
	 */
	boolean isMutant(String[] dna) throws InputValidationException ;
}
