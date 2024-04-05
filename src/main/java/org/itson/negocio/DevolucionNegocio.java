/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.negocio;
import org.itson.dominio.Devolucion;
import org.itson.dao.DevolucionDAO;
import org.itson.interfaces.IDevolucion;
/**
 *
 * @author
 */
public class DevolucionNegocio {
    
    private IDevolucion ddao;
    
    public DevolucionNegocio(){
        ddao = new DevolucionDAO();
    }
}
