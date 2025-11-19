package ThreadsSuperMercado;

public class Caja {
    private double total = 0;
    private int numeroCaja;

    public Caja(int numeroCaja) {
        this.numeroCaja = numeroCaja;
    }

    public synchronized void pagar(double totalAPagar) {
    	setTotal(getTotal() + totalAPagar);
    }

    public int getNumeroCaja() {
        return numeroCaja;
    }

    public double getTotal() {
        return total;
    }

	public void setTotal(double total) {
		this.total = total;
	}
}
