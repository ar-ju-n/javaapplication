/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javaapplication;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AlphaBeta's
 */
public class Order_View extends javax.swing.JFrame {

    /**
     * Creates new form orderview
     */
    public Order_View() {
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
        jScrollPane1 = new javax.swing.JScrollPane();
        ordertable = new javax.swing.JTable();
        popbtn = new javax.swing.JButton();
        confirmbtn = new javax.swing.JButton();
        cancelbtn = new javax.swing.JButton();
        totacostfield = new javax.swing.JTextField();
        total = new javax.swing.JLabel();
        backbtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Order");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, -1, 22));

        ordertable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "OrderId", "Items"
            }
        ));
        jScrollPane1.setViewportView(ordertable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 40, 510, 214));

        popbtn.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        popbtn.setText("Populate");
        popbtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        popbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popbtnActionPerformed(evt);
            }
        });
        getContentPane().add(popbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 143, -1));

        confirmbtn.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        confirmbtn.setText("Confirm");
        confirmbtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        confirmbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmbtnActionPerformed(evt);
            }
        });
        getContentPane().add(confirmbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 310, 221, -1));

        cancelbtn.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        cancelbtn.setText("Cancel Order");
        cancelbtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cancelbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelbtnActionPerformed(evt);
            }
        });
        getContentPane().add(cancelbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 310, 128, -1));

        totacostfield.setEditable(false);
        getContentPane().add(totacostfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 260, 93, -1));

        total.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        total.setForeground(new java.awt.Color(255, 255, 255));
        total.setText("Tota Cost:");
        getContentPane().add(total, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 260, -1, 20));

        backbtn.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        backbtn.setText("<<Back");
        backbtn.setActionCommand("Back");
        backbtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbtnActionPerformed(evt);
            }
        });
        getContentPane().add(backbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/opnew.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, -4, 630, 370));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void popbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popbtnActionPerformed
       DefaultTableModel tableModel = (DefaultTableModel) ordertable.getModel();
       try{
           String filePath = "D:\\\\netbeans_projects\\\\JavaApplication2\\\\textfile\\\\ordertmp.txt";
           File file = new File(filePath);
           
           if(file.exists()){
               populateTableFromTextFile(tableModel, filePath);
           }
           else{
               JOptionPane.showMessageDialog(this,"No Order has been placed.");
           }
       }
       catch(IOException ex){
           ex.printStackTrace();
           JOptionPane.showMessageDialog(this,"Error occurred while reading file.","Error",JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_popbtnActionPerformed
   
    private void populateTableFromTextFile(DefaultTableModel tableModel,String filename) throws IOException{
        try(BufferedReader reader = new BufferedReader(new FileReader(filename))){
            String line;
            String orderId = "";
            ArrayList<String> items = new ArrayList<>();
            double totalPrice = 0.0;
            boolean readingItems = false;
            
            while((line = reader.readLine())!=null){
             if(line.startsWith("Order ID:")){
                 orderId = line.substring("Order ID:".length()).trim();
               } else if (line.startsWith("Items: [")) {
                    readingItems = true;
                    String itemsLine = line.substring("Items: [".length()).trim();
                    // Split and parse the items line into items and prices
                    Pattern pattern = Pattern.compile("([^,]+)-RM(\\d+(?:\\.\\d+)?)");
                    Matcher matcher = pattern.matcher(itemsLine);
                    while (matcher.find()) {
                        String item = matcher.group(1).trim();
                        String price = matcher.group(2).trim();
                        items.add(item);
                        totalPrice += Double.parseDouble(price);
                    }
                } else if (line.startsWith("Total Price:")) {
                    readingItems = true;
                    String totalLine = line.substring("Total Price:".length()).trim();
                    
            }
            
        }
            tableModel.addRow(new Object[]{orderId,String.join(",",items)});
            totacostfield.setText(Double.toString(totalPrice));
        }
        
    }
    
    private void confirmbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmbtnActionPerformed
      String sourceFilePath = "D:\\netbeans_projects\\JavaApplication2\\textfile\\ordertmp.txt";
      String targetFilePath = "D:\\netbeans_projects\\JavaApplication2\\textfile\\order.txt";
      String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
      
      File sourceFile = new File(sourceFilePath);
      File targetFile = new File(targetFilePath);
      
      if (sourceFile.exists()){
          try(BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
                  BufferedWriter writer = new BufferedWriter(new FileWriter(targetFile,true))){
                  String line;
                  while((line = reader.readLine())!=null){
                      writer.write(line+timestamp);
                      writer.newLine();
                  }
          } catch(IOException ex){
              ex.printStackTrace();
              JOptionPane.showMessageDialog(this,"Error occured while transfering","Error",JOptionPane.ERROR_MESSAGE);
              return;
          }
          
          if(sourceFile.delete()){
              JOptionPane.showMessageDialog(this,"Order Confirmed.","Confirmed",JOptionPane.INFORMATION_MESSAGE);
              
              DefaultTableModel model = (DefaultTableModel)ordertable.getModel();
              model.setRowCount(0);
              
              totacostfield.setText("");
//              
//              Menu_GUI mgui = new Menu_GUI();
//              mgui.setVisible(true);
//              this.dispose();
              
          }
          else{
              JOptionPane.showMessageDialog(this,"Error deleting file","Error",JOptionPane.ERROR_MESSAGE);
          }          
      } else{
          JOptionPane.showMessageDialog(this,"File not found","Error",JOptionPane.ERROR_MESSAGE);
       } 
    }//GEN-LAST:event_confirmbtnActionPerformed

    private void cancelbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelbtnActionPerformed
      
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
        Menu_GUI mnu = new Menu_GUI();
        mnu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelbtnActionPerformed

    private void backbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbtnActionPerformed
        Menu_GUI mnu = new Menu_GUI();
        mnu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backbtnActionPerformed

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
            java.util.logging.Logger.getLogger(Order_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Order_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Order_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Order_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Main_menu mnu = new Main_menu();
                mnu.setVisible(true);
//                new Order_View().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backbtn;
    private javax.swing.JButton cancelbtn;
    private javax.swing.JButton confirmbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable ordertable;
    private javax.swing.JButton popbtn;
    private javax.swing.JTextField totacostfield;
    private javax.swing.JLabel total;
    // End of variables declaration//GEN-END:variables
}
