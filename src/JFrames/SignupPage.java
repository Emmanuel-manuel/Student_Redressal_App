package JFrames;

import db.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author EMMANUEL
 */
public class SignupPage extends javax.swing.JFrame {

    /**
     * Creates new form SignupPage
     */
    public SignupPage() {
        initComponents();
    }

    // method to insert values into users table
    public void insertSignupDetails(){
        String name = txt_username.getText();
        String u_id = txt_id.getText();
        String role = cbo_role.getSelectedItem().toString();
        String pwd = txt_password.getText();
        String secQuiz = (String)cbo_quiz.getSelectedItem();
        String answer = txt_answer.getText();
        
        try{
            //You can use this way: But you will need to type these two lines everytime
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","");

            // or you can create a javaClass name it MyConnection and call the class instead like this ...
            Connection con = MyConnection.getConnection();
            String sql = "insert into users(username, user_id, role, password, security_quiz, answer, status) values(?,?,?,?,?,?,'Not_Approved')";
            PreparedStatement pst = con.prepareStatement(sql);
            
            //sets the values from the textfield to the colums in the db
            pst.setString(1, name);
            pst.setString(2, u_id);
            pst.setString(3, role);
            pst.setString(4, pwd);
            pst.setString(5, secQuiz);
            pst.setString(6, answer);
            
            //If a database row is added to output a success message
            int updatedRowCount = pst.executeUpdate();
            
            if (updatedRowCount > 0){
                JOptionPane.showMessageDialog(this, "Record Added Successfully");
                //redirects to LoginPage
                LoginPage page = new LoginPage();
                page.setVisible(true);
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(this, "Record Insertion Failure. Please check your Database Connection...");
            }
            
        } catch (Exception e) {
            //catches the error, by printing where the error is emanating from
            e.printStackTrace();
        }
    }
    
    //Validate textfields not empty
    public boolean validateSignup(){
        String name = txt_username.getText();
        String pwd = txt_password.getText();
        String u_id = txt_id.getText();
        String answer = txt_answer.getText();
//        String role = cbo_role.getSelectedItem().toString();
        
        if (name.equals("")){
            JOptionPane.showMessageDialog(this, "Please Enter Username");
            return false;
        }
        
        if (pwd.equals("")){
            JOptionPane.showMessageDialog(this, "Please Enter Password");
            return false;
        }
        
        if (u_id.equals("")){
            JOptionPane.showMessageDialog(this, "Please Enter valid Registration Number/ Employee ID");
            return false;
        }
        if (answer.equals("")){
            JOptionPane.showMessageDialog(this, "Please Enter your Answer");
            return false;
        }
                
        return true;
    }
        
