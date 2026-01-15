package hotel;

public class Cliente {
    private String nombre;
    private String documento;
    private String telefono;

    public Cliente(String nombre, String documento, String telefono) {
        this.nombre = nombre;
        this.documento = documento;
        this.telefono = telefono;
    }

    public String getDocumento() {
        return documento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "Nombre='" + nombre + '\'' +
                ", Documento='" + documento + '\'' +
                ", Teléfono='" + telefono + '\'' +
                '}';
    }
}
