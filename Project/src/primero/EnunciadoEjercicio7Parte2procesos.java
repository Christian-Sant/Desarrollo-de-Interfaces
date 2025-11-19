package primero;

import java.io.File;
import java.io.IOException;
import java.util.Map;


public class EnunciadoEjercicio7Parte2procesos {
    public static void main(String[] args) {
        File directorio = new File("C:\\Users\\Tarde\\Documents\\Mantenimiento");
        File salidaMantenimiento = new File(directorio, "mantenimiento_salida.txt");    
        File errorMantenimiento = new File(directorio, "mantenimiento_error.txt");    
        try {
            ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "scriptMantenimiento.bat");
            pb.directory(directorio);
            Map<String, String> map = pb.environment();
            map.put("MODO", "limpieza");
            pb.redirectOutput(salidaMantenimiento);
            pb.redirectError(errorMantenimiento);
            Process p = pb.start();
            p.waitFor();
        } catch (InterruptedException e) {
            System.out.println("El hilo fue interrumpido mientras esperaba al proceso: " + e);
        } catch (IOException e) {
            System.out.println("Hubo un problema en la entrada o salida de los datos: " + e);
        }
    }
}