/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TestsMockito;
import org.itson.dominio.Libro;
import org.itson.mockito.EvaluacionLibroServicio;
import org.itson.mockito.servicioExterno;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
//import org.junit.runner.RunWith;
/**
 *
 * @author marco
 */



public class ServicioExternoMockitoTest {
    
    //El mockito a insertar como parametro y la simulación de mokito, solo que me daban 
    //errores algunas sentencias y tenía que instanciarlos aunque investigando decía que no.
    @Mock
    private EvaluacionLibroServicio evaluacionLibroServicioMockito = new EvaluacionLibroServicio();

    @InjectMocks
    private servicioExterno servicioExterno = new servicioExterno();

    @Test
    public void testSolicitarReseña() {

        evaluacionLibroServicioMockito.setReseña("Libro muy bien recomendado");
        
        
        EvaluacionLibroServicio resultado = servicioExterno.solicitarReseña(evaluacionLibroServicioMockito);

        // Verificar que la reseña se haya seteado correctamente en el servicio de evaluación
        assertEquals("Libro muy bien recomendado", resultado.getReseña());

    }

    @Test
    public void testSolicitarValoracion() {
        evaluacionLibroServicioMockito.setValoracion(4.5);
        
        
        EvaluacionLibroServicio resultado = servicioExterno.solicitarValoracion(evaluacionLibroServicioMockito);

        // Verificar que la reseña se haya seteado correctamente en el servicio de evaluación
        assertEquals(4.5, resultado.getValoracion());
    }
}
