/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javaapplication;

import java.io.File;
import javax.swing.JOptionPane;
import prom.AuthenticateFile;

/**
 *
 * @author AlphaBeta's
 */
public class User_DashBoard extends javax.swing.JFrame {
    private String authenticatedEmail;
    /**
     * Creates new form student_dashboard
     */
    public User_DashBoard(String authenticatedEmail) {
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

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        menuview = new javax.swing.JButton();
        payment = new javax.swing.JButton();
        cnclord = new javax.swing.JButton();
        feedback = new javax.swing.JButton();
        SignOut = new javax.swing.JButton();
        email = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dahs.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setForeground(new java.awt.Color(204, 204, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("WELCOME TO APU Cafeteria Ordering System");
        jLabel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));

        menuview.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        menuview.setText("View Menu");
        menuview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuviewActionPerformed(evt);
            }
        });
        getContentPane().add(menuview, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 120, 40));

        payment.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        payment.setText("Payment");
        payment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentActionPerformed(evt);
            }
        });
        getContentPane().add(payment, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 120, 40));

        cnclord.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        cnclord.setText("Cancel Order");
        cnclord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cnclordActionPerformed(evt);
            }
        });
        getContentPane().add(cnclord, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, -1, 40));

        feedback.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        feedback.setText("FeedBack");
        getContentPane().add(feedback, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 119, 40));

        SignOut.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        SignOut.setText("SignOut");
        SignOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignOutActionPerformed(evt);
            }
        });
        getContentPane().add(SignOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 102, 40));
        getContentPane().add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tes.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, -4, 560, 310));

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    
    private void menuviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuviewActionPerformed
       Menu_GUI mgui =new  Menu_GUI();
       mgui.setVisible(true);
       this.hide();
    }//GEN-LAST:event_menuviewActionPerformed

    private void paymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentActionPerformed
        Order_View oview = new Order_View();
        oview.setVisible(true);
        this.hide();
    }//GEN-LAST:event_paymentActionPerformed

    private void cnclordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cnclordActionPerformed
               String filePath = "D:\\\\netbeans_projects\\\\JavaApplication2\\\\textfile\\\\ordertmp.txt";
        File fileToDelete = new File(filePath);
        
        if(fileToDelete.exists()){
            if(fileToDelete.delete()){
                JOptionPane.showMessageDialog(this,"Order Canceld.");
            }else{
                JOptionPane.showMessageDialog(this,"Error Deleting","Error",JOptionPane.ERROR_MESSAGE);
            }
         }else{
            JOptionPane.showMessageDialog(this,"No active order found.");
        }
    }//GEN-LAST:event_cnclordActionPerformed

    private void SignOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignOutActionPerformed
        Customer_Login stdlog = new Customer_Login();
        stdlog.setVisible(true);
        this.hide();
    }//GEN-LAST:event_SignOutActionPerformed

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
            java.util.logging.Logger.getLogger(User_DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(User_DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(User_DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(User_DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AuthenticateFile auth = new AuthenticateFile(null);
                String authenticatedEmail = auth.getAuthenticatedEmail();
                Main_menu mnu = new Main_menu();
                mnu.setVisible(true);
                
            }
        });
    }
    
    private AuthenticateFile auth = new AuthenticateFile(null);

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SignOut;
    private javax.swing.JButton cnclord;
    private javax.swing.JLabel email;
    private javax.swing.JButton feedback;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton menuview;
    private javax.swing.JButton payment;
    // End of variables declaration//GEN-END:variables
}
