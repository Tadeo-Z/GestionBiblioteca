
package org.itson.negocio;
import org.itson.dominio.Usuario;
import org.itson.dao.UsuarioDAO;
import org.itson.interfaces.IUsuario;
/**
 *
 * @author 
 */
public class UsuarioNegocio {
    
    private IUsuario udao;
    
    public UsuarioNegocio(){
        udao = new UsuarioDAO();
    }
    
    public boolean registrarUsuario(Usuario usuario){
        
        return udao.registrarUsuario(usuario);
        
    }
}
