
package org.itson.mockito;

/**
 *Esta clase básicamente  es el que implementará la logica para que hacer con el libro, reseña y evaluación.
 * @author marco
 */
public class servicioExterno implements IService{

    
    
    public servicioExterno(){
        
    }
    
    @Override
    public EvaluacionLibroServicio solicitarReseña(EvaluacionLibroServicio evaluacion) {
        evaluacion.setReseña(evaluacion.getReseña());
       
        
        return evaluacion;
    }

    @Override
    public EvaluacionLibroServicio solicitarValoracion(EvaluacionLibroServicio evaluacion) {
       evaluacion.setValoracion(evaluacion.getValoracion());
       
       return evaluacion;
    }
    
}
