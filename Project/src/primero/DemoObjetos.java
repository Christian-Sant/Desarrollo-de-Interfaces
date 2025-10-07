package primero;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.List;

public class DemoObjetos {

	public static void main(String[] args) throws IOException,
		ClassNotFoundException {
		List<Persona> lista = Arrays.asList(new Persona("Ana", 20),new Persona("Luis", 22));
	
		ObjectOutputStream oos = new ObjectOutputStream(new
		FileOutputStream("personas.dat"));
		oos.writeObject(lista);
		oos.close();
	
		ObjectInputStream ois = new ObjectInputStream(new
		FileInputStream("personas.dat"));
		List<Persona> recuperadas = (List<Persona>) ois.readObject();
		ois.close();
	
		for (Persona p : recuperadas) {
		System.out.println(p.nombre + " tiene " + p.edad + " años");
		}
	}
}
