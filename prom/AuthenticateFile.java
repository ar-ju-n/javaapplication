/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prom;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author AlphaBeta's
 */

public class AuthenticateFile {
    private ArrayList<User> userList;
    private String authenticatedEmail;

    public AuthenticateFile(ArrayList<User> userList) {
        this.userList = userList;
    }

    public boolean authenticateUser(String email, String password, String filename) {
        try {
            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                String line;

                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split("\\|\\|");
                    if (parts.length == 5 && parts[2].equals(email) && parts[4].equals(password)) {
                        authenticatedEmail = email;
                        reader.close();
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean authenticateManager(String email, String password, ArrayList<User> managerUsers) {
        for (User user : managerUsers) {
            if (user.getEmail().equals(email)) {
                String hashedInputPassword = hashing_code.hashpassword(password);
                if (user.getPassword().equals(hashedInputPassword)) {
                    authenticatedEmail = email;
                    return true;
                }
            }
        }

        return false;
    }

    public String getAuthenticatedEmail() {
        return authenticatedEmail;
    }
}

