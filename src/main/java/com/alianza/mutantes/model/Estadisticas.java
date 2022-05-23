package com.alianza.mutantes.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Estadisticas {
	
	private BigDecimal contar_adn_mutante;
    private BigDecimal contar_adn_humano;
    private BigDecimal radio;

    public Estadisticas(Integer mutantCount, Integer humanCount) {
        contar_adn_mutante = new BigDecimal(mutantCount);
        contar_adn_humano = new BigDecimal(humanCount);
        radio = (contar_adn_humano.compareTo(BigDecimal.ZERO) != 0) ? contar_adn_mutante.divide(contar_adn_humano, 2, RoundingMode.UNNECESSARY) : new BigDecimal("0.00");

    }

    public BigDecimal getcontar_adn_mutante() {
        return contar_adn_mutante;
    }

    public BigDecimal getcontar_adn_humano() {
        return contar_adn_humano;
    }

    public BigDecimal getradio() {
        return radio;
    }
}
