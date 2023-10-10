/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javaapplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import prom.LoginLogger;
import prom.User;
import java.io.IOException;


/**
 *
 * @author AlphaBeta's
 */
public class Manager_Login extends javax.swing.JFrame {

    /**
     * Creates new form Manager_Login
     */
    public Manager_Login() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        emailfield = new javax.swing.JTextField();
        loginbtn = new javax.swing.JButton();
        bckbtn = new javax.swing.JButton();
        passwordfield = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Manager Login");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 70, 20));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, -1, 20));

        emailfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailfieldActionPerformed(evt);
            }
        });
        getContentPane().add(emailfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, 240, -1));

        loginbtn.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        loginbtn.setText("Login");
        loginbtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        loginbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginbtnActionPerformed(evt);
            }
        });
        getContentPane().add(loginbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 234, 160, 30));

        bckbtn.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        bckbtn.setText("Back");
        bckbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bckbtnActionPerformed(evt);
            }
        });
        getContentPane().add(bckbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        getContentPane().add(passwordfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, 240, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Screenshot 2023-09-21 105206.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, -4, 590, 310));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void emailfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailfieldActionPerformed

       
    private void loginbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginbtnActionPerformed
        
        String enteredEmail = emailfield.getText(); //getting entered email from email field
        String enteredPassword = passwordfield.getText(); //getting entered password from pass field
                
           if(enteredEmail.equals("admin") && enteredPassword.equals("admin")){
                    try {
                   LoginLogger.logLogin(enteredEmail);
               } catch (Exception e) {
                   e.printStackTrace();
               }

                    JOptionPane.showMessageDialog(this,"Login Sucessful");
                }   
        else{
                JOptionPane.showMessageDialog(this,"Invalid Credential");
            }  
            Manager_DashBoard mdash = new Manager_DashBoard();
            mdash.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_loginbtnActionPerformed

    private void bckbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bckbtnActionPerformed
        Main_menu mnmu = new Main_menu();
        mnmu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bckbtnActionPerformed

 private ArrayList<User> loadManagerUsersFromFile(String filename){
     ArrayList<User> managerUsers = new ArrayList<>();
     try(BufferedReader reader = new BufferedReader(new FileReader(filename))){
         String line;
         while((line =reader.readLine())!=null){
             String[] parts = line.split(",");
             if(parts.length == 3 ){
                 String name = parts[0];
                 String email = parts[1];
                 String hashedPassword = parts[2];
                 User user = new User(0,name,email,hashedPassword,"");
                 managerUsers.add(user);
             }
         }
     }catch(IOException e){
         e.printStackTrace();
     }
     return managerUsers;
 }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Manager_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Manager_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Manager_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Manager_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Manager_Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bckbtn;
    private javax.swing.JTextField emailfield;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton loginbtn;
    private javax.swing.JPasswordField passwordfield;
    // End of variables declaration//GEN-END:variables
}