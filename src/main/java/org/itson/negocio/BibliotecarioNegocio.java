/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.negocio;

import Exceptions.NegocioException;
import Utilities.Encriptador;
import java.util.List;
import org.itson.dao.BibliotecarioDAO;
import org.itson.dao.UsuarioDAO;
import org.itson.dominio.Bibliotecario;
import org.itson.dominio.Usuario;
import org.itson.interfaces.IBibliotecario;
import org.itson.interfaces.IUsuario;

/**
 *
 * @author HP 240 G8
 */
public class BibliotecarioNegocio {
    
    private IBibliotecario bibliotecarioDAO;
    private Encriptador encrypter;

    public BibliotecarioNegocio() {
        bibliotecarioDAO = new BibliotecarioDAO();
        encrypter = new Encriptador();
    }
    
    public boolean registrar(Bibliotecario bibliotecario) throws Exception {

        if (bibliotecario.getNombre().length()>75){
            throw new NegocioException("El nombre es muy largo :(");
        }
        
        if (isNameTaken(bibliotecario.getNombre())) {
            throw new NegocioException("El nombre ya está siedo usado");
        }
        
        bibliotecario.setContrasena(encrypter.encrypt(bibliotecario.getContrasena()));
        return bibliotecarioDAO.insert(bibliotecario);
    }

    public Bibliotecario editar(Bibliotecario bibliotecario) throws Exception {

        Bibliotecario bibliotecarioActual = bibliotecarioDAO.getBibliotecarioById(bibliotecario.getId());

        //Enripta la nueva contraseña
        if (bibliotecario.getContrasena() != bibliotecarioActual.getContrasena()) {
            bibliotecario.setContrasena(encrypter.encrypt(bibliotecario.getContrasena()));
        }
        if (bibliotecario.getNombre().length() > 75) {
            throw new NegocioException("El nombre es muy largo :(");
        }

        if (isNameTaken(bibliotecario.getNombre())) {
            throw new NegocioException("El nombre ya está siedo usado");
        }

        return bibliotecarioDAO.update(bibliotecario);
    }
    
    public boolean delete(Bibliotecario bibliotecario) throws Exception{
        
        //No sé que validaciones hacer ademas del null pero ese va en la misma dao xd
        
        return bibliotecarioDAO.delete(bibliotecario);
    }
    
    public Bibliotecario getBibliotecarioById(Long id) throws NegocioException, Exception{
        
        if (id<=0){
            throw new NegocioException("El id no es válido >:(");
        }
        return bibliotecarioDAO.getBibliotecarioById(id);
    }
    
    public Bibliotecario getBibliotecarioByName(String name) throws NegocioException, Exception{
        
        return bibliotecarioDAO.getBibliotecarioByName(name);
    }
    
    

    private boolean isNameTaken(String name) throws Exception {

        List<Bibliotecario> bibliotecarios = bibliotecarioDAO.getAll();

        for (Bibliotecario bibliotecario : bibliotecarios) {
            if (bibliotecario.getNombre().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
