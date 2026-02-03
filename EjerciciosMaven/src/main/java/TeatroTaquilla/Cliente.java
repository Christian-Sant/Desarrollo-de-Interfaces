package TeatroTaquilla;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {

    private static final String HOST = "localhost";
    private static final int PUERTO = 12345;

    public static void main(String[] args) {

        try (
            Socket socket = new Socket(HOST, PUERTO);
            BufferedReader entrada = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter salida = new PrintWriter(
                    socket.getOutputStream(), true);
            BufferedReader teclado = new BufferedReader(
                    new InputStreamReader(System.in))
        ) {

            System.out.println("SERVIDOR >> " + entrada.readLine()); 
            System.out.println("SERVIDOR >> " + entrada.readLine()); 
            
            String lineaMapa;
            while ((lineaMapa = entrada.readLine()) != null && !lineaMapa.isEmpty()) {
                System.out.println(lineaMapa);
            }

            String mensaje;
            boolean continuar = true;

            while (continuar) {
                System.out.print("\nCliente (Escribe Butaca o SALIR) > ");
                mensaje = teclado.readLine();

                salida.println(mensaje);

                if (mensaje.equalsIgnoreCase("SALIR")) {
                    System.out.println("SERVIDOR >> " + entrada.readLine());
                    continuar = false;
                } else {
                    String respuestaReserva = entrada.readLine();
                    System.out.println("SERVIDOR >> " + respuestaReserva);

                    
                    if (respuestaReserva.contains("con éxito")) {
                        String encabezado = entrada.readLine();
                        if (encabezado != null) {
                            System.out.println("SERVIDOR >> " + encabezado);
                            
                            String fila;
                            while ((fila = entrada.readLine()) != null && !fila.isEmpty()) {
                                System.out.println(fila);
                            }
                        }
                    }
                   
                }
            }

        } catch (Exception e) {
            System.err.println("Error en el cliente: " + e.getMessage());
        }
    }
}