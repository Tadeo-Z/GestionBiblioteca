/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import java.util.List;
import org.itson.dominio.Libro;
import org.itson.dominio.Prestamo;
import org.itson.dominio.Usuario;

/**
 *
 * @author TADEO
 */
public interface IUsuario {
    
    public Boolean insert(Usuario usuario)throws Exception;
    public Usuario update(Usuario usuario)throws Exception;
    public Boolean delete(Usuario usuario)throws Exception;
    public Usuario getUsuarioById(Long id)throws Exception;
    public Usuario getUsuarioByName(String nombre)throws Exception;
    public List <Usuario> getAll()throws Exception;
    
}
