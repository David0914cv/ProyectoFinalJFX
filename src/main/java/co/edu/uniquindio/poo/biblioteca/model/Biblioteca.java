package co.edu.uniquindio.poo.biblioteca.model;

import java.util.ArrayList;
import java.util.HashMap;
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

    public Map<String,String> loginUsuario(Map<String,String> formLogin) {
        Map<String,String> resultado = new HashMap<>();
        boolean bandera = false;

        for (Usuario usuario : listUsuarios) {
            if(usuario.getNumeroIdentificacion().equals(formLogin.get("cedula")) && usuario.getContrasenia().equals(formLogin.get("contrasenia"))) {
                if (usuario.getClass() == Administrador.class || usuario.getClass() == Bibliotecario.class){
                    resultado.put("message","type incorrect") ;
                    bandera = true;
                }else {
                    resultado.put("message","login correct");
                    resultado.put("rol",usuario.getClass().getSimpleName());
                    bandera = true;
                }
            }
            if (usuario.getNumeroIdentificacion().equals(formLogin.get("cedula")) && !usuario.getContrasenia().equals(formLogin.get("contrasenia"))) {
                resultado.put("message","password incorrect");
                bandera = true;
            }
        }

        if (!bandera) {
            resultado.put("message","user not exist");
        }
        return resultado;
    }

    public Map<String,String> loginUsuarioCredencial(Map<String,String> formLogin) {
        Map<String,String> resultado = new HashMap<>();
        boolean bandera = false;

        for (Usuario usuario : listUsuarios) {
            if(usuario.getNumeroIdentificacion().equals(formLogin.get("cedula")) && usuario.getContrasenia().equals(formLogin.get("contrasenia"))) {
                if (usuario.getClass() == Estudiante.class || usuario.getClass() == Visitante.class || usuario.getClass() == Docente.class){
                    resultado.put("message","type incorrect") ;
                }else {
                    if (usuario.getClass() == Administrador.class){
                        Administrador user = (Administrador) usuario;
                        if (user.getCredencial().equals(formLogin.get("credencial"))) {
                            resultado.put("message","login correct");
                            resultado.put("rol",usuario.getClass().getSimpleName());
                        }else {
                            resultado.put("message","password incorrect");
                        }
                    }
                    if (usuario.getClass() == Bibliotecario.class){
                        Bibliotecario user = (Bibliotecario) usuario;
                        if (user.getCredencialBibliotecario().equals(formLogin.get("credencial"))) {
                            resultado.put("message","login correct");
                            resultado.put("rol",usuario.getClass().getSimpleName());
                        }else {
                            resultado.put("message","password incorrect");
                        }
                    }
                }
                bandera = true;
            }
            if (usuario.getNumeroIdentificacion().equals(formLogin.get("cedula")) && !usuario.getContrasenia().equals(formLogin.get("contrasenia"))) {
                resultado.put("message","password incorrect");
                bandera = true;
            }
        }

        if (!bandera) {
            resultado.put("message","user not exist");
        }
        return resultado;
    }

    public boolean verificarUsuarioExiste(Usuario usuario) {
        for (Usuario user : listUsuarios) {
            if(usuario.getNumeroIdentificacion().equals(user.getNumeroIdentificacion())) {
                return true;
            }
        } return false;
    }

    public boolean agregarUsuario(Usuario usuario) {
        if (verificarUsuarioExiste(usuario)) {
            return false;
        }
        else {
            listUsuarios.add(usuario);
            return true;
        }
    }

    public boolean eliminarUsuario(String numeroIdentificacionUsuario) {
        for (int i = 0; i < listUsuarios.size(); i++) {
            if(listUsuarios.get(i).getNumeroIdentificacion().equals(numeroIdentificacionUsuario)) {
                listUsuarios.remove(i);
                return true;
            }
        } return false;
    }

    public boolean actualizarUsuario(String numeroIdentificacionUsuario, Usuario usuario) {
        for (int i = 0; i < listUsuarios.size(); i++) {
            if(listUsuarios.get(i).getNumeroIdentificacion().equals(numeroIdentificacionUsuario)) {
                listUsuarios.set(i, usuario);
                return true;
            }
        } return false;
    }

    public Usuario mostrarUsuario(String numeroIdentificacionUsuario) {
        for (Usuario user : listUsuarios) {
            if(user.getNumeroIdentificacion().equals(numeroIdentificacionUsuario)) {
                return user;
            }
        } return null;
    }

    public boolean verificarDevolucionExiste(Devolucion devolucion) {
        for (Devolucion devolucion1 : listDevoluciones) {
            if(devolucion.getId().equals(devolucion1.getId())) {
                return true;
            }
        } return false;
    }


    public boolean agregarDevolucion(Devolucion devolucion) {
        if (verificarDevolucionExiste(devolucion)) {
            return false;
        }
        listDevoluciones.add(devolucion);
        return true;
    }

    public boolean eliminarDevolucion (String idDevolucion) {
        for (int i = 0; i < listDevoluciones.size(); i++) {
            if(listDevoluciones.get(i).getId().equals(idDevolucion)) {
                listDevoluciones.remove(i);
                return true;
            }
        } return false;
    }

    public boolean actualizarDevolucion (String idDevolucion, Devolucion devolucion) {
        for (int i = 0; i < listDevoluciones.size(); i++) {
            if(listDevoluciones.get(i).getId().equals(idDevolucion)) {
                listDevoluciones.set(i, devolucion);
                return true;
            }
        } return false;
    }

    public Devolucion mostrarDevolucion(String idDevolucion) {
        for (Devolucion devolucion1 : listDevoluciones) {
            if(devolucion1.getId().equals(idDevolucion)) {
                return devolucion1;
            }
        } return null;
    }

    public boolean verificarPrestamoExiste(Prestamo prestamo) {
        for (Prestamo prestamo1 : listPrestamos) {
            if (prestamo.getId().equals(prestamo1.getId())) {
                return true;
            }
        }
        return false;
    }

    public boolean agregarPrestamo(Prestamo prestamo) {
        if (verificarPrestamoExiste(prestamo)) {
            return false;
        } else {
            listPrestamos.add(prestamo);
            return true;
        }
    }

    public boolean eliminarPrestamo(String idPrestamo) {
        for (int i = 0; i < listPrestamos.size(); i++) {
            if (listPrestamos.get(i).getId().equals(idPrestamo)) {
                listPrestamos.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean actualizarPrestamo(String idPrestamo, Prestamo prestamo) {
        for (int i = 0; i < listPrestamos.size(); i++) {
            if (listPrestamos.get(i).getId().equals(idPrestamo)) {
                listPrestamos.set(i, prestamo);
                return true;
            }
        }
        return false;
    }

    public Prestamo mostrarPrestamo(String idPrestamo) {
        for (Prestamo p : listPrestamos) {
            if (p.getId().equals(idPrestamo)) {
                return p;
            }
        }
        return null;
    }

    public boolean verificarLibroExiste(Libro libro) {
        for (Libro book : listLibros) {
            if (libro.getCodigo().equals(book.getCodigo())) {
                return true;
            }
        }
        return false;
    }

    public boolean agregarLibro(Libro libro) {
        if (verificarLibroExiste(libro)) {
            return false;
        } else {
            listLibros.add(libro);
            return true;
        }
    }

    public boolean eliminarLibro(String codigoLibro) {
        for (int i = 0; i < listLibros.size(); i++) {
            if (listLibros.get(i).getCodigo().equals(codigoLibro)) {
                listLibros.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean actualizarLibro(String codigoLibro, Libro libro) {
        for (int i = 0; i < listLibros.size(); i++) {
            if (listLibros.get(i).getCodigo().equals(codigoLibro)) {
                listLibros.set(i, libro);
                return true;
            }
        }
        return false;
    }

    public Libro mostrarLibro(String codigoLibro) {
        for (Libro l : listLibros) {
            if (l.getCodigo().equals(codigoLibro)) {
                return l;
            }
        }
        return null;
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
