/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.negocio;
import Utilities.Encriptador;
import org.itson.dao.LibroDAO;
import org.itson.interfaces.ILibro;
import org.itson.dominio.Libro;
import java.util.ArrayList;
import java.util.List;
import org.itson.dominio.EstadoLibro;
import org.itson.dominio.Usuario;
/**
 *
 * @author
 */
public class LibroNegocio {

    private ILibro libroDAO;
    private Encriptador encrypter;

    public LibroNegocio() {
        libroDAO = new LibroDAO();
        encrypter = new Encriptador();
    }

    public boolean registrar(Libro libro) throws Exception {

        libro.setIsbn(encrypter.encrypt(libro.getIsbn()));
        libroDAO.insert(libro);
        return true;
    }

    public boolean editar(Libro libro) throws Exception {

        Libro libroActual = libroDAO.getLibroById(libro.getId());

        if (libro.getIsbn() != libroActual.getTitulo()) {
            //El isbn no es actualizable
            libro.setIsbn(libroActual.getIsbn());
        }

        libroDAO.update(libro);
        return true;
    }
    
    public List<Libro> obtenerTodosLosLibros() throws Exception{
        return libroDAO.getAll();
    }
    
    public List<Libro> obtenerLibrosDisponibles() throws Exception{
        
        List<Libro> librosDisponibles = new ArrayList<>();
        
        return librosDisponibles = libroDAO.getLibrosByDisponibilidad(EstadoLibro.DISPONIBLE);
    }
    
    public List<Libro> obtenerLibrosPrestados(Usuario usuario) throws Exception{
        return libroDAO.getLibrosPrestadosByUsuario(usuario);
    }
    
    public Libro obtenerLibroISBN(String isbn)throws Exception{
        return libroDAO.getLibroByISBN(isbn);
    }
    
    public List<Libro> obtenerLibroAutor(String autor) throws Exception{
        return libroDAO.getLibrosByAutor(autor);
    }

    public List<Libro> obtenerLibroTitulo(String titulo) throws Exception{
        return libroDAO.getLibrosByTitulo(titulo);
    }
    
}
