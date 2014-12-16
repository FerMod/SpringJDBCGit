package es.eurohelp.formacion.accesodatos.springjdbc.dao;

import es.eurohelp.formacion.accesodatos.springjdbc.beans.Proveedores;

public interface ProveedoresDao {

	Proveedores getProveedor(int proveedor);
	
	void updateProveedor(Proveedores proveedor);

	void insertProveedor(Proveedores proveedor);

	void deleteProveedor(int proveedor);
	}
