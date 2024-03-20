/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

/**
 *
 * @author TADEO
 */
public class Devolucion {
    
    private Libro libro;
    private Usuario usuario;
    private Prestamo prestamo;

    public Devolucion(Libro libro, Usuario usuario, Prestamo prestamo) {
        this.libro = libro;
        this.usuario = usuario;
        this.prestamo = prestamo;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    @Override
    public String toString() {
        return "Devolucion{" + "libro=" + libro + ", usuario=" + usuario + ", prestamo=" + prestamo + '}';
    }
    
}
