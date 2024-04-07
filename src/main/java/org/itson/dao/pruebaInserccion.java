/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.itson.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.itson.dominio.Usuario;
import org.itson.dao.UsuarioDAO;
import org.itson.dominio.Bibliotecario;
import org.itson.dominio.EstadoLibro;
import org.itson.dominio.EstadoPrestamo;
import org.itson.dominio.Libro;
import org.itson.dominio.Prestamo;
import org.itson.interfaces.IUsuario;
import org.itson.negocio.UsuarioNegocio;

/**
 *
 * @author marco
 */
public class pruebaInserccion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        EntityManagerFactory emf =Conexion.getConexion();
        EntityManager em = emf.createEntityManager();

    }

    public static void test1() {

        EntityManagerFactory emf = Conexion.getConexion();
        EntityManager em = emf.createEntityManager();
        Usuario usuarioPrueba = new Usuario("jayson tatum", "boston");

        UsuarioNegocio un = new UsuarioNegocio();

        try {
            un.registrarUsuario(usuarioPrueba);
        } catch (Exception ex) {
            Logger.getLogger(pruebaInserccion.class.getName()).log(Level.SEVERE, null, ex);
        }

        Bibliotecario bibliotecario = new Bibliotecario("Nombre", "Contraseña xd");
        em.getTransaction().begin();
        em.persist(bibliotecario);
        em.getTransaction().commit();

        Libro libro = new Libro("ISBN", "Titulo", "Autor", EstadoLibro.DISPONIBLE);
        em.getTransaction().begin();
        em.persist(libro);
        em.getTransaction().commit();

        Libro libro2 = new Libro("ISBN2", "Titulo2", "Autor2", EstadoLibro.DISPONIBLE);
        em.getTransaction().begin();
        em.persist(libro2);
        em.getTransaction().commit();

        List libros = new ArrayList<Libro>();
        libros.add(libro);
        libros.add(libro2);

        Prestamo prestamo = new Prestamo(libros, usuarioPrueba, EstadoPrestamo.DEVUELTO);
        em.getTransaction().begin();
        em.persist(prestamo);
        em.getTransaction().commit();

        Libro libro3 = new Libro("ISBN3", "Titulo3", "Autor3", EstadoLibro.DISPONIBLE);
        em.getTransaction().begin();
        em.persist(libro3);
        em.getTransaction().commit();

        Libro libro4 = new Libro("ISBN4", "Titulo4", "Autor4", EstadoLibro.DISPONIBLE);
        em.getTransaction().begin();
        em.persist(libro4);
        em.getTransaction().commit();

        List libros2 = new ArrayList<Libro>();
        libros.add(libro3);
        libros.add(libro4);

        Prestamo prestamo2 = new Prestamo(libros2, usuarioPrueba, EstadoPrestamo.DEVUELTO);
        em.getTransaction().begin();
        em.persist(prestamo2);
        em.getTransaction().commit();

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuarioTest = new Usuario("Add test", "Add test");

        try {
            usuarioDAO.insert(usuarioTest);
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            System.out.println(usuarioDAO.getUsuarioById(2L));
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            System.out.println(usuarioDAO.getUsuarioByName("jayson tatum"));
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            System.out.println(usuarioDAO.getAll());
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            usuarioPrueba.setNombre("Update Test");
            usuarioDAO.update(usuarioPrueba);
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            usuarioDAO.delete(usuarioTest);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
