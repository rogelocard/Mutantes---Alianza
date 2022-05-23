package com.alianza.mutantes.dao;

import com.alianza.mutantes.exception.DbException;
import com.alianza.mutantes.model.Individuo;

/**
 * Interface para controlar acciones en la Base de Datos.
 * 
 * @author cardo
 *
 */
public interface MutantsDAO {
	
	/**
	 * Metodo para insertar un individuo a la Base de datos
	 * 
	 * @param individuo | Individuo a ser guardado en la BD
	 * @throws DbException | Si hay algun problema con la BD
	 */
	void insert(Individuo individuo) throws DbException;
	
	/**
	 * Metodo que retorna los humanos que hay en la BD
	 *  
	 * @return la cantidad de humanos
	 * @throws DbException | Si hay algun problema con la BD
	 */
	int getContadorHumanos() throws DbException;
	
	/**
	 * Metodo que retorna los mutantes que existen en la BD
	 * @return
	 * @throws DbException
	 */
	int getContadorMatantes() throws DbException;
}
