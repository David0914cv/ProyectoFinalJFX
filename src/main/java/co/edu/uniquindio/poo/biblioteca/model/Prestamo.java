package co.edu.uniquindio.poo.biblioteca.model;

import java.time.LocalDate;
import java.util.UUID;

public class Prestamo {

    private String id,fechaInicio,fechaFin;
    private Usuario usuario;
    private Bibliotecario bibliotecario;
    private Libro libro;

    /**
     * constructor de la clase Prestamo
     * @param id
     * @param fechaInicio
     * @param fechaFin
     * @param usuario
     * @param bibliotecario
     * @param libro
     */
    public Prestamo(String id, String fechaInicio, String fechaFin, Usuario usuario, Bibliotecario bibliotecario, Libro libro) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.usuario = usuario;
        this.bibliotecario = bibliotecario;
        this.libro = libro;
    }


    public String getId() {
        return id;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Bibliotecario getBibliotecario() {
        return bibliotecario;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setBibliotecario(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "id='" + id + '\'' +
                ", fechaInicio='" + fechaInicio + '\'' +
                ", fechaFin='" + fechaFin + '\'' +
                ", Prestamista=" + usuario +
                ", bibliotecario=" + bibliotecario +
                '}';
    }
}
