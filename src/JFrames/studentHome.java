package JFrames;

import db.*;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author EMMANUEL
 */
public class studentHome extends javax.swing.JFrame {

    //    ............  GENERATE TRANSCRIPT REPORT METHOD  ..........
    public void my_report() {
        // Clear the JTextArea
        txt_transcript.setText("");

        // Set the logo icon from file path: G:\Netbeans_project\Student_Redressal_App\src\res\icons
        String logoPath = "src\\res\\icons\\kafu_logo.png";
//    String logoPath = "/src/res/icons/kafu_logo.png";
        String base64Logo = encodeImageToBase64(logoPath);
        ImageIcon logoIcon = new ImageIcon(Base64.getDecoder().decode(base64Logo));
        lbl_logo.setIcon(logoIcon);

        // Append the transcript text to the JTextArea
        txt_transcript.append(" \n \n ");
        txt_transcript.append(" \t KAIMOSI FRIENDS UNIVERSITY \n");
        txt_transcript.append(" \t  P.O BOX 385 - 50309 KAIMOSI - KENYA \n");
        txt_transcript.append(" \t     CELL: 0777373633 \n");
        txt_transcript.append(" \t Email: info@kafu.ac.ke ~ Web: www.kafu.ac.ke \n");
        txt_transcript.append("     PROVISIONAL UNDERGRADUATE ACADEMIC TRANSCRIPT \n");
        txt_transcript.append("_______________________________________________________\n");

        // Fetch student's name from the database
        String regNo = txtSearchMarkSheet.getText();
        String studentName = getStudentName(regNo);

        txt_transcript.append("STUDENT NAME: " + studentName + "          " + "REG. NO: " + regNo + "\n");
        txt_transcript.append("PROGRAMME: BACHELOR OF SCIENCE (INFORMATION TECHNOLOGY) \n");
        txt_transcript.append("DEPARTMENT: INFORMATION TECHNOLOGY AND INFORMATICS \n");
        txt_transcript.append("SCHOOL/FACULTY: SCHOOL OF COMPUTING AND INFORMATION \n"
                + "                TECHNOLOGY \n");

        txt_transcript.append("_______________________________________________________\n");

        txt_transcript.append("UNIT TITLE              " + "       |" + "          MARKS " + "\n");
        txt_transcript.append("\n");

        int maxCourseLen = 0;
        for (int i = 0; i < tbl_detailsMarksSheet.getRowCount(); i++) {
            for (int j = 4; j <= 12; j += 2) {
                String course = tbl_detailsMarksSheet.getValueAt(i, j).toString();
                maxCourseLen = Math.max(maxCourseLen, course.length());
            }
        }

        DefaultTableModel model = (DefaultTableModel) tbl_detailsMarksSheet.getModel();
//        This is responsible for creating vertical lines in the report
//        StringBuilder line = new StringBuilder();

        for (int i = 0; i < tbl_detailsMarksSheet.getRowCount(); i++) {
//            line.setLength(0);

            String course1 = tbl_detailsMarksSheet.getValueAt(i, 4).toString();
            String score1 = tbl_detailsMarksSheet.getValueAt(i, 5).toString();
            String course2 = tbl_detailsMarksSheet.getValueAt(i, 6).toString();
            String score2 = tbl_detailsMarksSheet.getValueAt(i, 7).toString();
            String course3 = tbl_detailsMarksSheet.getValueAt(i, 8).toString();
            String score3 = tbl_detailsMarksSheet.getValueAt(i, 9).toString();
            String course4 = tbl_detailsMarksSheet.getValueAt(i, 10).toString();
            String score4 = tbl_detailsMarksSheet.getValueAt(i, 11).toString();
            String course5 = tbl_detailsMarksSheet.getValueAt(i, 12).toString();
            String score5 = tbl_detailsMarksSheet.getValueAt(i, 13).toString();

            txt_transcript.append(String.format("%-" + (maxCourseLen + 10) + "s%s%n", course1, score1));
            txt_transcript.append("_______________________________________________________\n");
            txt_transcript.append(String.format("%-" + (maxCourseLen + 10) + "s%s%n", course2, score2));
            txt_transcript.append("_______________________________________________________\n");
            txt_transcript.append(String.format("%-" + (maxCourseLen + 10) + "s%s%n", course3, score3));
            txt_transcript.append("_______________________________________________________\n");
            txt_transcript.append(String.format("%-" + (maxCourseLen + 10) + "s%s%n", course4, score4));
            txt_transcript.append("_______________________________________________________\n");
            txt_transcript.append(String.format("%-" + (maxCourseLen + 10) + "s%s%n", course5, score5));
            txt_transcript.append("_______________________________________________________\n");

        }

        String grand_tot = lblCummulative.getText();
        String Tdate = txtDate.getText();

        txt_transcript.append("========================================================\n");
        txt_transcript.append(grand_tot + " %" + "\n");
        txt_transcript.append("========================================================\n" + "\n");
        txt_transcript.append("Signed:_________________________" + "   " + Tdate + "\n");
        txt_transcript.append("\t" + "DEAN, SCHOOL OF COMPUTING " + "  " + "DATE" + "\n");
        txt_transcript.append("\t" + "& INFORMATION TECHNOLOGY " + "\n");
    }

//    ................. METHOD TO PULL STUDENT_NAME ......................
    private String getStudentName(String regNo) {
        String studentName = "";
        try {
            String query = "SELECT name FROM student WHERE student_id = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, regNo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                studentName = rs.getString("name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentName;
    }

//    ................. METHOD TO INSERT LOGO ............................
    private static String encodeImageToBase64(String imagePath) {
        String base64Image = "";
        try {
            File file = new File(imagePath);
            byte[] bytes = Files.readAllBytes(file.toPath());
            base64Image = Base64.getEncoder().encodeToString(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return base64Image;
    }


    
    //Calls the other public java Classes
    Complaints complaints = new Complaints();
    MarkSheet markSheet = new MarkSheet();

    // Gets the window's screen position
    int xx, xy;

    private String imagePath;

    //JTable
    private DefaultTableModel model;
    private int rowIndex;

    //Gets the Double NumberFormat
    NumberFormat nf = NumberFormat.getInstance();

    public studentHome() {
        initComponents();
        init();
    }

    Connection con = MyConnection.getConnection();
    PreparedStatement ps;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbl_close1 = new javax.swing.JLabel();
        txtTime = new javax.swing.JLabel();
        txtDate = new javax.swing.JLabel();
        lbl_logout = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jlabelimage = new javax.swing.JLabel();
        btnBrowse = new rojerusan.RSMaterialButtonCircle();
        cboReason = new rojerusan.RSComboMetro();
        jComplaintDate = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        textDescription = new javax.swing.JTextArea();
        btnPost = new rojerusan.RSMaterialButtonCircle();
        jLabel2 = new javax.swing.JLabel();
        txtComplaintID = new app.bolivia.swing.JCTextField();
        btnRefreshComplaints = new rojerusan.RSMaterialButtonCircle();
        jPanel32 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        txtSearchComplaintNo = new app.bolivia.swing.JCTextField();
        btnSearchComplaintNo = new rojerusan.RSMaterialButtonCircle();
        jLabel3 = new javax.swing.JLabel();
        txtComplaintINID = new app.bolivia.swing.JCTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        txtComplaintDate = new app.bolivia.swing.JCTextField();
        txtComplaintReason = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        textResponse = new javax.swing.JTextArea();
        jPanel27 = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        txtSearchMarkSheet = new app.bolivia.swing.JCTextField();
        btnSearchMarksheet = new rojerusan.RSMaterialButtonCircle();
        transcriptPanel = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        txt_transcript = new javax.swing.JTextArea();
        lbl_logo = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl_detailsMarksSheet = new rojeru_san.complementos.RSTableMetro();
        jPanel34 = new javax.swing.JPanel();
        btnPrintMarkSheet = new rojerusan.RSMaterialButtonCircle();
        btnClearMarkSheet = new rojerusan.RSMaterialButtonCircle();
        jPanel22 = new javax.swing.JPanel();
        lblCummulative = new javax.swing.JLabel();
        btnGenerateTranscript = new rojerusan.RSMaterialButtonCircle();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1370, 760));
        setUndecorated(true);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 153, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("STUDENT REDRESSAL APPLICATION");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 810, 60));

        lbl_close1.setFont(new java.awt.Font("Times New Roman", 1, 40)); // NOI18N
        lbl_close1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_close1.setText(" X");
        lbl_close1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_close1MouseClicked(evt);
            }
        });
        jPanel2.add(lbl_close1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 10, 60, 50));

        txtTime.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        txtTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(txtTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 10, 180, 30));

        txtDate.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(txtDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 40, 210, 30));

        lbl_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/icons/logout.png"))); // NOI18N
        lbl_logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_logoutMouseClicked(evt);
            }
        });
        jPanel2.add(lbl_logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 0, 60, 60));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, -1));

        jTabbedPane1.setBackground(new java.awt.Color(0, 153, 153));
        jTabbedPane1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 102), 2, true));
        jTabbedPane1.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 102), 2, true));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(51, 255, 153));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 102), 2, true));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel9.setText("Description: ");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 90, 20));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel10.setText("Complaint Date: ");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 120, 20));

        jPanel6.setBackground(new java.awt.Color(51, 255, 153));
        jPanel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 102), 3, true));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setBackground(new java.awt.Color(51, 255, 153));
        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel12.setText("Image");
        jPanel6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel7.setBackground(new java.awt.Color(51, 255, 153));
        jPanel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 102), 3, true));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlabelimage.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.add(jlabelimage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 200));

        jPanel6.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 270, 200));

        btnBrowse.setBackground(new java.awt.Color(153, 153, 0));
        btnBrowse.setForeground(new java.awt.Color(0, 0, 0));
        btnBrowse.setText("Browse");
        btnBrowse.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseActionPerformed(evt);
            }
        });
        jPanel6.add(btnBrowse, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 100, 70));

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 410, 200));

        cboReason.setForeground(new java.awt.Color(0, 0, 0));
        cboReason.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Education Oriented", "Finance", "Staff Work Ethics", "Other" }));
        cboReason.setColorFondo(new java.awt.Color(204, 204, 204));
        cboReason.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPanel4.add(cboReason, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 270, 40));

        jComplaintDate.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPanel4.add(jComplaintDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 270, 40));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel11.setText("Reason: ");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 70, 20));

        textDescription.setColumns(20);
        textDescription.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        textDescription.setRows(5);
        jScrollPane6.setViewportView(textDescription);

        jPanel4.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 270, 160));

        btnPost.setText("POST COMPLAINT");
        btnPost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPostActionPerformed(evt);
            }
        });
        jPanel4.add(btnPost, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 450, 180, 60));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel2.setText("INID");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 100, -1));

        txtComplaintID.setEditable(false);
        txtComplaintID.setBackground(new java.awt.Color(204, 204, 204));
        txtComplaintID.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txtComplaintID.setPlaceholder("s.No");
        jPanel4.add(txtComplaintID, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 160, 35));

        btnRefreshComplaints.setText("Refresh");
        btnRefreshComplaints.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshComplaintsActionPerformed(evt);
            }
        });
        jPanel4.add(btnRefreshComplaints, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 520, 170, 60));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 640));

        jPanel32.setBackground(new java.awt.Color(51, 255, 153));
        jPanel32.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 102), 2, true));
        jPanel32.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel23.setBackground(new java.awt.Color(51, 255, 153));
        jPanel23.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 102), 3, true));
        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setBackground(new java.awt.Color(51, 255, 153));
        jLabel27.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel27.setText("Complaint Number: ");
        jPanel23.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        txtSearchComplaintNo.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        txtSearchComplaintNo.setPlaceholder("Please Type Complaint Number");
        jPanel23.add(txtSearchComplaintNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 280, 40));

        btnSearchComplaintNo.setBackground(new java.awt.Color(0, 204, 204));
        btnSearchComplaintNo.setForeground(new java.awt.Color(0, 0, 0));
        btnSearchComplaintNo.setText("Search");
        btnSearchComplaintNo.setFont(new java.awt.Font("Times New Roman", 1, 17)); // NOI18N
        btnSearchComplaintNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchComplaintNoActionPerformed(evt);
            }
        });
        jPanel23.add(btnSearchComplaintNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, 100, 50));

        jPanel32.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 690, 90));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 21)); // NOI18N
        jLabel3.setText("View Complaints & Missing Marks Responses:");
        jPanel32.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 420, 50));

        txtComplaintINID.setEditable(false);
        txtComplaintINID.setBackground(new java.awt.Color(204, 204, 204));
        txtComplaintINID.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txtComplaintINID.setPlaceholder("ID");
        jPanel32.add(txtComplaintINID, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 200, 35));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel15.setText("Complaint ID: ");
        jPanel32.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 120, -1));

        jLabel51.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel51.setText("Complaint Date: ");
        jPanel32.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, -1, -1));

        txtComplaintDate.setEditable(false);
        txtComplaintDate.setBackground(new java.awt.Color(204, 204, 204));
        txtComplaintDate.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jPanel32.add(txtComplaintDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 300, 35));

        txtComplaintReason.setEditable(false);
        txtComplaintReason.setBackground(new java.awt.Color(204, 204, 204));
        txtComplaintReason.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel32.add(txtComplaintReason, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, 300, 35));

        jLabel58.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel58.setText("Reason: ");
        jPanel32.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 70, -1));

        jLabel59.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel59.setText("Response:  ");
        jPanel32.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 440, 80, -1));

        textResponse.setColumns(20);
        textResponse.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        textResponse.setRows(5);
        jScrollPane7.setViewportView(textResponse);

        jPanel32.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 470, 300, 160));

        jPanel3.add(jPanel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 0, 690, 640));

        jTabbedPane1.addTab("File Complaints", jPanel3);

        jPanel27.setBackground(new java.awt.Color(0, 153, 153));
        jPanel27.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 102), 2, true));
        jPanel27.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel28.setBackground(new java.awt.Color(51, 255, 153));
        jPanel28.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 102), 2, true));
        jPanel28.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel21.setBackground(new java.awt.Color(51, 255, 153));
        jPanel21.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 102), 3, true));
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setBackground(new java.awt.Color(51, 255, 153));
        jLabel26.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel26.setText("Student's ID");
        jPanel21.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        txtSearchMarkSheet.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        txtSearchMarkSheet.setPlaceholder("Search by Student ID");
        jPanel21.add(txtSearchMarkSheet, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 230, 40));

        btnSearchMarksheet.setBackground(new java.awt.Color(0, 204, 204));
        btnSearchMarksheet.setForeground(new java.awt.Color(0, 0, 0));
        btnSearchMarksheet.setText("Search");
        btnSearchMarksheet.setFont(new java.awt.Font("Times New Roman", 1, 17)); // NOI18N
        btnSearchMarksheet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchMarksheetActionPerformed(evt);
            }
        });
        jPanel21.add(btnSearchMarksheet, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, 100, 50));

        jPanel28.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 90));

        transcriptPanel.setLayout(new java.awt.BorderLayout());

        txt_transcript.setEditable(false);
        txt_transcript.setColumns(20);
        txt_transcript.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        txt_transcript.setRows(20);
        jScrollPane8.setViewportView(txt_transcript);

        transcriptPanel.add(jScrollPane8, java.awt.BorderLayout.CENTER);

        lbl_logo.setBackground(new java.awt.Color(204, 204, 204));
        transcriptPanel.add(lbl_logo, java.awt.BorderLayout.PAGE_START);

        jPanel28.add(transcriptPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 390, 490));

        jPanel27.add(jPanel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 640));

        jPanel31.setBackground(new java.awt.Color(51, 255, 153));
        jPanel31.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 102), 2, true));
        jPanel31.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel33.setBackground(new java.awt.Color(51, 255, 153));
        jPanel33.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 102), 3, true));
        jPanel33.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_detailsMarksSheet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Student's ID", "Semester", "Course 1", "Score 1", "Course 2", "Score 2", "Course 3", "Score 3", "Course 4", "Score 4", "Course 5", "Score 5", "Average"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_detailsMarksSheet.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbl_detailsMarksSheet.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tbl_detailsMarksSheet.setFuenteFilas(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tbl_detailsMarksSheet.setFuenteFilasSelect(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tbl_detailsMarksSheet.setFuenteHead(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jScrollPane5.setViewportView(tbl_detailsMarksSheet);

        jPanel33.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 4, 970, 560));

        jPanel31.add(jPanel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, 0, 970, 570));

        jPanel34.setBackground(new java.awt.Color(51, 255, 153));
        jPanel34.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 102), 3, true));
        jPanel34.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnPrintMarkSheet.setText("Print");
        btnPrintMarkSheet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintMarkSheetActionPerformed(evt);
            }
        });
        jPanel34.add(btnPrintMarkSheet, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 130, 60));

        btnClearMarkSheet.setText("Clear");
        btnClearMarkSheet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearMarkSheetActionPerformed(evt);
            }
        });
        jPanel34.add(btnClearMarkSheet, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 130, 60));

        jPanel22.setBackground(new java.awt.Color(51, 255, 153));
        jPanel22.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 102), 3, true));
        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCummulative.setBackground(new java.awt.Color(51, 255, 153));
        lblCummulative.setFont(new java.awt.Font("Times New Roman", 1, 25)); // NOI18N
        lblCummulative.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCummulative.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel22.add(lblCummulative, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 70));

        jPanel34.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 380, 70));

        btnGenerateTranscript.setText("Generate Transcript");
        btnGenerateTranscript.setFont(new java.awt.Font("Constantia", 0, 17)); // NOI18N
        btnGenerateTranscript.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnGenerateTranscript.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateTranscriptActionPerformed(evt);
            }
        });
        jPanel34.add(btnGenerateTranscript, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 210, 60));

        jPanel31.add(jPanel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 570, 970, 70));

        jPanel27.add(jPanel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 970, 640));

        jTabbedPane1.addTab("Marks Sheet", jPanel27);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1370, 680));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 760));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void init() {
        setTime();
        //        getMax for complaints 
        txtComplaintID.setText(String.valueOf(complaints.getMax()));

        tableViewMarksSheet();
    }

    private void tableViewMarksSheet() {
//        score.getScoreValue(tbl_detailsMarksSheet, "");
        model = (DefaultTableModel) tbl_detailsMarksSheet.getModel();
        tbl_detailsMarksSheet.setRowHeight(30);
        tbl_detailsMarksSheet.setShowGrid(true);
        tbl_detailsMarksSheet.setGridColor(Color.darkGray);
        tbl_detailsMarksSheet.setBackground(Color.WHITE);
    }

    private void clearComplaint() {
        txtComplaintID.setText(String.valueOf(complaints.getMax()));
        jComplaintDate.setDate(null);
        cboReason.setSelectedIndex(0);
        textDescription.setText("");
        jlabelimage.setIcon(null);
        imagePath = null;

        txtSearchComplaintNo.setText("");
        txtComplaintINID.setText("");
        txtComplaintDate.setText("");
        txtComplaintReason.setText("");
        textResponse.setText("");
    }

