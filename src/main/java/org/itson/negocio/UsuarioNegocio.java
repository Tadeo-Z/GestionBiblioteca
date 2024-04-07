package org.itson.negocio;

import Exceptions.NegocioException;
import Utilities.Encriptador;
import java.util.List;
import org.itson.dominio.Usuario;
import org.itson.dao.UsuarioDAO;
import org.itson.dominio.Libro;
import org.itson.interfaces.IUsuario;

/**
 *
 * @author
 */
public class UsuarioNegocio {

    private IUsuario usuarioDAO;
    private Encriptador encrypter;

    public UsuarioNegocio() {
        usuarioDAO = new UsuarioDAO();
        encrypter = new Encriptador();
    }

    public boolean registrar(Usuario usuario) throws Exception {

        if (usuario.getNombre().length()>75){
            throw new NegocioException("El nombre es muy largo :(");
        }
        
        if (isNameTaken(usuario.getNombre())) {
            throw new NegocioException("El nombre ya está siedo usado");
        }
        
        usuario.setContrasena(encrypter.encrypt(usuario.getContrasena()));
        return usuarioDAO.insert(usuario);
    }

    public Usuario editar(Usuario usuario) throws Exception {

        Usuario usuarioActual = usuarioDAO.getUsuarioById(usuario.getId());

        //Enripta la nueva contraseña
        if (usuario.getContrasena() != usuarioActual.getContrasena()) {
            usuario.setContrasena(encrypter.encrypt(usuario.getContrasena()));
        }
        if (usuario.getNombre().length() > 75) {
            throw new NegocioException("El nombre es muy largo :(");
        }

        if (isNameTaken(usuario.getNombre())) {
            throw new NegocioException("El nombre ya está siedo usado");
        }

        return usuarioDAO.update(usuario);
    }
    
    public boolean delete(Usuario usuario) throws Exception{
        
        //No sé que validaciones hacer ademas del null pero ese va en la misma dao xd
        
        return usuarioDAO.delete(usuario);
    }
    
    public Usuario getUsuarioById(Long id) throws NegocioException, Exception{
        
        if (id<=0){
            throw new NegocioException("El id no es válido >:(");
        }
        return usuarioDAO.getUsuarioById(id);
    }
    
    public Usuario getUsuarioByName(String name) throws NegocioException, Exception{
        
        
        return usuarioDAO.getUsuarioByName(name);
    }
    
    

    private boolean isNameTaken(String name) throws Exception {

        List<Usuario> usuarios = usuarioDAO.getAll();

        for (Usuario usuario : usuarios) {
            if (usuario.getNombre().equals(name)) {
                return true;
            }
        }
        return false;
    }

}
