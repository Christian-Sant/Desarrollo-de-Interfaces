package biblioteca;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Prestamo {

    private String dniUsuario;
    private String isbnLibro;
    private LocalDate fechaInicio;
    private LocalDate fechaLimite;
    private LocalDate fechaDevolucion;
    private double multa;

    public Prestamo() {
    }

    public Prestamo(String dniUsuario, String isbnLibro, LocalDate fechaInicio, LocalDate fechaLimite) {
        this.dniUsuario = dniUsuario;
        this.isbnLibro = isbnLibro;
        this.fechaInicio = fechaInicio;
        this.fechaLimite = fechaLimite;
    }

    public boolean estaActivo() {
        return fechaDevolucion == null;
    }

    public void calcularMulta(double tarifaDiaria) {
        if (fechaDevolucion != null && fechaDevolucion.isAfter(fechaLimite)) {
            long diasRetraso = ChronoUnit.DAYS.between(fechaLimite, fechaDevolucion);
            multa = diasRetraso * tarifaDiaria;
        } else {
            multa = 0;
        }
    }

    public String getDniUsuario() {
        return dniUsuario;
    }

    public void setDniUsuario(String dniUsuario) {
        this.dniUsuario = dniUsuario;
    }

    public String getIsbnLibro() {
        return isbnLibro;
    }

    public void setIsbnLibro(String isbnLibro) {
        this.isbnLibro = isbnLibro;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(LocalDate fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public double getMulta() {
        return multa;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }
}
