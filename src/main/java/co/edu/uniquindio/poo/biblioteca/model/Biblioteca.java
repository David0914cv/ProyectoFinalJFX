package co.edu.uniquindio.poo.biblioteca.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Biblioteca {
    private String nombre, codigo;
    private List<Usuario> listUsuarios;
    private List<Devolucion> listDevoluciones;
    private List<Prestamo> listPrestamos;
    private List<Libro> listLibros;

    public Biblioteca(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
        listUsuarios = new ArrayList<>();
        listDevoluciones = new ArrayList<>();
        listPrestamos = new ArrayList<>();
        listLibros = new ArrayList<>();
    }

    public boolean loginUsuario(Map<String,String> formLogin) {
        boolean resultado = false;

        for (Usuario usuario : listUsuarios) {
            if(usuario.getNumeroIdentificacion().equals(formLogin.get("cedula")) && usuario.getContrasenia().equals(formLogin.get("contrasenia"))) {
                resultado = true;
            }
        }
        return resultado;
    }

    public void agregarUsuario(Usuario usuario) {
        listUsuarios.add(usuario);
    }

    public void agregarDevolucion(Devolucion devolucion) {
        listDevoluciones.add(devolucion);
    }

    public void agregarPrestamo(Prestamo prestamo) {
        listPrestamos.add(prestamo);
    }

    public void agregarLibro(Libro libro) {
        listLibros.add(libro);
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public List<Usuario> getListUsuarios() {
        return listUsuarios;
    }

    public List<Devolucion> getListDevoluciones() {
        return listDevoluciones;
    }

    public List<Prestamo> getListPrestamos() {
        return listPrestamos;
    }

    public List<Libro> getListLibros() {
        return listLibros;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "nombre='" + nombre + '\'' +
                ", codigo='" + codigo + '\'' +
                ", listUsuarios=" + listUsuarios +
                ", listDevoluciones=" + listDevoluciones +
                ", listPrestamos=" + listPrestamos +
                ", listLibros=" + listLibros +
                '}';
    }
}
