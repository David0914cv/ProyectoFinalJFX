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
    private List<Libro> listLibrosPrestados;
    private List<Usuario> listUsuariosEnMora;
    private List<SolicitudPrestamo> listSolicitudPrestamos;

    /**
     * constructor de la clase Biblioteca
     * @param nombre
     * @param codigo
     */
    public Biblioteca(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
        listUsuarios = new ArrayList<>();
        listDevoluciones = new ArrayList<>();
        listPrestamos = new ArrayList<>();
        listLibros = new ArrayList<>();
        listLibrosPrestados = new ArrayList<>();
        listUsuariosEnMora = new ArrayList<>();
        listSolicitudPrestamos = new ArrayList<>();
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

    /**
     * metodo para verificar la existencia de un usuario en una lista de usuarios
     * @param usuario
     * @return boolean
     */
    public boolean verificarUsuarioExiste(Usuario usuario) {
        for (Usuario user : listUsuarios) {
            if(usuario.getNumeroIdentificacion().equals(user.getNumeroIdentificacion())) {
                return true;
            }
        } return false;
    }

    /**
     * metodo para agregar un usuario a una lista de usuarios
     * @param usuario
     * @return boolean
     */
    public boolean agregarUsuario(Usuario usuario) {
        if (verificarUsuarioExiste(usuario)) {
            return false;
        }
        else {
            listUsuarios.add(usuario);
            return true;
        }
    }

    /**
     * metodo para eliminar un usuario de una lista de usuarios
     * @param numeroIdentificacionUsuario
     * @return boolean
     */
    public boolean eliminarUsuario(String numeroIdentificacionUsuario) {
        for (int i = 0; i < listUsuarios.size(); i++) {
            if(listUsuarios.get(i).getNumeroIdentificacion().equals(numeroIdentificacionUsuario)) {
                listUsuarios.remove(i);
                return true;
            }
        } return false;
    }

    /**
     * metodo para actualizar un usuario en una lista de usuarios
     * @param numeroIdentificacionUsuario
     * @param usuario
     * @return boolean
     */
    public boolean actualizarUsuario(String numeroIdentificacionUsuario, Usuario usuario) {
        for (int i = 0; i < listUsuarios.size(); i++) {
            if(listUsuarios.get(i).getNumeroIdentificacion().equals(numeroIdentificacionUsuario)) {
                listUsuarios.set(i, usuario);
                return true;
            }
        } return false;
    }

    /**
     * metodo para mostrar los datos de un usuario en una lista de usuarios
     * @param numeroIdentificacionUsuario
     * @return usuario
     */
    public Usuario mostrarUsuario(String numeroIdentificacionUsuario) {
        for (Usuario user : listUsuarios) {
            if(user.getNumeroIdentificacion().equals(numeroIdentificacionUsuario)) {
                return user;
            }
        } return null;
    }

    /**
     * metodo para verificar la existencia de una devolucion en una lista de devoluciones
     * @param devolucion
     * @return boolean
     */
    public boolean verificarDevolucionExiste(Devolucion devolucion) {
        for (Devolucion devolucion1 : listDevoluciones) {
            if(devolucion.getId().equals(devolucion1.getId())) {
                return true;
            }
        } return false;
    }

    /**
     * metodo para agregar una devolucion a una lista de devoluciones
     * @param devolucion
     * @return boolean
     */
    public boolean agregarDevolucion(Devolucion devolucion) {
        if (verificarDevolucionExiste(devolucion)) {
            return false;
        }
        listDevoluciones.add(devolucion);
        return true;
    }

    /**
     * metodo para eliminar una devolucion de una lista de devoluciones
     * @param idDevolucion
     * @return boolean
     */
    public boolean eliminarDevolucion (String idDevolucion) {
        for (int i = 0; i < listDevoluciones.size(); i++) {
            if(listDevoluciones.get(i).getId().equals(idDevolucion)) {
                listDevoluciones.remove(i);
                return true;
            }
        } return false;
    }

    /**
     * metodo para actualizar una devolucion en una lista de devoluciones
     * @param idDevolucion
     * @param devolucion
     * @return boolean
     */
    public boolean actualizarDevolucion (String idDevolucion, Devolucion devolucion) {
        for (int i = 0; i < listDevoluciones.size(); i++) {
            if(listDevoluciones.get(i).getId().equals(idDevolucion)) {
                listDevoluciones.set(i, devolucion);
                return true;
            }
        } return false;
    }


    /**
     * metodo para mostrar los datos de una devolucion en una lista de devoluciones
     * @param idDevolucion
     * @return devolucion
     */
    public Devolucion mostrarDevolucion(String idDevolucion) {
        for (Devolucion devolucion1 : listDevoluciones) {
            if(devolucion1.getId().equals(idDevolucion)) {
                return devolucion1;
            }
        } return null;
    }

    /**
     * metodo para verificar la existencia de un prestamo en una lista de prestamos
     * @param prestamo
     * @return boolean
     */
    public boolean verificarPrestamoExiste(Prestamo prestamo) {
        for (Prestamo prestamo1 : listPrestamos) {
            if (prestamo.getId().equals(prestamo1.getId())) {
                return true;
            }
        }
        return false;
    }

    /**
     * metodo para agregar un prestamo a una lista de prestamos
     * @param prestamo
     * @return boolean
     */
    public boolean agregarPrestamo(Prestamo prestamo) {
        System.out.println(prestamo);
        if (verificarPrestamoExiste(prestamo)) {
            return false;
        } else {
            listPrestamos.add(prestamo);
            return true;
        }
    }

    /**
     * metodo para eliminar un prestamo de una lista de prestamos
     * @param idPrestamo
     * @return boolean
     */
    public boolean eliminarPrestamo(String idPrestamo) {
        for (int i = 0; i < listPrestamos.size(); i++) {
            if (listPrestamos.get(i).getId().equals(idPrestamo)) {
                listPrestamos.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * metodo para actualizar un prestamo de una lista de prestamos
     * @param idPrestamo
     * @param prestamo
     * @return boolean
     */
    public boolean actualizarPrestamo(String idPrestamo, Prestamo prestamo) {
        for (int i = 0; i < listPrestamos.size(); i++) {
            if (listPrestamos.get(i).getId().equals(idPrestamo)) {
                listPrestamos.set(i, prestamo);
                return true;
            }
        }
        return false;
    }

    /**
     * metodo para mostrar los datos de un prestamo en una lista de prestamos
     * @param idPrestamo
     * @return prestamo
     */
    public Prestamo mostrarPrestamo(String idPrestamo) {
        for (Prestamo prestamo1 : listPrestamos) {
            if (prestamo1.getId().equals(idPrestamo)) {
                return prestamo1;
            }
        }
        return null;
    }

    /**
     * metodo para verificar la existencia de un libro en una lista de libros
     * @param libro
     * @return boolean
     */
    public boolean verificarLibroExiste(Libro libro) {
        for (Libro book : listLibros) {
            if (libro.getCodigo().equals(book.getCodigo())) {
                return true;
            }
        }
        return false;
    }

    /**
     * metodo para agregar un libro a una lista de libros
     * @param libro
     * @return boolean
     */
    public boolean agregarLibro(Libro libro) {
        if (verificarLibroExiste(libro)) {
            return false;
        } else {
            listLibros.add(libro);
            return true;
        }
    }

    /**
     * metodo para eliminar un libro de una lista de libros
     * @param codigoLibro
     * @return boolean
     */
    public boolean eliminarLibro(String codigoLibro) {
        for (int i = 0; i < listLibros.size(); i++) {
            if (listLibros.get(i).getCodigo().equals(codigoLibro)) {
                listLibros.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * metodo para actualizar un libro de una lista de  prestamos
     * @param codigoLibro
     * @param libro
     * @return boolean
     */
    public boolean actualizarLibro(String codigoLibro, Libro libro) {
        for (int i = 0; i < listLibros.size(); i++) {
            if (listLibros.get(i).getCodigo().equals(codigoLibro)) {
                listLibros.set(i, libro);
                return true;
            }
        }
        return false;
    }

    /**
     * metodo para mostrar los datos de un libro de una lista de libros
     * @param codigoLibro
     * @return libro
     */
    public Libro mostrarLibro(String codigoLibro) {
        for (Libro book : listLibros) {
            if (book.getCodigo().equals(codigoLibro)) {
                return book;
            }
        }
        return null;
    }

    /**
     * metodo para verificar la existencia de una solicitud de prestamo en una lista de prestamos
     * @param solicitudPrestamo
     * @return boolean
     */
    public boolean verificarSolicitudPrestamoExiste(SolicitudPrestamo solicitudPrestamo) {
        for (SolicitudPrestamo solicitudPrestamo1 : listSolicitudPrestamos) {
            if (solicitudPrestamo.getId().equals(solicitudPrestamo1.getId())) {
                return true;
            }
        } return false;
    }

    /**
     * metodo para agregar una solicitud de prestamo a una lista de solicitudes de prestamo
     * @param solicitudPrestamo
     * @return boolean
     */
    public boolean agregarSolicitudPrestamo(SolicitudPrestamo solicitudPrestamo) {
        if (verificarSolicitudPrestamoExiste(solicitudPrestamo)) {
            return false;
        } else {
            listSolicitudPrestamos.add(solicitudPrestamo);
            return true;
        }
    }

    /**
     * metodo para  eliminar una solicitud de prestamo de una lista de solicitudes de prestamo
     * @param idSolicitudPrestamo
     * @return boolean
     */
    public boolean eliminarSolicitudPrestamo(String idSolicitudPrestamo) {
        for (int i = 0; i < listSolicitudPrestamos.size(); i++) {
            if (listSolicitudPrestamos.get(i).getId().equals(idSolicitudPrestamo)) {
                listSolicitudPrestamos.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * metodo para actualizar una solicitud de prestamo de una lista de solicitudes de prestamo
     * @param codSolicitud
     * @param solicitudPrestamo
     * @return boolean
     */
    public boolean actualizarSolicitudPrestamo(String codSolicitud, SolicitudPrestamo solicitudPrestamo) {
        for (int i = 0; i < listSolicitudPrestamos.size(); i++) {
            if (listSolicitudPrestamos.get(i).getId().equals(codSolicitud)) {
                listSolicitudPrestamos.set(i, solicitudPrestamo);
                return true;
            }
        }
        return false;
    }

    /**
     * metodo para mostrar los datos de una solicitud de prestamo de una lista de solicitudes de prestamo
     * @param idSolicitud
     * @return solicitud de prestamo
     */
    public SolicitudPrestamo mostrarSolicitudPrestamo(String idSolicitud) {
        for (SolicitudPrestamo solicitudPrestamo1 : listSolicitudPrestamos) {
            if (solicitudPrestamo1.getId().equals(idSolicitud)) {
                return solicitudPrestamo1;
            }
        } return null;
    }

    /**
     * metodo para verificar la existencia de un libro en una lista de libros prestados
     * @param libro
     * @return boolean
     */
    public boolean verificarLibroPrestadoExiste(Libro libro) {
        for (Libro book : listLibrosPrestados) {
            if (libro.getCodigo().equals(book.getCodigo())) {
                return true;
            }
        }
        return false;
    }

    /**
     * metodo para agregar un libro a una lista de libros prestados
     * @param libro
     * @return boolean
     */
    public boolean agregarLibroPrestado(Libro libro) {
        if (verificarLibroPrestadoExiste(libro)) {
            return false;
        } else {
            listLibrosPrestados.add(libro);
            return true;
        }
    }

    /**
     * metodo para eliminar un libro de una lista de libros prestados
     * @param codigoLibro
     * @return boolean
     */
    public boolean eliminarLibroPrestado(String codigoLibro) {
        for (int i = 0; i < listLibrosPrestados.size(); i++) {
            if (listLibrosPrestados.get(i).getCodigo().equals(codigoLibro)) {
                listLibrosPrestados.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * metodo  para verificar la existencia de un usuario en una lista de usuarios en mora
     * @param usuario
     * @return boolean
     */
    public boolean verificarUsuarioEnMoraExiste(Usuario usuario) {
        for (Usuario user : listUsuariosEnMora) {
            if(usuario.getNumeroIdentificacion().equals(user.getNumeroIdentificacion())) {
                return true;
            }
        } return false;
    }

    /**
     * metodo para agregar un usuario a una lista de usuarios en mora
     * @param usuario
     * @return boolean
     */
    public boolean agregarUsuarioEnMora(Usuario usuario) {
        if (verificarUsuarioEnMoraExiste(usuario)) {
            return false;
        }
        else {
            listUsuariosEnMora.add(usuario);
            return true;
        }
    }

    /**
     * metodo para eliminar un usuario de una lista de usuarios en mora
     * @param numeroIdentificacionUsuario
     * @return boolean
     */
    public boolean eliminarUsuarioEnMora(String numeroIdentificacionUsuario) {
        for (int i = 0; i < listUsuariosEnMora.size(); i++) {
            if(listUsuariosEnMora.get(i).getNumeroIdentificacion().equals(numeroIdentificacionUsuario)) {
                listUsuariosEnMora.remove(i);
                return true;
            }
        } return false;
    }

    /**
     * metodo para comprobar la disponibilidad de un libro segun su estado
     * @param codigoLibro
     * @return boolean
     */
    public boolean libroDisponible(String codigoLibro) {
        Libro libro = mostrarLibro(codigoLibro);
        if (libro != null && libro.getEstado() == EstadoLibro.DISPONIBLE) {
            return true;
        }
        return false;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<Usuario> getListUsuarios() {
        return listUsuarios;
    }

    public void setListUsuarios(List<Usuario> listUsuarios) {
        this.listUsuarios = listUsuarios;
    }

    public List<Devolucion> getListDevoluciones() {
        return listDevoluciones;
    }

    public void setListDevoluciones(List<Devolucion> listDevoluciones) {
        this.listDevoluciones = listDevoluciones;
    }

    public List<Prestamo> getListPrestamos() {
        return listPrestamos;
    }

    public void setListPrestamos(List<Prestamo> listPrestamos) {
        this.listPrestamos = listPrestamos;
    }

    public List<Libro> getListLibros() {
        return listLibros;
    }

    public void setListLibros(List<Libro> listLibros) {
        this.listLibros = listLibros;
    }

    public List<Libro> getListLibrosPrestados() {
        return listLibrosPrestados;
    }

    public void setListLibrosPrestados(List<Libro> listLibrosPrestados) {
        this.listLibrosPrestados = listLibrosPrestados;
    }

    public List<Usuario> getListUsuariosEnMora() {
        return listUsuariosEnMora;
    }

    public void setListUsuariosEnMora(List<Usuario> listUsuariosEnMora) {
        this.listUsuariosEnMora = listUsuariosEnMora;
    }

    public List<SolicitudPrestamo> getListSolicitudPrestamos() {
        return listSolicitudPrestamos;
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
