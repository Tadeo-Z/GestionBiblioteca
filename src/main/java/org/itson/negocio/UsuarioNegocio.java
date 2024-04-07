
package org.itson.negocio;
import Utilities.Encriptador;
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
    
    public UsuarioNegocio(){
        usuarioDAO = new UsuarioDAO();
        encrypter = new Encriptador();
    }
    
    public boolean registrar(Usuario usuario) throws Exception {

        usuario.setContrasena(encrypter.encrypt(usuario.getContrasena()));
        usuarioDAO.insert(usuario);
        return true;
    }

    public boolean editar(Usuario usuario) throws Exception {

        Usuario usuarioActual = usuarioDAO.getUsuarioById(usuario.getId());
        
        //Encripta la nueva contraseña
        if(usuario.getContrasena()!=usuarioActual.getContrasena()){
            usuario.setContrasena(encrypter.encrypt(usuario.getContrasena()));
        }
        
        usuarioDAO.update(usuario);
        return true;
    }
    
    
}
