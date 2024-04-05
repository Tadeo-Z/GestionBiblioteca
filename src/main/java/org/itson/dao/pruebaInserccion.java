/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.itson.dao;
import org.itson.dominio.Usuario;
import org.itson.dao.UsuarioDAO;
import org.itson.interfaces.IUsuario;
import org.itson.negocio.UsuarioNegocio;

/**
 *
 * @author marco
 */
public class pruebaInserccion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Usuario usuarioPrueba = new Usuario("jayson tatum", "boston");
        
        UsuarioNegocio un = new UsuarioNegocio();
        
        
        if(un.registrarUsuario(usuarioPrueba)){
            System.out.println("registrado exitosamente");
        }else{
            System.out.println("no se pudo");
        }
    }
    
}
