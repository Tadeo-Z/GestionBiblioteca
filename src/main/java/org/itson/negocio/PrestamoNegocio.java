/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.negocio;
import java.util.List;
import org.itson.dominio.Prestamo;
import org.itson.dao.PrestamoDAO;
import org.itson.dominio.EstadoLibro;
import org.itson.dominio.Libro;
import org.itson.interfaces.IPrestamo;
import org.itson.dominio.EstadoPrestamo;
/**
 *
 * @author 
 */
public class PrestamoNegocio {
    
    private IPrestamo pdao;
    
    public PrestamoNegocio(){
        pdao = new PrestamoDAO();
    }
    
    public boolean registrarPrestamo(Prestamo prestamo) throws Exception{
        LibroNegocio libroNegocio = new LibroNegocio();
        
        for (Libro libro : prestamo.getLibros()) {
            libro.setDisponibilidad(EstadoLibro.NO_DISPONIBLE);
            libroNegocio.editar(libro);
        }
        return pdao.insert(prestamo);
        
    }
    
    public Prestamo liberarPrestamo(Prestamo prestamo) throws Exception{
        LibroNegocio libroNegocio = new LibroNegocio();
        
        for (Libro libro : prestamo.getLibros()) {
            libro.setDisponibilidad(EstadoLibro.DISPONIBLE);
            libroNegocio.editar(libro);
        }
        prestamo.setEstado(EstadoPrestamo.DEVUELTO);
        return pdao.update(prestamo);
        
    }
    
    public List<Prestamo> obtenerPrestamoDisponibilidad(EstadoPrestamo estado) throws Exception{
        
        return pdao.getPrestamosByDisponibilidad(estado);
    }
    
    public Prestamo obtenerPrestamoByIsbn(String isbn) throws Exception{
        
        return pdao.getPrestamoByLibroISBN(isbn);
    }
}
