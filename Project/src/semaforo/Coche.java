package semaforo;

public class Coche extends Thread{
	private String matricula;
	private Semaforo semaforo;
	public Coche(String matricula, Semaforo semaforo) {
		super();
		this.matricula = matricula;
		this.semaforo = semaforo;
	}
	@Override
	public void run() {
		semaforo.esperarLuzVerde();
	}
}
