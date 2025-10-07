package primero;
import java.io.*;

public class DemoBinario {
	public static void main(String[] args) throws IOException {
		FileOutputStream caracterEscribir = new FileOutputStream("C:\\Users\\Tarde\\Downloads\\datos.bin");
		caracterEscribir.write(72);
		caracterEscribir.write(111); 
		caracterEscribir.write(108); 
		caracterEscribir.write(97); 	
		caracterEscribir.close();
		FileInputStream caracterLeer = new FileInputStream("C:\\Users\\Tarde\\Downloads\\datos.bin");
		int byt;
		while ((byt = caracterLeer.read()) != -1) {
		System.out.println("Contenido: " + byt + " -> " + (char) byt);
		}
		caracterLeer.close();
	}
}
