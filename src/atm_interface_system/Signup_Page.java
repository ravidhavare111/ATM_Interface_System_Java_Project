package atm_interface_system;

import java.util.Date;
import javax.swing.JOptionPane;
import java.sql.*;
import java.text.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author HP
 */
public class Signup_Page extends javax.swing.JFrame {

    /**
     * Creates new form Signup_Page
     */
    public Signup_Page() {
        initComponents();
    }
    
        String FirstName, LastName, UserName, Password, Confirm_Password, MobileNo;
        Date DOB;
        int ID;
    
    
    boolean Validation(){
        
        
        FirstName = txt_FirstName.getText();
        LastName = txt_LastName.getText();
        UserName = txt_UserName.getText();
        Password = txt_Password.getText();
        Confirm_Password = txt_Confirm_Password.getText();
        DOB = txt_DOB.getDate();
//        System.out.println(DOB);
        MobileNo = txt_Mobile_No.getText();
        
        
        
        if(FirstName.equals("")){
            JOptionPane.showMessageDialog(rootPane, "Please Enter First Name");
            return false;
        }
        
        if(LastName.equals("")){
            JOptionPane.showMessageDialog(rootPane, "Please Enter Last Name");
            return false;
        }
        
        if(UserName.equals("")){
            JOptionPane.showMessageDialog(rootPane, "Please Enter UserName");
            return false;
        }
        
        if(Password.equals("")){
            JOptionPane.showMessageDialog(rootPane, "Please Enter Password");
            return false;
        }
        
        if(Confirm_Password.equals("")){
            JOptionPane.showMessageDialog(rootPane, "Please Confirm Password");
            return false;
        }
        
        if(DOB == null){
            JOptionPane.showMessageDialog(rootPane, "Please Enter Date of Birth");
            return false;
        }
        
        if(MobileNo.equals("")){
            JOptionPane.showMessageDialog(rootPane, "Please Enter Mobile No");
            return false;
        }
        
        if(!Password.equals(Confirm_Password)){
            JOptionPane.showMessageDialog(rootPane, "Confirm Passsword should be same as Password");
            return false;
        }  
        
        
        
        return true;
    }
    
    
    public void CheckPassword(){
        Password = txt_Password.getText();
    if(Password.length() < 8){
            Label_Pass_Error.setText("Passsword should be greater than 8 characters"); 
        }
    else{
        Label_Pass_Error.setText("");
    
    }
        
    }
    
    
    
    public void CheckMobileNo(){
        MobileNo = txt_Mobile_No.getText();
        if(MobileNo.length() == 10){
            Label_MobileNo_Error.setText("");        
        }
        else{
            Label_MobileNo_Error.setText("Mobile No. should be 10 digits");
        }
    
    }
    
    
    public int getID (){
        ResultSet rs;
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            String conUrl = "jdbc:mysql://localhost:3306/fees_report_management";
            String conUserName = "root";
            String conPassword = "Admin@123";
            Connection con = DriverManager.getConnection(conUrl, conUserName, conPassword);
            String Query = "select max(ID) from signup";
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(Query);
            while(rs.next()){
                ID = rs.getInt(1);
                ID++;
            }
   
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return ID;
    
    }
    
    
    void insertDetails(){
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
        String newDOB = format.format(DOB);
       
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            String conUrl = "jdbc:mysql://localhost:3306/fees_report_management";
            String conUserName = "root";
            String conPassword = "Admin@123";
            Connection con = DriverManager.getConnection(conUrl, conUserName, conPassword);
            
            String Query = "insert into signup values(?,?,?,?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(Query);
            pstmt.setInt(1, getID());
            pstmt.setString(2, FirstName);
            pstmt.setString(3, LastName);
            pstmt.setString(4, UserName);
            pstmt.setString(5, Password);
            pstmt.setString(6, newDOB);
            pstmt.setString(7, MobileNo);
            
            int i = pstmt.executeUpdate();
            if(i > 0){
                JOptionPane.showMessageDialog(rootPane, "record Inserted");
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "record not Inserted");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }
        

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_Mobile_No = new javax.swing.JTextField();
        txt_FirstName = new javax.swing.JTextField();
        txt_UserName = new javax.swing.JTextField();
        txt_LastName = new javax.swing.JTextField();
        txt_Password = new javax.swing.JPasswordField();
        txt_Confirm_Password = new javax.swing.JPasswordField();
        btn_Login = new javax.swing.JButton();
        btn_SignUp = new javax.swing.JButton();
        Label_Pass_Error = new javax.swing.JLabel();
        Label_Pass_Mitchmatch = new javax.swing.JLabel();
        Label_MobileNo_Error = new javax.swing.JLabel();
        txt_DOB = new com.toedter.calendar.JDateChooser();

        jPanel2.setBackground(new java.awt.Color(255, 102, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("First Name :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addContainerGap(429, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 0, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SIGNUP");

        jPanel3.setBackground(new java.awt.Color(153, 0, 153));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel3.setText("First Name :");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 21, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel4.setText("User Name :");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 101, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel5.setText("Last Name :");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 61, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel6.setText("Password :");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 147, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel7.setText("Mobile No :");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 305, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel8.setText("Confirm Password :");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 201, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel9.setText("DOB :");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 260, -1, -1));

