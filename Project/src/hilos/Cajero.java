package hilos;

public class Cajero extends Thread {
	private int atendido;
	public Cajero(int atendido) {
		this.atendido = atendido;
	}
	public int getAtendido() {
		return atendido;
	}
	public void setAtendido(int atendido) {
		this.atendido = atendido;
	}
	
	@Override
	public void run() {
		System.out.println("El Cajero ha atendido a " + getAtendido() + " clientes");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}
	
}
