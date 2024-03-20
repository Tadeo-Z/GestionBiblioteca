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
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
    public void testRegistrarUsuario(){
        Usuario usuario = new Usuario("Nombre","Contraseña");
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        assertTrue(usuarioDAO.registrarUsuario(usuario));
    }
    
    @Test
    public void testRegistrarUsuarioNull(){
        Usuario usuario = null;
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        assertFalse(usuarioDAO.registrarUsuario(usuario));
    }
    
    @Test
    public void testActualizarNombreUsuario(){
        Usuario usuario = new Usuario("Nombre","Contraseña");
        usuario.setNombre("New nombre");
        assertEquals(usuario.getNombre(),"New nombre");
    }
    
    @Test
    public void testActualizarPasswordUsuario(){
        Usuario usuario = new Usuario("Nombre","Contraseña");
        usuario.setContrasena("New contraseña");
        assertEquals(usuario.getNombre(),"New contraseña");
    }
    
    
}