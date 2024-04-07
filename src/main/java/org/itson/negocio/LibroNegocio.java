/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.negocio;
import Utilities.Encriptador;
import org.itson.dao.LibroDAO;
import org.itson.interfaces.ILibro;
import org.itson.dominio.Libro;
/**
 *
 * @author
 */
public class LibroNegocio {

    private ILibro libroDAO;
    private Encriptador encrypter;

    public LibroNegocio() {
        libroDAO = new LibroDAO();
        encrypter = new Encriptador();
    }

    public boolean registrar(Libro libro) throws Exception {

        libro.setIsbn(encrypter.encrypt(libro.getIsbn()));
        libroDAO.insert(libro);
        return true;
    }

    public boolean editar(Libro libro) throws Exception {

        Libro libroActual = libroDAO.getLibroById(libro.getId());

        if (libro.getIsbn() != libroActual.getTitulo()) {
            //El isbn no es actualizable
            libro.setIsbn(libroActual.getIsbn());
        }

        libroDAO.update(libro);
        return true;
    }

}
