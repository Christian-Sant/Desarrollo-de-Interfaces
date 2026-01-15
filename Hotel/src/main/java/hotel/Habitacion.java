package hotel;

public class Habitacion {
    private int numero;
    private String tipo; // Simple, Doble, Suite
    private double precioPorNoche;
    private boolean disponible;

    public Habitacion(int numero, String tipo, double precioPorNoche) {
        this.numero = numero;
        this.tipo = tipo;
        this.precioPorNoche = precioPorNoche;
        this.disponible = true;
    }

    public int getNumero() {
        return numero;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean estado) {
        this.disponible = estado;
    }

    @Override
    public String toString() {
        return "Habitación{" +
                "Número=" + numero +
                ", Tipo='" + tipo + '\'' +
                ", Precio=" + precioPorNoche +
                ", Estado=" + (disponible ? "Disponible" : "Ocupada") +
                '}';
    }
}