    //Check and prevent Duplicate data
    public boolean checkDuplicateUser(){
        String u_id = txt_id.getText();
        //Declare 'isExist' variable
        boolean isExist = false;
        
        try {
            Connection con = MyConnection.getConnection();
            
            PreparedStatement pst = con.prepareStatement("select * from users where user_id = ?");
            
            //uses the value from the textfield to the colums in the db
            pst.setString(1, u_id);
            
            //returns ResultSet value
            ResultSet rs = pst.executeQuery();
            if (rs.next()){
                isExist = true;
            }else{
                isExist = false;
            }
            
        }catch (Exception e){
            e.printStackTrace();
        }
        //returns the 'isExist' variable value
        return isExist;
    }
    
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
        jLabel4 = new javax.swing.JLabel();
        lbl_close = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_username = new app.bolivia.swing.JCTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_password = new app.bolivia.swing.JCTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_id = new app.bolivia.swing.JCTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btn_login = new rojerusan.RSMaterialButtonCircle();
        btn_signup = new rojerusan.RSMaterialButtonCircle();
        jLabel16 = new javax.swing.JLabel();
        cbo_role = new rojerusan.RSComboMetro();
        jLabel17 = new javax.swing.JLabel();
        txt_answer = new app.bolivia.swing.JCTextField();
        jLabel18 = new javax.swing.JLabel();
        cbo_quiz = new rojerusan.RSComboMetro();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1366, 766));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1366, 766));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 255));
        jLabel1.setText("Systems");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Sitka Display", 0, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 255));
        jLabel2.setText("Students' Redressal App ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, 310, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setText("EMMANUEL ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/icons/signup-library-icon.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 810, 610));

        jLabel6.setFont(new java.awt.Font("Sitka Display", 0, 30)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 51, 51));
        jLabel6.setText("Welcome To");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, 180, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 770));

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/icons/icons8_Account_50px.png"))); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 60, 50));

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
        jLabel8.setText("Create New Account Here");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 280, -1));

        txt_username.setBackground(new java.awt.Color(102, 153, 255));
        txt_username.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_username.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txt_username.setPlaceholder("Please Enter Username ....");
        txt_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usernameActionPerformed(evt);
            }
        });
        jPanel2.add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 260, 40));

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Username");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 180, -1));

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/icons/icons8_Secure_50px.png"))); // NOI18N
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 60, 50));

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Password");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 180, -1));

        txt_password.setBackground(new java.awt.Color(102, 153, 255));
        txt_password.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_password.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txt_password.setPlaceholder("Please Enter Password ....");
        txt_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passwordActionPerformed(evt);
            }
        });
        jPanel2.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 260, 40));

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/icons/icons8_Secured_Letter_50px.png"))); // NOI18N
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 60, 50));

        jLabel13.setFont(new java.awt.Font("Verdana", 0, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Employee ID/ Reg Number");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, 290, -1));

        txt_id.setBackground(new java.awt.Color(102, 153, 255));
        txt_id.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_id.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txt_id.setPlaceholder("Enter User ID/ Reg Number ....");
        txt_id.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_idFocusLost(evt);
            }
        });
        txt_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idActionPerformed(evt);
            }
        });
        jPanel2.add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, 260, 40));

        jLabel14.setFont(new java.awt.Font("Verdana", 0, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/icons/icons8_Account_50px.png"))); // NOI18N
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, 60, 50));

        jLabel15.setFont(new java.awt.Font("Verdana", 0, 20)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Role");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, 180, -1));

        btn_login.setBackground(new java.awt.Color(102, 102, 255));
        btn_login.setText("Login");
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });
        jPanel2.add(btn_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 680, 330, 70));

        btn_signup.setBackground(new java.awt.Color(255, 51, 51));
        btn_signup.setText("Signup");
        btn_signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_signupActionPerformed(evt);
            }
        });
        jPanel2.add(btn_signup, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 610, 330, 70));

        jLabel16.setFont(new java.awt.Font("Stencil", 0, 25)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Signup Page");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 170, -1));

        cbo_role.setBackground(new java.awt.Color(102, 153, 255));
        cbo_role.setForeground(new java.awt.Color(0, 0, 0));
        cbo_role.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Student", "Tutor", "COD", "Dean", "Admin" }));
        cbo_role.setColorBorde(new java.awt.Color(109, 109, 109));
        cbo_role.setColorFondo(new java.awt.Color(102, 153, 255));
        cbo_role.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jPanel2.add(cbo_role, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 380, 270, 40));

        jLabel17.setFont(new java.awt.Font("Verdana", 0, 20)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Answer");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 510, 100, -1));

        txt_answer.setBackground(new java.awt.Color(102, 153, 255));
        txt_answer.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_answer.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txt_answer.setPlaceholder("Answer to Security Question ...");
        txt_answer.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_answerFocusLost(evt);
            }
        });
        txt_answer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_answerActionPerformed(evt);
            }
        });
        jPanel2.add(txt_answer, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 540, 260, 40));

        jLabel18.setFont(new java.awt.Font("Verdana", 0, 20)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Security Question");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 430, 200, -1));

        cbo_quiz.setBackground(new java.awt.Color(102, 153, 255));
        cbo_quiz.setForeground(new java.awt.Color(0, 0, 0));
        cbo_quiz.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "What brand was your first car?", "Which Secondary school did you attend?", "Which town were you born in?", "What is the name of your pet?" }));
        cbo_quiz.setColorBorde(new java.awt.Color(109, 109, 109));
        cbo_quiz.setColorFondo(new java.awt.Color(102, 153, 255));
        cbo_quiz.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jPanel2.add(cbo_quiz, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 460, 270, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 0, 510, 760));

        setSize(new java.awt.Dimension(1366, 766));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usernameActionPerformed

    private void txt_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passwordActionPerformed

    private void txt_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idActionPerformed

    private void btn_signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_signupActionPerformed
        //validates signup textfields
        if (validateSignup() == true){
            //validates duplicate user in the db
            if (checkDuplicateUser() == false){
                insertSignupDetails();
            }else{
                JOptionPane.showMessageDialog(this, "Username already exists, Please visit your Systems Admin");
            }
            
        }
        
    }//GEN-LAST:event_btn_signupActionPerformed

    private void lbl_closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_closeMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lbl_closeMouseClicked

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        LoginPage page = new LoginPage();
        page.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_loginActionPerformed

    private void txt_idFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_idFocusLost
        if (checkDuplicateUser() == true){
            JOptionPane.showMessageDialog(this, "Username already exists, Please visit your Systems Admin");
            txt_id.setText("");
        }
    }//GEN-LAST:event_txt_idFocusLost

    private void txt_answerFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_answerFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_answerFocusLost

    private void txt_answerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_answerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_answerActionPerformed

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
            java.util.logging.Logger.getLogger(SignupPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignupPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignupPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignupPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignupPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSMaterialButtonCircle btn_login;
    private rojerusan.RSMaterialButtonCircle btn_signup;
    private rojerusan.RSComboMetro cbo_quiz;
    private rojerusan.RSComboMetro cbo_role;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_close;
    private app.bolivia.swing.JCTextField txt_answer;
    private app.bolivia.swing.JCTextField txt_id;
    private app.bolivia.swing.JCTextField txt_password;
    private app.bolivia.swing.JCTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
