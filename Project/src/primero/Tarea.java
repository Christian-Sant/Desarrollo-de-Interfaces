package primero;

import java.util.ArrayList;

public class Tarea {
	private String nombre;
	private String prioridad;
	private boolean estado;
	private boolean seleccionada;
	public Tarea(String nombre, String prioridad) {
		this.nombre = nombre;
		this.prioridad = prioridad;
		this.estado = false;
		this.seleccionada = false;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getestadoCompletadaPendiente() {
		return nombre;
	}

	public String getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	public boolean isSeleccionada() {
		return seleccionada;
	}

	public void setSeleccionada(boolean seleccionada) {
		this.seleccionada = seleccionada;
	}

	public String toString() {
		return "Nombre: " + getNombre() + " Prioridad: " + getPrioridad();
	}
	
}
