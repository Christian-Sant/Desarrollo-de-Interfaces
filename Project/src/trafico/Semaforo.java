package trafico;

public class Semaforo {

    private boolean verdeCoches = true;
    private boolean peatonalVerde = false;

    private boolean hayPeatonesEsperando = false;
    private boolean cicloActivo = false;

    // Botón pulsado
    public synchronized void pulsarBoton(String nombre) {
        System.out.println(nombre + " ha pulsado el botón");
        hayPeatonesEsperando = true;

        if (!cicloActivo) {
            iniciarCicloPeatonal();
        }
    }

    private void iniciarCicloPeatonal() {
        cicloActivo = true;

        // Lanzamos el ciclo en un hilo
        new Thread(() -> {
            try {
                synchronized (this) {
                    // coches pasan a rojo
                    verdeCoches = false;
                    System.out.println("Semáforo coches → ROJO");
                    notifyAll(); // avisamos a coches y peatones
                }

                // tiempo antes de dar verde a peatones
                Thread.sleep(500);

                synchronized (this) {
                    peatonalVerde = true;
                    System.out.println("PEATONES → VERDE (cruzar 3s)");
                    notifyAll();
                }

                Thread.sleep(3000);

                synchronized (this) {
                    peatonalVerde = false;
                    verdeCoches = true;
                    hayPeatonesEsperando = false;
                    cicloActivo = false;

                    System.out.println("Ciclo finalizado → Coches VERDE, Peatones ROJO");
                    notifyAll();
                }

            } catch (InterruptedException e) {}
        }).start();
    }

    // Coches
    public synchronized void esperarCoche(String matricula) {
        while (!verdeCoches) {
            try {
                System.out.println("Coche " + matricula + " espera en ROJO");
                wait();
            } catch (InterruptedException e) {}
        }
        System.out.println("Coche " + matricula + " pasa");
    }

    // Peatones
    public synchronized void cruzarPeaton(String nombre) {
        while (!peatonalVerde) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }

        System.out.println("Peatón " + nombre + " está cruzando…");
    }
}
