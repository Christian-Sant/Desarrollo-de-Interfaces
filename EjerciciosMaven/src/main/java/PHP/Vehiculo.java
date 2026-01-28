package PHP;

public class Vehiculo {
	private int idVehiculo;
	private int idPropietario;
	private String matricula;
	private String marca;
	private String modelo;
	private int anio;
	public Vehiculo(String matricula, String marca, String modelo, int anio) {
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.anio = anio;
	}
	public Vehiculo() {
	}
	public int getIdVehiculo() {
		return idVehiculo;
	}
	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}
	public int getIdPropietario() {
		return idPropietario;
	}
	public void setIdPropietario(int idPropietario) {
		this.idPropietario = idPropietario;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
}
