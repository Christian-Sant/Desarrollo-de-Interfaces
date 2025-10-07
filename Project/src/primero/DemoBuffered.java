package primero;
import java.io.*;
public class DemoBuffered {
public static void main(String[] args) throws IOException {

	BufferedWriter escribir = new BufferedWriter(new FileWriter("C:\\Users\\Tarde\\Downloads\\texto.txt"));
	escribir.write("Hola buenos dias\nVamos a hablar sobre eclipse");
	escribir.close();
	BufferedReader leer = new BufferedReader(new FileReader("C:\\Users\\Tarde\\Downloads\\texto.txt"));
	String linea;
	while ((linea = leer.readLine()) != null) {
	System.out.println(linea);
	}
	leer.close();
	}
}