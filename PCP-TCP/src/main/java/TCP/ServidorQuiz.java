package TCP;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

public class ServidorQuiz {

    private static final int PUERTO = 9876;

    private static Map<String, String> preguntas = new HashMap<>();

    public static void main(String[] args) {

        cargarDiccionario("preguntas.txt");
        //Instanciamos DatagramSocket ya que es la base de la conexion entre servidor y cliente en UDP, u usamos while true para que el servidor siempre este activo
        try (DatagramSocket socket = new DatagramSocket(PUERTO)) {

            System.out.println("ServidorQuiz escuchando en el puerto " + PUERTO);
            
            while (true) {
            	//Instanciamos byte ya que los mensajes que se envian, se envian solamente en bytes
                byte[] bufferEntrada = new byte[1024];
                //Instanciamos DatagramPacket, ya que se encarga de todo el tema de enviar los mensajes y recibirlas.
                DatagramPacket paqueteEntrada = new DatagramPacket(bufferEntrada, bufferEntrada.length);
                //usamos uno del os metodos de DatagramSocket y con la ayuda de DatagramPacket, podemos conseguir el mensaje
                socket.receive(paqueteEntrada);

                String respuesta = new String(paqueteEntrada.getData(),0,paqueteEntrada.getLength()).trim().toLowerCase();
                //Instanciamos InetAddres para conseguir el Ip del cliente, y nos ayuda con un metodo de DatagramPacket
                InetAddress ipCliente = paqueteEntrada.getAddress();

                int puertoCliente = paqueteEntrada.getPort();

                System.out.println("Petición de " + ipCliente.getHostAddress() + ":" + puertoCliente + " -> " + respuesta);

                String enviarARespuesta = preguntas.getOrDefault(respuesta, "Equivocado");

                byte[] bufferSalida = enviarARespuesta.getBytes();

                
                DatagramPacket paqueteSalida = new DatagramPacket( bufferSalida, bufferSalida.length, ipCliente, puertoCliente);
                //Y ahora usamos de nuevo el DatagramSocket y usamos su metodo send para enviar la respuesta hacia el cliente y el contenido es un DatagramPacket
                socket.send(paqueteSalida);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    
    private static void cargarDiccionario(String rutaArchivo) {

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {

            String linea;

            while ((linea = br.readLine()) != null) {

                if (linea.trim().isEmpty()) continue;

                String[] partes = linea.split("=");

                if (partes.length == 2) {
                    String clave = partes[0].trim().toLowerCase();
                    String valor = partes[1].trim().toLowerCase();
                    preguntas.put(clave, valor);
                }
            }

            System.out.println("Preguntas cargadas correctamente.");

        } catch (IOException e) {
            System.out.println("Error al leer el archivo de las preguntas.");
            e.printStackTrace();
        }
    }
}
