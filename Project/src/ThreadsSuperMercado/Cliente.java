package ThreadsSuperMercado;

public class Cliente implements Runnable {
    private Caja caja;
    private double cuantoPaga;

    public Cliente(Caja caja, double cuantoPaga) {
        this.caja = caja;
        this.cuantoPaga = cuantoPaga;
    }

    @Override
    public void run() {
        caja.pagar(cuantoPaga);
        System.out.println("Cliente pagó " + cuantoPaga + " en la caja " + caja.getNumeroCaja());
    }

    public double getCuantoPaga() {
        return cuantoPaga;
    }
}
