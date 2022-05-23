package com.alianza.mutantes.utils;

import com.alianza.mutantes.Configuration;

/**
 * Esta clase maneja todas las operaciones de la matriz para determinar
 * si basado en la secuencia de ADN alguien es Mutante o Humano.
 * 
 * @author cardonaRoger
 *
 */
public class OperacionesMatriz {
	
	private Configuration configuration = new Configuration();
	private char[][] secuenciaADN;
	private int contadorSecuencia = 0; // Contador de secuencias encontradas
	private char ultimoCaracter;

	/**
	 * Este metodo lee las filas de la matriz que forman una secuencia de ADN
	 *
	 * @return un valor buleano para saber si el sujeto es Humano o Mutante
	 */
	Boolean lecturaHorizontal(char[][] secuenciaADN) {
		this.secuenciaADN = secuenciaADN;

		for (int fila = 0; fila < secuenciaADN.length; fila++) {
			ultimoCaracter = secuenciaADN[fila][0];
			if (leerHorizontalOVertical(LeerDirecciones.HORIZONTAL, ultimoCaracter, fila)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Este metodo lee las columnas de la matriz que forman secuencias de ADN
	 *
	 * @return un valor booleano para saber si el sujeto es Humano o Mutante
	 */
	Boolean LecturaVertical(char[][] secunciaADN) {
		this.secuenciaADN = secuenciaADN;

		for (int colm = 0; colm < secuenciaADN.length; colm++) {
			ultimoCaracter = secuenciaADN[0][colm];
			if (leerHorizontalOVertical(LeerDirecciones.VERTICAL, ultimoCaracter, colm)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Este metodo lee de izquierda a derecha todas las diagonales de ABAJO que
	 * forman secuencias de ADN en la matriz sin la diagonal principal
	 *
	 * @return un valor booleano para saber si el sujeto es Humano o Mutante
	 */
	Boolean diagonalesBajoDiagonalPrincipalDesdeIzquierda(char[][] secuenciaADN) {
		this.secuenciaADN = secuenciaADN;

		for (int fila = 1; fila < secuenciaADN.length; fila++) {
			ultimoCaracter = secuenciaADN[fila][0];
			if (leerDiagonales(LeerDireccionesDiagonales.DESDE_IZQUIERDA, LeerTipoDiagonal.DEBAJO_DIAGONAL_PRINCIPAL,
					fila, 0)) {
				return true;
			}

		}
		return false;
	}

	/**
	 * Este metodo lee de derecha a Izquierda todas las diagonales de ABAJO que
	 * forman secuencias de ADN en la matriz sin la diagonal principal
	 *
	 * @return un valor booleano para saber si el sujeto es Humano o Mutante
	 * 
	 */
	Boolean diagonalesBajoDiagonalPrincipalDesdeDerecha(char[][] secuenciaADN) {
		this.secuenciaADN = secuenciaADN;

		for (int fila = 1; fila < secuenciaADN.length; fila++) {
			ultimoCaracter = secuenciaADN[fila][secuenciaADN.length - 1];
			if (leerDiagonales(LeerDireccionesDiagonales.DESDE_DERECHA, LeerTipoDiagonal.DEBAJO_DIAGONAL_PRINCIPAL,
					fila, secuenciaADN.length - 1)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Este metodo lee de izquierda a derecha todas las diagonales de ARRIBA que
	 * forman secuencias de ADN en la matriz incluyendo la diagonal principal
	 *
	 *
	 * @return un valor booleano para saber si el sujeto es Humano o Mutante
	 */
	Boolean diagonalesArribaDiagonalPrincipalDesdeIzquieda(char[][] secuenciaADN) {
		this.secuenciaADN = secuenciaADN;

		for (int col = 0; col < secuenciaADN.length; col++) {
			ultimoCaracter = secuenciaADN[0][col];
			if (leerDiagonales(LeerDireccionesDiagonales.DESDE_IZQUIERDA, LeerTipoDiagonal.ARRIBA_DIAGONAL_PRINCIPAL, 0,
					col)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Este metodo lee de derecha a Izquierda todas las diagonales de ARRIBA que
	 * forman secuencias de ADN en la matriz incluyendo la diagonal principal
	 *
	 * @return a boolean value that determinate if the subject is Human or Mutant
	 */
	Boolean diagonalesArribaDiagonalPrincipalDesdeDerecha(char[][] secuenciaADN) {
		this.secuenciaADN = secuenciaADN;

		for (int col = 1; col < secuenciaADN.length; col++) {
			ultimoCaracter = secuenciaADN[0][secuenciaADN.length - col];
			if (leerDiagonales(LeerDireccionesDiagonales.DESDE_DERECHA, LeerTipoDiagonal.ARRIBA_DIAGONAL_PRINCIPAL, 0,
					secuenciaADN.length - col)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Este metodo se usa para buscar secuencias en una sola fila o columna
	 * dependiendo de un punto base o direccion dada.
	 *
	 * @param direccion       Si se lee columna por columna o fila por fila.
	 * @param caracterInicial El primer caracter leido.
	 * @param index           La iteracion provista en este metodo para escanear
	 *                        fila por fila y columna por columna.
	 * @return true Si el numero de secuencias para considerar a alguien mutante es
	 *         alcanzado. Note: Quizas el numero de secuencias fue alcanzado por
	 *         este y un metodo previo.
	 * 
	 */
	private boolean leerHorizontalOVertical(LeerDirecciones direccion, char caracterInicial, int index) {
		int contadorCaracteresIguales = 1;
		char ultimoCaracter = caracterInicial;
		char caracterActual;

		for (int subindex = 1; secuenciaADN.length - subindex + contadorCaracteresIguales >= configuration
				.getLargorSecuencia() && subindex < secuenciaADN.length; subindex++) {

			caracterActual = (LeerDirecciones.HORIZONTAL.equals(direccion) ? secuenciaADN[index][subindex]
					: secuenciaADN[subindex][index]);
			if (ultimoCaracter == caracterActual) {
				contadorCaracteresIguales++;
				if (contadorCaracteresIguales == configuration.getLargorSecuencia()) {
					contadorSecuencia++;
					contadorCaracteresIguales = 0;
					if (contadorSecuencia == configuration.getMinSecuenciasParaSerMutante()) {
						// Si se encuentran el minimo de secuencias que determinan si alguien es
						// mutante, para la busqueda y retorna TRUE.
						return true;
					}
				}
			} else {
				ultimoCaracter = caracterActual;
				contadorCaracteresIguales = 1;
			}
		}
		// El sujeto es Humano
		return false;
	}

	/***
	 * Este metodo es usado para buscar secuencias en una sola diagonal dependiendo
	 * de un punto base y direccion Y si esta se lee encima de la diagonal y
	 * incluyendala o abajo de la diagonal principal.
	 *
	 * @param izquierdaODerecha La direccion donde se escanea.
	 * @param arribaOAbajo      Si se leen las diagonales arriba de la principal
	 *                          (incluyendola) o abajo de la diagonal principal.
	 * 
	 * @param baseRow           La fila Inicial
	 * @param baseM             La columna inicial
	 *
	 * @return true Si el numero de secuencias para considerar a alguien mutante es
	 *         alcanzado. Note: Quizas el numero de secuencias fue alcanzado por
	 *         este y un metodo previo.
	 */
	private boolean leerDiagonales(LeerDireccionesDiagonales izquierdaODerecha, LeerTipoDiagonal arribaOAbajo,
			int baseRow, int baseColm) {
		int offset = 1;
		int contadorCaracteresIguales = 1;
		char ultimoCaracter = secuenciaADN[baseRow][baseColm];
		char caracterActual;

		// Esta condicion es valida cuando todavia se puede leer debajo de la diagonal
		boolean condicionLecturaAbajo = baseRow + offset < secuenciaADN.length;

		// Esta condicion es valida cuando todavia se puede leer desde la diagonal a
		// arriba.
		boolean condicionLecturaArriba = (izquierdaODerecha.equals(LeerDireccionesDiagonales.DESDE_IZQUIERDA)
				&& baseColm + offset < secuenciaADN.length
				|| izquierdaODerecha.equals(LeerDireccionesDiagonales.DESDE_DERECHA) && baseColm - offset >= 0);

		// Dependiendo de la verificacion del anterior condicional se determina si es
		// correcto continuar leyendo la diagonal.
		while ((arribaOAbajo.equals(LeerTipoDiagonal.ARRIBA_DIAGONAL_PRINCIPAL) && condicionLecturaArriba)
				|| (arribaOAbajo.equals(LeerTipoDiagonal.DEBAJO_DIAGONAL_PRINCIPAL) && condicionLecturaAbajo)) {

			caracterActual = (izquierdaODerecha.equals(LeerDireccionesDiagonales.DESDE_IZQUIERDA))
					? secuenciaADN[baseRow + offset][baseColm + offset]
					: secuenciaADN[baseRow + offset][baseColm - offset];
			if (ultimoCaracter == caracterActual) {
				contadorCaracteresIguales++;
				if (contadorCaracteresIguales == configuration.getLargorSecuencia()) {
					contadorSecuencia++;
					contadorCaracteresIguales = 0;
					if (contadorSecuencia >= configuration.getMinSecuenciasParaSerMutante()) {
						// Si se encuentran el minimo de secuencias que determinan si alguien es
						// mutante, para la busqueda y retorna TRUE.
						return true;
					}
				}
			} else {
				ultimoCaracter = caracterActual;
				contadorCaracteresIguales = 1;
			}

			offset++;

			// Verifico las condiciones leidas.
			condicionLecturaAbajo = baseRow + offset < secuenciaADN.length;

			condicionLecturaArriba = (izquierdaODerecha.equals(LeerDireccionesDiagonales.DESDE_IZQUIERDA)
					&& baseColm + offset < secuenciaADN.length
					|| izquierdaODerecha.equals(LeerDireccionesDiagonales.DESDE_DERECHA) && baseColm - offset >= 0);

		}
		// El sujeto es Humano.
		return false;
	}

	public enum LeerDirecciones {
		HORIZONTAL, VERTICAL
	}

	public enum LeerDireccionesDiagonales {
		DESDE_DERECHA, DESDE_IZQUIERDA
	}

	public enum LeerTipoDiagonal {
		DEBAJO_DIAGONAL_PRINCIPAL, ARRIBA_DIAGONAL_PRINCIPAL// ABOVE_MAIN_DIAGONAL_INCLUDING
	}
}
