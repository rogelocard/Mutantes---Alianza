package com.alianza.mutantes.utils;

import java.util.regex.Pattern;

import com.alianza.mutantes.exception.InputValidationException;


/**
 * Clase que implementa la interface Detector
 * 
 * @author cardo
 *
 */
public class DetectorMutante implements Detector {
	
	OperacionesMatriz operacionMatriz = new OperacionesMatriz();
	
	private char[][] secuenciaADN;
	
	
	/**
	 * Determina por un ADN dado si el individuo es Humano o Mutante
	 * @param dna  La secuencia de ADN a ser evaluada para saber si un individuo es mutante o no. 
	 * @return True  Si el individuo es mutante, de lo contrario retornara un FALSE.
	 * 
	 */
	//@Override
	public boolean isMutant(String[] dna) throws InputValidationException {
		
		secuenciaADN = llenarSecuenciaADN(dna);
		
		if (secuenciaADN.length < 4) {
			return false;
		}
		
		return analizarADN();
	}
	
    /**
     * The decision to use several IF Statements was made to fit the request of the maximum efficiency of the algorithm.
     * The strategy pattern could be used, but because the strategies are always the same and would not change in the future
     * it becomes unnecessary to implement it because of the complexity and the several new Java Class that would be necessary.
     *
     * @return a boolean value that determinate if the subject is Human or Mutant
     */
	private Boolean analizarADN() {
		
		if(operacionMatriz.lecturaHorizontal(secuenciaADN)) return true;
		if(operacionMatriz.LecturaVertical(secuenciaADN)) return true;
		if(operacionMatriz.diagonalesBajoDiagonalPrincipalDesdeIzquierda(secuenciaADN)) return true;
		if(operacionMatriz.diagonalesBajoDiagonalPrincipalDesdeDerecha(secuenciaADN)) return true;
		if(operacionMatriz.diagonalesArribaDiagonalPrincipalDesdeIzquieda(secuenciaADN)) return true;
		return operacionMatriz.diagonalesArribaDiagonalPrincipalDesdeDerecha(secuenciaADN);
		
		
	}
	
	/**
     * Mientras el array se llena, se chequea que las secuencias de adn sean correctas con las validaciones que se han puesto
     *
     * @param dna La secuencia de ADN a ser analizada.
     * @return la secuencia representada en un arreglo de dos dimenciones.
     * @throws InputValidationException Si el adn es invalido se lanza la excepcion.
     */
	private char[][] llenarSecuenciaADN(String[] dna) throws InputValidationException {
		
		int rangoSecuenciaADN = dna.length;
		Pattern pattern = Pattern.compile("[acgt]+", Pattern.CASE_INSENSITIVE);
		
		secuenciaADN = new char[rangoSecuenciaADN][rangoSecuenciaADN];
		
		for (int rango = 0; rango < rangoSecuenciaADN; rango++) {
			
			if(dna[rango].length() != rangoSecuenciaADN) {
				throw new InputValidationException("El largo de la secuencia de ADN debe ser igual al numero de secuencias");
			} else if (!pattern.matcher(dna[rango]).matches()) {
                throw new InputValidationException("DESCONOCIDO: El ADN humano y mutante contiene unicamente los caracteres A, C, G y T.");
			} else {
                secuenciaADN[rango] = dna[rango].toUpperCase().toCharArray();
            }
		}
		
		return secuenciaADN;
	}

}
