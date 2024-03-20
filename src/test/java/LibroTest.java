/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.itson.dao.LibroDAO;
import org.itson.dominio.Libro;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 *
 * @author TADEO
 */
public class LibroTest {
    
    public LibroTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void testRegistrarLibro(){
        Libro libro = new Libro();
        LibroDAO libroDAO = new LibroDAO();
        Libro resultado = libroDAO.registrarLibro(libro);
        assertEquals(true, resultado);
    }
    
    @Test
    public void testActualizarLibro(){
        Libro libro = new Libro();
        LibroDAO libroDAO = new LibroDAO();
        libroDAO.registrarLibro(libro);
        Libro resultado = libroDAO.actualizarLibro(libro);
        assertEquals(true, resultado);
    }
    
    @Test
    public void testEliminarLibro(){
        Libro libro = new Libro();
        LibroDAO libroDAO = new LibroDAO();
        libroDAO.registrarLibro(libro);
        Libro resultado = libroDAO.eliminarLibro(libro);
        assertEquals(true, resultado);
    }
}
