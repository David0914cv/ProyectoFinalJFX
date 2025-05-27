package co.edu.uniquindio.poo.biblioteca.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AdministradorTest {
    private Administrador administrador;

    @BeforeEach
    void setUp() throws Exception {
        Biblioteca biblioteca = new Biblioteca("Mi Biblioteca", "001");
        administrador = new Administrador("luis","123","contra","admin1");
        Bibliotecario bib = new Bibliotecario("miguel","456","contra2","bib1");

    }

    @Test
    void agregarBibliotecario() {
        Biblioteca biblioteca = new Biblioteca("Mi Biblioteca", "001");
        Bibliotecario bib = new Bibliotecario("miguel","456","contra2","bib1");
        boolean resultado = administrador.agregarBibliotecario(biblioteca,bib);
        assertTrue(resultado);
    }

    @Test
    void eliminarBibliotecario() {
        Biblioteca biblioteca = new Biblioteca("Mi Biblioteca", "001");
        Bibliotecario bib = new Bibliotecario("miguel", "456", "contra2", "credBib");
        biblioteca.agregarUsuario(bib);
        Administrador admin = new Administrador("Luis", "123", "contra", "admin1");
        boolean resultado = admin.eliminarBibliotecario(biblioteca, "456");
        assertTrue(resultado);
    }

    @Test
    void actualizarBibliotecario() {
        Biblioteca biblioteca = new Biblioteca("Mi Biblioteca", "001");
        Bibliotecario bib = new Bibliotecario("miguel", "456", "contra2", "credBib");
        biblioteca.agregarUsuario(bib);
        Administrador admin = new Administrador("Luis", "456", "adminpass", "admin1");
        Bibliotecario actualizado = new Bibliotecario("Laura", "456", "nuevaPass", "credencialNueva");
        boolean resultado = admin.actualizarBibliotecario(biblioteca, "456", actualizado);
        assertTrue(resultado);
        assertEquals("Laura", biblioteca.mostrarUsuario("456").getNombre());
    }

    @Test
    void mostrarBibliotecario() {
        Biblioteca biblioteca = new Biblioteca("Mi Biblioteca", "001");
        Bibliotecario bib = new Bibliotecario("miguel", "456", "contra2", "credBib");
        biblioteca.agregarUsuario(bib);
        Bibliotecario bibliotecario = administrador.mostrarBibliotecario(biblioteca,"456");
        assertNotNull(bibliotecario);
        assertEquals("456", bibliotecario.getNumeroIdentificacion());
    }
}