package TeatroTaquilla;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor {

    private static final int PUERTO = 12345;
    private static ArrayList<Butacas> butacas = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("----Servidor Iniciado----");

       
        crearButacas();

        try (ServerSocket serverSocket = new ServerSocket(PUERTO)) {
            while (true) {
                
                System.out.println("Esperando al cliente...");
                Socket socketCliente = serverSocket.accept();
                
                System.out.println("Cliente conectado: " + socketCliente.getInetAddress());
                atenderCliente(socketCliente);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   
    private static void crearButacas() {
        char fila;
        for (fila = 'A'; fila <= 'T'; fila++) {
            for (int i = 1; i <= 9; i++) {
                String nombreButaca = "" + fila + i;
                Butacas butaca = new Butacas(nombreButaca, false); 
                butacas.add(butaca);
            }
        }
    }

  
    private static String mostrarButacas() {
        StringBuilder resultado = new StringBuilder();

        for (char fila = 'A'; fila <= 'T'; fila++) {
            StringBuilder filaButacas = new StringBuilder();
            for (int i = 1; i <= 9; i++) {
                String nombreButaca = "" + fila + i;
                Butacas butaca = obtenerButaca(nombreButaca);
                if (butaca != null && butaca.isOcupado()) {
                    filaButacas.append("XX | ");
                } else {
                    filaButacas.append(nombreButaca + " | ");
                }
            }
           
            filaButacas.setLength(filaButacas.length() - 3);
            resultado.append(filaButacas.toString()).append("\n");
        }
        return resultado.toString();
    }


    private static Butacas obtenerButaca(String nombreButaca) {
        for (Butacas butaca : butacas) {
            if (butaca.getButaca().equalsIgnoreCase(nombreButaca)) {
                return butaca;
            }
        }
        return null;
    }

    public static void atenderCliente(Socket socket) {
        try (BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter salida = new PrintWriter(socket.getOutputStream(), true)) {

            salida.println("Bienvenido a nuestro servicio: Escribe SALIR para finalizar");

            
            String butacasDisponibles = mostrarButacas();
            salida.println("Estas son las butacas disponibles:\n" + butacasDisponibles);

            boolean clienteConectado = true;
            String lineaRecibida;
            while (clienteConectado && (lineaRecibida = entrada.readLine()) != null) {
                System.out.println("Cliente dice: " + lineaRecibida);
                if (!lineaRecibida.equalsIgnoreCase("SALIR")) {
                 
                    boolean encontrado = false;
                    for (Butacas butaca : butacas) {
                        if (butaca.getButaca().equalsIgnoreCase(lineaRecibida) && !butaca.isOcupado()) {
                            butaca.setOcupado(true);
                            salida.println("Butaca " + lineaRecibida + " reservada con éxito.");

                            
                            salida.println("Estas son las butacas actualizadas:\n" + mostrarButacas());
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        salida.println("La butaca " + lineaRecibida + " no está disponible o no existe.");
                    }
                } else {
                    salida.println("Adios");
                    clienteConectado = false;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}