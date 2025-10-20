package primero;

import java.io.IOException;

public class ejercicioJose {
	public static void main(String[] args) throws InterruptedException, IOException {
	       
	       ProcessBuilder pb = new ProcessBuilder("sc","query","Spooler");
	       Process p;
	       int code = 0;
	       int code2 = 0;
	      
	       try {
	           p = pb.start();
	           code = p.waitFor();
	           code2 = p.exitValue();
	          
	       } catch (InterruptedException e) {
	               System.err.println("El hilo fue interrumpido mientras esperaba al proceso.");
	       } catch (IllegalThreadStateException e) {
	               System.err.println("Intentaste obtener el código de salida antes de que terminara el proceso.");
	       }
	       finally {
	           System.out.println(code);
	           System.out.println(code2);
	           if(code == 0) {
	               System.out.println("El metodo waitFor ha funcionado correctamente");
	           }
	           else {
	               System.out.println("El metodo waitFor no ha logrado su cometido");
	           }
	           if(code2 == 0) {
	               System.out.println("El proceso ha terminado");
	           }
	           else {
	               System.out.println("El proceso no ha terminado");
	           }
	       }
	   }
	}