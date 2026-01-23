package futbol;

/**
 * Clase de utilidades generales para la aplicación de gestión de fútbol.
 * Contiene métodos estáticos que se pueden usar en diferentes partes del programa.
 * 
 * @author Christian
 * @version 1.0
 * @since 2026-01-19
 */
public class utilidades {

    /**
     * Genera un número aleatorio de 10 dígitos, usado por ejemplo para IDs únicos.
     * 
     * @return Un número entero aleatorio de 10 dígitos (entre 1000000000 y 1999999999)
     */
    public static int generarNumeroAleatorio() {
        return (int) (Math.random() * 1000000000) + 1000000000;
    }
}
