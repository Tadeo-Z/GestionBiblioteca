/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import org.itson.dominio.Usuario;

/**
 *
 * @author TADEO
 */
public interface IUsuario {
    
    public Boolean registrarUsuario(Usuario usuario);
    public Boolean actualizarUsuario(Usuario usuario);
}
