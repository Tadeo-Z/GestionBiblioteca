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
import org.itson.dominio.EstadoLibro;
import org.itson.dominio.Libro;
import org.itson.dominio.Prestamo;
import org.itson.dominio.Usuario;
import org.itson.interfaces.ILibro;

/**
 *
 * @author TADEO
 */
public class LibroDAO implements ILibro {

    EntityManagerFactory emf;
    EntityManager em;

    public LibroDAO() {
        this.emf = Conexion.getConexion();
        this.em = emf.createEntityManager();
    }

    @Override
    public Boolean insert(Libro libro) throws Exception {
        if (libro == null) {
            return false;
        }

        EntityTransaction transaction = null;
        try {
            transaction = em.getTransaction();
            transaction.begin();
            em.persist(libro);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new Exception("El libro no se pudo insertar:" + e);
        }
        return true;
    }

    @Override
    public Libro update(Libro libro) throws Exception {
        if (libro == null) {
            return null;
        }

        if (libro.getAutor().isBlank()||libro.getIsbn().isBlank()||libro.getTitulo().isBlank()) {
            return null;
        }

        EntityTransaction transaction = null;
        try {
            transaction = em.getTransaction();
            transaction.begin();
            em.merge(libro);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new Exception("El libro no se pudo actualizar:" + e);
        }
        return libro;
    }

    @Override
    public Boolean delete(Libro libro) throws Exception {
        if (libro == null) {
            return false;
        }

        EntityTransaction transaction = null;
        try {
            transaction = em.getTransaction();
            transaction.begin();
            em.remove(libro);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new Exception("El libro no se pudo eliminar:" + e);
        }
        return true;
    }

    @Override
    public List<Libro> getAll() throws Exception {
        List libros = new ArrayList<Libro>();
        try {
            TypedQuery<Libro> query = em.createQuery("SELECT e FROM Libro e", Libro.class);
            libros = query.getResultList();
        } catch (Exception e) {
            throw new Exception("La busqueda no se pudo ejecutar:" + e);
        }
        return libros;
    }

    @Override
    public List <Libro> getLibroByTitulo(String titulo) throws Exception {
        if (titulo.isBlank()) {
            return null;
        }

        List libros = new ArrayList<Libro>();
        try {
            TypedQuery<Libro> query = em.createQuery("SELECT e FROM Libro e WHERE e.titulo = :titulo", Libro.class);
            query.setParameter("titulo", titulo);
            libros = query.getResultList();
        } catch (Exception e) {
            throw new Exception("La busqueda no se pudo ejecutar:" + e);
        }
        return libros;
    }

    @Override
    public List<Libro> getLibroByAutor(String autor) throws Exception {
        if (autor.isBlank()) {
            return null;
        }

        List libros = new ArrayList<Libro>();
        try {
            TypedQuery<Libro> query = em.createQuery("SELECT e FROM Libro e WHERE e.autor = :autor", Libro.class);
            query.setParameter("autor", autor);
            libros = query.getResultList();
        } catch (Exception e) {
            throw new Exception("La busqueda no se pudo ejecutar:" + e);
        }
        return libros;
    }

    @Override
    public List<Libro> getLibroByISBN(String isbn) throws Exception {
        if (isbn.isBlank()) {
            return null;
        }

        List libros = new ArrayList<Libro>();
        try {
            TypedQuery<Libro> query = em.createQuery("SELECT e FROM Libro e WHERE e.isbn = :isbn", Libro.class);
            query.setParameter("isbn", isbn);
            libros = query.getResultList();
        } catch (Exception e) {
            throw new Exception("La busqueda no se pudo ejecutar:" + e);
        }
        return libros;
    }

    @Override
    public List<Libro> getLibrosByDisponibilidad(EstadoLibro estado) throws Exception {
        if (estado==null) {
            return null;
        }

        List libros = new ArrayList<Libro>();
        try {
            TypedQuery<Libro> query = em.createQuery("SELECT e FROM Libro e WHERE e.estado = :estado", Libro.class);
            query.setParameter("estado", estado);
            libros = query.getResultList();
        } catch (Exception e) {
            throw new Exception("La busqueda no se pudo ejecutar:" + e);
        }
        return libros;
    }

    @Override
    public List<Libro> getLibrosPrestadosByUsuario(Usuario usuario) throws Exception {
        if (usuario == null) {
            return null;
        }

        List libros = new ArrayList<Libro>();
        try {
            TypedQuery<Libro> query = em.createQuery(
                    "SELECT DISTINCT l FROM Libro l "
                    + "JOIN l.prestamos pl "
                    + "JOIN pl.prestamo p "
                    + "WHERE p.usuario.id = :usuarioId",
                    Libro.class
            );
            query.setParameter("id_usuario", usuario.getId());
            libros = query.getResultList();
        } catch (Exception e) {
            throw new Exception("La busqueda no se pudo ejecutar:" + e);
        }
        return libros;
    }
}
