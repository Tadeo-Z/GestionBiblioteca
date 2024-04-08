/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import java.util.List;
import org.itson.dominio.EstadoPrestamo;
import org.itson.dominio.Prestamo;
import org.itson.dominio.Usuario;

/**
 *
 * @author TADEO
 */
public interface IPrestamo {
    
    public Boolean insert(Prestamo prestamo)throws Exception;
    public Prestamo update(Prestamo prestamo)throws Exception;
    public Boolean delete(Prestamo prestamo)throws Exception;
    public List<Prestamo> getPrestamosByUsuario(Usuario usuario)throws Exception;
    public List<Prestamo> getPrestamosByDisponibilidad(EstadoPrestamo estado)throws Exception;
    public List<Prestamo> getAll()throws Exception;
    public Prestamo getPrestamoById(Long id)throws Exception;

    
}
