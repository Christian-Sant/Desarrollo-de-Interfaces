package semaforo;

public class Curce {
	public static void main(String[] args) {
		Semaforo semaforo = new Semaforo();
		Coche coche1 = new Coche("1",semaforo);
		Coche coche2 = new Coche("2",semaforo);
		Coche coche3 = new Coche("3",semaforo);
		semaforo.CambiarLuzVerde();
		coche1.start();
		coche2.start();
	}
}