//    Displays Current Date & Time
    public void setTime() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(COD_Home.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    Date date = new Date();
                    SimpleDateFormat tf = new SimpleDateFormat("h:mm:ss aa");
                    SimpleDateFormat df = new SimpleDateFormat("EEEE, dd/MM/yyyy");
                    String time = tf.format(date);
                    txtTime.setText(time.split(" ")[0] + " " + time.split(" ")[1]);
                    txtDate.setText(df.format(date));
                }
            }
        }).start();
    }

    // Checks Missing Fields & Data Validation
    public boolean isEmpty() {
        if (jComplaintDate.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Date is Required");
            return false;
        }
        if (jComplaintDate.getDate().compareTo(new Date()) > 0) {
            JOptionPane.showMessageDialog(this, "Can't Post/Update a data from the future");
            return false;
        }
        if (textDescription.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Brief Description is Missing");
            return false;
        }
//        if (imagePath == null) {
//            JOptionPane.showMessageDialog(this, "Please Add Your Image");
//            return false;
//        }
        return true;
    }

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseClicked

    private void lbl_close1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_close1MouseClicked
        int a = JOptionPane.showConfirmDialog(null, "Do you really want to Close Application?", "Select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_lbl_close1MouseClicked

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged

        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_jPanel2MouseDragged

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed

        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    private void btnClearMarkSheetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearMarkSheetActionPerformed

        txtSearchMarkSheet.setText("");
        lblCummulative.setText("");

        // WHEN THE Search Textfield has been cleared it returns null values to the JTable...Clears the Table
        tbl_detailsMarksSheet.setModel(new DefaultTableModel(null, new Object[]{"ID", "Student ID", "Academic Year", "Semester",
            "Course 1", "Score 1", "Course 2", "Score 2", "Course 3", "Score 3", "Course 4", "Score 4",
            "Course 5", "Score 5", "Average"}));
    }//GEN-LAST:event_btnClearMarkSheetActionPerformed

    private void btnPrintMarkSheetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintMarkSheetActionPerformed
        try {
            txt_transcript.print();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnPrintMarkSheetActionPerformed

    private void btnSearchMarksheetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchMarksheetActionPerformed
        if (txtSearchMarkSheet.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please insert Student ID");

        } else {
            String sid = txtSearchMarkSheet.getText();

            if (markSheet.isIdExist(sid)) {
                tbl_detailsMarksSheet.setModel(new DefaultTableModel(null, new Object[]{"ID", "Student ID", "Academic Year", "Semester",
                    "Course 1", "Score 1", "Course 2", "Score 2", "Course 3", "Score 3", "Course 4", "Score 4",
                    "Course 5", "Score 5", "Average"}));

                //Refreshes the JTable
                markSheet.getScoreValue(tbl_detailsMarksSheet, sid);

                String cgpa = String.valueOf(String.format("%.2f", markSheet.getCGPA(sid)));
                lblCummulative.setText("CUMMULATIVE MEAN: " + cgpa);

            } else {
                JOptionPane.showMessageDialog(this, "No scores found for this Student");
            }
        }
    }//GEN-LAST:event_btnSearchMarksheetActionPerformed

