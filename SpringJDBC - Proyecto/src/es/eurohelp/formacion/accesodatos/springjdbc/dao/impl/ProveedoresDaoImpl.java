package es.eurohelp.formacion.accesodatos.springjdbc.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import es.eurohelp.formacion.accesodatos.springjdbc.beans.Proveedores;
import es.eurohelp.formacion.accesodatos.springjdbc.dao.ProveedoresDao;

public class ProveedoresDaoImpl  extends JdbcDaoSupport implements ProveedoresDao{

	public Proveedores getProveedor(int prov) {

		StringBuffer sql = new StringBuffer();

		sql
		.append(" SELECT * ")
		.append(" FROM ").append("proveedores")
		.append(" WHERE proveedor = ?");
		

		Object[] params = new Object[] { prov };

		Proveedores it = (Proveedores) getJdbcTemplate().queryForObject( sql.toString(), params, new ItemRowMapper());


		return it;

	}

	public void updateProveedor(Proveedores prov) {

		StringBuffer sql = new StringBuffer();
		sql
		.append("UPDATE ").append("proveedores")
		.append(" SET empresa= ?,")
		.append(" apellidos= ?,")
		.append(" nombre= ?,")
		.append(" direccion1= ?,")
		.append(" direccion2= ?,")
		.append(" poblacion= ?,")
		.append(" provincia= ?,")
		.append(" distrito= ?,")
		.append(" telefono= ?")
		.append(" WHERE proveedor = ?");

		Object[] params = new Object[] {

				prov.getEmpresa(),
				prov.getApellidos(),
				prov.getNombre(),
				prov.getDireccion1(),
				prov.getDireccion2(),
				prov.getPoblacion(),
				prov.getProvincia(),
				prov.getDistrito(),
				prov.getTelefono(),
				prov.getProveedor()
		};
		

		getJdbcTemplate().update(sql.toString(), params);

	}

	public void insertProveedor(Proveedores prov) {
		StringBuffer sql = new StringBuffer();

		sql
		.append("INSERT INTO ").append("proveedores")
		.append(" (proveedor,empresa,apellidos,nombre,direccion1,direccion2,poblacion,provincia,distrito,telefono) ")
		.append("VALUES(?,?,?,?,?,?,?,?,?,?)");

		Object[] params = new Object[] {
				
				
				prov.getProveedor(),
				prov.getEmpresa(),
				prov.getApellidos(),
				prov.getNombre(),
				prov.getDireccion1(),
				prov.getDireccion2(),
				prov.getPoblacion(),
				prov.getProvincia(),
				prov.getDistrito(),
				prov.getTelefono()
				
		};

		getJdbcTemplate().update(sql.toString(), params);

	}

	public void deleteProveedor(int prov) {
		StringBuffer sql = new StringBuffer();

		sql
		.append("DELETE FROM ").append("proveedores")
		.append(" WHERE proveedor = ? ");

		Object[] params = new Object[] {prov};

		getJdbcTemplate().update(sql.toString(), params);


	}

	class ItemRowMapper implements RowMapper {

		public Object mapRow(ResultSet rs, int index) throws SQLException {

			Proveedores it = new Proveedores();

			it.setProvincia(rs.getInt("provincia"));
			it.setEmpresa(rs.getString("empresa"));
			it.setApellidos(rs.getString("apellidos"));
			it.setNombre(rs.getString("nombre"));
			it.setDireccion1(rs.getString("direccion1"));
			it.setDireccion2(rs.getString("direccion2"));
			it.setPoblacion(rs.getString("provincia"));
			it.setDistrito(new Integer(rs.getInt("distrito")));
			it.setTelefono(rs.getString("telefono"));
			

			return it;
		}
	}
}
