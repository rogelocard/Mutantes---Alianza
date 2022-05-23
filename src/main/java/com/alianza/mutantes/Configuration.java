package com.alianza.mutantes;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.LoggerFactory;
import ch.qos.logback.classic.Logger;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * Clase que contiene toda la configuracion de la App
 * El archivo config.properties de configuracion esta localizado bajo el archivo de resources
 * justo abajo de el application.properties
 * 
 * @author cardo
 *
 */
public class Configuration {
	private static final Logger logger = (Logger) LoggerFactory.getLogger(Configuration.class);

    private static final String CONFIG_FILE = "/config.properties";
    private static final String MIN_SEQUENCES_TO_BE_MUTANT = "min-sequences-to-be-mutant";
    private static final String SEQUENCES_LENGTH = "sequences-length";


    private Integer minSecuenciasParaSerMutante; 
    private Integer LargorSecuencia;


    public Configuration() {
        super();
        Properties propiedades = this.loadConfig(CONFIG_FILE);

        this.minSecuenciasParaSerMutante = Integer.parseInt(propiedades.getProperty(MIN_SEQUENCES_TO_BE_MUTANT));
        this.LargorSecuencia = Integer.parseInt(propiedades.getProperty(SEQUENCES_LENGTH));

    }


    public Integer getMinSecuenciasParaSerMutante() {
        return minSecuenciasParaSerMutante;
    }

    public Integer getLargorSecuencia() {
        return LargorSecuencia;
    }

    /**
     * Este metodo carga el archivo de config.properties para que los parametros puedan ser leidos.
     *
     * @return objeto properties.
     */
    private Properties loadConfig(String propertiesFileName) {
        Properties configFile = new Properties();
        try {
            configFile.load(getClass().getResourceAsStream(propertiesFileName));
        } catch (IOException e) {
            logger.error("Problemas cargando el archivo de configuracion.", e);
        }
        return configFile;
    }
}
