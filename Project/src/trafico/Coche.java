package trafico;

public class Coche extends Thread {
    private String matricula;
    private Semaforo semaforo;

    public Coche(String matricula, Semaforo semaforo) {
        this.matricula = matricula;
        this.semaforo = semaforo;
    }

    @Override
    public void run() {
        while (true) {
            semaforo.esperarCoche(matricula);

            try {
                Thread.sleep(1000); // tiempo entre coches
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
