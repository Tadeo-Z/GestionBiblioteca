/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.mockito;
import org.itson.dominio.Libro;

/**
 *Esta clase es una clase externa, la cual tiene como atributos, una valoración, uan reseña y un
 * libro al cual estará asociado dicha valoración y reseña.
 * @author marco
 */
public class EvaluacionLibroServicio {
    
    private double valoracion;
    private String reseña;
    private Libro libro;

    
    public EvaluacionLibroServicio(){
        
    }
    
    public EvaluacionLibroServicio(double valoracion, String reseña) {
        this.valoracion = valoracion;
        this.reseña = reseña;
    }

    public double getValoracion() {
        return valoracion;
    }

    public String getReseña() {
        return reseña;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public void setValoracion(double valoracion) {
        this.valoracion = valoracion;
    }

    public void setReseña(String reseña) {
        this.reseña = reseña;
    }
    
    
    
  
}
