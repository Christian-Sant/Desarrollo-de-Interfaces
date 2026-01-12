package trafico;

public class Persona extends Thread {

    private String nombre;
    private Semaforo semaforo;

    public Persona(String nombre, Semaforo semaforo) {
        this.nombre = nombre;
        this.semaforo = semaforo;
    }

    @Override
    public void run() {
        try {
            Thread.sleep((long)(Math.random()*3000)); // Llega en un tiempo aleatorio
        } catch (InterruptedException e) {}

        semaforo.pulsarBoton(nombre);
        semaforo.cruzarPeaton(nombre);
    }
}
