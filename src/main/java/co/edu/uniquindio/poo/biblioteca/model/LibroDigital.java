package co.edu.uniquindio.poo.biblioteca.model;

public class LibroDigital extends Libro {

    private FormatoLibro formato;

    public LibroDigital(String codigo, String titulo, String autor, String genero, String anioPublicacion, EstadoLibro estado, FormatoLibro formato) {
        super(codigo, titulo, autor, genero, anioPublicacion, estado);
        this.formato = formato;
    }

    public FormatoLibro getFormato() {
        return formato;
    }

    public void setFormato(FormatoLibro formato) {
        this.formato = formato;
    }

    @Override
    public String toString() {
        return "LibroDigital{" +
                "formato=" + formato +
                '}';
    }
}
