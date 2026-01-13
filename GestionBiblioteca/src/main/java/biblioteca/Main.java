package biblioteca;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final BibliotecaServicio servicio = new BibliotecaServicio();

    public static void main(String[] args) {

        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");

            try {
                switch (opcion) {
                    case 1:
                        registrarUsuario();
                        break;
                    case 2:
                        listarUsuarios();
                        break;
                    case 3:
                        registrarLibro();
                        break;
                    case 4:
                        listarLibros();
                        break;
                    case 5:
                        registrarPrestamo();
                        break;
                    case 6:
                        devolverLibro();
                        break;
                    case 7:
                        mostrarPrestamosActivos();
                        break;
                    case 8:
                        mostrarRankingLibros();
                        break;
                    case 0:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción inválida");
                        break;
                }
            } catch (RuntimeException e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (opcion != 0);
    }

    // ---------------- MENU ----------------

    private static void mostrarMenu() {
        System.out.println("\n=== SISTEMA DE GESTIÓN DE BIBLIOTECA ===");
        System.out.println("1. Registrar usuario");
        System.out.println("2. Listar usuarios");
        System.out.println("3. Registrar libro");
        System.out.println("4. Listar libros");
        System.out.println("5. Registrar préstamo");
        System.out.println("6. Devolver libro");
        System.out.println("7. Mostrar préstamos activos");
        System.out.println("8. Ranking de libros más prestados");
        System.out.println("0. Salir");
    }

    // ---------------- USUARIOS ----------------

    private static void registrarUsuario() {
        Biblioteca biblioteca = servicio.cargarBiblioteca();

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("DNI: ");
        String dni = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        for (Usuario u : biblioteca.getUsuarios()) {
            if (u.getDni().equals(dni)) {
                throw new RuntimeException("Ya existe un usuario con ese DNI");
            }
        }

        biblioteca.getUsuarios().add(new Usuario(nombre, dni, email));
        servicio.guardarBiblioteca(biblioteca);

        System.out.println("Usuario registrado correctamente");
    }

    private static void listarUsuarios() {
        Biblioteca biblioteca = servicio.cargarBiblioteca();

        if (biblioteca.getUsuarios().isEmpty()) {
            System.out.println("No hay usuarios registrados");
            return;
        }

        for (Usuario u : biblioteca.getUsuarios()) {
            System.out.println(u.getNombre() + " | DNI: " + u.getDni() + " | Email: " + u.getEmail());
        }
    }

    // ---------------- LIBROS ----------------

    private static void registrarLibro() {
        Biblioteca biblioteca = servicio.cargarBiblioteca();

        System.out.print("Título: ");
        String titulo = scanner.nextLine();

        System.out.print("Autor: ");
        String autor = scanner.nextLine();

        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();

        System.out.print("Género: ");
        String genero = scanner.nextLine();

        for (Libro l : biblioteca.getLibros()) {
            if (l.getIsbn().equals(isbn)) {
                throw new RuntimeException("Ya existe un libro con ese ISBN");
            }
        }

        biblioteca.getLibros().add(new Libro(titulo, autor, isbn, genero));
        servicio.guardarBiblioteca(biblioteca);

        System.out.println("Libro registrado correctamente");
    }

    private static void listarLibros() {
        Biblioteca biblioteca = servicio.cargarBiblioteca();

        if (biblioteca.getLibros().isEmpty()) {
            System.out.println("No hay libros registrados");
            return;
        }

        for (Libro l : biblioteca.getLibros()) {
            System.out.print(l.getTitulo() + " | ISBN: " + l.getIsbn());
            System.out.print(" | Autor: " + l.getAutor());
            System.out.print(" | Estado: ");
            if (l.isPrestado()) {
                System.out.println("Prestado");
            } else {
                System.out.println("Disponible");
            }
        }
    }

    // ---------------- PRÉSTAMOS ----------------

    private static void registrarPrestamo() {
        System.out.print("DNI del usuario: ");
        String dni = scanner.nextLine();

        System.out.print("ISBN del libro: ");
        String isbn = scanner.nextLine();

        servicio.registrarPrestamo(dni, isbn);
        System.out.println("Préstamo registrado correctamente");
    }

    private static void devolverLibro() {
        System.out.print("ISBN del libro a devolver: ");
        String isbn = scanner.nextLine();

        double multa = servicio.devolverLibro(isbn);

        if (multa > 0) {
            System.out.println("Libro devuelto con multa: €" + multa);
        } else {
            System.out.println("Libro devuelto sin multa");
        }
    }

    private static void mostrarPrestamosActivos() {
        List<Prestamo> prestamos = servicio.obtenerPrestamosActivos();

        if (prestamos.isEmpty()) {
            System.out.println("No hay préstamos activos");
            return;
        }

        for (Prestamo p : prestamos) {
            System.out.print("Usuario DNI: " + p.getDniUsuario());
            System.out.print(" | ISBN: " + p.getIsbnLibro());
            System.out.print(" | Inicio: " + p.getFechaInicio());
            System.out.println(" | Límite: " + p.getFechaLimite());
        }
    }

    private static void mostrarRankingLibros() {
        List<String> ranking = servicio.obtenerRankingLibros();

        if (ranking.isEmpty()) {
            System.out.println("No hay préstamos registrados");
            return;
        }

        for (String r : ranking) {
            System.out.println(r);
        }
    }

    // ---------------- UTILIDAD ----------------

    private static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        int valor = Integer.parseInt(scanner.nextLine());
        return valor;
    }
}
