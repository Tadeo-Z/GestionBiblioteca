/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import java.util.List;
import org.itson.dominio.Bibliotecario;


/**
 *
 * @author HP 240 G8
 */
public interface IBibliotecario {
    public Boolean insert(Bibliotecario bibliotecario)throws Exception;
    public Bibliotecario update(Bibliotecario bibliotecario)throws Exception;
    public Boolean delete(Bibliotecario bibliotecario)throws Exception;
    public Bibliotecario getBibliotecarioById(Long id)throws Exception;
    public Bibliotecario getBibliotecarioByName(String nombre)throws Exception;
    public List<Bibliotecario> getAll()throws Exception;
}
