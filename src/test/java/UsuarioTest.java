/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import Utilities.SesionManager;
import java.util.function.BooleanSupplier;
import org.itson.dao.UsuarioDAO;
import org.itson.dominio.Usuario;
import org.itson.interfaces.ISesionManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author TADEO
 */
public class UsuarioTest {
    
    public UsuarioTest() {
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
    
//    @BeforeAll
//    public static void setUpClass() {
//    }
//    
//    @AfterAll
//    public static void tearDownClass() {
//    }
//    
//    @BeforeEach
//    public void setUp() {
//    }
//    
//    @AfterEach
//    public void tearDown() {
//    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void testAutenticacionDeUsuariosNoRegistrados() {
        // Prueba de autenticación de usuarios
        ISesionManager sesionManager = new SesionManager();
        assertFalse(sesionManager.autenticarUsuario("usuario", "contraseña")); // Usuario no registrado
    }
    
    @Test
    public void testAutenticacionDeUsuariosRegistrados() {
        // Prueba de autenticación de usuarios
        ISesionManager sesionManager = new SesionManager();
        assertTrue(sesionManager.autenticarUsuario("usuario", "contraseña")); // Usuario registrado, Contraseña correcta
    }
    
    @Test
    public void testAutenticacionDeUsuariosErronea() {
        // Prueba de autenticación de usuarios
        ISesionManager sesionManager = new SesionManager();
        assertFalse(sesionManager.autenticarUsuario("usuario", "contraseña")); // Usuario registrado, Contraseña incorrecta
    }
        
    @Test
    public void testRegistrarUsuario() throws Exception{
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = new Usuario("Nombre","Contraseña");
        assertTrue(usuarioDAO.insert(usuario));
    }
    
    @Test
    public void testRegistrarUsuarioNull() throws Exception {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = null;
        assertFalse(usuarioDAO.insert(usuario));
    }

    @Test
    public void testActualizarUsuarioFuncional() throws Exception {

        UsuarioDAO usuarioDAO = mock(UsuarioDAO.class);

        Usuario usuario = new Usuario("TestName#1", "TestPassWord#1");

        when(usuarioDAO.getUsuarioById(1L)).thenReturn(usuario);

        usuario.setNombre("Mockito");
         
         Usuario updatedUsuario = usuarioDAO.update(usuario);
        
         doAnswer(invocation -> {

            return updatedUsuario;
            
        }).when(usuarioDAO).getUsuarioById(1L);
         
         
        Usuario updatedUsuarioTest = usuarioDAO.getUsuarioById(1L);
        assertEquals("Mockito", updatedUsuarioTest.getNombre());
    }
    
    @Test
    public void testActualizarUsuarioNull() throws Exception {

        UsuarioDAO usuarioDAO = mock(UsuarioDAO.class);

        Usuario usuario = new Usuario("TestName#2", "TestPassWord#2");

        when(usuarioDAO.getUsuarioById(2L)).thenReturn(usuario);

         
         Usuario updatedUsuario = usuarioDAO.update(null);
        
         doAnswer(invocation -> {

            return updatedUsuario;
            
        }).when(usuarioDAO).getUsuarioById(2L);
         
         
        Usuario updatedUsuarioTest = usuarioDAO.getUsuarioById(2L);
        assertNull(updatedUsuarioTest);
    }
    
    @Test
    public void testActualizarUsuarioBlank() throws Exception {

        UsuarioDAO usuarioDAO = mock(UsuarioDAO.class);

        Usuario usuario = new Usuario("TestName#3", "TestPassWord#3");
        usuario.setId(1L);

        when(usuarioDAO.getUsuarioById(3L)).thenReturn(usuario);

        usuario.setNombre("");
         
         Usuario updatedUsuario = usuarioDAO.update(usuario);
        
         doAnswer(invocation -> {

            return updatedUsuario;
            
        }).when(usuarioDAO).getUsuarioById(3L);
         
         
        Usuario updatedUsuarioTest = usuarioDAO.getUsuarioById(3L);
        assertNull(updatedUsuarioTest);
    }
}