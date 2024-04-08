package TestsDAO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.itson.dao.PrestamoDAO;
import org.itson.dominio.Libro;
import org.itson.dominio.Prestamo;
import org.itson.dominio.Usuario;
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
public class PrestamoDAOTest {

    public PrestamoDAOTest() {
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
    public void testRegistrarPrestamo() throws Exception {
        Usuario usuario = new Usuario();
        Libro libro = new Libro();
        Prestamo prestamo = new Prestamo();
        PrestamoDAO prestamoDAO = new PrestamoDAO();
        Boolean resultado = prestamoDAO.insert(prestamo);
        assertEquals(true, resultado);
    }
    
//    public void testLiberarPrestamo(){
//        Usuario usuario = new Usuario();
//        Libro libro = new Libro();
//        Prestamo prestamo = new Prestamo();
//        PrestamoDAO prestamoDAO = new PrestamoDAO();
//        Prestamo resultado = prestamoDAO.(prestamo);
//        assertEquals(true, resultado);
//    }
}
