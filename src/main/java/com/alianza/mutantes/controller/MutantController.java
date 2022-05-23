package com.alianza.mutantes.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alianza.mutantes.exception.InputValidationException;
import com.alianza.mutantes.exception.ServiceException;
import com.alianza.mutantes.model.Individuo;
import com.alianza.mutantes.model.SecuenciaADN;
import com.alianza.mutantes.repository.IndividuoRepository;
import com.alianza.mutantes.service.MutantService;

import ch.qos.logback.classic.Logger;

/**
 * Controlador para el ServicioMutante
 * 
 * @author cardo
 *
 */

@RestController
//@RequestMapping(value = "/api")
public class MutantController {

	//private static final Logger logger = (Logger) LoggerFactory.getLogger(MutantController.class);
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(MutantController.class);
	
	@Autowired
	private IndividuoRepository individuoRepository;

	@Autowired
	//private MutantService servicioMutante;
	private MutantService servicioMutante;
	
//	@GetMapping("/")
//	public List<Individuo> readAll(){
//		return individuoRepository.findAll();
//	}

	/**
	 * Metodo que analiza si el individuo es Mutante o Humano
	 * 
	 * @param dna Secuencia de ADN para analizar
	 * @return Si el analisis es Mutante retornara 200(OK) si es Humano
	 *         403(Forbidden)
	 */
	//@PostMapping("/mutant")
	@RequestMapping(value = "/mutant", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	public ResponseEntity<String> analizaIndividuo(@RequestBody SecuenciaADN dna) {

		ResponseEntity<String> responseEntity;
		boolean isMutant;

		try {
			isMutant = servicioMutante.isMutant(dna.getAdn());

			if (isMutant) {
				responseEntity = new ResponseEntity<>(HttpStatus.OK);
			} else {
				responseEntity = new ResponseEntity<>(HttpStatus.FORBIDDEN);
			}

		} catch (ServiceException e) {
			responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			logger.error(e.getMessage());
		} catch (InputValidationException e) {
			responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			logger.error(e.getMessage());
			// e.printStackTrace();
		}

		return responseEntity;
	}
}
