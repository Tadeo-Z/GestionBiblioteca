/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import org.itson.dominio.Prestamo;

/**
 *
 * @author TADEO
 */
public interface IPrestamo {
    
    public Prestamo registrarPrestamo(Prestamo prestamo);
    public Prestamo liberarPrestamo(Prestamo prestamo);
    
}
