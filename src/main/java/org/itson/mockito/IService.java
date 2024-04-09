/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.mockito;

/**
 *Esta interfaz es una que proporciona nuestro programa para que otro servicio pueda enviarnos 
 * las reseñas y las valoraciones.
 * @author marco
 */
public interface IService {
    
    public EvaluacionLibroServicio solicitarReseña(EvaluacionLibroServicio evaluacion);
    
    public EvaluacionLibroServicio solicitarValoracion(EvaluacionLibroServicio evaluacion);
    
}
