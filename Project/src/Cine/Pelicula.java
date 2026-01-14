package Cine;

public class Pelicula {

    private String titulo;
    private String tipo;
    private String resumen;
    private String rutaImagen;

    public Pelicula(String titulo, String tipo, String resumen, String rutaImagen) {
        this.titulo = titulo;
        this.tipo = tipo;
        this.resumen = resumen;
        this.rutaImagen = rutaImagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public String getResumen() {
        return resumen;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    @Override
    public String toString() {
        return titulo;
    }
}
