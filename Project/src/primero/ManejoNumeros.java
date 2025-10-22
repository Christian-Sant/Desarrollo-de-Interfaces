package primero;

import java.io.IOException;
import java.io.RandomAccessFile;

public class ManejoNumeros {

    public static void main(String[] args) {
        // Nombre del archivo donde se almacenarán los números
        String nombreArchivo = "numeros2.txt";

        try (RandomAccessFile archivo = new RandomAccessFile(nombreArchivo, "rw")) {
            // 1. Escribir 10 números enteros en el archivo
            System.out.println("Escribiendo números en el archivo...");
            for (int i = 1; i <= 10; i++) {
                archivo.writeInt(i); // Escribir el número en el archivo
            }

            // 2. Leer todos los números del archivo y mostrarlos
            System.out.println("Números en el archivo:");
            mostrarNumeros(archivo);

            // 3. Actualizar el tercer número (índice 2, porque empieza en 0)
            int nuevoNumero = 100; // Número que se desea actualizar
            archivo.seek(2 * Integer.BYTES); // Moverse a la posición del tercer número
            archivo.writeInt(nuevoNumero); // Actualizar el número

            // 4. Mostrar los números actualizados
            System.out.println("\nNúmeros después de la actualización: ");
            mostrarNumeros(archivo);
        } catch (IOException e) {
            System.err.println("Error al acceder al archivo: " + e.getMessage());
        }
    }

    // Método para mostrar los números en el archivo
    private static void mostrarNumeros(RandomAccessFile archivo) throws IOException {
        // Volver al inicio del archivo
        archivo.seek(0);
        while(archivo.getFilePointer() < archivo.length()) {
        	System.out.print(archivo.readInt() + " ");
        }
        System.out.println();
    }
}