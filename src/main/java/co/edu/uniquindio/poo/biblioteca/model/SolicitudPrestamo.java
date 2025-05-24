package co.edu.uniquindio.poo.biblioteca.model;

import java.time.LocalDate;

public class SolicitudPrestamo {

    private String id;
    private Usuario solicitante;
    private LibroFisico libroSolicitado;
    private LocalDate fechaSolicitud;
    private TiempoPrestamo tiempoPrestamo;
    private EstadoSolicitud estado;

    public SolicitudPrestamo(String id, Usuario solicitante, LibroFisico libroSolicitado, TiempoPrestamo tiempoPrestamo) {
        this.id = id;
        this.solicitante = solicitante;
        this.libroSolicitado = libroSolicitado;
        this.fechaSolicitud = LocalDate.now();
        this.tiempoPrestamo = tiempoPrestamo;
        this.estado = EstadoSolicitud.PENDIENTE;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Usuario getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Usuario solicitante) {
        this.solicitante = solicitante;
    }

    public Libro getLibroSolicitado() {
        return libroSolicitado;
    }

    public void setLibroSolicitado(LibroFisico libroSolicitado) {
        this.libroSolicitado = libroSolicitado;
    }

    public LocalDate getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(LocalDate fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public EstadoSolicitud getEstado() {
        return estado;
    }

    public void setEstado(EstadoSolicitud estado) {
        this.estado = estado;
    }

    public TiempoPrestamo getTiempoPrestamo() {
        return tiempoPrestamo;
    }

    public void setTiempoPrestamo(TiempoPrestamo tiempoPrestamo) {
        this.tiempoPrestamo = tiempoPrestamo;
    }

    @Override
    public String toString() {
        return "SolicitudPrestamo{" +
                "id='" + id + '\'' +
                ", solicitante=" + solicitante +
                ", libroSolicitado=" + libroSolicitado +
                ", fechaSolicitud=" + fechaSolicitud +
                ", tiempoPrestamo=" + tiempoPrestamo +
                ", estado=" + estado +
                '}';
    }
}