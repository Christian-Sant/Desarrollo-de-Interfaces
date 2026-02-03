package TeatroTaquilla;

public class Butacas {
	private String butaca;
	private boolean ocupado;
	public Butacas(String butaca, boolean ocupado) {
		this.butaca = butaca;
		this.ocupado = ocupado;
	}
	public boolean isOcupado() {
		return ocupado;
	}
	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}
	public String getButaca() {
		return butaca;
	}
	public void setButaca(String butaca) {
		this.butaca = butaca;
	}
	
}