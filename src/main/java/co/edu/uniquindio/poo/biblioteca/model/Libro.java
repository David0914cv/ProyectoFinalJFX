package co.edu.uniquindio.poo.biblioteca.model;

public class Libro {
    private String codigo,titulo,autor,genero,anioPublicacion;
    private int cantidadVecesPrestado;
    private EstadoLibro estado;

    public Libro(String codigo, String titulo, String autor, String genero, String anioPublicacion, EstadoLibro estado) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.anioPublicacion = anioPublicacion;
        this.estado = estado;
        this.cantidadVecesPrestado = 0;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(String anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public EstadoLibro getEstado() {
        return estado;
    }

    public void setEstado(EstadoLibro estado) {
        this.estado = estado;
    }

    public int getCantidadVecesPrestado() {return cantidadVecesPrestado;}

    public void setCantidadVecesPrestado( int cantidadVecesPrestado) {this.cantidadVecesPrestado = cantidadVecesPrestado;}

    @Override
    public String toString() {
        return "Libro{" +
                "codigo='" + codigo + '\'' +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", genero='" + genero + '\'' +
                ", anioPublicacion='" + anioPublicacion + '\'' +
                ", cantidadVecesPrestado=" + cantidadVecesPrestado +
                ", estado=" + estado +
                '}';
    }
}
