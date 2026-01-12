package semaforo;

public class Curce {
	public static void main(String[] args) {
		Semaforo semaforo = new Semaforo();
		Coche coche1 = new Coche("1",semaforo);
		Coche coche2 = new Coche("2",semaforo);
		Coche coche3 = new Coche("3",semaforo);
		coche1.start();
		coche2.start();
		coche3.start();
		try {
			Thread.sleep(2000);
			semaforo.CambiarLuzVerde();
			Thread.sleep(2000);
			semaforo.CambiarLuzVerde();
			Thread.sleep(2000);
			semaforo.CambiarLuzVerde();
			coche1.join();
			coche2.join();
			coche3.join();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
