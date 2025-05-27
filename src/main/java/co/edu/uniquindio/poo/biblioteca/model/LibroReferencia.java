package co.edu.uniquindio.poo.biblioteca.model;

public class LibroReferencia extends Libro {

    /**
     * constructor de la clase LibroReferencia
     * @param codigo
     * @param titulo
     * @param autor
     * @param genero
     * @param anioPublicacion
     */
    public LibroReferencia(String codigo, String titulo, String autor, String genero, String anioPublicacion) {
        super(codigo, titulo, autor, genero, anioPublicacion);
    }

    @Override
    public String toString() {
        return "( "+getTitulo()+
                " Del autor" +getAutor()+ '\'' +
                " publicado en el año "+getAnioPublicacion()+ '\'' +
                " Con el código '" + getCodigo() + '\'' +
                ')';
    }
}
