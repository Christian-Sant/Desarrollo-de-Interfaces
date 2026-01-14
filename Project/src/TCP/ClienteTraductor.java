package TCP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ClienteTraductor {

    private static final int PUERTO_SERVIDOR = 9876;

    public static void main(String[] args) {

        try(DatagramSocket socket = new DatagramSocket();
            Scanner scanner = new Scanner(System.in)) {
            InetAddress direccionServidor = InetAddress.getByName("localhost");
            while(true){
                System.out.print("Introduce una palabra en inglés (salir para terminar): ");
                String palabra = scanner.nextLine();

                if (palabra.equalsIgnoreCase("salir")) {
                    System.out.println("Saliendo del programa.");
                    break;
                }
                byte[] bufferSalida = palabra.getBytes();
                DatagramPacket paqueteSalida = new DatagramPacket( bufferSalida, bufferSalida.length, direccionServidor, PUERTO_SERVIDOR);
                
                socket.send(paqueteSalida);

                byte[] bufferEntrada = new byte[1024];
                DatagramPacket paqueteEntrada = new DatagramPacket(bufferEntrada, bufferEntrada.length);
                
                socket.receive(paqueteEntrada);

                String respuesta = new String( paqueteEntrada.getData(), 0, paqueteEntrada.getLength());
                System.out.println("Traducción en inglés: " + respuesta);
            }
        } 
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
