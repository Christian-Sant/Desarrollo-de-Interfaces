package TCP;
import java.io.*;
import java.net.*;

public class EsqueletoServidor {
	private static final int PUERTO = 12345;
	public static void main(String[] args) {
		System.out.println("----Servidor Iniciado----");
		
		try(ServerSocket serverSocket = new ServerSocket(PUERTO)){
			while(true) {
				// 1. - Esperar Conexion
				System.out.println("Esperando al cliente...");
				Socket socketCliente = serverSocket.accept();
				// 2. - Atender petición del cliente
				System.out.println("Cliente conectado: " + socketCliente.getInetAddress());
				atenderCliente(socketCliente);
			}
		}
		catch(IOException e) {
			
		};
	}
	
	public static void atenderCliente(Socket socket) {
		try (BufferedReader entrada = new BufferedReader( new InputStreamReader(socket.getInputStream()));
			PrintWriter salida = new PrintWriter(socket.getOutputStream(),true)){
			salida.println("Bienvenido a nuestro servicio: Escribe SALIR para finalizar");
			boolean clienteConectado = true;
			String lineaRecibida;
			while(clienteConectado && (lineaRecibida = entrada.readLine()) != null) {
				System.out.println("Cliente dice: " + lineaRecibida);
				if(!lineaRecibida.equalsIgnoreCase("SALIR")) {
					salida.println("Tu mensaje es: " + lineaRecibida);
				}
				else {
					salida.println("Adios");
					clienteConectado = false;
				}
			}
		}
		catch(Exception e) {
			
		}
	}
}
