/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import Exceptions.DAOException;
import Exceptions.LoginException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.itson.dao.UsuarioDAO;
import org.itson.dominio.Usuario;
import org.itson.interfaces.ISesionManager;

/**
 *
 * @author HP 240 G8
 */
public class SesionManager implements ISesionManager {

    private UsuarioDAO usuarioDAO;
    private Encriptador encrypter;

    public SesionManager() {
        usuarioDAO = new UsuarioDAO();
        encrypter = new Encriptador();
    }

    @Override
    public boolean autenticarUsuario(String nombreUsuario, String password) throws Exception {

        Usuario usuario = null;

        try {
            usuario = usuarioDAO.getUsuarioByName(nombreUsuario);
            
            if (encrypter.encrypt(password).equals(usuario.getContrasena())) {
                return true;
            }

        } catch (Exception ex) {
            if (usuario == null) {
                return false;
            }
            throw new DAOException("No se pudo conectar con la base de datos");
        }

        return false;
    }

}
