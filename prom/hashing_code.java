/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prom;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author AlphaBeta's
 */
public class hashing_code {
    public static String hashpassword(String Password){
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] bytes = md.digest(Password.getBytes());
            
            StringBuilder sb = new StringBuilder();
            
            for(byte b : bytes){
                
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