//    ...........   END OF MISSING MARKS  ............
//   ............  START OF COMPLAINTS MODULE ........
    private void btnPostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPostActionPerformed

        if (isEmpty()) {

            int id = complaints.getMax();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String date = df.format(jComplaintDate.getDate());
            String reason = cboReason.getSelectedItem().toString();
            //            String reason = (String)cboReason.getSelectedItem();
            String desc = textDescription.getText();

            try {

                Connection con = MyConnection.getConnection();
                String sql = "insert into complaints(id, complaint_date, reason, description, image, status) values(?,?,?,?,?,'unread')";
                PreparedStatement ps = con.prepareStatement(sql);
                //sets the values from the textfield to the colums in the db
                ps.setInt(1, id);
                ps.setString(2, date);
                ps.setString(3, reason);
                ps.setString(4, desc);
//                ps.setBytes(5, imageBytes);
                // Check if imagePath is not null, if not, read the image file into a byte array
                if (imagePath != null) {
                    File imageFile = new File(imagePath);
                    byte[] imageBytes = Files.readAllBytes(imageFile.toPath());
                    ps.setBytes(5, imageBytes);
                } else {
                    // If imagePath is null, set image column to null
                    ps.setNull(5, Types.BLOB);
                }

                //Pus
                //If a database row is added to output a success message
                int updatedRowCount = ps.executeUpdate();

                if (updatedRowCount > 0) {
                    JOptionPane.showMessageDialog(this, "Complaint Posted Successfully");
                    //Refreshes the Textfields and other Items on the window
                    clearComplaint();
                } else {
                    JOptionPane.showMessageDialog(this, "Complaint Post Failure. Please check your Database Connection...");
                }

            } catch (Exception e) {
                //catches the error, by printing where the error is emanating from
                e.printStackTrace();
            }
//            else {
//            JOptionPane.showMessageDialog(this, "Please fill in all fields");
//        }
        }
    }//GEN-LAST:event_btnPostActionPerformed

    private void btnBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseActionPerformed

        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.image", "jpg", "gif", "png", "jpeg");
        file.addChoosableFileFilter(filter);
        int output = file.showSaveDialog(file);
        if (output == JFileChooser.APPROVE_OPTION) {
            File selectFile = file.getSelectedFile();
            String path = selectFile.getAbsolutePath();
            jlabelimage.setIcon(imageAdjust(path, null));
            imagePath = path;

        } else {
            JOptionPane.showMessageDialog(this, "Please select an Image");
        }
    }//GEN-LAST:event_btnBrowseActionPerformed

    private void btnRefreshComplaintsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshComplaintsActionPerformed

