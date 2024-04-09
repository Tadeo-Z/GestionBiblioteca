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

        if (usuario.getNombre().length() > 75) {
            throw new NegocioException("El nombre es muy largo :(");
        }

        if (isNameTaken(usuario.getNombre())) {
            throw new NegocioException("El nombre ya está siedo usado");
        }

        usuario.setContrasena(encrypter.encrypt(usuario.getContrasena()));
        return usuarioDAO.insert(usuario);
    }

    public Usuario editar(Usuario usuario) throws Exception {

        // Verificamos que el ID del usuario sea válido
        if (usuario.getId() == null || usuario.getId() <= 0) {
            throw new NegocioException("El ID del usuario no es válido");
        }

        // Obtenemos el usuario actual de la base de datos
        Usuario usuarioActual = usuarioDAO.getUsuarioById(usuario.getId());

        if (usuarioActual == null) {
            throw new NegocioException("El usuario con ID " + usuario.getId() + " no existe");
        }

        // Encriptamos la nueva contraseña
        String nuevaContrasenaEncriptada = encrypter.encrypt(usuario.getContrasena());
        usuario.setContrasena(nuevaContrasenaEncriptada);

        if (usuario.getNombre().length() > 75) {
            throw new NegocioException("El nombre es muy largo :(");
        }

        if (isNameTaken(usuario.getNombre())) {
            throw new NegocioException("El nombre ya está siendo usado");
        }

        // Actualizamos el usuario en la base de datos
        return usuarioDAO.update(usuario);
    }

    public boolean delete(Usuario usuario) throws Exception {

        //No sé que validaciones hacer ademas del null pero ese va en la misma dao xd
        return usuarioDAO.delete(usuario);
    }

    public Usuario getUsuarioById(Long id) throws NegocioException, Exception {

        if (id <= 0) {
            throw new NegocioException("El id no es válido >:(");
        }
        return usuarioDAO.getUsuarioById(id);
    }

    public Usuario getUsuarioByName(String name) throws NegocioException, Exception {

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

    public List<Usuario> getAllUsuarios() throws NegocioException, Exception {
        return usuarioDAO.getAll();
    }

}
