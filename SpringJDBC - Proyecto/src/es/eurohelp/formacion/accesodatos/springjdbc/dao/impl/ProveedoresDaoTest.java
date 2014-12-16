package es.eurohelp.formacion.accesodatos.springjdbc.dao.impl;

import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

import es.eurohelp.formacion.accesodatos.springjdbc.beans.Proveedores;
import es.eurohelp.formacion.accesodatos.springjdbc.dao.ProveedoresDao;

@SuppressWarnings("deprecation")
public class ProveedoresDaoTest extends AbstractTransactionalDataSourceSpringContextTests {

	private ProveedoresDao proveedoresDao;

	public void setProveedoresDao(ProveedoresDao proveedoresDao) {
		this.proveedoresDao = proveedoresDao;
	}

	protected String[] getConfigLocations() {
		this.setAutowireMode(AUTOWIRE_BY_NAME);
		return new String[] {"es/eurohelp/formacion/accesodatos/springjdbc/applicationContext-testProveedores.xml"};
	}


	public void testInsertProveedor() {
		//this.setDefaultRollback(false); // Si se pone esta linea, los cambios hechos se guardan
		Proveedores prov = new Proveedores();
		prov.setProveedor(559);
		prov.setEmpresa("Empresa S.A.");
		prov.setApellidos("Jones Mios");
		prov.setNombre("Paoco");
		prov.setDireccion1("Aqui");
		prov.setDireccion2("Allli");
		prov.setPoblacion("Villareal");
		prov.setProvincia(12);
		prov.setDistrito(54);
		prov.setTelefono("11110");
		
		proveedoresDao.insertProveedor(prov);

		Proveedores provResult = proveedoresDao.getProveedor(prov.getProveedor());

		assertEquals(prov.getProvincia(), provResult.getProvincia());

	}

	public void testGetProveedor() {
		int provId = 560;
		Proveedores prov = new Proveedores();
		prov.setProveedor(provId);
		prov.setEmpresa("Empresa S.A.");
		prov.setApellidos("Jones Mios");
		prov.setNombre("Paoco");
		prov.setDireccion1("Aqui");
		prov.setDireccion2("Allli");
		prov.setPoblacion("Esaf");
		prov.setProvincia(6);
		prov.setDistrito(54);
		prov.setTelefono("11110");

		proveedoresDao.insertProveedor(prov);

		Proveedores provResult = proveedoresDao.getProveedor(provId);
		assertNotNull(provResult);
	}

	public void testUpdateProveedor() {

		Proveedores prov = new Proveedores();
		prov.setProveedor(561);
		prov.setEmpresa("Empresa S.A.");
		prov.setApellidos("Jones Mios");
		prov.setNombre("Paoco");
		prov.setDireccion1("Aqui");
		prov.setDireccion2("Allli");
		prov.setPoblacion("Esaf");
		prov.setProvincia(6);
		prov.setDistrito(54);
		prov.setTelefono("11110");

		proveedoresDao.insertProveedor(prov);

		Proveedores provNueva = new Proveedores();
		provNueva.setProveedor(561);
		provNueva.setEmpresa("Empresa S.A. Nuevo");
		provNueva.setApellidos("Jones Mios Nuevo");
		provNueva.setNombre("Paoco Nuevo");
		provNueva.setDireccion1("Aqui Nuevo");
		provNueva.setDireccion2("Allli Nuevo");
		provNueva.setPoblacion("Esaf Nuevo");
		provNueva.setProvincia(6);
		provNueva.setDistrito(54);
		provNueva.setTelefono("11110 Nuevo");

		proveedoresDao.updateProveedor(provNueva);

		Proveedores provResult = proveedoresDao.getProveedor(provNueva.getProveedor());
		assertEquals(provResult.getEmpresa(), "Empresa S.A. Nuevo");
	}

	public void testDeleteProveedor() {
		
		Proveedores prov = new Proveedores();
		prov.setProveedor(563);
		prov.setEmpresa("Empresa S.A.");
		prov.setApellidos("Jones Mios");
		prov.setNombre("Paoco");
		prov.setDireccion1("Aqui");
		prov.setDireccion2("Allli");
		prov.setPoblacion("Esaf");
		prov.setProvincia(6);
		prov.setDistrito(54);
		prov.setTelefono("11110");

		proveedoresDao.insertProveedor(prov);

		int provId = 563;
		proveedoresDao.deleteProveedor(provId);

		//si la ejecucion llega aqui significa que el delete se ha efectuado correctamente
		assertTrue(true);

	}

}
