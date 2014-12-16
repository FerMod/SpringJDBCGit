package es.eurohelp.formacion.accesodatos.springjdbc.dao;

import es.eurohelp.formacion.accesodatos.springjdbc.beans.Provincias;

public interface ProvinciaDao {

	Provincias getProvincia(int provincia);
	
	void updateProvincia(Provincias provincia);

	void insertProvincia(Provincias provincia);

	void deleteProvincia(int provincia);
}
