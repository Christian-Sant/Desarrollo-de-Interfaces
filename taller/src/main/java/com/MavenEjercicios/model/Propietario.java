package com.MavenEjercicios.model;

public class Propietario {
	private int idPropietario;
	private String nombre;
	private String telefono;
	private String direccion;
	public Propietario(String nombre, String telefono, String direccion) {
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
	}
	public Propietario() {
		
	}
	public int getIdPropietario() {
		return idPropietario;
	}
	public void setIdPropietario(int idPropietario) {
		this.idPropietario = idPropietario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
}
