/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.negocio;
import org.itson.dao.LibroDAO;
import org.itson.interfaces.ILibro;
import org.itson.dominio.Libro;
/**
 *
 * @author 
 */
public class LibroNegocio {
    
    private ILibro ldao;
    
    public LibroNegocio(){
        ldao = new LibroDAO();
    }
    
}
