package co.edu.uniquindio.poo.biblioteca.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class BibliotecarioTest {
    private Bibliotecario bibliotecario;




    @BeforeEach
    public void setUp() {
        bibliotecario = new Bibliotecario("pablo","145","bib1", "bibcred");
        Biblioteca biblioteca = new Biblioteca("Mi Biblioteca", "001");
        Estudiante estudiante = new Estudiante("luis","999","alo");
        Libro libro1 = new LibroFisico("1","El principito"," Antoine de Saint-Exupéry","Fantasía","1943","300","qwerty","seccion2");

        bibliotecario.agregarEstudiante(biblioteca,estudiante);
        bibliotecario.agregarLibro(biblioteca,libro1);


    }

    @Test
    void agregarEstudiante() {
        Biblioteca biblioteca = new Biblioteca("Mi Biblioteca", "001");
        Bibliotecario bibliotecario = new Bibliotecario("Ana", "123", "clave", "credencial");
        Estudiante estudiante = new Estudiante("luis", "999", "alo");
        boolean resultado = bibliotecario.agregarEstudiante(biblioteca,estudiante);
        assertTrue(resultado);
    }


    @Test
    void eliminarEstudiante() {
        Biblioteca biblioteca = new Biblioteca("Mi Biblioteca", "001");
        Estudiante estudiante = new Estudiante("luis","999","alo");
        biblioteca.agregarUsuario(estudiante);
        bibliotecario = new Bibliotecario("pablo","145","bib1", "bibcred");
        boolean resultado = bibliotecario.eliminarEstudiante(biblioteca, "999");
        assertTrue(resultado);
    }

    @Test
    void actualizarEstudiante() {
        Biblioteca biblioteca = new Biblioteca("Mi Biblioteca", "001");
        Estudiante estudiante = new Estudiante("luis","999","alo");
        biblioteca.agregarUsuario(estudiante);
        bibliotecario = new Bibliotecario("pablo","145","bib1", "bibcred");
        Estudiante actualizado = new Estudiante("miguelillo","999","alo");
        boolean resultado = bibliotecario.actualizarEstudiante(biblioteca,"999",actualizado);
        assertTrue(resultado);
        assertEquals("miguelillo",biblioteca.mostrarUsuario("999").getNombre());

    }

    @Test
    void mostrarEstudiante() {
        Biblioteca biblioteca = new Biblioteca("Mi Biblioteca", "001");
        Estudiante estudiante = new Estudiante("luis","999","alo");
        biblioteca.agregarUsuario(estudiante);
        bibliotecario = new Bibliotecario("pablo","145","bib1", "bibcred");
        Estudiante estudiante1 = bibliotecario.mostrarEstudiante(biblioteca,"999");
        assertNotNull(estudiante1);
        assertEquals("999",estudiante.getNumeroIdentificacion());

    }

    @Test
    void agregarDocente() {
        Biblioteca biblioteca = new Biblioteca("Mi Biblioteca", "001");
        Docente docente = new Docente("Raul","888","profe1");
        boolean resultado = bibliotecario.agregarDocente(biblioteca,docente);
        assertTrue(resultado);
    }

    @Test
    void eliminarDocente() {
        Biblioteca biblioteca = new Biblioteca("Mi Biblioteca", "001");
        Docente docente = new Docente("Raul","888","profe1");
        biblioteca.agregarUsuario(docente);
        bibliotecario = new Bibliotecario("pablo","145","bib1", "bibcred");
        boolean resultado = bibliotecario.eliminarDocente(biblioteca,"888");
        assertTrue(resultado);
    }

    @Test
    void actualizarDocente() {
        Biblioteca biblioteca = new Biblioteca("Mi Biblioteca", "001");
        Docente docente = new Docente("Raul","888","profe1");
        biblioteca.agregarUsuario(docente);
        bibliotecario = new Bibliotecario("pablo","145","bib1", "bibcred");
        Docente actualizado = new Docente("yul","888","profe1");
        boolean resultado = bibliotecario.actualizarDocente(biblioteca,"888",actualizado);
        assertTrue(resultado);
        assertEquals("888",actualizado.getNumeroIdentificacion());

    }

    @Test
    void mostrarDocente() {
        Biblioteca biblioteca = new Biblioteca("Mi Biblioteca", "001");
        Docente docente = new Docente("Raul","888","profe1");
        biblioteca.agregarUsuario(docente);
        bibliotecario = new Bibliotecario("pablo","145","bib1", "bibcred");
        Docente docente1 = bibliotecario.mostrarDocente(biblioteca,"888");
        assertNotNull(docente1);
        assertEquals("888",docente1.getNumeroIdentificacion());
    }

    @Test
    void agregarVisitante() {
        Biblioteca biblioteca = new Biblioteca("Mi Biblioteca", "001");
        Visitante visitante = new Visitante("alejo","777","visit1");
        boolean resultado = bibliotecario.agregarVisitante(biblioteca,visitante);
        assertTrue(resultado);
    }

    @Test
    void eliminarVisitante() {
        Biblioteca biblioteca = new Biblioteca("Mi Biblioteca", "001");
        Visitante visitante = new Visitante("alejo","777","visit1");
        biblioteca.agregarUsuario(visitante);
        bibliotecario = new Bibliotecario("pablo","145","bib1", "bibcred");
        boolean resultado = bibliotecario.eliminarVisitante(biblioteca,"777");
        assertTrue(resultado);
    }

    @Test
    void actualizarVisitante() {
        Biblioteca biblioteca = new Biblioteca("Mi Biblioteca", "001");
        Visitante visitante = new Visitante("alejo","777","visit1");
        biblioteca.agregarUsuario(visitante);
        bibliotecario = new Bibliotecario("pablo","145","bib1", "bibcred");
        Visitante actualizado = new Visitante("reppe","777","visit1");
        boolean resultado = bibliotecario.actualizarVisitante(biblioteca,"777",actualizado);
        assertTrue(resultado);
        assertEquals("777",actualizado.getNumeroIdentificacion());
    }

    @Test
    void mostrarVisitante() {
        Biblioteca biblioteca = new Biblioteca("Mi Biblioteca", "001");
        Visitante visitante = new Visitante("alejo","777","visit1");
        biblioteca.agregarUsuario(visitante);
        bibliotecario = new Bibliotecario("pablo","145","bib1", "bibcred");
        Visitante visitante1 = bibliotecario.mostrarVisitante(biblioteca,"777");
        assertNotNull(visitante1);
        assertEquals("777",visitante1.getNumeroIdentificacion());
    }

    @Test
    void agregarLibro() {
        Biblioteca biblioteca = new Biblioteca("Mi Biblioteca", "001");
        Libro libro = new LibroFisico("2","El principito"," Antoine de Saint-Exupéry","Fantasía","1943","300","qwerty","seccion2");
        boolean resultado = bibliotecario.agregarLibro(biblioteca,libro);
        assertTrue(resultado);

    }

    @Test
    void eliminarLibro() {
        Biblioteca biblioteca = new Biblioteca("Mi Biblioteca", "001");
        Libro libro = new LibroFisico("2","El principito"," Antoine de Saint-Exupéry","Fantasía","1943","300","qwerty","seccion2");
        biblioteca.agregarLibro(libro);
        bibliotecario = new Bibliotecario("pablo","145","bib1", "bibcred");
        boolean resultado = bibliotecario.eliminarLibro(biblioteca,"2");
        assertTrue(resultado);

    }

    @Test
    void actualizarLibro() {
        Biblioteca biblioteca = new Biblioteca("Mi Biblioteca", "001");
        Libro libro = new LibroFisico("2","El principito"," Antoine de Saint-Exupéry","Fantasía","1943","300","qwerty","seccion2");
        biblioteca.agregarLibro(libro);
        bibliotecario = new Bibliotecario("pablo","145","bib1", "bibcred");
        Libro actualizado = new LibroFisico("2", "metamorfosis", "Antoine de Saint-Exupéry", "Fantasía", "1943", "300", "qwerty", "seccion2");
        boolean resultado = bibliotecario.actualizarLibro(biblioteca,"2",actualizado);
        assertTrue(resultado);
        assertEquals("2",actualizado.getCodigo());
    }

    @Test
    void mostrarLibro() {
        Biblioteca biblioteca = new Biblioteca("Mi Biblioteca", "001");
        Libro libro = new LibroFisico("2","El principito"," Antoine de Saint-Exupéry","Fantasía","1943","300","qwerty","seccion2");
        biblioteca.agregarLibro(libro);
        bibliotecario = new Bibliotecario("pablo","145","bib1", "bibcred");
        Libro libro1 = bibliotecario.mostrarLibro(biblioteca,"2");
        assertNotNull(libro1);
        assertEquals("2",libro1.getCodigo());
    }

    @Test
    void posibilidadPrestamoEstudiante() {
        Biblioteca biblioteca = new Biblioteca("Mi Biblioteca", "001");
        Estudiante estudiante = new Estudiante("luis","999","alo");
        estudiante.setCantidadlibrosPrestados(3); // menos de 5
        biblioteca.agregarUsuario(estudiante);
        Bibliotecario bibliotecario = new Bibliotecario("pablo", "145", "bib1", "bibcred");
        boolean resultado = bibliotecario.posibilidadPrestamoEstudiante(biblioteca, "999");

        assertTrue(resultado);
    }

    @Test
    void posibilidadPrestamoDocente() {
        Biblioteca biblioteca = new Biblioteca("Mi Biblioteca", "001");
        Docente docente = new Docente("Raul","888","profe1");
        biblioteca.agregarUsuario(docente);
        Bibliotecario bibliotecario = new Bibliotecario("pablo", "145", "bib1", "bibcred");
        boolean resultado = bibliotecario.posibilidadPrestamoDocente(biblioteca, "888");
        assertTrue(resultado);

    }

    @Test
    void validarPrestamo() {
        Biblioteca biblioteca = new Biblioteca("Mi Biblioteca", "001");
        Estudiante estudiante = new Estudiante("luis","999","alo");
        estudiante.setCantidadlibrosPrestados(3);
        biblioteca.agregarUsuario(estudiante);
        Bibliotecario bibliotecario = new Bibliotecario("pablo", "145", "bib1", "bibcred");
        boolean resultado = bibliotecario.validarPrestamo(biblioteca,estudiante);
        assertTrue(resultado);

    }

    @Test
    void asignarId() {
        Bibliotecario bibliotecario = new Bibliotecario("pablo", "145", "bib1", "bibcred");
        String idGenerado = bibliotecario.asignarId();

        assertNotNull(idGenerado);
        assertFalse(idGenerado.isEmpty());
        // Verifica que el ID tenga formato UUID válido
        assertDoesNotThrow(() -> UUID.fromString(idGenerado));

    }

    @Test
    void asignarFechaActual() {
        Bibliotecario bibliotecario = new Bibliotecario("pablo", "145", "bib1", "bibcred");
        String fechaGenerada = bibliotecario.asignarFechaActual();
        String fechaEsperada = LocalDate.now().toString();
        assertEquals(fechaEsperada, fechaGenerada);


    }

    @Test
    void asignarFechaFin() {
        Bibliotecario bibliotecario = new Bibliotecario("Ana", "123", "clave", "credencial");
        Usuario otro = new Estudiante("Carlos", "111", "clave");

        String fechaInicio = "2025-05-24";
        String fechaEsperada = LocalDate.parse(fechaInicio).plusDays(5).toString();
        String fechaFin = bibliotecario.asignarFechaFin(fechaInicio, otro);
        assertEquals(fechaEsperada, fechaFin);
    }

    @Test
    void actualizarEstadolibro() {
        Biblioteca biblioteca = new Biblioteca("Mi Biblioteca", "001");
        Libro libro = new LibroFisico("2","El principito"," Antoine de Saint-Exupéry","Fantasía","1943","300","qwerty","seccion2");
        biblioteca.agregarLibro(libro);
        Bibliotecario bibliotecario = new Bibliotecario("Ana", "123", "clave", "credencial");
        bibliotecario.actualizarlibro(biblioteca,"2",EstadoLibro.PRESTADO);
        Libro actualizado = biblioteca.mostrarLibro("2");
        assertEquals(EstadoLibro.PRESTADO,actualizado.getEstado());

    }

    @Test
    void tieneDeuda() {
        Biblioteca biblioteca = new Biblioteca("Mi Biblioteca", "001");
        Usuario otro = new Estudiante("Carlos", "111", "clave");
        Libro libro = new LibroFisico("2","El principito"," Antoine de Saint-Exupéry","Fantasía","1943","300","qwerty","seccion2");
        String fechaInicio = LocalDate.now().minusDays(10).toString();
        String fechaFin = LocalDate.now().minusDays(2).toString(); // vencida

        Prestamo prestamo1 = new Prestamo("P001",fechaInicio,fechaFin,otro,bibliotecario,libro);
        biblioteca.agregarPrestamo(prestamo1);

        Bibliotecario biblio = new Bibliotecario("Luis", "456", "pass", "cred");

        assertTrue(biblio.tieneDeuda(biblioteca, otro));


    }

    @Test
    void actualizarEstadoUsuario() {
        Biblioteca biblioteca = new Biblioteca("Mi Biblioteca", "001");
        Estudiante otro = new Estudiante("Carlos", "111", "clave");
        biblioteca.agregarUsuario(otro);
        Bibliotecario bibliotecario = new Bibliotecario("Ana", "123", "clave", "credencial");
        bibliotecario.actualizarEstadoUsuario(biblioteca,otro,true );
        Estudiante actualizado = (Estudiante) biblioteca.mostrarUsuario("111");
        assertEquals(EstadoUsuario.EN_MORA,actualizado.getEstadoUsuario());
    }

    @Test
    void crearPrestamo() {
        Biblioteca biblioteca = new Biblioteca("Mi Biblioteca", "001");
        Estudiante estudiante = new Estudiante("luis","999","alo");
        estudiante.setCantidadlibrosPrestados(3);
        biblioteca.agregarUsuario(estudiante);
        Libro libro = new LibroFisico("2","El principito"," Antoine de Saint-Exupéry","Fantasía","1943","300","qwerty","seccion2");
        biblioteca.agregarLibro(libro);
        Bibliotecario bibliotecario = new Bibliotecario("Ana", "123", "clave", "credencial");
        boolean resultado = bibliotecario.crearPrestamo(biblioteca,estudiante,libro);
        assertTrue(resultado);

    }

    @Test
    void verificarprestamoActivo() {
        Biblioteca biblioteca = new Biblioteca("Mi Biblioteca", "001");
        Estudiante estudiante = new Estudiante("luis", "999", "alo");
        estudiante.setCantidadlibrosPrestados(3);
        biblioteca.agregarUsuario(estudiante);
        Libro libro = new LibroFisico("2", "El principito", "Antoine de Saint-Exupéry", "Fantasía", "1943", "300", "qwerty", "seccion2");
        biblioteca.agregarLibro(libro);
        Bibliotecario bibliotecario = new Bibliotecario("Ana", "123", "clave", "credencial");
        Prestamo prestamo = new Prestamo("P1", "2023-05-10", "2023-05-20", estudiante, bibliotecario, libro);
        biblioteca.agregarPrestamo(prestamo);
        biblioteca.agregarLibroPrestado(libro);

        libro.setEstado(EstadoLibro.PRESTADO);
        biblioteca.actualizarLibro(libro.getCodigo(), libro);
        boolean resultado = bibliotecario.crearDevolucion(biblioteca, estudiante, libro, "Buen estado");

        assertTrue(resultado);

    }

    @Test
    void crearDevolucion() {
        Biblioteca biblioteca = new Biblioteca("Mi Biblioteca", "001");
        Estudiante estudiante = new Estudiante("luis","999","alo");
        estudiante.setCantidadlibrosPrestados(3);
        biblioteca.agregarUsuario(estudiante);
        Libro libro = new LibroFisico("2","El principito"," Antoine de Saint-Exupéry","Fantasía","1943","300","qwerty","seccion2");
        biblioteca.agregarLibro(libro);
        Bibliotecario bibliotecario = new Bibliotecario("Ana", "123", "clave", "credencial");
        Prestamo prestamo = new Prestamo("P1", "2023-05-10", "2023-05-20", estudiante, bibliotecario, libro);
        biblioteca.agregarPrestamo(prestamo);
        biblioteca.agregarLibroPrestado(libro);
        libro.setEstado(EstadoLibro.PRESTADO);
        boolean resultado = bibliotecario.crearDevolucion(biblioteca, estudiante, libro, "Buen estado");
        assertTrue(resultado);

    }

    @Test
    void libroMasPrestado() {
        Biblioteca biblioteca = new Biblioteca("Mi Biblioteca", "001");
        Libro libro1 = new LibroFisico("1","El principito"," Antoine de Saint-Exupéry","Fantasía","1943","300","qwerty","seccion2");
        Libro libro4 = new LibroFisico("4","El señor de los anillos","J. R. R. Tolkien","Novela","1954","800","George Allen & Unwin HarperCollins","seccion4");
        libro4.setCantidadVecesPrestado(5);
        libro1.setCantidadVecesPrestado(10);
        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro4);
        Bibliotecario bibliotecario = new Bibliotecario("Ana", "123", "clave", "credencial");
        assertEquals(libro1, bibliotecario.libroMasPrestado(biblioteca));

    }

    @Test
    void crearReporte() {
        Biblioteca biblioteca = new Biblioteca("Mi Biblioteca", "001");
        Libro libro1 = new LibroFisico("1","El principito"," Antoine de Saint-Exupéry","Fantasía","1943","300","qwerty","seccion2");
        libro1.setCantidadVecesPrestado(5);
        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibroPrestado(libro1);
        Estudiante estudiante = new Estudiante("luis","999","alo");
        biblioteca.agregarUsuarioEnMora(estudiante);

        Bibliotecario bibliotecario = new Bibliotecario("Ana", "123", "clave", "credencial");

        String report = bibliotecario.crearReporte(biblioteca);
        assertTrue(report.contains("El principito"));

    }
}