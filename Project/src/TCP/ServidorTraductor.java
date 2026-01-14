package TCP;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.HashMap;
import java.util.Map;

public class ServidorTraductor {

    private static final int PUERTO = 9876;
    private static Map<String, String> diccionario = new HashMap<>();

    public static void main(String[] args) {

    	diccionario.put("house", "casa");
    	diccionario.put("car", "coche");
    	diccionario.put("water", "agua");
    	diccionario.put("book", "libro");
    	diccionario.put("computer", "ordenador");
    	diccionario.put("phone", "teléfono");
    	diccionario.put("sun", "sol");
    	diccionario.put("moon", "luna");
    	diccionario.put("tree", "árbol");
    	diccionario.put("friend", "amigo");
    	diccionario.put("family", "familia");
    	diccionario.put("school", "escuela");
    	diccionario.put("teacher", "profesor");
    	diccionario.put("student", "estudiante");
    	diccionario.put("city", "ciudad");
    	diccionario.put("country", "país");
    	diccionario.put("music", "música");
    	diccionario.put("movie", "película");
    	diccionario.put("love", "amor");
    	diccionario.put("work", "trabajo");


        try(DatagramSocket socket = new DatagramSocket(PUERTO)) {
        	
            System.out.println("ServidorTraductor escuchando en el puerto " + PUERTO);
            
            while (true) {
                byte[] bufferEntrada = new byte[1024];
                DatagramPacket paqueteEntrada = new DatagramPacket(bufferEntrada, bufferEntrada.length);

                socket.receive(paqueteEntrada);

                String palabra = new String(paqueteEntrada.getData(),0,paqueteEntrada.getLength()).trim().toLowerCase();

                String ipCliente = paqueteEntrada.getAddress().getHostAddress();
                int puertoCliente = paqueteEntrada.getPort();

                System.out.println("Petición de " + ipCliente + ":" + puertoCliente +" -> " + palabra);

                String respuesta = diccionario.getOrDefault(palabra, "SIN_DATOS");

                byte[] bufferSalida = respuesta.getBytes();

                DatagramPacket paqueteSalida =new DatagramPacket(bufferSalida,bufferSalida.length,paqueteEntrada.getAddress(),puertoCliente);

                socket.send(paqueteSalida);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

