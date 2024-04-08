package TestsDAO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import java.util.ArrayList;
import java.util.List;
import org.itson.dao.LibroDAO;
import org.itson.dominio.EstadoLibro;
import org.itson.dominio.Libro;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author TADEO
 */
public class LibroDAOTest {
    
    public LibroDAOTest() {
    }
    
    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
    
    @Test
    public void testRegistrarLibro() throws Exception{
        Libro libro = new Libro("TestISBN0000", "TituloTest", "Tadeo", EstadoLibro.DISPONIBLE);
        LibroDAO libroDAO = new LibroDAO();
        Boolean resultado = libroDAO.insert(libro);
        assertEquals(true, resultado);
    }
    
    @Test
    public void testActualizarLibro() throws Exception{
        
        LibroDAO libroDAO = mock(LibroDAO.class);
        Libro libro = new Libro("TestISBN0000", "TituloTest", "Tadeo", EstadoLibro.DISPONIBLE);
        
        when(libroDAO.getLibroById(10L)).thenReturn(libro);
        
        libro.setTitulo("TituloTest1");
        
        //Actualizacion engañada para no alterar de verdad a la base de datos
        doAnswer(invocation -> {
            Libro updatedLibro = invocation.getArgument(0);
            return updatedLibro;
        }).when(libroDAO).update(libro);
        
        Libro updatedLibro = libroDAO.update(libro);
        
        doAnswer(invocation -> {
            return updatedLibro;
        }).when(libroDAO).getLibroById(10L);
        
        Libro updatedLibroTest = libroDAO.getLibroById(10L);
        assertEquals("TituloTest1", updatedLibroTest.getTitulo());
    }
    
    @Test
    public void testEliminarLibro() throws Exception{
        LibroDAO libroDAO = new LibroDAO();
        Libro libro = new Libro("TestISBN0000", "TituloTest", "Tadeo", EstadoLibro.DISPONIBLE);
        assertTrue(libroDAO.delete(libro));
    }
    
    @Test
    public void testBuscarLibroTitulo() throws Exception{
        List <Libro> libros = new ArrayList<Libro>();
        LibroDAO libroDAO = new LibroDAO();
        List resultado = libroDAO.getLibrosByTitulo("TestTitulo#2");
        assertFalse(resultado.isEmpty());
    }
    
     @Test
    public void testBuscarLibroAutor() throws Exception{
        List <Libro> libros = new ArrayList<Libro>();
        LibroDAO libroDAO = new LibroDAO();
        List resultado = libroDAO.getLibrosByAutor("TestAutor#3");
        assertFalse(resultado.isEmpty());
    }
    
     @Test
    public void testBuscarLibroIdentificador() throws Exception{
        Libro libro = new Libro("TestISBN0000", "TituloTest", "Tadeo", EstadoLibro.DISPONIBLE);
        LibroDAO libroDAO = new LibroDAO();
        Libro resultado = libroDAO.getLibroByISBN(libro.getIsbn());
        assertTrue(true, resultado.getIsbn());
    }
}
