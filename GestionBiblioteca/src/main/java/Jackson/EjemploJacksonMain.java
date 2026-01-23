package Jackson;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class EjemploJacksonMain {

private static final String nombrearchivo="personas.json";	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ObjectMapper mapper= new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		
		Persona p= new Persona("Mario",20,"a@gmail.com");
		guardarJson(p,mapper);
		System.out.println(sacarValorJson());
		
	}
	
	public static void guardarJson(Persona persona, ObjectMapper mapper) {
	
		try {
		
		mapper.writeValue(new File(nombrearchivo), persona);

		} catch (StreamWriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Persona sacarValorJson() {
		ObjectMapper mapper= new ObjectMapper();
		try {
			return mapper.readValue(new File(nombrearchivo), Persona.class);
		} catch (StreamReadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

}