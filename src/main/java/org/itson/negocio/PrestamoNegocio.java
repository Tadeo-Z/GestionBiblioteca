/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.negocio;
import org.itson.dominio.Prestamo;
import org.itson.dao.PrestamoDAO;
import org.itson.interfaces.IPrestamo;
/**
 *
 * @author 
 */
public class PrestamoNegocio {
    
    private IPrestamo pdao;
    
    public PrestamoNegocio(){
        pdao = new PrestamoDAO();
    }
}
