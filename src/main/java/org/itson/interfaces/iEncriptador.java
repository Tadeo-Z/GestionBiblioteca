/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import java.security.Key;

/**
 *
 * @author HP 240 G8
 */
public interface iEncriptador {

    public String encrypt(String plainText) throws Exception;

    public String decrypt(String encryptedText) throws Exception;
}
