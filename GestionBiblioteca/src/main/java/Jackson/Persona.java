package Jackson;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Persona {
	
	@JsonProperty ("nombre_completo")
	private String nombre;
	
	private int edad;
	
	@JsonIgnore
	private String email;
	
	public Persona() {}
	
	public Persona(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
	}

	public Persona(String nombre, int edad, String email) {
		this.nombre= nombre;
		this.edad=edad;
		this.email= email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + ", email=" + email + "]";
	}
	
}