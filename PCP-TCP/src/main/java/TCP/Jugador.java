package TCP;

public class Jugador {

    private String nombre;
    private int aciertos;

    // Constructor vacío necesario para Jackson
    public Jugador() {
    }

    // Constructor con parámetros
    public Jugador(String nombre, int aciertos) {
        this.nombre = nombre;
        this.aciertos = aciertos;
    }

    // Getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAciertos() {
        return aciertos;
    }

    public void setAciertos(int aciertos) {
        this.aciertos = aciertos;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", aciertos=" + aciertos +
                '}';
    }
}
