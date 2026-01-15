package hotel;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reserva {
    private Cliente cliente;
    private Habitacion habitacion;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private double costoTotal;
    private boolean activa;

    public Reserva(Cliente cliente, Habitacion habitacion,
                   LocalDate entrada, LocalDate salida) {
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.fechaEntrada = entrada;
        this.fechaSalida = salida;
        long noches = ChronoUnit.DAYS.between(entrada, salida);
        this.costoTotal = noches * habitacion.getPrecioPorNoche();
        this.activa = true;
    }

    public boolean isActiva() {
        return activa;
    }

    public void finalizar() {
        this.activa = false;
        habitacion.setDisponible(true);
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "Cliente=" + cliente.getNombre() +
                ", Habitación=" + habitacion.getNumero() +
                ", Entrada=" + fechaEntrada +
                ", Salida=" + fechaSalida +
                ", Costo=" + costoTotal +
                ", Estado=" + (activa ? "Activa" : "Finalizada") +
                '}';
    }
}
