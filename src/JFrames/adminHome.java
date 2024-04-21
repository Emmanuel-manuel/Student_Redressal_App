package JFrames;


import javax.swing.JOptionPane;
import db.*;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author EMMANUEL
 */
public class adminHome extends javax.swing.JFrame {

    //Global variable for Hover Effect
    Color mouseEnterColor = new Color(255, 153, 0);
    Color mouseExitColor = new Color(51, 51, 51);
    
    
    public adminHome() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnclear = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbl_close1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txt_search_by_name_or_ID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        lbl_viewIssuedBooks = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        lbl_manageBooks = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        lbl_manageStudents = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        lbl_issueBook = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        lbl_returnBook = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        lbl_viewRecords = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        lbl_logout = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));
        setMinimumSize(new java.awt.Dimension(1370, 760));
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnclear.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        btnclear.setForeground(new java.awt.Color(102, 0, 0));
        btnclear.setText("Refresh");
        btnclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearActionPerformed(evt);
            }
        });
        jPanel1.add(btnclear, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 70, -1, 40));

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/adminIcons/icons8_menu_48px_1.png"))); // NOI18N
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 50, 40));

        jPanel15.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 5, 50));

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/adminIcons/male_user_50px.png"))); // NOI18N
        jLabel8.setText("Welcome, Admin");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 10, -1, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("STUDENT REDRESSAL APPLICATION");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

        lbl_close1.setFont(new java.awt.Font("Calibri Light", 1, 40)); // NOI18N
        lbl_close1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_close1.setText(" X");
        lbl_close1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_close1MouseClicked(evt);
            }
        });
        jPanel2.add(lbl_close1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 10, 50, 50));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1366, 70));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "INID", "Name", "User ID", "Role", "Security Question", "Answer", "Status"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, 1030, 490));

        txt_search_by_name_or_ID.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_search_by_name_or_ID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                key_released(evt);
            }
        });
        jPanel1.add(txt_search_by_name_or_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 80, 231, 36));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setText("Search by Name or ID :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, -1, 33));

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Features");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 16, 230, 30));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 250, 60));

        jPanel5.setBackground(new java.awt.Color(255, 153, 0));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel5.setText("   Home Page");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 16, 190, 30));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 250, 60));

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/adminIcons/icons8_Library_32px.png"))); // NOI18N
        jLabel6.setText("  LMS Dashboard");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 16, 230, 30));

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 250, 60));

        jPanel7.setBackground(new java.awt.Color(51, 51, 51));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_viewIssuedBooks.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        lbl_viewIssuedBooks.setForeground(new java.awt.Color(153, 153, 153));
        lbl_viewIssuedBooks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/adminIcons/icons8_Books_26px.png"))); // NOI18N
        lbl_viewIssuedBooks.setText("  Label1");
        lbl_viewIssuedBooks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_viewIssuedBooksMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_viewIssuedBooksMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_viewIssuedBooksMouseExited(evt);
            }
        });
        jPanel7.add(lbl_viewIssuedBooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 16, 230, 30));

        jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 250, 60));

        jPanel8.setBackground(new java.awt.Color(51, 51, 51));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_manageBooks.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        lbl_manageBooks.setForeground(new java.awt.Color(153, 153, 153));
        lbl_manageBooks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/adminIcons/icons8_Book_26px.png"))); // NOI18N
        lbl_manageBooks.setText("  View Clearance");
        lbl_manageBooks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_manageBooksMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_manageBooksMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_manageBooksMouseExited(evt);
            }
        });
        jPanel8.add(lbl_manageBooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 16, 230, 30));

        jPanel3.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 250, 60));

        jPanel9.setBackground(new java.awt.Color(51, 51, 51));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_manageStudents.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        lbl_manageStudents.setForeground(new java.awt.Color(153, 153, 153));
        lbl_manageStudents.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/adminIcons/icons8_Read_Online_26px.png"))); // NOI18N
        lbl_manageStudents.setText("  View Missing Marks");
        lbl_manageStudents.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_manageStudentsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_manageStudentsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_manageStudentsMouseExited(evt);
            }
        });
        jPanel9.add(lbl_manageStudents, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 16, 230, 30));

        jPanel3.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 250, 60));

        jPanel10.setBackground(new java.awt.Color(51, 51, 51));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_issueBook.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        lbl_issueBook.setForeground(new java.awt.Color(153, 153, 153));
        lbl_issueBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/adminIcons/icons8_Sell_26px.png"))); // NOI18N
        lbl_issueBook.setText("  View Complains");
        lbl_issueBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_issueBookMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_issueBookMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_issueBookMouseExited(evt);
            }
        });
        jPanel10.add(lbl_issueBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 16, 230, 30));

        jPanel3.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 250, 60));

        jPanel11.setBackground(new java.awt.Color(51, 51, 51));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_returnBook.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        lbl_returnBook.setForeground(new java.awt.Color(153, 153, 153));
        lbl_returnBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/adminIcons/icons8_Return_Purchase_26px.png"))); // NOI18N
        lbl_returnBook.setText("  Label1");
        lbl_returnBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_returnBookMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_returnBookMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_returnBookMouseExited(evt);
            }
        });
        jPanel11.add(lbl_returnBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 16, 230, 30));

        jPanel3.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 250, 60));

        jPanel12.setBackground(new java.awt.Color(51, 51, 51));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_viewRecords.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        lbl_viewRecords.setForeground(new java.awt.Color(153, 153, 153));
        lbl_viewRecords.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/adminIcons/icons8_View_Details_26px.png"))); // NOI18N
        lbl_viewRecords.setText("  View Records");
        lbl_viewRecords.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_viewRecordsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_viewRecordsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_viewRecordsMouseExited(evt);
            }
        });
        jPanel12.add(lbl_viewRecords, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 16, 230, 30));

        jPanel3.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 250, 60));

        jPanel14.setBackground(new java.awt.Color(153, 51, 0));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_logout.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        lbl_logout.setForeground(new java.awt.Color(255, 255, 255));
        lbl_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/adminIcons/icons8_Exit_26px_2.png"))); // NOI18N
        lbl_logout.setText("  Log Out");
        lbl_logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_logoutMouseClicked(evt);
            }
        });
        jPanel14.add(lbl_logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 16, 230, 30));

        jPanel3.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 610, 250, 60));

        jPanel13.setBackground(new java.awt.Color(51, 51, 51));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(153, 153, 153));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/adminIcons/icons8_Conference_26px.png"))); // NOI18N
        jLabel13.setText("  View Complains");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel13MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel13MouseExited(evt);
            }
        });
        jPanel13.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 16, 230, 30));

        jPanel3.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, 250, 60));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 250, 690));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/icons/idea.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 70, 1370, 690));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 760));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearActionPerformed
        setVisible(false);
       new adminHome().setVisible(true);
    }//GEN-LAST:event_btnclearActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
       ResultSet rs = Select.getData("select * from users");
       DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
       model.setRowCount(0);
       try
       {
           while(rs.next())
           {
               model.addRow(new Object[ ]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(6),rs.getString(7),rs.getString(8)});
           }
           rs.close();
       }
       catch (Exception e)
       {
           JOptionPane.showMessageDialog(null, e);
       }
    }//GEN-LAST:event_formComponentShown

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int index = jTable1.getSelectedRow();
        TableModel model = jTable1.getModel();
        String u_id = model.getValueAt(index, 2).toString();
        String status = model.getValueAt(index, 6).toString();
        if(status.equals("Not_Approved"))
            status = "Approved";
        else
            status = "Not_Approved";
        try
        {
            int a = JOptionPane.showConfirmDialog(null, "Do you want to change status of "+u_id+"","Select",JOptionPane.YES_NO_OPTION);
            if (a==0)
            {
                InsertUpdateDelete.setData("update users set status='"+status+"' where user_id='"+u_id+"' ", "Status Changed Successfully");
                setVisible(false);
                new adminHome().setVisible(true);
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void key_released(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_key_released
        
        String search_by = txt_search_by_name_or_ID.getText();
       ResultSet rs = Select.getData("select * from users where username like '%"+search_by+"%' or user_id like '%"+search_by+"%' ");
       DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
       model.setRowCount(0);
       try
       {
           while(rs.next())
           {
               model.addRow(new Object[ ]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(6),rs.getString(7),rs.getString(8) });
           }
           rs.close();
       }
       catch (Exception e)
       {
           JOptionPane.showMessageDialog(null, e);
       }
    }//GEN-LAST:event_key_released

    private void lbl_viewIssuedBooksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_viewIssuedBooksMouseClicked
//        ViewIssuedBookDetails viewIssued = new ViewIssuedBookDetails();
//        viewIssued.setVisible(true);
//        dispose();
    }//GEN-LAST:event_lbl_viewIssuedBooksMouseClicked

    private void lbl_viewIssuedBooksMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_viewIssuedBooksMouseEntered
        jPanel7.setBackground(mouseEnterColor);
    }//GEN-LAST:event_lbl_viewIssuedBooksMouseEntered

    private void lbl_viewIssuedBooksMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_viewIssuedBooksMouseExited
        jPanel7.setBackground(mouseExitColor);
    }//GEN-LAST:event_lbl_viewIssuedBooksMouseExited

    private void lbl_manageBooksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_manageBooksMouseClicked
