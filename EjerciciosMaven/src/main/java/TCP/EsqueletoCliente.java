package TCP;
import java.net.*;
import java.io.*;
public class EsqueletoCliente {
	private static final int PUERTO = 12345;
	private static final String HOST = "localhost";
	public static void main(String[] args) {
		try(Socket socket = new Socket(HOST,PUERTO);
		    BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		    PrintWriter salida = new PrintWriter(socket.getOutputStream(),true);
			BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in))){
			System.out.println("SERVIDOR>> " + entrada.readLine());
			boolean continuar = true;
			String mensajes;
			while(continuar) {
				System.out.println("El mensaje: ");
				mensajes = teclado.readLine();
				salida.println(mensajes);
				if(mensajes.equalsIgnoreCase("SALIR")) {
					continuar = false;
				}
				String respuesta = entrada.readLine();
				System.out.println("Respuesta del servidor: " + respuesta);
				
			}
		}
		catch (Exception e) {
			
		}
	}

}
