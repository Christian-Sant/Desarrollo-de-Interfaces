package PHP;

public class Propietario {
	private int idPropietario;
	private String nombre;
	private int telefono;
	private String direccion;
	public Propietario(String nombre, int telefono, String direccion) {
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
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
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
}
