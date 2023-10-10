/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prom;

import java.util.ArrayList;

/**
 *
 * @author AlphaBeta's
 */
public class managerauth {
    private ArrayList<User> userList;
    
    public managerauth(ArrayList<User> userlist){
        this.userList = userList;
    }

    public boolean authenticateUser(String email, String Password){
        for(User user : userList){
            if(user.getEmail().equals(email)){
               String hashedInputPassword = hashing_code.hashpassword(Password);
               if(user.getPassword().equals(hashedInputPassword)){
                   return true;
                }
            }
        }
           
    return false;
}
 }
