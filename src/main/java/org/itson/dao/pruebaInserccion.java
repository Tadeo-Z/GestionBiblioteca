/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.itson.dao;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.itson.dominio.Usuario;
import org.itson.dao.UsuarioDAO;
import org.itson.dominio.Bibliotecario;
import org.itson.dominio.EstadoLibro;
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
        // TODO code application logic here
        
        EntityManagerFactory emf =Conexion.getConexion();
        EntityManager em = emf.createEntityManager();

        Usuario usuarioPrueba = new Usuario("jayson tatum", "boston");
        
        UsuarioNegocio un = new UsuarioNegocio();
        
        
        if(un.registrarUsuario(usuarioPrueba)){
            System.out.println("registrado exitosamente");
        }else{
            System.out.println("no se pudo");
        }
        
        Bibliotecario bibliotecario = new Bibliotecario("Nombre", "Contraseña xd");
        em.getTransaction().begin();
        em.persist(bibliotecario);
        em.getTransaction().commit();
        
        Libro libro = new Libro("ISBN", "Titulo","Autor", EstadoLibro.DISPONIBLE);
        em.getTransaction().begin();
        em.persist(libro);
        em.getTransaction().commit();
        
        Libro libro2 = new Libro("ISBN2", "Titulo2","Autor2", EstadoLibro.DISPONIBLE);
        em.getTransaction().begin();
        em.persist(libro2);
        em.getTransaction().commit();
        
        List libros = new ArrayList<Libro>();
        libros.add(libro);
        libros.add(libro2);
        
        Prestamo prestamo = new Prestamo(libros, usuarioPrueba);
        em.getTransaction().begin();
        em.persist(prestamo);
        em.getTransaction().commit();
    }
    
}
