/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

/**
 *
 * @author TADEO
 */
public class Libro {

    private String id;
    private String titulo;
    private String autor;
    private String disponibilidad;

    public Libro() {
    }

    public Libro(String id) {
        this.id = id;
    }
    
    public Libro(String id, String titulo, String autor, String disponibilidad) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.disponibilidad = disponibilidad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    @Override
    public String toString() {
        return "Libro{" + "id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", disponibilidad=" + disponibilidad + '}';
    }

}
