package biblioteca;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class BibliotecaServicio {

    private static final String ARCHIVO = "biblioteca.json";
    private static final int DIAS_PRESTAMO = 14;
    private static final double TARIFA_MULTA = 1.5;

    private ObjectMapper mapper;

    public BibliotecaServicio() {
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    // ---------------- PERSISTENCIA ----------------

    public Biblioteca cargarBiblioteca() {
        try {
            File archivo = new File(ARCHIVO);

            if (!archivo.exists()) {
                Biblioteca biblioteca = new Biblioteca();
                guardarBiblioteca(biblioteca);
                return biblioteca;
            }

            return mapper.readValue(archivo, Biblioteca.class);

        } catch (IOException e) {
            throw new RuntimeException("Error al leer el archivo biblioteca.json");
        }
    }

    public void guardarBiblioteca(Biblioteca biblioteca) {
        try {
            mapper.writerWithDefaultPrettyPrinter()
                  .writeValue(new File(ARCHIVO), biblioteca);

        } catch (IOException e) {
            throw new RuntimeException("Error al guardar el archivo biblioteca.json");
        }
    }

    // ---------------- PRESTAMOS ----------------

    public void registrarPrestamo(String dniUsuario, String isbnLibro) {
        Biblioteca biblioteca = cargarBiblioteca();

        Libro libro = null;
        for (Libro l : biblioteca.getLibros()) {
            if (l.getIsbn().equals(isbnLibro)) {
                libro = l;
                break;
            }
        }

        if (libro == null) {
            throw new RuntimeException("Libro no encontrado");
        }

        if (libro.isPrestado()) {
            throw new RuntimeException("El libro ya está prestado");
        }

        for (Prestamo p : biblioteca.getPrestamos()) {
            if (p.getDniUsuario().equals(dniUsuario)
                    && p.getIsbnLibro().equals(isbnLibro)
                    && p.estaActivo()) {
                throw new RuntimeException("El usuario ya tiene este libro en préstamo");
            }
        }

        LocalDate fechaInicio = LocalDate.now();
        LocalDate fechaLimite = fechaInicio.plusDays(DIAS_PRESTAMO);

        Prestamo prestamo = new Prestamo(
                dniUsuario,
                isbnLibro,
                fechaInicio,
                fechaLimite
        );

        libro.setPrestado(true);
        biblioteca.getPrestamos().add(prestamo);

        guardarBiblioteca(biblioteca);
    }

    public double devolverLibro(String isbnLibro) {
        Biblioteca biblioteca = cargarBiblioteca();

        Prestamo prestamo = null;
        for (Prestamo p : biblioteca.getPrestamos()) {
            if (p.getIsbnLibro().equals(isbnLibro) && p.estaActivo()) {
                prestamo = p;
                break;
            }
        }

        if (prestamo == null) {
            throw new RuntimeException("Préstamo no encontrado");
        }

        prestamo.setFechaDevolucion(LocalDate.now());
        prestamo.calcularMulta(TARIFA_MULTA);

        for (Libro l : biblioteca.getLibros()) {
            if (l.getIsbn().equals(isbnLibro)) {
                l.setPrestado(false);
                break;
            }
        }

        guardarBiblioteca(biblioteca);
        return prestamo.getMulta();
    }

    // ---------------- CONSULTAS ----------------

    public List<Prestamo> obtenerPrestamosActivos() {
        Biblioteca biblioteca = cargarBiblioteca();
        List<Prestamo> activos = new ArrayList<>();

        for (Prestamo p : biblioteca.getPrestamos()) {
            if (p.estaActivo()) {
                activos.add(p);
            }
        }

        return activos;
    }

    public List<String> obtenerRankingLibros() {
        Biblioteca biblioteca = cargarBiblioteca();
        Map<String, Integer> contador = new HashMap<>();

        for (Prestamo p : biblioteca.getPrestamos()) {
            String isbn = p.getIsbnLibro();

            if (contador.containsKey(isbn)) {
                contador.put(isbn, contador.get(isbn) + 1);
            } else {
                contador.put(isbn, 1);
            }
        }

        List<String> ranking = new ArrayList<>();

        for (String isbn : contador.keySet()) {
            ranking.add(isbn + " → " + contador.get(isbn) + " préstamos");
        }

        return ranking;
    }
}