//Refreshes the Textfields and other Items on the window
        clearComplaint();
    }//GEN-LAST:event_btnRefreshComplaintsActionPerformed

//    .............. PULLING COMPLAINT RESPONSE PART ........

    private void btnSearchComplaintNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchComplaintNoActionPerformed

        if (txtSearchComplaintNo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Complaint Number is Missing");
            return; // Exit the method if any of the fields are empty

        }
        String cid = txtSearchComplaintNo.getText();

        int ComplaintNo = Integer.parseInt(cid);

        getComplaintDetails(ComplaintNo);
        getResponseDetails(ComplaintNo);

    }//GEN-LAST:event_btnSearchComplaintNoActionPerformed

    private void lbl_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_logoutMouseClicked
        int a = JOptionPane.showConfirmDialog(null, "Do you really want to Logout?", "Logout?", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            setVisible(false);
            new LoginPage().setVisible(true);
        }
    }//GEN-LAST:event_lbl_logoutMouseClicked

    private void btnGenerateTranscriptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateTranscriptActionPerformed

        my_report();
    }//GEN-LAST:event_btnGenerateTranscriptActionPerformed

//    ............ USES complaint_id TO PULL DATA FROM COMPLAINTS TABLE TO THE INTERFACE
    public boolean getComplaintDetails(int ComplaintNo) {
        try {
            ps = con.prepareStatement("select * from complaints where id = ?");
            ps.setInt(1, ComplaintNo);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                txtComplaintINID.setText(String.valueOf(rs.getInt(1)));
                txtComplaintDate.setText(rs.getString(2));
                txtComplaintReason.setText(rs.getString(3));
//                textResponse.setText(rs.getString(7));

            }

        } catch (Exception e) {
        }
        return false;
    }

    //    ............ USES complaint_id TO PULL DATA FROM RESPONSE TABLE TO THE INTERFACE
    public boolean getResponseDetails(int ComplaintNo) {
        try {
            ps = con.prepareStatement("select * from responses where complaint_ID = ?");
            ps.setInt(1, ComplaintNo);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                textResponse.setText(rs.getString(5));

            }

        } catch (Exception e) {
        }
        return false;
    }

    //Adjusts image to fit the JLabel (jlabelimage)
    private ImageIcon imageAdjust(String path, byte[] pic) {
        ImageIcon myImage = null;
        if (path != null) {
            myImage = new ImageIcon(path);

        } else {
            myImage = new ImageIcon(pic);
        }
        Image img = myImage.getImage();
        Image newImage = img.getScaledInstance(jlabelimage.getWidth(), jlabelimage.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(newImage);
        return icon;
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
            java.util.logging.Logger.getLogger(studentHome.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(studentHome.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(studentHome.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(studentHome.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new studentHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSMaterialButtonCircle btnBrowse;
    private rojerusan.RSMaterialButtonCircle btnClearMarkSheet;
    private rojerusan.RSMaterialButtonCircle btnGenerateTranscript;
    private rojerusan.RSMaterialButtonCircle btnPost;
    private rojerusan.RSMaterialButtonCircle btnPrintMarkSheet;
    private rojerusan.RSMaterialButtonCircle btnRefreshComplaints;
    private rojerusan.RSMaterialButtonCircle btnSearchComplaintNo;
    private rojerusan.RSMaterialButtonCircle btnSearchMarksheet;
    private rojerusan.RSComboMetro cboReason;
    private com.toedter.calendar.JDateChooser jComplaintDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel jlabelimage;
    private javax.swing.JLabel lblCummulative;
    private javax.swing.JLabel lbl_close1;
    private javax.swing.JLabel lbl_logo;
    private javax.swing.JLabel lbl_logout;
    private rojeru_san.complementos.RSTableMetro tbl_detailsMarksSheet;
    private javax.swing.JTextArea textDescription;
    private javax.swing.JTextArea textResponse;
    private javax.swing.JPanel transcriptPanel;
    public static app.bolivia.swing.JCTextField txtComplaintDate;
    private app.bolivia.swing.JCTextField txtComplaintID;
    private app.bolivia.swing.JCTextField txtComplaintINID;
    public static javax.swing.JTextField txtComplaintReason;
    private javax.swing.JLabel txtDate;
    private app.bolivia.swing.JCTextField txtSearchComplaintNo;
    private app.bolivia.swing.JCTextField txtSearchMarkSheet;
    private javax.swing.JLabel txtTime;
    private javax.swing.JTextArea txt_transcript;
    // End of variables declaration//GEN-END:variables
}
