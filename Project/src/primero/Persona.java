package primero;

import java.io.Serializable;

public class Persona implements Serializable {
	String nombre;
	int edad;

	Persona(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}
}