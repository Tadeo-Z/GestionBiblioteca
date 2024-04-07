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
    
    @Test
    public void testRegistrarLibro() throws Exception{
        Libro libro = new Libro();
        LibroDAO libroDAO = new LibroDAO();
        Boolean resultado = libroDAO.insert(libro);
        assertEquals(true, resultado);
    }
    
    @Test
    public void testActualizarLibro() throws Exception{
        Libro libro = new Libro();
        LibroDAO libroDAO = new LibroDAO();
        libroDAO.insert(libro);
        Boolean resultado = libroDAO.insert(libro);
        assertEquals(true, resultado);
    }
    
    @Test
    public void testEliminarLibro() throws Exception{
        Libro libro = new Libro();
        LibroDAO libroDAO = new LibroDAO();
        libroDAO.insert(libro);
        Boolean resultado = libroDAO.delete(libro);
        assertEquals(true, resultado);
    }
    
    @Test
    public void testBuscarLibroTitulo() throws Exception{
        Libro libro = new Libro();
        LibroDAO libroDAO = new LibroDAO();
        Libro resultado = libroDAO.getLibroByTitulo(libro.getTitulo());
        assertEquals(true, resultado);
    }
    
     @Test
    public void testBuscarLibroAutor() throws Exception{
        Libro libro = new Libro();
        LibroDAO libroDAO = new LibroDAO();
        Libro resultado = libroDAO.getLibroByAutor(libro.getAutor());
        assertEquals(true, resultado);
    }
    
     @Test
    public void testBuscarLibroIdentificador() throws Exception{
        Libro libro = new Libro();
        LibroDAO libroDAO = new LibroDAO();
        Libro resultado = libroDAO.getLibroByISBN(libro.getIsbn());
        assertEquals(true, resultado);
    }
}
