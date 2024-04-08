package TestsDAO;


import org.itson.dao.PrestamoDAO;
import org.itson.dominio.EstadoLibro;
import org.itson.dominio.EstadoPrestamo;
import org.itson.dominio.Libro;
import org.itson.dominio.Prestamo;
import org.itson.dominio.Usuario;
import java.util.ArrayList;
import java.util.List;
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

    @Test
    public void testRegistrarPrestamo() throws Exception {
        Usuario usuario = new Usuario("prueba", "contraseñafalsa");
        Libro libro = new Libro("abc", "librofalso", "alguien 123", EstadoLibro.NO_DISPONIBLE);
        List<Libro> libros = new ArrayList<>();
        libros.add(libro);
        Prestamo prestamo = new Prestamo(libros, usuario, EstadoPrestamo.PRESTADO);
        PrestamoDAO prestamoDAO = new PrestamoDAO();
        Boolean resultado = prestamoDAO.insert(prestamo);
        assertEquals(true, resultado);
    }
    
    @Test
    public void testLiberarPrestamo() throws Exception{
        Usuario usuario = new Usuario("prueba", "contraseñafalsa");
        Libro libro = new Libro("abc", "librofalso", "alguien 123", EstadoLibro.DISPONIBLE);
        List<Libro> libros = new ArrayList<>();
        libros.add(libro);
        Prestamo prestamo = new Prestamo(libros, usuario, EstadoPrestamo.DEVUELTO);
        PrestamoDAO prestamoDAO = new PrestamoDAO();
        Prestamo prestamoLiberado = prestamoDAO.update(prestamo);
        assertEquals(EstadoPrestamo.DEVUELTO, prestamoLiberado.getEstado());
    }
}
