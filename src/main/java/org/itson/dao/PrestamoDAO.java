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
import org.itson.dominio.EstadoPrestamo;
import org.itson.dominio.Prestamo;
import org.itson.dominio.Usuario;
import org.itson.interfaces.IPrestamo;

/**
 *
 * @author TADEO
 */
public class PrestamoDAO implements IPrestamo {

    EntityManagerFactory emf;
    EntityManager em;

    public PrestamoDAO() {
        this.emf = Conexion.getConexion();
        this.em = emf.createEntityManager();
    }
    
    @Override
    public Boolean insert(Prestamo prestamo) throws Exception {

        if (prestamo == null) {
            return false;
        }

        EntityTransaction transaction = null;
        try{
            transaction = em.getTransaction();            
            transaction.begin();
            em.persist(prestamo);
            em.getTransaction().commit();
        } catch (Exception e) {
           if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new Exception("El prestamo no se pudo insertar:" + e);
        }
        return true;

    }

    @Override
    public Prestamo update(Prestamo prestamo) throws Exception {
        if (prestamo == null) {
            return null;
        }

        if (prestamo.getUsuario()==null || prestamo.getLibros()==null) {
            return null;
        }

        EntityTransaction transaction = null;
        try {
            transaction = em.getTransaction();
            transaction.begin();
            em.merge(prestamo);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new Exception("El prestamo no se pudo actualizar:" + e);
        }
        return prestamo;
    }

    @Override
    public Boolean delete(Prestamo prestamo) throws Exception {
        if (prestamo==null){
            return false;
        }
        
        EntityTransaction transaction = null;
        try{
            transaction = em.getTransaction();            
            transaction.begin();
            em.remove(prestamo);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new Exception("El prestamo no se pudo eliminar:" + e);
        }
        return true;
    }

    @Override
    public List<Prestamo> getPrestamosByUsuario(Usuario usuario) throws Exception {
        if (usuario == null) {
            return null;
        }

        List prestamos = new ArrayList<Prestamo>();
        try {
            TypedQuery<Prestamo> query = em.createQuery("SELECT e FROM Prestamo e WHERE e.id_usuario = :id_usuario", Prestamo.class);
            query.setParameter("id_usuario", usuario.getId());
            prestamos = query.getResultList();
        } catch (Exception e) {
            throw new Exception("La busqueda no se pudo ejecutar:" + e);
        }
        return prestamos;
    }

    @Override
    public List<Prestamo> getPrestamosByDisponibilidad(EstadoPrestamo estado) throws Exception {

        if (estado == null) {
            return null;
        }

        List prestamos = new ArrayList<Prestamo>();
        try {
            TypedQuery<Prestamo> query = em.createQuery("SELECT e FROM Prestamo e WHERE e.estado = :estado", Prestamo.class);
            query.setParameter("estado", estado);
            prestamos = query.getResultList();
        } catch (Exception e) {
            throw new Exception("La busqueda no se pudo ejecutar:" + e);
        }
        return prestamos;

    }

    @Override
    public List<Prestamo> getAll() throws Exception {
        List prestamos = new ArrayList<Prestamo>();
        try {
            TypedQuery<Prestamo> query = em.createQuery("SELECT e FROM Prestamo e", Prestamo.class);
            prestamos = query.getResultList();
        } catch (Exception e) {
            throw new Exception("La busqueda no se pudo ejecutar:" + e);
        }
        return prestamos;
    }

}
