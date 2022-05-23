package com.alianza.mutantes.model;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

/**
 * Clase que modela el individuo
 * @author cardo
 *
 */

@Document(collection = "individuos")
public class Individuo {
	
	public String tipoIndividuo;
	@Indexed(unique = true)
	private String secuenciaADN;
	
	public Individuo(String[] secuenciaADN, String tipoIndividuo) {
		this.secuenciaADN = String.join("", secuenciaADN);
		this.tipoIndividuo = tipoIndividuo;
	}
}
