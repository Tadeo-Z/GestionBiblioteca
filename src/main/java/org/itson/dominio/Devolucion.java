/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Column;

/**
 *
 * @author TADEO
 */
@Entity
public class Devolucion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_devolucion")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "id_libro")
    private Libro libro;
    
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
  

    public Devolucion(){
        
    }
    
    public Devolucion(Libro libro, Usuario usuario) {
        this.libro = libro;
        this.usuario = usuario;

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


    @Override
    public String toString() {
        return "Devolucion{" + "libro=" + libro + ", usuario=" + usuario + '}';
    }
    
}
