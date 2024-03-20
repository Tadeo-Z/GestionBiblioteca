/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import org.itson.dominio.Libro;

/**
 *
 * @author TADEO
 */
public interface ILibro {
    
    public Libro registrarLibro(Libro libro);
    public Libro actualizarLibro(Libro libro);
    public Libro eliminarLibro(Libro libro);
    public Libro buscarLibroTitulo(String titulo);
    public Libro buscarLibroAutor(String autor);
    public Libro buscarLibroIdentificador(String id);
}
