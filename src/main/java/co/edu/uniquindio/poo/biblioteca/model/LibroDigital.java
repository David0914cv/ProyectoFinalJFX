package co.edu.uniquindio.poo.biblioteca.model;

public class LibroDigital extends Libro {

    private FormatoLibro formato;
    private String enlace;

    public LibroDigital(String codigo, String titulo, String autor, String genero, String anioPublicacion, FormatoLibro formato, String enlace) {
        super(codigo, titulo, autor, genero, anioPublicacion);
        this.formato = formato;
        this.enlace = enlace;
    }

    public FormatoLibro getFormato() {
        return formato;
    }

    public void setFormato(FormatoLibro formato) {
        this.formato = formato;
    }

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }

    @Override
    public String toString() {
        return "LibroDigital{" +
                "formato=" + formato +
                '}';
    }
}
