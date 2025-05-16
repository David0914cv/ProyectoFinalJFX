package co.edu.uniquindio.poo.biblioteca.model;

public class LibroFisico extends Libro {

    private String numeroPaginas,editorial,ubicacionBiblioteca;


    public LibroFisico(String codigo, String titulo, String autor, String genero, String anioPublicacion, EstadoLibro estado, String numeroPaginas, String editorial, String ubicacionBiblioteca) {
        super(codigo, titulo, autor, genero, anioPublicacion, estado);
        this.numeroPaginas = numeroPaginas;
        this.editorial = editorial;
        this.ubicacionBiblioteca = ubicacionBiblioteca;
    }

    public String getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(String numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getUbicacionBiblioteca() {
        return ubicacionBiblioteca;
    }

    public void setUbicacionBiblioteca(String ubicacionBiblioteca) {
        this.ubicacionBiblioteca = ubicacionBiblioteca;
    }

    @Override
    public String toString() {
        return "LibroFisico{" +
                "numeroPaginas='" + numeroPaginas + '\'' +
                ", editorial='" + editorial + '\'' +
                ", ubicacionBiblioteca='" + ubicacionBiblioteca + '\'' +
                '}';
    }
}
