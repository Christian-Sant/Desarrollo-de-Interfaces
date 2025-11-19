package ThreadsSuperMercado;

public class Main {
    public static void main(String[] args) {
        
        Caja caja = new Caja(cajaRandom());

        int clientes = numeroCliente();
        Thread[] hilosTotal = new Thread[clientes];

        for (int i = 0; i < clientes; i++) {
            Cliente cliente = new Cliente(caja, pagoCliente());
            hilosTotal[i] = new Thread(cliente);
            hilosTotal[i].start();

            try {
                Thread.sleep(tiempo());
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        for (Thread hilos : hilosTotal) {
            try {
            	hilos.join();
            } catch (InterruptedException e) {}
        }

        System.out.println("\nTOTAL RECAUDADO: " + caja.getTotal());
    }

    public static int cajaRandom() {
        return (int)(Math.random() * 3) + 1;
    }
    public static int numeroCliente() {
        return (int)(Math.random() * 5) + 1; 
    }
    public static double pagoCliente() {
        return (Math.random() * 300) + 1; 
    }
    public static int tiempo() {
        return (int)(Math.random() * 2500) + 500;
    }
}
