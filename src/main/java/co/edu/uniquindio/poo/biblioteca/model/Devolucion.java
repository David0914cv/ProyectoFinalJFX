package co.edu.uniquindio.poo.biblioteca.model;

public class Devolucion {

    private String id,fechaDevolucion,observaciones;
    private Prestamo prestamo;

    public Devolucion(String id, String fechaDevolucion, String observaciones, Prestamo prestamo) {
        this.id = id;
        this.fechaDevolucion = fechaDevolucion;
        this.observaciones = observaciones;
        this.prestamo = prestamo;
    }

    public String getId() {
        return id;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    @Override
    public String toString() {
        return "Devolucion{" +
                "id='" + id + '\'' +
                ", fechaDevolucion='" + fechaDevolucion + '\'' +
                ", observaciones='" + observaciones + '\'' +
                ", prestamo=" + prestamo +
                '}';
    }
}
