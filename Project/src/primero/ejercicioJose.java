package primero;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ejercicioJose {
		static Scanner sc = new Scanner(System.in);
		  public static void main(String[] args) throws InterruptedException, IOException {
		       
			   System.out.print("Dime el servicio: ");
			   String servicio = sc.nextLine();
			   System.out.println(servicio);
		       ProcessBuilder pb = new ProcessBuilder("sc","query",servicio);
		       Process p;
		       sc.close();
		       try {
		           p = pb.start();
		           p.waitFor();
		           p.exitValue();
		           BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));   
			       String linea;
			       while ((linea = br.readLine()) != null) {
			       System.out.println(linea);
			       }
			       br.close();
		          
		       } catch (InterruptedException e) {
		               System.out.println("El hilo fue interrumpido mientras esperaba al proceso.");
		       } catch (IllegalThreadStateException e) {
		               System.out.println("Intentaste obtener el código de salida antes de que terminara el proceso.");
		       }
		       
		  }
	}