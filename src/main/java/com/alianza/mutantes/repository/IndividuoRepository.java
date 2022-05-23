package com.alianza.mutantes.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.alianza.mutantes.model.Individuo;

@Repository
public interface IndividuoRepository extends MongoRepository<Individuo, String>{
	
	Long countByTipoIndividuo(String tipoIndividuo);
}