//        ManageBooks books = new ManageBooks();
//        books.setVisible(true);
//        dispose();
    }//GEN-LAST:event_lbl_manageBooksMouseClicked

    private void lbl_manageBooksMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_manageBooksMouseEntered
        jPanel8.setBackground(mouseEnterColor);
    }//GEN-LAST:event_lbl_manageBooksMouseEntered

    private void lbl_manageBooksMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_manageBooksMouseExited
        jPanel8.setBackground(mouseExitColor);
    }//GEN-LAST:event_lbl_manageBooksMouseExited

    private void lbl_manageStudentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_manageStudentsMouseClicked
//        ManageStudents student = new ManageStudents();
//        student.setVisible(true);
//        dispose();
    }//GEN-LAST:event_lbl_manageStudentsMouseClicked

    private void lbl_manageStudentsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_manageStudentsMouseEntered
        jPanel9.setBackground(mouseEnterColor);
    }//GEN-LAST:event_lbl_manageStudentsMouseEntered

    private void lbl_manageStudentsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_manageStudentsMouseExited
        jPanel9.setBackground(mouseExitColor);
    }//GEN-LAST:event_lbl_manageStudentsMouseExited

    private void lbl_issueBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_issueBookMouseClicked
        
    }//GEN-LAST:event_lbl_issueBookMouseClicked

    private void lbl_issueBookMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_issueBookMouseEntered
        jPanel10.setBackground(mouseEnterColor);
    }//GEN-LAST:event_lbl_issueBookMouseEntered

    private void lbl_issueBookMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_issueBookMouseExited
        jPanel10.setBackground(mouseExitColor);
    }//GEN-LAST:event_lbl_issueBookMouseExited

    private void lbl_returnBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_returnBookMouseClicked
        
    }//GEN-LAST:event_lbl_returnBookMouseClicked

    private void lbl_returnBookMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_returnBookMouseEntered
        jPanel11.setBackground(mouseEnterColor);
    }//GEN-LAST:event_lbl_returnBookMouseEntered

    private void lbl_returnBookMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_returnBookMouseExited
        jPanel11.setBackground(mouseExitColor);
    }//GEN-LAST:event_lbl_returnBookMouseExited

    private void lbl_viewRecordsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_viewRecordsMouseClicked
        
    }//GEN-LAST:event_lbl_viewRecordsMouseClicked

    private void lbl_viewRecordsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_viewRecordsMouseEntered
        jPanel12.setBackground(mouseEnterColor);
    }//GEN-LAST:event_lbl_viewRecordsMouseEntered

    private void lbl_viewRecordsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_viewRecordsMouseExited
        jPanel12.setBackground(mouseExitColor);
    }//GEN-LAST:event_lbl_viewRecordsMouseExited

    private void lbl_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_logoutMouseClicked
        LoginPage login = new LoginPage();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_lbl_logoutMouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseEntered
        jPanel13.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel13MouseEntered

    private void jLabel13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseExited
        jPanel13.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel13MouseExited

    private void lbl_close1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_close1MouseClicked
        int a= JOptionPane.showConfirmDialog(null, "Do you really want to Close Application?", "Select",JOptionPane.YES_NO_OPTION);
        if(a==0)
        {
            System.exit(0);
        }
        
    }//GEN-LAST:event_lbl_close1MouseClicked

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
            java.util.logging.Logger.getLogger(adminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnclear;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbl_close1;
    private javax.swing.JLabel lbl_issueBook;
    private javax.swing.JLabel lbl_logout;
    private javax.swing.JLabel lbl_manageBooks;
    private javax.swing.JLabel lbl_manageStudents;
    private javax.swing.JLabel lbl_returnBook;
    private javax.swing.JLabel lbl_viewIssuedBooks;
    private javax.swing.JLabel lbl_viewRecords;
    private javax.swing.JTextField txt_search_by_name_or_ID;
    // End of variables declaration//GEN-END:variables
}