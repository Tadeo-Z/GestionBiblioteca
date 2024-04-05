
package org.itson.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author 
 */
public class Conexion {
    private final String DIRECCION_PERSISTENCE = "org.itson_GestionBiblioteca_jar_1.0PU";
    private static EntityManagerFactory entityManagerFactory;
    private static Conexion conexion;
    
    
    private Conexion(){
        entityManagerFactory = Persistence.createEntityManagerFactory(DIRECCION_PERSISTENCE);
    }
    
    public static EntityManagerFactory getConexion(){
        
        if(conexion == null){
            conexion = new Conexion();
        }
        
        return entityManagerFactory;
    }
}