        txt_Mobile_No.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Mobile_NoActionPerformed(evt);
            }
        });
        txt_Mobile_No.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_Mobile_NoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_Mobile_NoKeyReleased(evt);
            }
        });
        jPanel3.add(txt_Mobile_No, new org.netbeans.lib.awtextra.AbsoluteConstraints(212, 311, 150, -1));

        txt_FirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_FirstNameActionPerformed(evt);
            }
        });
        jPanel3.add(txt_FirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(212, 27, 150, -1));

        txt_UserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_UserNameActionPerformed(evt);
            }
        });
        jPanel3.add(txt_UserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(212, 107, 150, -1));

        txt_LastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_LastNameActionPerformed(evt);
            }
        });
        jPanel3.add(txt_LastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(212, 67, 150, -1));

        txt_Password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_PasswordKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_PasswordKeyReleased(evt);
            }
        });
        jPanel3.add(txt_Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(212, 153, 150, -1));
        jPanel3.add(txt_Confirm_Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(212, 207, 150, -1));

        btn_Login.setBackground(new java.awt.Color(51, 0, 51));
        btn_Login.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        btn_Login.setForeground(new java.awt.Color(255, 255, 255));
        btn_Login.setText("Login");
        btn_Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LoginActionPerformed(evt);
            }
        });
        jPanel3.add(btn_Login, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 399, -1, -1));

        btn_SignUp.setBackground(new java.awt.Color(51, 0, 51));
        btn_SignUp.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        btn_SignUp.setForeground(new java.awt.Color(255, 255, 255));
        btn_SignUp.setText("Signup");
        btn_SignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SignUpActionPerformed(evt);
            }
        });
        jPanel3.add(btn_SignUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 398, -1, -1));

        Label_Pass_Error.setForeground(new java.awt.Color(255, 0, 0));
        jPanel3.add(Label_Pass_Error, new org.netbeans.lib.awtextra.AbsoluteConstraints(212, 177, 268, 18));

        Label_Pass_Mitchmatch.setForeground(new java.awt.Color(255, 0, 0));
        jPanel3.add(Label_Pass_Mitchmatch, new org.netbeans.lib.awtextra.AbsoluteConstraints(212, 230, 268, 18));

        Label_MobileNo_Error.setForeground(new java.awt.Color(255, 0, 0));
        Label_MobileNo_Error.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Label_MobileNo_ErrorKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Label_MobileNo_ErrorKeyReleased(evt);
            }
        });
        jPanel3.add(Label_MobileNo_Error, new org.netbeans.lib.awtextra.AbsoluteConstraints(212, 339, 268, 18));
        jPanel3.add(txt_DOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, 150, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(184, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(174, 174, 174))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -6, -1, 530));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_Mobile_NoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Mobile_NoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Mobile_NoActionPerformed

    private void txt_FirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_FirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_FirstNameActionPerformed

    private void txt_UserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_UserNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_UserNameActionPerformed

    private void txt_LastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_LastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_LastNameActionPerformed

    private void btn_LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_LoginActionPerformed

    private void btn_SignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SignUpActionPerformed
        // TODO add your handling code here:
        if(Validation()){
            insertDetails();
        }
        
    }//GEN-LAST:event_btn_SignUpActionPerformed

    private void txt_PasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_PasswordKeyPressed
        // TODO add your handling code here:
        CheckPassword();
    }//GEN-LAST:event_txt_PasswordKeyPressed

    private void txt_PasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_PasswordKeyReleased
        // TODO add your handling code here:
        CheckPassword();
    }//GEN-LAST:event_txt_PasswordKeyReleased

    private void Label_MobileNo_ErrorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Label_MobileNo_ErrorKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Label_MobileNo_ErrorKeyPressed

    private void Label_MobileNo_ErrorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Label_MobileNo_ErrorKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_Label_MobileNo_ErrorKeyReleased

    private void txt_Mobile_NoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Mobile_NoKeyPressed
        // TODO add your handling code here:
        CheckMobileNo();
    }//GEN-LAST:event_txt_Mobile_NoKeyPressed

    private void txt_Mobile_NoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Mobile_NoKeyReleased
        // TODO add your handling code here:
        CheckMobileNo();
    }//GEN-LAST:event_txt_Mobile_NoKeyReleased

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
            java.util.logging.Logger.getLogger(Signup_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Signup_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Signup_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Signup_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Signup_Page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Label_MobileNo_Error;
    private javax.swing.JLabel Label_Pass_Error;
    private javax.swing.JLabel Label_Pass_Mitchmatch;
    private javax.swing.JButton btn_Login;
    private javax.swing.JButton btn_SignUp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField txt_Confirm_Password;
    private com.toedter.calendar.JDateChooser txt_DOB;
    private javax.swing.JTextField txt_FirstName;
    private javax.swing.JTextField txt_LastName;
    private javax.swing.JTextField txt_Mobile_No;
    private javax.swing.JPasswordField txt_Password;
    private javax.swing.JTextField txt_UserName;
    // End of variables declaration//GEN-END:variables
}
