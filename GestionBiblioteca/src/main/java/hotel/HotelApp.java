package hotel;

import java.time.LocalDate;
import java.util.Scanner;

public class HotelApp {

    private static HotelData data;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        data = JsonManager.cargar();
        menu();
    }

    private static void menu() {
        int opcion;

        do {
            System.out.println("\n=== HOTEL ===");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Listar clientes");
            System.out.println("3. Registrar habitación");
            System.out.println("4. Listar habitaciones");
            System.out.println("5. Crear reserva");
            System.out.println("6. Listar reservas activas");
            System.out.println("7. Finalizar reserva");
            System.out.println("8. Reporte de ingresos");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1:
                    registrarCliente();
                    JsonManager.guardar(data);
                    break;

                case 2:
                    listarClientes();
                    break;

                case 3:
                    registrarHabitacion();
                    JsonManager.guardar(data);
                    break;

                case 4:
                    listarHabitaciones();
                    break;

                case 5:
                    crearReserva();
                    JsonManager.guardar(data);
                    break;

                case 6:
                    listarReservasActivas();
                    break;

                case 7:
                    finalizarReserva();
                    JsonManager.guardar(data);
                    break;

                case 8:
                    reporteIngresos();
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);
    }

    private static void registrarCliente() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Documento: ");
        String doc = sc.nextLine();
        System.out.print("Teléfono: ");
        String tel = sc.nextLine();

        data.clientes.add(new Cliente(nombre, doc, tel));
        System.out.println("Cliente registrado correctamente.");
    }

    private static void listarClientes() {
        if (data.clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }

        for (Cliente c : data.clientes) {
            System.out.println(c);
        }
    }

    private static void registrarHabitacion() {
        System.out.print("Número: ");
        int num = Integer.parseInt(sc.nextLine());
        System.out.print("Tipo: ");
        String tipo = sc.nextLine();
        System.out.print("Precio por noche: ");
        double precio = Double.parseDouble(sc.nextLine());

        data.habitaciones.add(new Habitacion(num, tipo, precio));
        System.out.println("Habitación registrada correctamente.");
    }

    private static void listarHabitaciones() {
        if (data.habitaciones.isEmpty()) {
            System.out.println("No hay habitaciones registradas.");
            return;
        }

        for (Habitacion h : data.habitaciones) {
            System.out.println(h);
        }
    }

    private static void crearReserva() {
        System.out.print("Documento del cliente: ");
        String doc = sc.nextLine();
        Cliente cliente = null;

        for (Cliente c : data.clientes) {
            if (c.getDocumento().equals(doc)) {
                cliente = c;
                break;
            }
        }

        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        System.out.print("Número de habitación: ");
        int num = Integer.parseInt(sc.nextLine());
        Habitacion habitacion = null;

        for (Habitacion h : data.habitaciones) {
            if (h.getNumero() == num && h.isDisponible()) {
                habitacion = h;
                break;
            }
        }

        if (habitacion == null) {
            System.out.println("Habitación no disponible.");
            return;
        }

        System.out.print("Fecha entrada (YYYY-MM-DD): ");
        LocalDate entrada = LocalDate.parse(sc.nextLine());
        System.out.print("Fecha salida (YYYY-MM-DD): ");
        LocalDate salida = LocalDate.parse(sc.nextLine());

        habitacion.setDisponible(false);
        Reserva reserva = new Reserva(cliente, habitacion, entrada, salida);
        data.reservas.add(reserva);

        System.out.println("Reserva creada correctamente.");
        System.out.println("Costo total: " + reserva.getCostoTotal());
    }

    private static void listarReservasActivas() {
        boolean hay = false;

        for (Reserva r : data.reservas) {
            if (r.isActiva()) {
                System.out.println(r);
                hay = true;
            }
        }

        if (!hay) {
            System.out.println("No hay reservas activas.");
        }
    }

    private static void finalizarReserva() {
        System.out.print("Número de habitación: ");
        int num = Integer.parseInt(sc.nextLine());
        boolean encontrada = false;

        for (Reserva r : data.reservas) {
            if (r.isActiva() && r.getHabitacion().getNumero() == num) {
                r.finalizar();
                encontrada = true;
                System.out.println("Reserva finalizada correctamente.");
                break;
            }
        }

        if (!encontrada) {
            System.out.println("No se encontró una reserva activa para esa habitación.");
        }
    }

    private static void reporteIngresos() {
        double total = 0;

        for (Reserva r : data.reservas) {
            if (!r.isActiva()) {
                total += r.getCostoTotal();
            }
        }

        System.out.println("Ingresos totales: " + total);
        System.out.println("Habitaciones ocupadas:");

        boolean hay = false;
        for (Reserva r : data.reservas) {
            if (r.isActiva()) {
                System.out.println(r);
                hay = true;
            }
        }

        if (!hay) {
            System.out.println("No hay habitaciones ocupadas.");
        }
    }
}
