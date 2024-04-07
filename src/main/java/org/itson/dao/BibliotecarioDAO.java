/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import org.itson.dominio.Bibliotecario;
import org.itson.dominio.Usuario;
import org.itson.interfaces.IBibliotecario;

/**
 *
 * @author HP 240 G8
 */
public class BibliotecarioDAO implements IBibliotecario {

    EntityManagerFactory emf;
    EntityManager em;

    public BibliotecarioDAO() {
        this.emf = Conexion.getConexion();
        this.em = emf.createEntityManager();
    }
    
    @Override
    public Boolean insert(Bibliotecario bibliotecario) throws Exception {
       if (bibliotecario==null){
            return false;
        }
        
        EntityTransaction transaction = null;
        try{
            transaction = em.getTransaction();            
            transaction.begin();
            em.persist(bibliotecario);
            em.getTransaction().commit();
        } catch (Exception e) {
           if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new Exception("El bibliotecario no se pudo insertar:" + e);
        }
        return true;
    }

    @Override
    public Bibliotecario update(Bibliotecario bibliotecario) throws Exception {
        if (bibliotecario == null) {
            return null;
        }

        if (bibliotecario.getNombre().isBlank() || bibliotecario.getContrasena().isBlank()) {
            return null;
        }

        EntityTransaction transaction = null;
        try {
            transaction = em.getTransaction();
            transaction.begin();
            em.merge(bibliotecario);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new Exception("El bibliotecario no se pudo actualizar:" + e);
        }
        return bibliotecario;
    }

    @Override
    public Boolean delete(Bibliotecario bibliotecario) throws Exception {
        if (bibliotecario == null) {
            return false;
        }

        EntityTransaction transaction = null;
        try {
            transaction = em.getTransaction();
            transaction.begin();
            em.remove(bibliotecario);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new Exception("El bibliotecario no se pudo eliminar:" + e);
        }
        return true;
    }

   @Override
    public Bibliotecario getBibliotecarioByName(String nombre) throws Exception {
        
        if (nombre==null || nombre.isBlank()){
            return null;
        }
        
        Bibliotecario bibliotecario;
        try {
            TypedQuery<Bibliotecario> query = em.createQuery("SELECT e FROM Bibliotecario e WHERE e.nombre = :nombre", Bibliotecario.class);
            query.setParameter("nombre", nombre);
            bibliotecario = query.getSingleResult();
        } catch (Exception e) {
            throw new Exception("La busqueda no se pudo ejecutar:" + e);
        }
        return bibliotecario;
    }

    @Override
    public List<Bibliotecario> getAll() throws Exception {
        List bibliotecarios = new ArrayList<Bibliotecario>();
        try {
            TypedQuery<Bibliotecario> query = em.createQuery("SELECT e FROM Bibliotecario e", Bibliotecario.class);
            bibliotecarios = query.getResultList();
        } catch (Exception e) {
            throw new Exception("La busqueda no se pudo ejecutar:" + e);
        }
        return bibliotecarios;
    }

    @Override
    public Bibliotecario getBibliotecarioById(Long id) throws Exception {
        
        if (id==null){
            return null;
        }
        
        Bibliotecario bibliotecario;
        try {
             bibliotecario=em.find(Bibliotecario.class, id);
        } catch (Exception e) {
            throw new Exception("La busqueda no se pudo ejecutar:" + e);
        }
        return bibliotecario;
    }
    
}
