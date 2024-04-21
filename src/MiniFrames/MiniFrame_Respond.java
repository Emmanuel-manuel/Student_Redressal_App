package MiniFrames;

import JFrames.*;
import db.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
//import tray.notification.TrayNotification;


/**
 *
 * @author Lenovo-x130
 */
public class MiniFrame_Respond extends javax.swing.JFrame {

    Connection con = MyConnection.getConnection();

    Complaints complaints = new Complaints();

    // Gets the window's screen position
    int xx, xy;

    // Define variables to hold data
    private String complaintID;
    private String reason;
    private String description;

    /**
     * Creates new form MiniFrame_Respond
     */
    public MiniFrame_Respond(int complaintID, String reason, String description) {
        initComponents();

//        this.complaintID = complaintID;
        this.complaintID = String.valueOf(complaintID); // Convert int to String
        this.reason = reason;
        this.description = description;
        // Populate text fields with data
        txtComplaintID.setText(String.valueOf(complaintID)); // Set text using String.valueOf()
//        txtComplaintID.setText(complaintID);
        txtReason.setText(reason);
        textDescription.setText(description);
    }

    private MiniFrame_Respond() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lbl_back = new javax.swing.JLabel();
        txtComplaintID = new app.bolivia.swing.JCTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtReason = new app.bolivia.swing.JCTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        textDescription = new javax.swing.JTextArea();
        jScrollPane7 = new javax.swing.JScrollPane();
        textResponse = new javax.swing.JTextArea();
        btnSendResponse = new rojerusan.RSMaterialButtonCircle();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(806, 546));
        setMinimumSize(new java.awt.Dimension(806, 546));
        setUndecorated(true);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                formFocusLost(evt);
            }
        });
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                lost_focus(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel3MouseDragged(evt);
            }
        });
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel3MousePressed(evt);
            }
        });
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 51));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/AddNewBookIcons/icons8_Edit_Property_50px.png"))); // NOI18N
        jLabel1.setText("  RESPOND TO COMPLAINTS");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, -1, -1));

        jPanel4.setBackground(new java.awt.Color(255, 102, 51));
        jPanel4.setForeground(new java.awt.Color(255, 102, 51));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 370, 4));

        jPanel2.setBackground(new java.awt.Color(255, 102, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_back.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        lbl_back.setForeground(new java.awt.Color(255, 255, 255));
        lbl_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        lbl_back.setText("Back");
        lbl_back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_backMouseClicked(evt);
            }
        });
        jPanel2.add(lbl_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 110, -1));

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 50));

        txtComplaintID.setEditable(false);
        txtComplaintID.setBackground(new java.awt.Color(204, 204, 204));
        txtComplaintID.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txtComplaintID.setPlaceholder("s.No");
        jPanel3.add(txtComplaintID, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 200, 35));

        jLabel27.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel27.setText("Reason:");
        jPanel3.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 110, -1));

        jLabel29.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel29.setText("Complaint: ");
        jPanel3.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 100, 20));

        txtReason.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txtReason.setPlaceholder("Reason For Complaint");
        jPanel3.add(txtReason, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 350, 40));

        jLabel28.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel28.setText("Complaint Number: ");
        jPanel3.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, -1));

        jLabel30.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel30.setText("Response: ");
        jPanel3.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, 100, 20));

        textDescription.setColumns(20);
        textDescription.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        textDescription.setRows(5);
        jScrollPane6.setViewportView(textDescription);

        jPanel3.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 350, 110));

        textResponse.setColumns(20);
        textResponse.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        textResponse.setRows(5);
        jScrollPane7.setViewportView(textResponse);

        jPanel3.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 340, 350, 110));

        btnSendResponse.setText("Send Response");
        btnSendResponse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendResponseActionPerformed(evt);
            }
        });
        jPanel3.add(btnSendResponse, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 480, 150, 60));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 550));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Checks Missing Fields & Data Validation
    public boolean isEmpty() {

        if (txtComplaintID.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Complaint ID is Missing");
            return false;
        }
        if (textDescription.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Complaint Description is Missing");
            return false;
        }
        if (textResponse.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Response is Missing");
            return false;
        }
        if (txtReason.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Reason is Missing");
            return false;
        }
        return true;
    }

    // clears the JFrame components
    private void clearResponse() {
        txtComplaintID.setText("");
        txtReason.setText("");
        textDescription.setText("");
        textResponse.setText("");
    }
    private void lbl_backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_backMouseClicked
        this.dispose();
    }//GEN-LAST:event_lbl_backMouseClicked

    private void formFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusLost
//        this.dispose();
    }//GEN-LAST:event_formFocusLost

    private void lost_focus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_lost_focus
//        this.dispose();
    }//GEN-LAST:event_lost_focus

    private void btnSendResponseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendResponseActionPerformed

        if (isEmpty()) {
// Call method to insert data into the responses table
            insertResponseData();
            clearResponse();
        }
    }//GEN-LAST:event_btnSendResponseActionPerformed

    // Method to insert data into the responses table
    private void insertResponseData() {
        try {

            // Define SQL query to insert data
            String query = "INSERT INTO responses (complaint_ID, reason, description, response) VALUES (?, ?, ?, ?)";
            // Create PreparedStatement
            PreparedStatement ps = con.prepareStatement(query);
            // Set parameters
            ps.setString(1, txtComplaintID.getText());
            ps.setString(2, txtReason.getText());
            ps.setString(3, textDescription.getText());
            ps.setString(4, textResponse.getText());
            // Execute query
            ps.executeUpdate();
            // Close PreparedStatement
            ps.close();
            // Close Connection
            con.close();
            // Show success message
            JOptionPane.showMessageDialog(this, "Response Sent Successfully");

            // Show success notification
//            TrayNotification.success("Success", "Response sent successfully");

        } catch (SQLException ex) {
            // Handle SQL exception
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private void jPanel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MousePressed

        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_jPanel3MousePressed

    private void jPanel3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseDragged

        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_jPanel3MouseDragged

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
            java.util.logging.Logger.getLogger(MiniFrame_Respond.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MiniFrame_Respond.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MiniFrame_Respond.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MiniFrame_Respond.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MiniFrame_Respond().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSMaterialButtonCircle btnSendResponse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JLabel lbl_back;
    private javax.swing.JTextArea textDescription;
    private javax.swing.JTextArea textResponse;
    private app.bolivia.swing.JCTextField txtComplaintID;
    private app.bolivia.swing.JCTextField txtReason;
    // End of variables declaration//GEN-END:variables
}
