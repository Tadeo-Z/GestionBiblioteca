/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import org.itson.dominio.Usuario;
import org.itson.interfaces.IUsuario;

/**
 *
 * @author TADEO
 */
public class UsuarioDAO implements IUsuario{

    EntityManagerFactory emf;

    public UsuarioDAO() {
        this.emf = Conexion.getConexion();
    }
    
    @Override
    public Boolean registrarUsuario(Usuario usuario) {
        
        Boolean registrado = false;
        EntityManager em = emf.createEntityManager();
        
        try{
            
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
            registrado = true;
            
        }catch(Exception e){
            em.getTransaction().rollback();
            registrado = false;
        }

        return registrado;
    }
    

    @Override
    public Boolean actualizarUsuario(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
