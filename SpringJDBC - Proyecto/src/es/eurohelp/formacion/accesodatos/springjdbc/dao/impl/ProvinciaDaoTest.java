package es.eurohelp.formacion.accesodatos.springjdbc.dao.impl;

import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

import es.eurohelp.formacion.accesodatos.springjdbc.beans.Provincias;
import es.eurohelp.formacion.accesodatos.springjdbc.dao.ProvinciaDao;

@SuppressWarnings("deprecation")
public class ProvinciaDaoTest extends AbstractTransactionalDataSourceSpringContextTests {

	private ProvinciaDao provinciaDao;

	public void setProvinciaDao(ProvinciaDao provinciaDao) {
		this.provinciaDao = provinciaDao;
	}

	protected String[] getConfigLocations() {
		this.setAutowireMode(AUTOWIRE_BY_NAME);
		return new String[] {"es/eurohelp/formacion/accesodatos/springjdbc/applicationContext-testProvincia.xml"};
	}


	public void testInsertProvincia() {
		//this.setDefaultRollback(false); // Si se pone esta linea, los cambios hechos se guardan
		Provincias prov = new Provincias();
		prov.setProvincia(55);
		prov.setDescripcion("Prov 1");
		prov.setPrefijo(15);

		provinciaDao.insertProvincia(prov);

		Provincias provResult = provinciaDao.getProvincia(prov.getProvincia());

		assertEquals(prov.getProvincia(), provResult.getProvincia());

	}

	public void testGetProvincia() {
		int provId = 100;
		Provincias prov = new Provincias();
		prov.setProvincia(provId);
		prov.setDescripcion("Prov 2");
		prov.setPrefijo(333);

		provinciaDao.insertProvincia(prov);

		Provincias provResult = provinciaDao.getProvincia(provId);
		assertNotNull(provResult);
	}

	public void testUpdateProvincia() {

		Provincias prov = new Provincias();
		prov.setProvincia(101);
		prov.setDescripcion("Prov 3");
		prov.setPrefijo(555);

		provinciaDao.insertProvincia(prov);

		Provincias provNueva = new Provincias();
		provNueva.setProvincia(101);
		provNueva.setDescripcion("Prov 3 Nueva");
		provNueva.setPrefijo(556);

		provinciaDao.updateProvincia(provNueva);

		Provincias provResult = provinciaDao.getProvincia(provNueva.getProvincia());
		assertEquals(provResult.getDescripcion(), "Prov 3 Nueva");
	}

	public void testDeleteProvincia() {
		
		Provincias prov = new Provincias();
		prov.setProvincia(200);
		prov.setDescripcion("Prov 4");
		prov.setPrefijo(555);

		provinciaDao.insertProvincia(prov);

		int provId = 200;
		provinciaDao.deleteProvincia(provId);

		//si la ejecucion llega aqui significa que el delete se ha efectuado correctamente
		assertTrue(true);

	}

}
