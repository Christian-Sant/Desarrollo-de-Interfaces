package semaforo;

public class Semaforo {
	private boolean verde = false;//Con esto suponemos que el semaforo esta en rojo(osea cerrado)
	
	public synchronized void esperarLuzVerde() {//Este metodo espera que el estado sea verde, osea que verde == true
		while(!verde) {
			System.out.println(Thread.currentThread().getName()+" esta esperando que sea verde");
			try {
				wait();//El coche se para y espera hasta que el semaforo se ponga verde(true).
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//Despues de pasar el coche, se pasa a rojo(false)
		verde = false;
		System.out.println("El semaforo es verde y el coche ha pasado, ahora el semaforo volvera a rojo.");
	}
	
	public synchronized void CambiarLuzVerde() {//Este metodo sirve para cambiar el estadoa verde, osea que verde == true
		verde = true;
		System.out.println("El semaforo pasa a verde");
		notify();
	}
}
