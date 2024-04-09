
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import org.itson.dao.BibliotecarioDAO;
import org.itson.dominio.Bibliotecario;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

//@ExtendWith(MockitoExtension.class) // Si estás utilizando JUnit 5.7 o posterior, puedes usar esta anotación
public class BibliotecarioDAOTest {

    @Mock
    private EntityManager em;

    @Mock
    private EntityTransaction transaction;

    @InjectMocks
    private BibliotecarioDAO bibliotecarioDAO;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testInsert() throws Exception {
        // Arrange
        Bibliotecario bibliotecario = new Bibliotecario();
        when(em.getTransaction()).thenReturn(transaction);

        // Act
        boolean result = bibliotecarioDAO.insert(bibliotecario);

        // Assert
        assertTrue(result);
        verify(em, times(1)).persist(bibliotecario);
        verify(transaction, times(1)).begin();
        verify(transaction, times(1)).commit();
    }

    @Test
    public void testUpdate() throws Exception {
        // Arrange
        Bibliotecario bibliotecario = new Bibliotecario();
        bibliotecario.setNombre("Juan");
        bibliotecario.setContrasena("123");
        when(em.getTransaction()).thenReturn(transaction);

        // Act
        Bibliotecario result = bibliotecarioDAO.update(bibliotecario);

        // Assert
        assertNotNull(result);
        assertEquals("Juan", result.getNombre());
        assertEquals("123", result.getContrasena());
        verify(em, times(1)).merge(bibliotecario);
        verify(transaction, times(1)).begin();
        verify(transaction, times(1)).commit();
    }

    @Test
    public void testDelete() throws Exception {
        // Arrange
        Bibliotecario bibliotecario = new Bibliotecario();
        when(em.getTransaction()).thenReturn(transaction);

        // Act
        boolean result = bibliotecarioDAO.delete(bibliotecario);

        // Assert
        assertTrue(result);
        verify(em, times(1)).remove(bibliotecario);
        verify(transaction, times(1)).begin();
        verify(transaction, times(1)).commit();
    }

    @Test
    public void testGetBibliotecarioByName() throws Exception {
        // Arrange
        String nombre = "Juan";
        TypedQuery<Bibliotecario> query = mock(TypedQuery.class);
        when(em.createQuery(anyString(), eq(Bibliotecario.class))).thenReturn(query);
        when(query.setParameter(anyString(), anyString())).thenReturn(query);

        // Act
        Bibliotecario result = bibliotecarioDAO.getBibliotecarioByName(nombre);

        // Assert
        assertNotNull(result);
        verify(query, times(1)).getSingleResult();
    }

    @Test
    public void testGetAll() throws Exception {
        // Arrange
        TypedQuery<Bibliotecario> query = mock(TypedQuery.class);
        when(em.createQuery(anyString(), eq(Bibliotecario.class))).thenReturn(query);

        // Act
        bibliotecarioDAO.getAll();

        // Assert
        verify(query, times(1)).getResultList();
    }

}
