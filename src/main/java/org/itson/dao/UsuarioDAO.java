/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dao;

import Exceptions.DAOException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import org.itson.dominio.Libro;
import org.itson.dominio.Usuario;
import org.itson.interfaces.IUsuario;

/**
 *
 * @author TADEO
 */
public class UsuarioDAO implements IUsuario{

    EntityManagerFactory emf;
    EntityManager em;


    public UsuarioDAO() {
        this.emf = Conexion.getConexion();
        this.em = emf.createEntityManager();
    }
    
    @Override
    public Boolean insert(Usuario usuario) throws Exception {
        
        if (usuario==null){
            return false;
        }
        
        if (usuario.getNombre().isBlank()||usuario.getContrasena().isBlank()){
            return false;
        } 
        
        EntityTransaction transaction = null;
        try{
            transaction = em.getTransaction();            
            transaction.begin();
            em.persist(usuario);
            em.getTransaction().commit();
        } catch (Exception e) {
           if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new Exception("El usuario no se pudo insertar:" + e);
        }
        return true;
    }


    @Override
    public Usuario update(Usuario usuario) throws Exception {
        
        if (usuario==null){
            return null;
        }
        
        if (usuario.getNombre().isBlank()||usuario.getContrasena().isBlank()){
            return null;
        }
        
        EntityTransaction transaction = null;
        try{
            transaction = em.getTransaction();            
            transaction.begin();
            em.merge(usuario);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new Exception("El usuario no se pudo actualizar:" + e);
        }
        return usuario;
    }

    @Override
    public Boolean delete(Usuario usuario) throws Exception{
        
        if (usuario==null){
            return false;
        }
        
        if (usuario.getNombre().isBlank()||usuario.getContrasena().isBlank()){
            return false;
        }
        
        EntityTransaction transaction = null;
        try{
            transaction = em.getTransaction();            
            transaction.begin();
            em.remove(usuario);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new Exception("El usuario no se pudo eliminar:" + e);
        }
        return true;
    }

    @Override
    public Usuario getUsuarioById(Long id) throws Exception {
        
        if (id==null){
            return null;
        }
        
        Usuario usuario;
        try {
             usuario=em.find(Usuario.class, id);
        } catch (Exception e) {
            throw new Exception("La busqueda no se pudo ejecutar:" + e);
        }
        return usuario;
    }

    @Override
    public Usuario getUsuarioByName(String nombre) throws Exception {
        
        if (nombre==null || nombre.isBlank()){
            return null;
        }
        
        Usuario usuario=null;
        try { 
            TypedQuery<Usuario> query = em.createQuery("SELECT e FROM Usuario e WHERE e.nombre = :nombre", Usuario.class);
            query.setParameter("nombre", nombre);
            usuario = query.getSingleResult();
        } catch (Exception e) {
            if (usuario==null){
                return null;
            }
            throw new Exception("La busqueda no se pudo ejecutar:" + e);
        }
        return usuario;
    }

    @Override
    public List<Usuario> getAll() throws Exception {
        List usuarios = new ArrayList<Usuario>();
        try {
            TypedQuery<Usuario> query = em.createQuery("SELECT e FROM Usuario e", Usuario.class);
            usuarios = query.getResultList();
        } catch (Exception e) {
            throw new Exception("La busqueda no se pudo ejecutar:" + e);
        }
        return usuarios;
    }
}
