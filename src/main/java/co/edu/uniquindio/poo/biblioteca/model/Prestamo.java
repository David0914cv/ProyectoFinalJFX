package co.edu.uniquindio.poo.biblioteca.model;

public class Prestamo {

    private String id,fechaInicio,fechaFin;
    private Estudiante estudiante;
    private Bibliotecario bibliotecario;
    private Libro libro;

    public Prestamo(String id, String fechaInicio, String fechaFin, Estudiante estudiante, Bibliotecario bibliotecario, Libro libro) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estudiante = estudiante;
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

    public Estudiante getEstudiante() {
        return estudiante;
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

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
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
                ", estudiante=" + estudiante +
                ", bibliotecario=" + bibliotecario +
                '}';
    }
}
