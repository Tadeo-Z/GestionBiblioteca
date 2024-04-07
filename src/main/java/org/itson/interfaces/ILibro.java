/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import java.util.List;
import org.itson.dominio.EstadoLibro;
import org.itson.dominio.Libro;
import org.itson.dominio.Usuario;

/**
 *
 * @author TADEO
 */
public interface ILibro {
    
    public Boolean insert(Libro libro)throws Exception;
    public Libro update(Libro libro)throws Exception;
    public Boolean delete(Libro libro)throws Exception;
    public List<Libro> getAll()throws Exception;
    public List<Libro>  getLibrosByTitulo(String titulo)throws Exception;
    public List<Libro>  getLibrosByAutor(String autor)throws Exception;
    public Libro  getLibroByISBN(String isbn)throws Exception;
    public List <Libro> getLibrosByDisponibilidad(EstadoLibro estado)throws Exception;    
    public List<Libro> getLibrosPrestadosByUsuario(Usuario usuario)throws Exception;

}
