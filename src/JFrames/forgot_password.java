/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrames;

import db.*;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo-x130
 */
public class forgot_password extends javax.swing.JFrame {

    /**
     * Creates new form forgot_password
     */
    public forgot_password() {
        initComponents();
    }
    String user_id;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblinvisible = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbl_close = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btn_login = new rojerusan.RSMaterialButtonCircle();
        btn_signup = new rojerusan.RSMaterialButtonCircle();
        lblvisible1 = new javax.swing.JLabel();
        lblinvisible1 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txt_pass = new javax.swing.JPasswordField();
        lblvisible = new javax.swing.JLabel();
        txtUserId = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtanswer = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btn_save = new rojerusan.RSMaterialButtonCircle();
        txtsecurityquestion = new javax.swing.JTextField();
        btnsearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1370, 770));
        setMinimumSize(new java.awt.Dimension(1370, 770));
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 255));
        jLabel1.setText("Systems");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Sitka Display", 0, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 255));
        jLabel2.setText("STUDENT REDRESSAL APPLICATION.");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, 480, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setText("EMMANUEL ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/icons/signup-library-icon.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 860, 670));

        jLabel6.setFont(new java.awt.Font("Sitka Display", 0, 30)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 51, 51));
        jLabel6.setText("Welcome To");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 180, -1));

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblinvisible.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblinvisibleMouseClicked(evt);
            }
        });
        jPanel2.add(lblinvisible, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 460, 40, 40));

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/icons/icons8_Secured_Letter_50px.png"))); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 50, 40));

        lbl_close.setFont(new java.awt.Font("Calibri Light", 1, 35)); // NOI18N
        lbl_close.setForeground(new java.awt.Color(255, 255, 255));
        lbl_close.setText("X");
        lbl_close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_closeMouseClicked(evt);
            }
        });
        jPanel2.add(lbl_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 6, 40, 30));

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Welcome Back");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 160, -1));

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/icons/icons8_Secure_50px.png"))); // NOI18N
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 60, 50));

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("New Password");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 420, 180, -1));

        btn_login.setBackground(new java.awt.Color(102, 102, 255));
        btn_login.setText("Login");
        btn_login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_loginMouseClicked(evt);
            }
        });
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });
        jPanel2.add(btn_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 590, 380, 80));

        btn_signup.setBackground(new java.awt.Color(255, 51, 51));
        btn_signup.setText("Signup");
        btn_signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_signupActionPerformed(evt);
            }
        });
        jPanel2.add(btn_signup, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 670, 380, 80));

        lblvisible1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/icons/visible.png"))); // NOI18N
        lblvisible1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblvisible1MouseClicked(evt);
            }
        });
        jPanel2.add(lblvisible1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 460, 40, 40));

        lblinvisible1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/icons/invisible.png"))); // NOI18N
        lblinvisible1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblinvisible1MouseClicked(evt);
            }
        });
        jPanel2.add(lblinvisible1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 460, 40, 40));

        jLabel16.setFont(new java.awt.Font("Stencil", 0, 25)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("FORGOT PASSWORD Page");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 330, -1));

        txt_pass.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jPanel2.add(txt_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 460, 290, 40));

        lblvisible.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblvisibleMouseClicked(evt);
            }
        });
        jPanel2.add(lblvisible, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 460, 40, 40));

        txtUserId.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel2.add(txtUserId, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 283, 31));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Employee ID/ Reg Number:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 300, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Security Question :");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 210, -1));

        txtanswer.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtanswer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtanswerActionPerformed(evt);
            }
        });
        jPanel2.add(txtanswer, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, 283, 33));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Answer :");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, 110, -1));

        btn_save.setBackground(new java.awt.Color(0, 204, 0));
        btn_save.setText("SAVE");
        btn_save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_saveMouseClicked(evt);
            }
        });
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });
        jPanel2.add(btn_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 510, 380, 80));

        txtsecurityquestion.setEditable(false);
        jPanel2.add(txtsecurityquestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 283, 34));

        btnsearch.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnsearch.setText("Search");
        btnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchActionPerformed(evt);
            }
        });
        jPanel2.add(btnsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, 80, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1370, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 770, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblinvisibleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblinvisibleMouseClicked
        txt_pass.setEchoChar((char) 0);
        lblinvisible.setVisible(false);
        lblvisible.setVisible(true);
    }//GEN-LAST:event_lblinvisibleMouseClicked

    private void lbl_closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_closeMouseClicked
        int a = JOptionPane.showConfirmDialog(null, "Do you really want to Close Application?", "Select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_lbl_closeMouseClicked

    private void btn_loginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_loginMouseClicked
        LoginPage page = new LoginPage();
        page.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_loginMouseClicked

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        LoginPage page = new LoginPage();
        page.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_loginActionPerformed

    private void btn_signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_signupActionPerformed
        SignupPage page = new SignupPage();
        page.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_signupActionPerformed

    private void lblvisibleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblvisibleMouseClicked
        txt_pass.setEchoChar('*');
        lblinvisible.setVisible(true);
        lblvisible.setVisible(false);
    }//GEN-LAST:event_lblvisibleMouseClicked

    private void txtanswerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtanswerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtanswerActionPerformed

    private void btn_saveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_saveMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_saveMouseClicked

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        int check = 0;
        String securityQuestion = txtsecurityquestion.getText();
        String answer = txtanswer.getText();
        String newPassword = txt_pass.getText();
        if (answer.equals("") || newPassword.equals("")) {
            check = 1;
            JOptionPane.showMessageDialog(null, "All field is Required");
        } else {
            ResultSet rs = Select.getData("select * from users where user_id = '" + user_id + "' and securityQuestion='" + securityQuestion + "' and answer ='" + answer + "' ");
            try {
                if (rs.next()) {
                    check = 1;
                    InsertUpdateDelete.setData("update users set password='" + newPassword + "' where user_id='" + user_id + "' ", "Password set Successfully");
                    setVisible(false);
                    new LoginPage().setVisible(true);

                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        if (check == 0) {
            JOptionPane.showMessageDialog(null, "Incorrect Answer");
        }
    }//GEN-LAST:event_btn_saveActionPerformed

    private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchActionPerformed
        int check = 0;
        user_id = txtUserId.getText();
        if (user_id.equals("")) {
            check = 1;
            JOptionPane.showMessageDialog(null, "User ID Field is Required");
//        } else if (!txtUserId.getText().matches("^.+@.+\\..+$")) {
//            JOptionPane.showMessageDialog(this, "Invalid Email Address");

        } else {
            ResultSet rs = Select.getData("select * from users where user_id = '" + user_id + "' ");
            try {
                if (rs.next()) {
                    check = 1;
                    txtsecurityquestion.setEditable(false);
                    txtUserId.setEditable(false);
                    txtsecurityquestion.setText(rs.getString(6));
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

        }
        if (check == 0) {
            JOptionPane.showMessageDialog(null, "There's No Existing User with this Credentials");
        }
    }//GEN-LAST:event_btnsearchActionPerformed

    private void lblinvisible1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblinvisible1MouseClicked
        txt_pass.setEchoChar((char) 0);
        lblinvisible.setVisible(false);
        lblvisible.setVisible(true);
    }//GEN-LAST:event_lblinvisible1MouseClicked

    private void lblvisible1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblvisible1MouseClicked
        txt_pass.setEchoChar('*');
        lblinvisible.setVisible(true);
        lblvisible.setVisible(false);
    }//GEN-LAST:event_lblvisible1MouseClicked

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
            java.util.logging.Logger.getLogger(forgot_password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(forgot_password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(forgot_password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(forgot_password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new forgot_password().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSMaterialButtonCircle btn_login;
    private rojerusan.RSMaterialButtonCircle btn_save;
    private rojerusan.RSMaterialButtonCircle btn_signup;
    private javax.swing.JButton btnsearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JLabel lbl_close;
    private javax.swing.JLabel lblinvisible;
    private javax.swing.JLabel lblinvisible1;
    private javax.swing.JLabel lblvisible;
    private javax.swing.JLabel lblvisible1;
    private javax.swing.JTextField txtUserId;
    private javax.swing.JPasswordField txt_pass;
    private javax.swing.JTextField txtanswer;
    private javax.swing.JTextField txtsecurityquestion;
    // End of variables declaration//GEN-END:variables
}
