package primero;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DemoFileReaderWriter {
	public static void main(String[] args) throws IOException {
		FileWriter escribir = new FileWriter("C:\\Users\\Tarde\\Downloads\\texto.txt");
		escribir.write("Hola que tal");
		escribir.close();
		FileReader leer = new FileReader("C:\\Users\\Tarde\\Downloads\\texto.txt");
		int caracter;
		while ((caracter = leer.read()) != -1) {
		System.out.print(caracter);
		}
		leer.close();
	}
}
