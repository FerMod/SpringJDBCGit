package es.eurohelp.formacion.accesodatos.springjdbc.beans;

import java.io.Serializable;

public class Proveedores implements Serializable {

	private static final long serialVersionUID = 1L;
	private int proveedor;
	private String empresa;
	private String apellidos;
	private String nombre;
	private String direccion1;
	private String direccion2;
	private String poblacion;
	private int provincia;
	private int distrito;
	private String telefono;
	
	public int getProveedor() {
		return proveedor;
	}
	
	public void setProveedor(int proveedor) {
		this.proveedor = proveedor;
	}
	
	public String getEmpresa() {
		return empresa;
	}
	
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	
	public String getApellidos() {
		return apellidos;
	}
	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDireccion1() {
		return direccion1;
	}
	
	public void setDireccion1(String direccion1) {
		this.direccion1 = direccion1;
	}
	
	public String getDireccion2() {
		return direccion2;
	}
	
	public void setDireccion2(String direccion2) {
		this.direccion2 = direccion2;
	}
	
	public String getPoblacion() {
		return poblacion;
	}
	
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}
	
	public int getProvincia() {
		return provincia;
	}
	
	public void setProvincia(int provincia) {
		this.provincia = provincia;
	}
	
	public int getDistrito() {
		return distrito;
	}
	
	public void setDistrito(int distrito) {
		this.distrito = distrito;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
