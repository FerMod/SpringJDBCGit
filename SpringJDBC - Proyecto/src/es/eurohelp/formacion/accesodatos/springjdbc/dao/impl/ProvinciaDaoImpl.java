package es.eurohelp.formacion.accesodatos.springjdbc.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import es.eurohelp.formacion.accesodatos.springjdbc.beans.Provincias;
import es.eurohelp.formacion.accesodatos.springjdbc.dao.ProvinciaDao;

public class ProvinciaDaoImpl extends JdbcDaoSupport implements ProvinciaDao{

	public Provincias getProvincia(int prov) {

		StringBuffer sql = new StringBuffer();

		sql
		.append(" SELECT provincia, descripcion, prefijo ")
		.append(" FROM ").append("provincias")
		.append(" WHERE provincia = ?");

		Object[] params = new Object[] { prov };

		Provincias it = (Provincias) getJdbcTemplate().queryForObject( sql.toString(), params, new ItemRowMapper());


		return it;

	}

	public void updateProvincia(Provincias prov) {

		StringBuffer sql = new StringBuffer();
		sql
		.append("UPDATE ").append("provincias")
		.append(" SET prefijo = ?,")
		.append(" descripcion = ?") // (linea añadida) Para poder hacer un update de "descripcion"
		.append(" WHERE provincia = ?");

		Object[] params = new Object[] {

				prov.getPrefijo(),
				prov.getDescripcion(), // (linea añadida) obtener "descripcion" de la provincia
				prov.getProvincia()
		};

		getJdbcTemplate().update(sql.toString(), params);

	}

	public void insertProvincia(Provincias prov) {
		StringBuffer sql = new StringBuffer();

		sql
		.append("INSERT INTO ").append("provincias")
		.append(" (provincia, descripcion, prefijo) ")
		.append("VALUES(?, ?, ?)");

		Object[] params = new Object[] {
				prov.getProvincia(),
				prov.getDescripcion(),
				prov.getPrefijo()
		};

		getJdbcTemplate().update(sql.toString(), params);

	}

	public void deleteProvincia(int prov) {
		StringBuffer sql = new StringBuffer();

		sql
		.append("DELETE FROM ").append("provincias")
		.append(" WHERE provincia = ? ");

		Object[] params = new Object[] {prov};

		getJdbcTemplate().update(sql.toString(), params);


	}

	class ItemRowMapper implements RowMapper<Object> {

		public Object mapRow(ResultSet rs, int index) throws SQLException {

			Provincias it = new Provincias();

			it.setProvincia(rs.getInt("provincia"));
			it.setDescripcion(rs.getString("descripcion"));
			it.setPrefijo(new Integer(rs.getInt("prefijo")));

			return it;
		}
	}
}
