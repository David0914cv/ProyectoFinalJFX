package co.edu.uniquindio.poo.biblioteca.model;



import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import co.edu.uniquindio.poo.biblioteca.model.Biblioteca;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class BibliotecaTest {

    private Biblioteca biblioteca;

    @BeforeEach
    public void setUp() {
        biblioteca = new Biblioteca("Mi Biblioteca", "001");

        // Usuarios para las pruebas
        Usuario usuario = new  Usuario("luis gomez","999","alo");
        Libro libro1 = new LibroFisico("1","El principito"," Antoine de Saint-Exupéry","Fantasía","1943","300","qwerty","seccion2");
        Libro libro4 = new LibroFisico("4","El señor de los anillos","J. R. R. Tolkien","Novela","1954","800","George Allen & Unwin HarperCollins","seccion4");
        libro4.setEstado(EstadoLibro.PRESTADO);
        Bibliotecario bibliotecario = new Bibliotecario("Bib", "333", "bibpass", "credBib");
        Devolucion devolucion1 = new Devolucion("D001","25/05/2024","ninguna",new Prestamo("D001","20/05/2024","25/05/2024",usuario,bibliotecario,libro1));
        Devolucion devolucion2 = new Devolucion("D002","25/04/2024","ninguna",new Prestamo("D002","15/04/2024","25/04/2024",usuario,bibliotecario,libro1));
        Prestamo prestamo1 = new Prestamo("P001","15/04/2024","25/04/2024",usuario,bibliotecario,libro1);
        Estudiante estudiante = new Estudiante("Juan Pérez", "111", "clave123");
        Administrador admin = new Administrador("Admin", "222", "adminpass", "credAdmin");



        biblioteca.agregarUsuario(estudiante);
        biblioteca.agregarUsuario(admin);
        biblioteca.agregarUsuario(bibliotecario);
        biblioteca.agregarDevolucion(devolucion1);
        biblioteca.agregarDevolucion(devolucion2);
        biblioteca.agregarLibro(libro1);
        biblioteca.agregarPrestamo(prestamo1);
        biblioteca.agregarLibroPrestado(libro4);

    }

    @Test
    public void testLoginUsuario_CorrectoEstudiante() {
        Map<String, String> formLogin = new HashMap<>();
        formLogin.put("cedula", "111");
        formLogin.put("contrasenia", "clave123");

        Map<String, String> resultado = biblioteca.loginUsuario(formLogin);

        assertEquals("login correct", resultado.get("message"));
        assertEquals("Estudiante", resultado.get("rol"));
    }

    @Test
    void loginUsuarioCredencial() {
        Map<String, String> formLogin = new HashMap<>();
        formLogin.put("cedula", "333");
        formLogin.put("contrasenia", "bibpass");

        Map<String, String> resultado = biblioteca.loginUsuario(formLogin);

        assertEquals("type incorrect", resultado.get("message"));
    }


    @Test
    void verificarUsuarioExiste() {

        Usuario usuarioExistente = new Estudiante("Otro Nombre", "111", "otraClave");
        boolean prueba1 = biblioteca.verificarUsuarioExiste(usuarioExistente);
        assertTrue(prueba1);
        Usuario usuarioNoExistente = new Estudiante("Nuevo", "999", "clave");
        boolean prueba2 = biblioteca.verificarUsuarioExiste(usuarioNoExistente);
        assertFalse(prueba2);
    }


    @Test
    void testAgregarUsuario() {

        Usuario nuevoUsuario = new Estudiante("Nuevo Estudiante", "444", "clave444");
        boolean prueba1 = biblioteca.agregarUsuario(nuevoUsuario);
        assertTrue(prueba1);
    }

    @Test
    void eliminarUsuario() {

        assertTrue(biblioteca.verificarUsuarioExiste(new Estudiante("Juan Pérez", "111", "clave123")));
        boolean eliminado = biblioteca.eliminarUsuario("111");
        assertTrue(eliminado);
    }

    @Test
    void actualizarUsuario() {

        assertTrue(biblioteca.verificarUsuarioExiste(new Estudiante("Juan Pérez", "111", "clave123")));
        Usuario estudianteActualizado = new Estudiante("Juan Pérez", "111", "nuevaClave456");
        boolean actualizado = biblioteca.actualizarUsuario("111", estudianteActualizado);
        assertTrue(actualizado);
    }

    @Test
    public void testMostrarUsuario_existente() {
        Usuario usuario = biblioteca.mostrarUsuario("111");
        assertNotNull(usuario);
        assertEquals("Juan Pérez", usuario.getNombre());
        assertEquals("111", usuario.getNumeroIdentificacion());
    }

    @Test
    void verificarDevolucionExiste(){
        Usuario usuario = new  Usuario("luis gomez","999","alo");
        Libro libro1 = new LibroFisico("1","El principito"," Antoine de Saint-Exupéry","Fantasía","1943","300","qwerty","seccion2");
        Bibliotecario bibliotecario = new Bibliotecario("Bib", "333", "bibpass", "credBib");
        Devolucion devolucion1 = new Devolucion("D001","25/05/2024","ninguna",new Prestamo("D001","20/05/2024","25/05/2024",usuario,bibliotecario,libro1));
        assertTrue(biblioteca.verificarDevolucionExiste(devolucion1));

    }

    @Test
    void agregarDevolucion() {
        Usuario usuario = new  Usuario("luis gomez","999","alo");
        Libro libro1 = new LibroFisico("1","El principito"," Antoine de Saint-Exupéry","Fantasía","1943","300","qwerty","seccion2");
        Bibliotecario bibliotecario = new Bibliotecario("Bib", "333", "bibpass", "credBib");
        Devolucion devolucion1 = new Devolucion("D001","25/05/2024","ninguna",new Prestamo("D001","20/05/2024","25/05/2024",usuario,bibliotecario,libro1));
        boolean resultado = biblioteca.agregarDevolucion(devolucion1);
        assertFalse(resultado);
    }

    @Test
    public void testEliminarDevolucion_existente() {
        boolean resultado = biblioteca.eliminarDevolucion("D001");
        assertTrue(resultado);
    }

    @Test
    void actualizarDevolucion() {
        Usuario usuario = new  Usuario("luis gomez","999","alo");
        Libro libro1 = new LibroFisico("1","El principito"," Antoine de Saint-Exupéry","Fantasía","1943","300","qwerty","seccion2");
        Bibliotecario bibliotecario = new Bibliotecario("Bib", "333", "bibpass", "credBib");
        Devolucion nuevaDevolucion = new Devolucion("D002","25/04/2024","ninguna",new Prestamo("D002","15/04/2024","25/04/2024",usuario,bibliotecario,libro1));
        boolean resultado = biblioteca.actualizarDevolucion("D001", nuevaDevolucion);

        assertTrue(resultado, "La devolución con ID D001 debería actualizarse correctamente.");
    }

    @Test
    public void testMostrarDevolucion_existente() {
        Devolucion resultado = biblioteca.mostrarDevolucion("D001");
        assertNotNull(resultado, "La devolución con ID D001 debería encontrarse.");
        assertEquals("D001", resultado.getId(), "El ID de la devolución debería coincidir.");
    }

    @Test
    void verificarPrestamoExiste() {
        Usuario usuario = new  Usuario("luis gomez","999","alo");
        Libro libro1 = new LibroFisico("1","El principito"," Antoine de Saint-Exupéry","Fantasía","1943","300","qwerty","seccion2");
        Bibliotecario bibliotecario = new Bibliotecario("Bib", "333", "bibpass", "credBib");
        Prestamo prestamo1 = new Prestamo("D002","15/04/2024","25/04/2024",usuario,bibliotecario,libro1);
        biblioteca.agregarPrestamo(prestamo1);
        assertTrue(biblioteca.verificarPrestamoExiste(prestamo1));
    }

    @Test
    void agregarPrestamo() {
        Usuario usuario = new  Usuario("luis gomez","999","alo");
        Libro libro1 = new LibroFisico("1","El principito"," Antoine de Saint-Exupéry","Fantasía","1943","300","qwerty","seccion2");
        Bibliotecario bibliotecario = new Bibliotecario("Bib", "333", "bibpass", "credBib");
        Prestamo prestamo1 = new Prestamo("D002","15/04/2024","25/04/2024",usuario,bibliotecario,libro1);
        boolean resultado = biblioteca.agregarPrestamo(prestamo1);
        assertTrue(resultado);
    }

    @Test
    void eliminarPrestamo() {
        boolean resultado = biblioteca.eliminarPrestamo("P001");
        assertTrue(resultado);
    }

    @Test
    void actualizarPrestamo() {
        Usuario usuario = new  Usuario("luis gomez","999","alo");
        Libro libro1 = new LibroFisico("1","El principito"," Antoine de Saint-Exupéry","Fantasía","1943","300","qwerty","seccion2");
        Bibliotecario bibliotecario = new Bibliotecario("Bib", "333", "bibpass", "credBib");
        Prestamo prestamo2 = new Prestamo("D002","15/04/2024","25/04/2024",usuario,bibliotecario,libro1);
        boolean resultado = biblioteca.actualizarPrestamo("P001",prestamo2);
        assertTrue(resultado, "La devolución con ID D001 debería actualizarse correctamente.");
    }

    @Test
    void mostrarPrestamo() {
        Prestamo prestamo = biblioteca.mostrarPrestamo("P001");
        assertNotNull(prestamo);
        assertEquals("P001", prestamo.getId());
    }

    @Test
    void verificarLibroExiste() {
        Libro libro1 = new LibroFisico("1","El principito"," Antoine de Saint-Exupéry","Fantasía","1943","300","qwerty","seccion2");
        assertTrue(biblioteca.verificarLibroExiste(libro1));

    }

    @Test
    void agregarLibro() {
        Libro libro2 = new LibroFisico("2", "Don Quijote de La Mancha"," Miguel de Cervantes Saavedra","Aventura","1605","600","poiu","seccion1");
        boolean resultado = biblioteca.agregarLibro(libro2);
        assertTrue(resultado);
    }

    @Test
    void eliminarLibro() {
        boolean resultado = biblioteca.eliminarLibro("1");
        assertTrue(resultado);
    }

    @Test
    void actualizarLibro() {
        Libro libro2 = new LibroFisico("2", "Don Quijote de La Mancha"," Miguel de Cervantes Saavedra","Aventura","1605","600","poiu","seccion1");
        boolean resultado = biblioteca.actualizarLibro("1",libro2);
        assertTrue(resultado);
    }

    @Test
    void mostrarLibro() {
        Libro libro = biblioteca.mostrarLibro("1");
        assertNotNull(libro);
        assertEquals("1",libro.getCodigo());
    }

    @Test
    void verificarLibroPrestadoExiste() {
        Libro libro4 = new LibroFisico("4","El señor de los anillos","J. R. R. Tolkien","Novela","1954","800","George Allen & Unwin HarperCollins","seccion4");
        assertTrue(biblioteca.verificarLibroPrestadoExiste(libro4));
    }

    @Test
    void agregarLibroPrestado() {
        Libro libroFisico= new LibroFisico("55","El señor de los anillos","J. R. R. Tolkien","Novela","1954","800","George Allen & Unwin HarperCollins","seccion4");
        boolean resultado = biblioteca.agregarLibroPrestado(libroFisico);
        assertTrue(resultado);
    }

    @Test
    void eliminarLibroPrestado() {
        boolean resultado = biblioteca.eliminarLibroPrestado("4");
        assertTrue(resultado);
    }

    @Test
    void verificarUsuarioEnMoraExiste() {
        Estudiante estudiante1 = new Estudiante("Juan Pérez", "112", "clave123");
        biblioteca.getListUsuariosEnMora().add(estudiante1);
        assertTrue(biblioteca.verificarUsuarioEnMoraExiste(estudiante1));
    }

    @Test
    void agregarUsuarioEnMora() {
        Estudiante estudiante1 = new Estudiante("Juan Pérez", "112", "clave123");
        boolean resultado = biblioteca.agregarUsuarioEnMora(estudiante1);
        assertTrue(resultado);
    }

    @Test
    void eliminarUsuarioEnMora() {
        Estudiante estudiante1 = new Estudiante("Juan Pérez", "112", "clave123");
        biblioteca.getListUsuariosEnMora().add(estudiante1);
        boolean resultado = biblioteca.eliminarUsuarioEnMora("112");

        assertTrue(resultado);
    }

    @Test
    void libroDisponible() {
        boolean libro = biblioteca.libroDisponible("1");
        assertTrue(libro);
    }


    @Test
    void agregarSolicitudPrestamo() {
        Estudiante estudiante = new Estudiante("Juan Pérez", "111", "clave123");
        LibroFisico libro1 = new LibroFisico("1","El principito"," Antoine de Saint-Exupéry","Fantasía","1943","300","qwerty","seccion2");
        SolicitudPrestamo soli = new SolicitudPrestamo("1",estudiante,libro1,TiempoPrestamo.MISMO_DIA);
        biblioteca.agregarSolicitudPrestamo(soli);
        List<SolicitudPrestamo> lista = biblioteca.getListSolicitudPrestamos();
        assertEquals(1, lista.size());
        assertEquals("1", lista.get(0).getId());


    }
}