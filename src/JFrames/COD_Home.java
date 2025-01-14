// Find out why Print Method is not working
package JFrames;

import MiniFrames.*;
import db.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author EMMANUEL
 */
public class COD_Home extends javax.swing.JFrame {

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

//            line.append(String.format("%-" + (maxCourseLen + 10) + "s", course1));
//            line.append("|");
//            line.append(String.format("%10s", score1));
//            txt_transcript.append(line.toString() + "\n");
//            txt_transcript.append("_______________________________________________________\n");
//
//            line.append(String.format("%-" + (maxCourseLen + 10) + "s", course2));
//            line.append("|");
//            line.append(String.format("%10s", score2));
//            txt_transcript.append(line.toString() + "\n");
//            txt_transcript.append("_______________________________________________________\n");
//
//            line.append(String.format("%-" + (maxCourseLen + 10) + "s", course3));
//            line.append("|");
//            line.append(String.format("%10s", score3));
//            txt_transcript.append(line.toString() + "\n");
//            txt_transcript.append("_______________________________________________________\n");
//
//            line.append(String.format("%-" + (maxCourseLen + 10) + "s", course4));
//            line.append("|");
//            line.append(String.format("%10s", score4));
//            txt_transcript.append(line.toString() + "\n");
//            txt_transcript.append("_______________________________________________________\n");
//
//            line.append(String.format("%-" + (maxCourseLen + 10) + "s", course5));
//            line.append("|");
//            line.append(String.format("%10s", score5));
//            txt_transcript.append(line.toString() + "\n");
//            txt_transcript.append("_______________________________________________________\n");
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

    Connection con = MyConnection.getConnection();
    PreparedStatement ps;

    //Calls the other public java Classes
    Student student = new Student();
    Course course = new Course();
    Score score = new Score();
    MarkSheet markSheet = new MarkSheet();
    Complaints complaints = new Complaints();

    // Gets the window's screen position
    int xx, xy;

    private String imagePath;

    //JTable
    private DefaultTableModel model;
    private int rowIndex;

    //Gets the Double NumberFormat
    NumberFormat nf = NumberFormat.getInstance();

    public COD_Home() {
        initComponents();
        init();
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbl_close1 = new javax.swing.JLabel();
        txtTime = new javax.swing.JLabel();
        txtDate = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        lbl_notification = new javax.swing.JLabel();
        lbl_logout = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jlabelimage = new javax.swing.JLabel();
        btnBrowse = new rojerusan.RSMaterialButtonCircle();
        txtStudID = new app.bolivia.swing.JCTextField();
        txtStudName = new app.bolivia.swing.JCTextField();
        txtEmail = new app.bolivia.swing.JCTextField();
        txtPhone = new app.bolivia.swing.JCTextField();
        txtFather = new app.bolivia.swing.JCTextField();
        txtMother = new app.bolivia.swing.JCTextField();
        txtAddr1 = new app.bolivia.swing.JCTextField();
        cboGender = new rojerusan.RSComboMetro();
        jDateDOB = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        txtStudentINID = new app.bolivia.swing.JCTextField();
        jPanel5 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        btnRefresh = new rojerusan.RSMaterialButtonCircle();
        txtSearchStudent = new app.bolivia.swing.JCTextField();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_details = new rojeru_san.complementos.RSTableMetro();
        jPanel10 = new javax.swing.JPanel();
        btnAdd = new rojerusan.RSMaterialButtonCircle();
        btnUpdate = new rojerusan.RSMaterialButtonCircle();
        btnDelete = new rojerusan.RSMaterialButtonCircle();
        btnPrint = new rojerusan.RSMaterialButtonCircle();
        btnClear = new rojerusan.RSMaterialButtonCircle();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        txtSearchStudID = new app.bolivia.swing.JCTextField();
        btnSearchStudIDCourse = new rojerusan.RSMaterialButtonCircle();
        txtSearchAcademicYear = new app.bolivia.swing.JCTextField();
        txtINID = new app.bolivia.swing.JCTextField();
        txtStudId_course = new app.bolivia.swing.JCTextField();
        jLabel18 = new javax.swing.JLabel();
        cbo1 = new rojerusan.RSComboMetro();
        cbo2 = new rojerusan.RSComboMetro();
        cbo3 = new rojerusan.RSComboMetro();
        cbo4 = new rojerusan.RSComboMetro();
        cbo5 = new rojerusan.RSComboMetro();
        cboSem = new rojerusan.RSComboMetro();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        btnRefreshCourse = new rojerusan.RSMaterialButtonCircle();
        txtSearchCourse = new app.bolivia.swing.JCTextField();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_course = new rojeru_san.complementos.RSTableMetro();
        jPanel18 = new javax.swing.JPanel();
        btnAddCourse = new rojerusan.RSMaterialButtonCircle();
        btnPrintCourse = new rojerusan.RSMaterialButtonCircle();
        btnClearCourse = new rojerusan.RSMaterialButtonCircle();
        jPanel19 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        txtSearchIdScore = new app.bolivia.swing.JCTextField();
        btnSearchScore = new rojerusan.RSMaterialButtonCircle();
        jLabel57 = new javax.swing.JLabel();
        txtSearchSemesterScore = new app.bolivia.swing.JCTextField();
        txtSearchYearScore = new app.bolivia.swing.JCTextField();
        jLabel59 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtScoreINID = new app.bolivia.swing.JCTextField();
        jLabel51 = new javax.swing.JLabel();
        txtStudIdScore = new app.bolivia.swing.JCTextField();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        txtScoreSemester = new javax.swing.JTextField();
        txtScoreCourse1 = new javax.swing.JTextField();
        txtScoreCourse2 = new javax.swing.JTextField();
        txtScoreCourse3 = new javax.swing.JTextField();
        txtScoreCourse4 = new javax.swing.JTextField();
        txtScoreCourse5 = new javax.swing.JTextField();
        jTextScore4 = new javax.swing.JTextField();
        jTextScore5 = new javax.swing.JTextField();
        jTextScore3 = new javax.swing.JTextField();
        jTextScore2 = new javax.swing.JTextField();
        jTextScore1 = new javax.swing.JTextField();
        txtScoreYear = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        btnRefreshScore = new rojerusan.RSMaterialButtonCircle();
        txtSearchScore = new app.bolivia.swing.JCTextField();
        jPanel25 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_detailsScore = new rojeru_san.complementos.RSTableMetro();
        jPanel26 = new javax.swing.JPanel();
        btnAddScore = new rojerusan.RSMaterialButtonCircle();
        btnUpdateScore = new rojerusan.RSMaterialButtonCircle();
        btnPrintScore = new rojerusan.RSMaterialButtonCircle();
        btnClearScore = new rojerusan.RSMaterialButtonCircle();
        jPanel27 = new javax.swing.JPanel();
        jPanelMarkSheetTranscript = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        txtSearchMarkSheet = new app.bolivia.swing.JCTextField();
        btnSearchMarksheet = new rojerusan.RSMaterialButtonCircle();
        transcriptPanel = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        txt_transcript = new javax.swing.JTextArea();
        lbl_logo = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl_detailsMarksSheet = new rojeru_san.complementos.RSTableMetro();
        jPanel34 = new javax.swing.JPanel();
        btnPrintMarkSheet = new rojerusan.RSMaterialButtonCircle();
        btnClearMarksheet = new rojerusan.RSMaterialButtonCircle();
        btnGenerateTranscript = new rojerusan.RSMaterialButtonCircle();
        jPanel22 = new javax.swing.JPanel();
        lblCummulative = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        txtComplaintID = new app.bolivia.swing.JCTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jComplaintDate = new com.toedter.calendar.JDateChooser();
        jLabel29 = new javax.swing.JLabel();
        cboReason = new rojerusan.RSComboMetro();
        jLabel30 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        textDescription = new javax.swing.JTextArea();
        jPanel32 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        jlabelimageComplaints = new javax.swing.JLabel();
        btnBrowse1 = new rojerusan.RSMaterialButtonCircle();
        jPanel36 = new javax.swing.JPanel();
        jPanel37 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        btnRefreshComplaints = new rojerusan.RSMaterialButtonCircle();
        txtSearchComplaints = new app.bolivia.swing.JCTextField();
        jPanel38 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_detailsComplaints = new rojeru_san.complementos.RSTableMetro();
        jPanel39 = new javax.swing.JPanel();
        btnRefresh4 = new rojerusan.RSMaterialButtonCircle();
        btnPrint1 = new rojerusan.RSMaterialButtonCircle();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 153, 102));
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
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 670, 60));

        lbl_close1.setFont(new java.awt.Font("Times New Roman", 1, 45)); // NOI18N
        lbl_close1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_close1.setText(" X");
        lbl_close1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_close1MouseClicked(evt);
            }
        });
        jPanel2.add(lbl_close1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 10, 60, 50));

        txtTime.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        txtTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(txtTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 10, 180, 30));

        txtDate.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(txtDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 40, 200, 30));

        jLabel32.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/icons/message_icon30px.png"))); // NOI18N
        jLabel32.setText("  You have:");
        jPanel2.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, -1, 40));

        lbl_notification.setFont(new java.awt.Font("Constantia", 0, 18)); // NOI18N
        lbl_notification.setText("    ");
        jPanel2.add(lbl_notification, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 10, 200, 40));

        lbl_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/icons/logout.png"))); // NOI18N
        lbl_logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_logoutMouseClicked(evt);
            }
        });
        jPanel2.add(lbl_logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 0, 60, 60));

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

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel2.setText("Student's ID");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 100, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel3.setText("Mother's Name");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 130, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel4.setText("Phone Number");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 120, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel5.setText("Father's Name");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 120, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel7.setText("Address Line 1");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, -1, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel8.setText("Email");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 60, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel9.setText("Gender");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 70, -1));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel10.setText("Date Of Birth");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 110, -1));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel11.setText("Student's Name");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 130, -1));

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
        jPanel7.add(jlabelimage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 180));

        jPanel6.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 240, 180));

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

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 380, 200));

        txtStudID.setBackground(new java.awt.Color(204, 204, 204));
        txtStudID.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txtStudID.setPlaceholder("Enter Student ID");
        jPanel4.add(txtStudID, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 250, 35));

        txtStudName.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txtStudName.setPlaceholder("Enter Student Name");
        jPanel4.add(txtStudName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 250, 35));

        txtEmail.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txtEmail.setPlaceholder("Enter Email Address");
        jPanel4.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 250, 35));

        txtPhone.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txtPhone.setPlaceholder("Enter Phone Number");
        txtPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPhoneKeyTyped(evt);
            }
        });
        jPanel4.add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 250, 35));

        txtFather.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txtFather.setPlaceholder("Enter Name of the Father");
        jPanel4.add(txtFather, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, 250, 35));

        txtMother.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txtMother.setPlaceholder("Enter Name of the Mother");
        jPanel4.add(txtMother, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, 250, 35));

        txtAddr1.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txtAddr1.setPlaceholder("Address 1");
        jPanel4.add(txtAddr1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 380, 250, 35));

        cboGender.setForeground(new java.awt.Color(0, 0, 0));
        cboGender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));
        cboGender.setColorFondo(new java.awt.Color(204, 204, 204));
        cboGender.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jPanel4.add(cboGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, -1, -1));

        jDateDOB.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jPanel4.add(jDateDOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 250, 30));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel6.setText("INID: ");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        txtStudentINID.setBackground(new java.awt.Color(204, 204, 204));
        txtStudentINID.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txtStudentINID.setPlaceholder("INID");
        jPanel4.add(txtStudentINID, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 250, 35));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 400, 630));

        jPanel5.setBackground(new java.awt.Color(51, 255, 153));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 102), 2, true));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(51, 255, 153));
        jPanel8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 102), 3, true));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel13.setText("Search Student");
        jPanel8.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        jPanel8.add(btnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, 140, 50));

        txtSearchStudent.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txtSearchStudent.setPlaceholder("Search by ID or Name");
        txtSearchStudent.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchStudentKeyReleased(evt);
            }
        });
        jPanel8.add(txtSearchStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 380, 40));

        jPanel5.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 920, 70));

        jPanel9.setBackground(new java.awt.Color(51, 255, 153));
        jPanel9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 102), 3, true));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_details.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "INID", "Student ID", "Student Name", "Date Of Birth", "Gender", "Email", "Phone Number", "Father Name", "Mother Name", "Address Line 1", "Image Path"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_details.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tbl_details.setFuenteFilas(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tbl_details.setFuenteFilasSelect(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tbl_details.setFuenteHead(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        tbl_details.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_detailsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_details);

        jPanel9.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 4, 910, 450));

        jPanel5.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 920, 460));

        jPanel10.setBackground(new java.awt.Color(51, 255, 153));
        jPanel10.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 102), 3, true));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAdd.setText("Add New");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel10.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 60));

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel10.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 130, 60));

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel10.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 140, 60));

        btnPrint.setText("Print");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });
        jPanel10.add(btnPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 130, 60));

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        jPanel10.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, 130, 60));

        jPanel5.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, 910, 80));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 930, 630));

        jTabbedPane1.addTab("Student", jPanel3);

        jPanel11.setBackground(new java.awt.Color(0, 153, 153));
        jPanel11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 102), 2, true));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel12.setBackground(new java.awt.Color(51, 255, 153));
        jPanel12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 102), 2, true));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel14.setText("INID");
        jPanel12.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 80, -1));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel16.setText("Course 3");
        jPanel12.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 90, -1));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel17.setText("Couse 5");
        jPanel12.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, 100, -1));

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel20.setText("Course 2");
        jPanel12.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 60, -1));

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel21.setText("Course 1");
        jPanel12.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 70, -1));

        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel22.setText("Semester");
        jPanel12.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 90, -1));

        jLabel23.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel23.setText("Student's ID");
        jPanel12.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 90, -1));

        jPanel13.setBackground(new java.awt.Color(51, 255, 153));
        jPanel13.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 102), 3, true));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setBackground(new java.awt.Color(51, 255, 153));
        jLabel24.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel24.setText("Student's ID");
        jPanel13.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        txtSearchStudID.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        txtSearchStudID.setPlaceholder("Search by Student ID");
        jPanel13.add(txtSearchStudID, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 220, 40));

        btnSearchStudIDCourse.setText("Search");
        btnSearchStudIDCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchStudIDCourseActionPerformed(evt);
            }
        });
        jPanel13.add(btnSearchStudIDCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 100, 60));

        txtSearchAcademicYear.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        txtSearchAcademicYear.setPlaceholder("Search by Academic Year");
        txtSearchAcademicYear.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchAcademicYearKeyTyped(evt);
            }
        });
        jPanel13.add(txtSearchAcademicYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 220, 40));

        jPanel12.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 150));

        txtINID.setEditable(false);
        txtINID.setBackground(new java.awt.Color(204, 204, 204));
        txtINID.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txtINID.setPlaceholder("ID");
        jPanel12.add(txtINID, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 250, 35));

        txtStudId_course.setEditable(false);
        txtStudId_course.setBackground(new java.awt.Color(204, 204, 204));
        txtStudId_course.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txtStudId_course.setPlaceholder("Enter Student ID");
        jPanel12.add(txtStudId_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 250, 35));

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel18.setText("Course 4");
        jPanel12.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 100, -1));

        cbo1.setForeground(new java.awt.Color(0, 0, 0));
        cbo1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "C Programming", "C++ Programming", "Advanced Mathematics II", "Data Structures  & Algorithm", "Python", "Java", "Comprehensive Practice I", "E ngineering Mathematics" }));
        cbo1.setColorFondo(new java.awt.Color(204, 204, 204));
        cbo1.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jPanel12.add(cbo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, 250, 40));

        cbo2.setForeground(new java.awt.Color(0, 0, 0));
        cbo2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Principle of Computer Component", "Report Writing", "Web Programming", "Java OOP", "Design User Interface", "JSP", "Software Testing and Inspection", "Mobile App Dev" }));
        cbo2.setColorFondo(new java.awt.Color(204, 204, 204));
        cbo2.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jPanel12.add(cbo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, 250, 40));

        cbo3.setForeground(new java.awt.Color(0, 0, 0));
        cbo3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Advanced Mathematics I", "Database", "Software Testing", "Linux", "Data Science", "Big Data I", "Big Data II", "Comprehensive Practice II" }));
        cbo3.setColorFondo(new java.awt.Color(204, 204, 204));
        cbo3.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jPanel12.add(cbo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 420, 250, 40));

        cbo4.setForeground(new java.awt.Color(0, 0, 0));
        cbo4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Chinese Traditional Culture", "Computer Network", "Overview of China", "Principle of Operating System", "Computer Science", "Artificial Intelligence I", "Artificial Intelligence II", "Digital Image Processing" }));
        cbo4.setColorFondo(new java.awt.Color(204, 204, 204));
        cbo4.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jPanel12.add(cbo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 470, 250, 40));

        cbo5.setForeground(new java.awt.Color(0, 0, 0));
        cbo5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cloud Computing", "Algorithms Analysis & Design", "Machine Learning", "Deep Learning", "IT Project 1", "IT Project Management", "IT Project 2", "Graduation Thesis" }));
        cbo5.setColorFondo(new java.awt.Color(204, 204, 204));
        cbo5.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jPanel12.add(cbo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 520, 250, 40));

        cboSem.setForeground(new java.awt.Color(0, 0, 0));
        cboSem.setColorFondo(new java.awt.Color(204, 204, 204));
        cboSem.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jPanel12.add(cboSem, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 250, 40));

        jPanel11.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 370, 630));

        jPanel15.setBackground(new java.awt.Color(51, 255, 153));
        jPanel15.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 102), 2, true));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel16.setBackground(new java.awt.Color(51, 255, 153));
        jPanel16.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 102), 3, true));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel25.setText("Search Student");
        jPanel16.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        btnRefreshCourse.setText("Refresh");
        btnRefreshCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshCourseActionPerformed(evt);
            }
        });
        jPanel16.add(btnRefreshCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 10, 140, 50));

        txtSearchCourse.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txtSearchCourse.setPlaceholder("Search by Student ID or Semester");
        txtSearchCourse.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchCourseKeyReleased(evt);
            }
        });
        jPanel16.add(txtSearchCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 380, 40));

        jPanel15.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 60));

        jPanel17.setBackground(new java.awt.Color(51, 255, 153));
        jPanel17.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 102), 3, true));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_course.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Student ID", "Academic Year", "Semester", "Course 1", "Course 2", "Course 3", "Course 4", "Course 5"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_course.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tbl_course.setFuenteFilas(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tbl_course.setFuenteFilasSelect(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tbl_course.setFuenteHead(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jScrollPane2.setViewportView(tbl_course);

        jPanel17.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 6, 970, 480));

        jPanel15.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 980, 490));

        jPanel18.setBackground(new java.awt.Color(51, 255, 153));
        jPanel18.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 102), 3, true));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAddCourse.setText("Save");
        btnAddCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCourseActionPerformed(evt);
            }
        });
        jPanel18.add(btnAddCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 60));

        btnPrintCourse.setText("Print");
        btnPrintCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintCourseActionPerformed(evt);
            }
        });
        jPanel18.add(btnPrintCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 130, 60));

        btnClearCourse.setText("Clear");
        btnClearCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearCourseActionPerformed(evt);
            }
        });
        jPanel18.add(btnClearCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 130, 60));

        jPanel15.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, 980, 80));

        jPanel11.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 980, 630));

        jTabbedPane1.addTab("Course", jPanel11);

        jPanel19.setBackground(new java.awt.Color(0, 153, 153));
        jPanel19.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 102), 2, true));
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel20.setBackground(new java.awt.Color(51, 255, 153));
        jPanel20.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 102), 2, true));
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel14.setBackground(new java.awt.Color(51, 255, 153));
        jPanel14.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 102), 3, true));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel50.setBackground(new java.awt.Color(51, 255, 153));
        jLabel50.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel50.setText("Student's ID");
        jPanel14.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        txtSearchIdScore.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        txtSearchIdScore.setPlaceholder("Search by Student ID");
        jPanel14.add(txtSearchIdScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 200, 40));

        btnSearchScore.setText("Search");
        btnSearchScore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchScoreActionPerformed(evt);
            }
        });
        jPanel14.add(btnSearchScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 100, 120));

        jLabel57.setBackground(new java.awt.Color(51, 255, 153));
        jLabel57.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel57.setText("Semester");
        jPanel14.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        txtSearchSemesterScore.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        txtSearchSemesterScore.setPlaceholder("Search by Semester");
        txtSearchSemesterScore.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchSemesterScoreKeyTyped(evt);
            }
        });
        jPanel14.add(txtSearchSemesterScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 200, 40));

        txtSearchYearScore.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        txtSearchYearScore.setPlaceholder("Search by Academic Year");
        txtSearchYearScore.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchYearScoreKeyTyped(evt);
            }
        });
        jPanel14.add(txtSearchYearScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 200, 40));

        jLabel59.setBackground(new java.awt.Color(51, 255, 153));
        jLabel59.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel59.setText("Academic Year");
        jPanel14.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jPanel20.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 220));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel15.setText("INID");
        jPanel20.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 70, -1));

        txtScoreINID.setEditable(false);
        txtScoreINID.setBackground(new java.awt.Color(204, 204, 204));
        txtScoreINID.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txtScoreINID.setPlaceholder("ID");
        jPanel20.add(txtScoreINID, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 200, 35));

        jLabel51.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel51.setText("Student's ID");
        jPanel20.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));

        txtStudIdScore.setEditable(false);
        txtStudIdScore.setBackground(new java.awt.Color(204, 204, 204));
        txtStudIdScore.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txtStudIdScore.setPlaceholder("Enter Student ID");
        jPanel20.add(txtStudIdScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, 270, 35));

        jLabel52.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel52.setText("Semester");
        jPanel20.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 70, -1));

        jLabel53.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel53.setText("Course 1");
        jPanel20.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 70, -1));

        jLabel54.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel54.setText("Course 2");
        jPanel20.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 70, -1));

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel19.setText("Course 3");
        jPanel20.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, 70, -1));

        jLabel55.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel55.setText("Course 4");
        jPanel20.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, 70, -1));

        jLabel56.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel56.setText("Course 5");
        jPanel20.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 600, 70, -1));

        txtScoreSemester.setEditable(false);
        txtScoreSemester.setBackground(new java.awt.Color(204, 204, 204));
        txtScoreSemester.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel20.add(txtScoreSemester, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 390, 270, 35));

        txtScoreCourse1.setEditable(false);
        txtScoreCourse1.setBackground(new java.awt.Color(204, 204, 204));
        txtScoreCourse1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel20.add(txtScoreCourse1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 430, 220, 35));

        txtScoreCourse2.setEditable(false);
        txtScoreCourse2.setBackground(new java.awt.Color(204, 204, 204));
        txtScoreCourse2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel20.add(txtScoreCourse2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 470, 220, 35));

        txtScoreCourse3.setEditable(false);
        txtScoreCourse3.setBackground(new java.awt.Color(204, 204, 204));
        txtScoreCourse3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel20.add(txtScoreCourse3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 510, 220, 35));

        txtScoreCourse4.setEditable(false);
        txtScoreCourse4.setBackground(new java.awt.Color(204, 204, 204));
        txtScoreCourse4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel20.add(txtScoreCourse4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 550, 220, 35));

        txtScoreCourse5.setEditable(false);
        txtScoreCourse5.setBackground(new java.awt.Color(204, 204, 204));
        txtScoreCourse5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel20.add(txtScoreCourse5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 590, 220, 35));

        jTextScore4.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jTextScore4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextScore4.setText("0.0");
        jPanel20.add(jTextScore4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 550, 50, 35));

        jTextScore5.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jTextScore5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextScore5.setText("0.0");
        jPanel20.add(jTextScore5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 590, 50, 35));

        jTextScore3.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jTextScore3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextScore3.setText("0.0");
        jPanel20.add(jTextScore3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 510, 50, 35));

        jTextScore2.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jTextScore2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextScore2.setText("0.0");
        jPanel20.add(jTextScore2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 470, 50, 35));

        jTextScore1.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jTextScore1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextScore1.setText("0.0");
        jPanel20.add(jTextScore1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 430, 50, 35));

        txtScoreYear.setEditable(false);
        txtScoreYear.setBackground(new java.awt.Color(204, 204, 204));
        txtScoreYear.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel20.add(txtScoreYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, 270, 35));

        jLabel58.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel58.setText("Year");
        jPanel20.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 70, -1));

        jPanel19.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 360, 630));

        jPanel23.setBackground(new java.awt.Color(51, 255, 153));
        jPanel23.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 102), 2, true));
        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel24.setBackground(new java.awt.Color(51, 255, 153));
        jPanel24.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 102), 3, true));
        jPanel24.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel37.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel37.setText("Search Student");
        jPanel24.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        btnRefreshScore.setText("Refresh");
        btnRefreshScore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshScoreActionPerformed(evt);
            }
        });
        jPanel24.add(btnRefreshScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, 140, 50));

        txtSearchScore.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txtSearchScore.setPlaceholder("Search by ID or Semester");
        txtSearchScore.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchScoreKeyReleased(evt);
            }
        });
        jPanel24.add(txtSearchScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 380, 40));

        jPanel23.add(jPanel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 70));

        jPanel25.setBackground(new java.awt.Color(51, 255, 153));
        jPanel25.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 102), 3, true));
        jPanel25.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_detailsScore.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "INID", "Student ID", "Academic Year", "Semester", "Course 1", "Score 1", "Course 2", "Score 2", "Course 3", "Score 3", "Course 4", "Score 4", "Course 5", "Score 5", "Average"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_detailsScore.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbl_detailsScore.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tbl_detailsScore.setFuenteFilas(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tbl_detailsScore.setFuenteFilasSelect(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tbl_detailsScore.setFuenteHead(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        tbl_detailsScore.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_detailsScoreMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_detailsScore);

        jPanel25.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 4, 980, 490));

        jPanel23.add(jPanel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 990, 500));

        jPanel26.setBackground(new java.awt.Color(51, 255, 153));
        jPanel26.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 102), 3, true));
        jPanel26.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAddScore.setText("Save");
        btnAddScore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddScoreActionPerformed(evt);
            }
        });
        jPanel26.add(btnAddScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 120, 60));

        btnUpdateScore.setText("Update");
        btnUpdateScore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateScoreActionPerformed(evt);
            }
        });
        jPanel26.add(btnUpdateScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 120, 60));

        btnPrintScore.setText("Print");
        btnPrintScore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintScoreActionPerformed(evt);
            }
        });
        jPanel26.add(btnPrintScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 120, 60));

        btnClearScore.setText("Clear");
        btnClearScore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearScoreActionPerformed(evt);
            }
        });
        jPanel26.add(btnClearScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 120, 60));

        jPanel23.add(jPanel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 570, 990, 60));

        jPanel19.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 990, 630));

        jTabbedPane1.addTab("Score", jPanel19);

        jPanel27.setBackground(new java.awt.Color(0, 153, 153));
        jPanel27.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 102), 2, true));
        jPanel27.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelMarkSheetTranscript.setBackground(new java.awt.Color(51, 255, 153));
        jPanelMarkSheetTranscript.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 102), 2, true));
        jPanelMarkSheetTranscript.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanelMarkSheetTranscript.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 90));

        transcriptPanel.setLayout(new java.awt.BorderLayout());

        txt_transcript.setEditable(false);
        txt_transcript.setColumns(20);
        txt_transcript.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        txt_transcript.setRows(20);
        jScrollPane7.setViewportView(txt_transcript);

        transcriptPanel.add(jScrollPane7, java.awt.BorderLayout.CENTER);

        lbl_logo.setBackground(new java.awt.Color(204, 204, 204));
        transcriptPanel.add(lbl_logo, java.awt.BorderLayout.PAGE_START);

        jPanelMarkSheetTranscript.add(transcriptPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 400, 490));

        jPanel27.add(jPanelMarkSheetTranscript, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 640));

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
                "ID", "Student's ID", "Academic Year", "Semester", "Course 1", "Score 1", "Course 2", "Score 2", "Course 3", "Score 3", "Course 4", "Score 4", "Course 5", "Score 5", "Average"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, false, false, false, false, false, false, false, false, false, false
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

        jPanel33.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 570));

        jPanel31.add(jPanel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, 0, 980, 570));

        jPanel34.setBackground(new java.awt.Color(51, 255, 153));
        jPanel34.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 102), 3, true));
        jPanel34.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnPrintMarkSheet.setText("Print");
        btnPrintMarkSheet.setFont(new java.awt.Font("Constantia", 0, 17)); // NOI18N
        btnPrintMarkSheet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintMarkSheetActionPerformed(evt);
            }
        });
        jPanel34.add(btnPrintMarkSheet, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 130, 60));

        btnClearMarksheet.setText("Clear");
        btnClearMarksheet.setFont(new java.awt.Font("Constantia", 0, 17)); // NOI18N
        btnClearMarksheet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearMarksheetActionPerformed(evt);
            }
        });
        jPanel34.add(btnClearMarksheet, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 130, 60));

        btnGenerateTranscript.setText("Generate Transcript");
        btnGenerateTranscript.setFont(new java.awt.Font("Constantia", 0, 17)); // NOI18N
        btnGenerateTranscript.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnGenerateTranscript.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateTranscriptActionPerformed(evt);
            }
        });
        jPanel34.add(btnGenerateTranscript, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 210, 60));

        jPanel22.setBackground(new java.awt.Color(51, 255, 153));
        jPanel22.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 102), 3, true));
        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCummulative.setBackground(new java.awt.Color(51, 255, 153));
        lblCummulative.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        lblCummulative.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCummulative.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel22.add(lblCummulative, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 60));

        jPanel34.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 290, 60));

        jPanel31.add(jPanel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 570, 950, -1));

        jPanel27.add(jPanel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 950, 640));

        jTabbedPane1.addTab("Marks Sheet", jPanel27);

        jPanel29.setBackground(new java.awt.Color(0, 153, 153));
        jPanel29.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 102), 2, true));
        jPanel29.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel30.setBackground(new java.awt.Color(51, 255, 153));
        jPanel30.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 102), 2, true));
        jPanel30.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtComplaintID.setEditable(false);
        txtComplaintID.setBackground(new java.awt.Color(204, 204, 204));
        txtComplaintID.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txtComplaintID.setPlaceholder("s.No");
        jPanel30.add(txtComplaintID, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 190, 35));

        jLabel27.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel27.setText("INID");
        jPanel30.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 100, -1));

        jLabel28.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel28.setText("Complaint Date: ");
        jPanel30.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 120, 20));

        jComplaintDate.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPanel30.add(jComplaintDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 250, 40));

        jLabel29.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel29.setText("Reason: ");
        jPanel30.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 70, 20));

        cboReason.setForeground(new java.awt.Color(0, 0, 0));
        cboReason.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Education Oriented", "Finance", "Staff Work Ethics", "Other" }));
        cboReason.setColorFondo(new java.awt.Color(204, 204, 204));
        cboReason.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPanel30.add(cboReason, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 250, 40));

        jLabel30.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel30.setText("Description: ");
        jPanel30.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 90, 20));

        textDescription.setColumns(20);
        textDescription.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        textDescription.setRows(5);
        jScrollPane6.setViewportView(textDescription);

        jPanel30.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 250, 160));

        jPanel32.setBackground(new java.awt.Color(51, 255, 153));
        jPanel32.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 102), 3, true));
        jPanel32.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel31.setBackground(new java.awt.Color(51, 255, 153));
        jLabel31.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel31.setText("Image");
        jPanel32.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel35.setBackground(new java.awt.Color(51, 255, 153));
        jPanel35.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 102), 3, true));
        jPanel35.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlabelimageComplaints.setBackground(new java.awt.Color(255, 255, 255));
        jPanel35.add(jlabelimageComplaints, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 210));

        jPanel32.add(jPanel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 250, 210));

        btnBrowse1.setBackground(new java.awt.Color(153, 153, 0));
        btnBrowse1.setForeground(new java.awt.Color(0, 0, 0));
        btnBrowse1.setText("Browse");
        btnBrowse1.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnBrowse1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowse1ActionPerformed(evt);
            }
        });
        jPanel32.add(btnBrowse1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 100, 70));

        jPanel30.add(jPanel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 380, 230));

        jPanel29.add(jPanel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 400, 630));

        jPanel36.setBackground(new java.awt.Color(51, 255, 153));
        jPanel36.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 102), 2, true));
        jPanel36.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel37.setBackground(new java.awt.Color(51, 255, 153));
        jPanel37.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 102), 3, true));
        jPanel37.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel39.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel39.setText("Search Student Complaints:");
        jPanel37.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        btnRefreshComplaints.setText("Refresh");
        btnRefreshComplaints.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshComplaintsActionPerformed(evt);
            }
        });
        jPanel37.add(btnRefreshComplaints, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, 140, 50));

        txtSearchComplaints.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txtSearchComplaints.setPlaceholder("Search by Reason or Status");
        txtSearchComplaints.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchComplaintsKeyReleased(evt);
            }
        });
        jPanel37.add(txtSearchComplaints, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 350, 40));

        jPanel36.add(jPanel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 920, 70));

        jPanel38.setBackground(new java.awt.Color(51, 255, 153));
        jPanel38.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 102), 3, true));
        jPanel38.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_detailsComplaints.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "INID", "Complaint Date", "Reason", "Description", "Image Path", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_detailsComplaints.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tbl_detailsComplaints.setFuenteFilas(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tbl_detailsComplaints.setFuenteFilasSelect(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tbl_detailsComplaints.setFuenteHead(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        tbl_detailsComplaints.setRowHeight(20);
        tbl_detailsComplaints.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_detailsComplaintsMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbl_detailsComplaints);

        jPanel38.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 4, 910, 450));

        jPanel36.add(jPanel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 920, 460));

        jPanel39.setBackground(new java.awt.Color(51, 255, 153));
        jPanel39.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 102), 3, true));
        jPanel39.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRefresh4.setText("Logout");
        btnRefresh4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefresh4ActionPerformed(evt);
            }
        });
        jPanel39.add(btnRefresh4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 130, 60));

        btnPrint1.setText("Print");
        btnPrint1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrint1ActionPerformed(evt);
            }
        });
        jPanel39.add(btnPrint1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 60));

        jPanel36.add(jPanel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, 310, 80));

        jPanel29.add(jPanel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 930, 630));

        jTabbedPane1.addTab("Complaints", jPanel29);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1370, 680));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 760));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void init() {
        setTime();
        tableViewStudent();
        tableViewCourse();
        tableViewScore();
        tableViewMarksSheet();
        tableViewComplaints();
        txtStudentINID.setText(String.valueOf(student.getMax()));
        txtINID.setText(String.valueOf(course.getMax()));
        txtScoreINID.setText(String.valueOf(score.getMax()));
        renderImageColumn();
        updateNotificationLabel();
    }

    private void tableViewStudent() {
        student.getStudentValue(tbl_details, "");
        model = (DefaultTableModel) tbl_details.getModel();
        tbl_details.setRowHeight(30);
        tbl_details.setShowGrid(true);
        tbl_details.setGridColor(Color.darkGray);
        tbl_details.setBackground(Color.WHITE);
    }

    private void tableViewCourse() {
        course.getCourseValue(tbl_course, "");
        model = (DefaultTableModel) tbl_course.getModel();
        tbl_course.setRowHeight(30);
        tbl_course.setShowGrid(true);
        tbl_course.setGridColor(Color.darkGray);
        tbl_course.setBackground(Color.WHITE);
    }

    private void tableViewScore() {
        score.getScoreValue(tbl_detailsScore, "");
        model = (DefaultTableModel) tbl_detailsScore.getModel();
        tbl_detailsScore.setRowHeight(30);
        tbl_detailsScore.setShowGrid(true);
        tbl_detailsScore.setGridColor(Color.darkGray);
        tbl_detailsScore.setBackground(Color.WHITE);
    }

    private void tableViewMarksSheet() {
//        score.getScoreValue(tbl_detailsMarksSheet, "");
        model = (DefaultTableModel) tbl_detailsMarksSheet.getModel();
        tbl_detailsMarksSheet.setRowHeight(30);
        tbl_detailsMarksSheet.setShowGrid(true);
        tbl_detailsMarksSheet.setGridColor(Color.darkGray);
        tbl_detailsMarksSheet.setBackground(Color.WHITE);
    }

    private void tableViewComplaints() {
        complaints.getStudentValue(tbl_detailsComplaints, "");
        model = (DefaultTableModel) tbl_detailsComplaints.getModel();
        tbl_detailsComplaints.setRowHeight(30);
        tbl_detailsComplaints.setShowGrid(true);
        tbl_detailsComplaints.setGridColor(Color.darkGray);
        tbl_detailsComplaints.setBackground(Color.WHITE);
    }

//    .....  END OF PULLING DATA TO THE JTABLES .....
    private void clearStudent() {
        txtStudentINID.setText(String.valueOf(student.getMax()));
        txtStudID.setText("");
        txtStudName.setText("");
        txtEmail.setText("");
        txtPhone.setText("");
        txtFather.setText("");
        txtMother.setText("");
        txtAddr1.setText("");
        txtStudentINID.setText("");
        txtSearchStudent.setText("");
        jDateDOB.setDate(null);
        cboGender.setSelectedIndex(0);
        jlabelimage.setIcon(null);
        tbl_details.clearSelection();
        imagePath = null;
    }

    public void clearCourse() {
        txtINID.setText(String.valueOf(course.getMax()));
        txtSearchStudID.setText("");
        txtSearchAcademicYear.setText("");
        txtStudId_course.setText("");
        txtSearchCourse.setText("");
        cboSem.removeAllItems();
        cbo1.setSelectedIndex(0);
        cbo2.setSelectedIndex(0);
        cbo3.setSelectedIndex(0);
        cbo4.setSelectedIndex(0);
        cbo5.setSelectedIndex(0);
        tbl_course.clearSelection();

    }

    public void clearScore() {
        txtScoreINID.setText(String.valueOf(score.getMax()));
        txtSearchIdScore.setText("");
        txtSearchYearScore.setText("");
        txtSearchSemesterScore.setText("");
        txtStudIdScore.setText("");
        txtScoreYear.setText("");
        txtScoreSemester.setText("");
        txtScoreCourse1.setText("");
        txtScoreCourse2.setText("");
        txtScoreCourse3.setText("");
        txtScoreCourse4.setText("");
        txtScoreCourse5.setText("");
        jTextScore1.setText("0.0");
        jTextScore2.setText("0.0");
        jTextScore3.setText("0.0");
        jTextScore4.setText("0.0");
        jTextScore5.setText("0.0");
        txtSearchScore.setText("");
        tbl_detailsScore.clearSelection();

    }

    private void clearComplaint() {
        txtComplaintID.setText(String.valueOf(complaints.getMax()));
        jComplaintDate.setDate(null);
        cboReason.setSelectedIndex(0);
        textDescription.setText("");
        jlabelimage.setIcon(null);
        imagePath = null;
    }

//    .....  END OF CLEARING TEXTFIELDS AND OTHER COMPONENTS IN THE PANEL .....
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

        if (txtStudID.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Student Registration Number is Missing");
            return false;
        }
        if (txtStudID.getText().length() >= 14) {
            JOptionPane.showMessageDialog(this, "Student Registration Number is too long");
            return false;
        }
        if (txtStudName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Student name is Missing");
            return false;
        }
        if (jDateDOB.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Student DOB is Missing");
            return false;
        }
        if (jDateDOB.getDate().compareTo(new Date()) > 0) {
            JOptionPane.showMessageDialog(this, "Can't Update a Student from the future");
            return false;
        }
        if (txtEmail.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Student Email Address is Missing");
            return false;
        }
        if (!txtEmail.getText().matches("^.+@.+\\..+$")) {
            JOptionPane.showMessageDialog(this, "Invalid Email Address");
            return false;
        }
        if (txtPhone.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Student Phone number is Missing");
            return false;
        }
        if (txtPhone.getText().length() >= 15) {
            JOptionPane.showMessageDialog(this, "Student Phone number is too long");
            return false;
        }
        if (txtPhone.getText().length() <= 8) {
            JOptionPane.showMessageDialog(this, "Student Phone number is too short");
            return false;
        }
        if (txtFather.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Student Father's name is Missing");
            return false;
        }
        if (txtMother.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Student Mother's name is Missing");
            return false;
        }
        if (txtAddr1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Student Address 1 is Missing");
            return false;
        }
        if (imagePath == null) {
            JOptionPane.showMessageDialog(this, "Please Add Your Image");
            return false;
        }
        return true;
    }

//    DefaultTableCellRenderer to render the ImageIcon in Complaints panel
    private void renderImageColumn() {
        // Assuming you have already set the TableModel for your jTable
        // You can use the DefaultTableCellRenderer to render the ImageIcon
        tbl_detailsComplaints.getColumnModel().getColumn(4).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                // Call super to get the default renderer
                JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                // Check if the value is an ImageIcon
                if (value instanceof ImageIcon) {
                    // Set the ImageIcon to the JLabel
                    label.setIcon((ImageIcon) value);
                } else {
                    // If the value is not an ImageIcon (probably 'NULL' string), clear the icon
                    label.setIcon(null);
                }
                return label;
            }
        });
    }

//    Update Notification Label Count
    private void updateNotificationLabel() {
        try {
            String sql = "SELECT COUNT(*) FROM complaints WHERE status = 'unread'";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int unreadCount = rs.getInt(1);
                lbl_notification.setText(unreadCount + " Unread Notifications");
            }
        } catch (SQLException ex) {
            Logger.getLogger(COD_Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed

        tbl_details.setModel(new DefaultTableModel(null, new Object[]{"INID", "Student ID", "Student Name", "Date Of Birth",
            "Gender", "Email", "Phone Number", "Father Name", "Mother Name", "Address Line 1", "Image Path"}));

        //Refreshes the JTable
        student.getStudentValue(tbl_details, "");
        //Refreshes the Textfields and other Items on the window
        clearStudent();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        if (isEmpty()) {
            if (!student.isEmailExist(txtEmail.getText())) {
                if (!student.isPhoneExist(txtPhone.getText())) {

                    try {
                        int id = student.getMax();
                        String stud_id = txtStudID.getText();
                        String name = txtStudName.getText();
                        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                        String date = df.format(jDateDOB.getDate());
                        String gender = cboGender.getSelectedItem().toString();
//            String gendrer = (String)cboGender.getSelectedItem();
                        String email = txtEmail.getText();
                        String phone = txtPhone.getText();
                        String father = txtFather.getText();
                        String mother = txtMother.getText();
                        String addr1 = txtAddr1.getText();

// Read the image file into a byte array
                        File imageFile = new File(imagePath);
                        byte[] imageBytes = Files.readAllBytes(imageFile.toPath());
//Pushes the data to the DB
                        student.insert(id, stud_id, name, date, gender, email, phone, father, mother, addr1, /*imagePath*/ imageBytes);

//Pushes the data to the JTable
                        tbl_details.setModel(new DefaultTableModel(null, new Object[]{"INID", "Student ID", "Student Name", "Date Of Birth",
                            "Gender", "Email", "Phone Number", "Father Name", "Mother Name", "Address Line 1", "Image Path"}));

//Refreshes the JTable
                        student.getStudentValue(tbl_details, "");
//Refreshes the Textfields and other Items on the window
                        clearStudent();
                    } catch (IOException ex) {
                        Logger.getLogger(COD_Home.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {
                    JOptionPane.showMessageDialog(this, "This Phone Number Already Exists");
                }

            } else {
                JOptionPane.showMessageDialog(this, "This Email Address Already Exists");
            }

            clearStudent();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (isEmpty()) {

            int id = Integer.parseInt(txtStudentINID.getText());
//            String stud_id = txtStudID.getText();

            if (student.isIdExist(id)) {

                if (!check()) {
                    String stud_id = txtStudID.getText();
                    String name = txtStudName.getText();
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                    String date = df.format(jDateDOB.getDate());
                    String gender = cboGender.getSelectedItem().toString();
                    String email = txtEmail.getText();
                    String phone = txtPhone.getText();
                    String father = txtFather.getText();
                    String mother = txtMother.getText();
                    String addr1 = txtAddr1.getText();

                    //Pushes the data to the DB
                    student.update(id, stud_id, name, date, gender, email, phone, father, mother, addr1, imagePath);

                    //Pushes the changes to the JTable
                    tbl_details.setModel(new DefaultTableModel(null, new Object[]{"INID", "Student ID", "Student Name", "Date Of Birth",
                        "Gender", "Email", "Phone Number", "Father Name", "Mother Name", "Address Line 1", "Image Path"}));

                    //Refreshes the JTable
                    student.getStudentValue(tbl_details, "");
                    //Refreshes the Textfields and other Items on the window
                    clearStudent();

                }
            } else {
                JOptionPane.showMessageDialog(this, "No Student Exists with that Registration Number");
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    // To check duplication of Email and Phone number while Updating
    public boolean check() {
        String newEmail = txtEmail.getText();
        String newPhone = txtPhone.getText();
        String oldEmail = model.getValueAt(rowIndex, 5).toString();
        String oldPhone = model.getValueAt(rowIndex, 6).toString();

        if (newEmail.equals(oldEmail) && newPhone.equals(oldPhone)) {
            return false;

        } else {
            // Checks Email address duplication
            if (!newEmail.equals(oldEmail)) {
                boolean x = student.isEmailExist(newEmail);
                if (x) {
                    JOptionPane.showMessageDialog(this, "This Email Address Already Exists");
                }
                return x;
            }
            // Checks Phone Number duplication
            if (!newPhone.equals(oldPhone)) {
                boolean x = student.isPhoneExist(newPhone);
                if (x) {
                    JOptionPane.showMessageDialog(this, "This Phone Number Already Exists");
                }
                return x;
            }
        }
        return false;
    }

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        int id = Integer.parseInt(txtStudentINID.getText());
//        String stud_id = txtStudID.getText();
        if (student.isIdExist(id)) {

            student.delete(id);

            //Pushes the changes to the JTable
            tbl_details.setModel(new DefaultTableModel(null, new Object[]{"INID", "Student ID", "Student Name", "Date Of Birth",
                "Gender", "Email", "Phone Number", "Father Name", "Mother Name", "Address Line 1", "Image Path"}));

            //Refreshes the JTable
            student.getStudentValue(tbl_details, "");
            //Refreshes the Textfields and other Items on the window
            clearStudent();

        } else {
            JOptionPane.showMessageDialog(this, "No Student Exists with that Registration Number");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    // Find out why Print Method is not working
    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed

        try {
            MessageFormat header = new MessageFormat("Kaimosi Friends University Students' Information");
//            MessageFormat c = new MessageFormat("Students' Information");
            MessageFormat footer = new MessageFormat("Page{0,number,integer}");

            tbl_details.print(JTable.PrintMode.FIT_WIDTH, header, footer);

//            tbl_details.print();
        } catch (Exception e) {
        }
//        catch (PrinterException ex) {
//            Logger.getLogger(landing_page.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_btnPrintActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed

        clearStudent();
    }//GEN-LAST:event_btnClearActionPerformed

//    ....... End of Student MODULE Page .......
    private void lbl_close1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_close1MouseClicked
        int a = JOptionPane.showConfirmDialog(null, "Do you really want to Close Application?", "Select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            System.exit(0);
        }

    }//GEN-LAST:event_lbl_close1MouseClicked

//   ....... START OF COURSES MODULE ......... 
    private void btnRefreshCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshCourseActionPerformed
        //Pushes the data to the JTable
        tbl_course.setModel(new DefaultTableModel(null, new Object[]{"ID", "Student ID", "Semester",
            "Course 1", "Course 2", "Course 3", "Course 4", "Course 5"}));

        //Refreshes the JTable
        course.getCourseValue(tbl_course, "");
        //Refreshes the Textfields and other Items on the window
        clearCourse();
    }//GEN-LAST:event_btnRefreshCourseActionPerformed

    private void btnAddCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCourseActionPerformed
        if (txtStudId_course.getText().isEmpty() || cboSem.getItemCount() == 0) {
            JOptionPane.showMessageDialog(null, "Student ID or Semester number is Missing");

        } else {
            int id = course.getMax();
            String sid = txtStudId_course.getText();
            int year = Integer.parseInt(txtSearchAcademicYear.getText());
            int semesterNo = Integer.parseInt(cboSem.getSelectedItem().toString());

            String course1 = cbo1.getSelectedItem().toString();
            String course2 = cbo2.getSelectedItem().toString();
            String course3 = cbo3.getSelectedItem().toString();
            String course4 = cbo4.getSelectedItem().toString();
            String course5 = cbo5.getSelectedItem().toString();

            //checks if the student has already taken the semester
            if (course.isYearSemesterExist(sid, year, semesterNo)) {
                JOptionPane.showMessageDialog(this, "This student has already taken semester " + semesterNo + " of year " + year);
            } else {
                //checks if the student has already taken the Course 1
                if (course.isCourseExist(sid, "course1", course1)) {
                    JOptionPane.showMessageDialog(this, "This student has already taken " + course1 + " course");
                } else {
                    //checks if the student has already taken the Course 2
                    if (course.isCourseExist(sid, "course2", course2)) {
                        JOptionPane.showMessageDialog(this, "This student has already taken " + course2 + " course");
                    } else {
                        //checks if the student has already taken the Course 3
                        if (course.isCourseExist(sid, "course3", course3)) {
                            JOptionPane.showMessageDialog(this, "This student has already taken " + course3 + " course");
                        } else {
                            //checks if the student has already taken the Course 4
                            if (course.isCourseExist(sid, "course4", course4)) {
                                JOptionPane.showMessageDialog(this, "This student has already taken " + course4 + " course");
                            } else {
                                //checks if the student has already taken the Course 5
                                if (course.isCourseExist(sid, "course5", course5)) {
                                    JOptionPane.showMessageDialog(this, "This student has already taken " + course5 + " course");
                                } else {
                                    course.insert(id, sid, year, semesterNo, course1, course2, course3, course4, course5);

                                    //Pushes the data to the JTable
                                    tbl_course.setModel(new DefaultTableModel(null, new Object[]{"ID", "Student ID", "Academic Year", "Semester",
                                        "Course 1", "Course 2", "Course 3", "Course 4", "Course 5"}));

                                    //Refreshes the JTable
                                    course.getCourseValue(tbl_course, "");
                                    //Refreshes the Textfields and other Items on the window
                                    clearCourse();
                                }
                            }
                        }
                    }
                }
            }
        }

    }//GEN-LAST:event_btnAddCourseActionPerformed

    private void btnClearCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearCourseActionPerformed

        clearCourse();
    }//GEN-LAST:event_btnClearCourseActionPerformed

//    ........ END OF COURSES MODULE PAGE .........
//    ........ STTART OF SCORE MODULE .................
    private void btnRefreshScoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshScoreActionPerformed
        //Pushes the data to the JTable
        tbl_detailsScore.setModel(new DefaultTableModel(null, new Object[]{"ID", "Student ID", "Semester",
            "Course 1", "Score 1", "Course 2", "Score 2", "Course 3", "Score 3", "Course 4", "Score 4",
            "Course 5", "Score 5", "Average"}));

        //Refreshes the JTable
        score.getScoreValue(tbl_detailsScore, "");
        //Refreshes the Textfields and other Items on the window
        clearScore();
    }//GEN-LAST:event_btnRefreshScoreActionPerformed

    private void btnAddScoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddScoreActionPerformed

        if (!txtStudIdScore.getText().isEmpty()) {
            if (!score.isIdExist(Integer.parseInt(txtScoreINID.getText()))) {

                String student_id = txtStudIdScore.getText();
                int academic_year = Integer.parseInt(txtScoreYear.getText());
                int semester = Integer.parseInt(txtScoreSemester.getText());

                if (!score.isSidSemesterExist(student_id, academic_year, semester)) {
                    if (isNumeric(jTextScore1.getText()) && isNumeric(jTextScore2.getText())
                            && isNumeric(jTextScore3.getText()) && isNumeric(jTextScore4.getText())
                            && isNumeric(jTextScore5.getText())) {
                        int id = score.getMax();
                        String course1 = txtScoreCourse1.getText();
                        String course2 = txtScoreCourse2.getText();
                        String course3 = txtScoreCourse3.getText();
                        String course4 = txtScoreCourse4.getText();
                        String course5 = txtScoreCourse5.getText();

                        double score1 = Double.parseDouble(jTextScore1.getText());
                        double score2 = Double.parseDouble(jTextScore2.getText());
                        double score3 = Double.parseDouble(jTextScore3.getText());
                        double score4 = Double.parseDouble(jTextScore4.getText());
                        double score5 = Double.parseDouble(jTextScore5.getText());

                        double average = (score1 + score2 + score3 + score4 + score5) / 5;
                        //This ensures that the digits is only two decimal place
                        nf.setMaximumFractionDigits(2);

                        score.insert(id, student_id, academic_year, semester, course1, course2, course3, course4, course5, score1, score2, score3, score4, score5, Double.parseDouble(nf.format(average)));

                        //Pushes the data to the JTable
                        tbl_detailsScore.setModel(new DefaultTableModel(null, new Object[]{"ID", "Student ID", "Semester",
                            "Course 1", "Score 1", "Course 2", "Score 2", "Course 3", "Score 3", "Course 4", "Score 4",
                            "Course 5", "Score 5", "Average"}));

                        //Refreshes the JTable
                        score.getScoreValue(tbl_detailsScore, "");
                        //Refreshes the Textfields and other Items on the window
                        clearScore();
                    }

                } else {
                    JOptionPane.showMessageDialog(this, "Semester " + semester + " score is already added");
                }

            } else {
                JOptionPane.showMessageDialog(this, "Score id Already Exists");
            }

        } else {
            JOptionPane.showMessageDialog(this, "No Student Selected");
        }
    }//GEN-LAST:event_btnAddScoreActionPerformed

    // Checks if the value entered is between 0 - 99
    private boolean isNumeric(String s) {
        try {
            double d = Double.parseDouble(s);
            if (d >= 0.0 && d <= 99.0) {
                return true;

            } else {
                JOptionPane.showMessageDialog(this, "Please enter a valid value, must be between 0.0 to 99.0");
                return false;
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "" + e);
        }
        return false;
    }

    private void btnUpdateScoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateScoreActionPerformed

        int id = Integer.parseInt(txtScoreINID.getText());
        if (score.isIdExist(id)) {
            if (isNumeric(jTextScore1.getText()) && isNumeric(jTextScore2.getText())
                    && isNumeric(jTextScore3.getText()) && isNumeric(jTextScore4.getText())
                    && isNumeric(jTextScore5.getText())) {

                double score1 = Double.parseDouble(jTextScore1.getText());
                double score2 = Double.parseDouble(jTextScore2.getText());
                double score3 = Double.parseDouble(jTextScore3.getText());
                double score4 = Double.parseDouble(jTextScore4.getText());
                double score5 = Double.parseDouble(jTextScore5.getText());

                double average = (score1 + score2 + score3 + score4 + score5) / 5;
                //This ensures that the digits is only two decimal place
                nf.setMaximumFractionDigits(2);

                score.update(id, score1, score2, score3, score4, score5, Double.parseDouble(nf.format(average)));

                //Pushes the data to the JTable
                tbl_detailsScore.setModel(new DefaultTableModel(null, new Object[]{"ID", "Student ID", "Semester",
                    "Course 1", "Score 1", "Course 2", "Score 2", "Course 3", "Score 3", "Course 4", "Score 4",
                    "Course 5", "Score 5", "Average"}));

                //Refreshes the JTable
                score.getScoreValue(tbl_detailsScore, "");
                //Refreshes the Textfields and other Items on the window
                clearScore();
            }
        }
    }//GEN-LAST:event_btnUpdateScoreActionPerformed

    private void btnPrintScoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintScoreActionPerformed

        try {
            MessageFormat header = new MessageFormat("Kaimosi Friends Primary All Students Scores Information");
//            MessageFormat c = new MessageFormat("Students' Information");
            MessageFormat footer = new MessageFormat("Page{0,number,integer}");

            tbl_detailsScore.print(JTable.PrintMode.FIT_WIDTH, header, footer);

//            tbl_details.print();
        } catch (Exception e) {
        }
//        catch (PrinterException ex) {
//            Logger.getLogger(landing_page.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_btnPrintScoreActionPerformed

    private void btnClearScoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearScoreActionPerformed
        clearScore();
    }//GEN-LAST:event_btnClearScoreActionPerformed

    private void btnPrintMarkSheetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintMarkSheetActionPerformed

        try {
            txt_transcript.print();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnPrintMarkSheetActionPerformed

    private void btnClearMarksheetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearMarksheetActionPerformed

        txtSearchMarkSheet.setText("");
        lblCummulative.setText("");
        txt_transcript.setText("");

        // WHEN THE Search Textfield has been cleared it returns null values to the JTable...Clears the Table
        tbl_detailsMarksSheet.setModel(new DefaultTableModel(null, new Object[]{"ID", "Student ID", "Academic Year", "Semester",
            "Course 1", "Score 1", "Course 2", "Score 2", "Course 3", "Score 3", "Course 4", "Score 4",
            "Course 5", "Score 5", "Average"}));

    }//GEN-LAST:event_btnClearMarksheetActionPerformed

    //the below two mouse events classes are for changing the location of the Window by dragging it
    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged

        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_jPanel2MouseDragged

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed

        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    // Window smooth Transition
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        for (double i = 0.1; i <= 1.0; i += 0.1) {
            String s = i + "";
            float f = Float.valueOf(s);
            this.setOpacity(f);
            try {
                Thread.sleep(40);
            } catch (InterruptedException ex) {
                java.util.logging.Logger.getLogger(COD_Home.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_formWindowOpened

    // Does not type Alphabets only Numerics
    private void txtPhoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhoneKeyTyped

        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPhoneKeyTyped

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

    // JTable Mouse Clicked
    private void tbl_detailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_detailsMouseClicked

        model = (DefaultTableModel) tbl_details.getModel();
        rowIndex = tbl_details.getSelectedRow();
        txtStudentINID.setText(model.getValueAt(rowIndex, 0).toString());
        txtStudID.setText(model.getValueAt(rowIndex, 1).toString());
        txtStudName.setText(model.getValueAt(rowIndex, 2).toString());

        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(model.getValueAt(rowIndex, 3).toString());
            jDateDOB.setDate(date);
        } catch (ParseException ex) {
            Logger.getLogger(COD_Home.class.getName()).log(Level.SEVERE, null, ex);
        }

        String gender = model.getValueAt(rowIndex, 4).toString();
        if (gender.equals("Male")) {
            cboGender.setSelectedIndex(0);
        } else {
            cboGender.setSelectedIndex(1);
        }

        txtEmail.setText(model.getValueAt(rowIndex, 5).toString());
        txtPhone.setText(model.getValueAt(rowIndex, 6).toString());
        txtFather.setText(model.getValueAt(rowIndex, 7).toString());
        txtMother.setText(model.getValueAt(rowIndex, 8).toString());
        txtAddr1.setText(model.getValueAt(rowIndex, 9).toString());

//        Retrieve the image as an icon for the JLabel
        String path = model.getValueAt(rowIndex, 10).toString();
        imagePath = path;
//        jlabelimage.setIcon(imageAdjust(path, null)); //Gets the image path & calls imageAdjust method & converts path to imageIcon

//        Sets the image as an icon for the JLabel
        ImageIcon imageIcon = new ImageIcon(path);
        Image image = imageIcon.getImage().getScaledInstance(jlabelimage.getWidth(), jlabelimage.getHeight(), Image.SCALE_SMOOTH);
        jlabelimage.setIcon(new ImageIcon(image));

    }//GEN-LAST:event_tbl_detailsMouseClicked

    // Search the Students from the JTable by typing their ID or Name
    private void txtSearchStudentKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchStudentKeyReleased

        String search_by = txtSearchStudent.getText();
        ResultSet rs = Select.getData("select * from student where name like '%" + search_by + "%' or student_id like '%" + search_by + "%' ");
        DefaultTableModel model = (DefaultTableModel) tbl_details.getModel();
        model.setRowCount(0);
        try {
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11)});
            }
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_txtSearchStudentKeyReleased

    // ........ search button in courses .............
    private void btnSearchStudIDCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchStudIDCourseActionPerformed
        if (txtSearchStudID.getText().isEmpty() || txtSearchAcademicYear.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Student ID or Academic Year is Missing");
            return; // Exit the method if any of the fields are empty

        }

        String sid = txtSearchStudID.getText();
        String academicYearText = txtSearchAcademicYear.getText();

        // Validate that the academic year is numeric
        if (!isInteger(academicYearText)) {
            JOptionPane.showMessageDialog(this, "Academic Year must be numeric");
            return; // Exit the method if either academic year or semester number is not numeric
        }

        int academicYear = Integer.parseInt(academicYearText);

//        Check if the Academic Year os < or = to 4
        if (academicYear <= 4) {
            if (course.getSid(sid)) {
                cboSem.removeAllItems();
                // Update cboSem based on academic year
                updateSemesterComboBox(sid, academicYear);

            }
        } else {
            JOptionPane.showMessageDialog(null, "This Student has Completed all your course work.");
        }

    }//GEN-LAST:event_btnSearchStudIDCourseActionPerformed

    // ........... LOGIC TO GENERATE THE NEXT SEMESTER .........
    // Method to update cboSem based on academic year
    public void updateSemesterComboBox(String sid, int academicYear) {
        int semestersTaken = course.countSemesters(sid, academicYear);

        if (semestersTaken < 1) {
            cboSem.removeAllItems();
            cboSem.addItem("1");
        } else if (semestersTaken == 1) {
            cboSem.removeAllItems();
            cboSem.addItem("2");
        }
    }

//  ..... COURSE SEARCH_BY TEXTFIELD EVENT LISTENER ............
    private void txtSearchCourseKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchCourseKeyReleased

        String search_by = txtSearchCourse.getText();
        ResultSet rs = Select.getData("select * from course where student_id like '%" + search_by + "%' or semester like '%" + search_by + "%' ");
        DefaultTableModel model = (DefaultTableModel) tbl_course.getModel();
        model.setRowCount(0);
        try {
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)});
            }
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_txtSearchCourseKeyReleased

    private void btnPrintCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintCourseActionPerformed
        try {
            MessageFormat header = new MessageFormat("Kaimosi Friends University Students' Courses Information");
//            MessageFormat c = new MessageFormat("Students' Information");
            MessageFormat footer = new MessageFormat("Page{0,number,integer}");

            tbl_details.print(JTable.PrintMode.FIT_WIDTH, header, footer);

//            tbl_details.print();
        } catch (Exception e) {
        }
//        catch (PrinterException ex) {
//            Logger.getLogger(landing_page.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_btnPrintCourseActionPerformed

//    ............... START OF SCORE MODULE ..........................
    private void txtSearchSemesterScoreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchSemesterScoreKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txtSearchSemesterScoreKeyTyped

    private void btnSearchScoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchScoreActionPerformed

        if (txtSearchIdScore.getText().isEmpty() || txtSearchYearScore.getText().isEmpty() || txtSearchSemesterScore.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Student ID or Academic Year or Semester Number is Missing");
            return; // Exit the method if any of the fields are empty

        }

        String sid = txtSearchIdScore.getText();
        String academicYearText = txtSearchYearScore.getText();
        String semesterNoText = txtSearchSemesterScore.getText();

        // Validate that the academic year and semester number are numeric
        if (!isInteger(academicYearText) || !isNumeric(semesterNoText)) {
            JOptionPane.showMessageDialog(this, "Academic Year and Semester Number must be numeric");
            return; // Exit the method if either academic year or semester number is not numeric
        }

        int academicYear = Integer.parseInt(academicYearText);
        int semesterNo = Integer.parseInt(semesterNoText);

        score.getDetails(sid, academicYear, semesterNo);
    }//GEN-LAST:event_btnSearchScoreActionPerformed

    // Helper method to check if a string is numeric
    private boolean isInteger(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    private void tbl_detailsScoreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_detailsScoreMouseClicked

        model = (DefaultTableModel) tbl_detailsScore.getModel();
        rowIndex = tbl_detailsScore.getSelectedRow();
        txtScoreINID.setText(model.getValueAt(rowIndex, 0).toString());
        txtStudIdScore.setText(model.getValueAt(rowIndex, 1).toString());
        txtScoreYear.setText(model.getValueAt(rowIndex, 2).toString());
        txtScoreSemester.setText(model.getValueAt(rowIndex, 3).toString());

        txtScoreCourse1.setText(model.getValueAt(rowIndex, 4).toString());
        txtScoreCourse2.setText(model.getValueAt(rowIndex, 6).toString());
        txtScoreCourse3.setText(model.getValueAt(rowIndex, 8).toString());
        txtScoreCourse4.setText(model.getValueAt(rowIndex, 10).toString());
        txtScoreCourse5.setText(model.getValueAt(rowIndex, 12).toString());

        jTextScore1.setText(model.getValueAt(rowIndex, 5).toString());
        jTextScore2.setText(model.getValueAt(rowIndex, 7).toString());
        jTextScore3.setText(model.getValueAt(rowIndex, 9).toString());
        jTextScore4.setText(model.getValueAt(rowIndex, 11).toString());
        jTextScore5.setText(model.getValueAt(rowIndex, 13).toString());

    }//GEN-LAST:event_tbl_detailsScoreMouseClicked

    private void txtSearchScoreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchScoreKeyReleased

        String search_by = txtSearchScore.getText();
        ResultSet rs = Select.getData("select * from score where student_id like '%" + search_by + "%' or semester like '%" + search_by + "%' ");
        DefaultTableModel model = (DefaultTableModel) tbl_detailsScore.getModel();
        model.setRowCount(0);
        try {
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14)});
            }
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_txtSearchScoreKeyReleased

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
                lblCummulative.setText("MEAN SCORE: " + cgpa);

            } else {
                JOptionPane.showMessageDialog(this, "No scores found for this Student");
            }
        }
    }//GEN-LAST:event_btnSearchMarksheetActionPerformed

    private void btnRefreshComplaintsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshComplaintsActionPerformed

        //Refreshes the Textfields and other Items on the window
        clearComplaint();
    }//GEN-LAST:event_btnRefreshComplaintsActionPerformed

    private void txtSearchComplaintsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchComplaintsKeyReleased

        renderImageColumn();

        String search_by = txtSearchComplaints.getText();
        ResultSet rs = Select.getData("select * from complaints where reason like '%" + search_by + "%' or status like '%" + search_by + "%' ");
        DefaultTableModel model = (DefaultTableModel) tbl_detailsComplaints.getModel();
        model.setRowCount(0);
        try {
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)});
            }
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_txtSearchComplaintsKeyReleased

    private void tbl_detailsComplaintsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_detailsComplaintsMouseClicked

        model = (DefaultTableModel) tbl_detailsComplaints.getModel();
        rowIndex = tbl_detailsComplaints.getSelectedRow();
        txtComplaintID.setText(model.getValueAt(rowIndex, 0).toString());

        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(model.getValueAt(rowIndex, 1).toString());
            jComplaintDate.setDate(date);
        } catch (ParseException ex) {
            Logger.getLogger(COD_Home.class.getName()).log(Level.SEVERE, null, ex);
        }

        String reason = model.getValueAt(rowIndex, 2).toString();
        if (reason.equals("Education Oriented")) {
            cboReason.setSelectedIndex(0);
        } else if (reason.equals("Finance")) {
            cboReason.setSelectedIndex(1);
        } else if (reason.equals("Staff Work Ethics")) {
            cboReason.setSelectedIndex(2);
        } else {
            cboReason.setSelectedIndex(3);
        }

        textDescription.setText(model.getValueAt(rowIndex, 3).toString());

        try {
            // Retrieve the rendered image icon from the JTable
            ImageIcon imageIcon = (ImageIcon) model.getValueAt(rowIndex, 4);

            if (imageIcon == null) {
                // If imageIcon is null, display nothing on the jLabel
                jlabelimageComplaints.setIcon(null);
            } else {
                // If imageIcon is not null, set it to the JLabel
                jlabelimageComplaints.setIcon(imageIcon);
            }
        } catch (ClassCastException ex) {
            // If there is a ClassCastException (likely due to a null value), display nothing on the jLabel
            jlabelimageComplaints.setIcon(null);
            Logger.getLogger(COD_Home.class.getName()).log(Level.SEVERE, null, ex);
        }

//        Change the value of status column
        // Update the status to "read"
        model.setValueAt("read", rowIndex, 5);

        // Refresh the table immediately
        model.fireTableDataChanged();

        // Update the status to "read" in the database
        updateStatusToRead(rowIndex);

//        Change the value of the notification counter label
        updateNotificationLabel();

        // Opens a miniframe to send response
        MiniFrame_Respond response = new MiniFrame_Respond(
                //                txtComplaintID.getText(),
                Integer.parseInt(txtComplaintID.getText()),
                cboReason.getSelectedItem().toString(),
                textDescription.getText()
        );
        response.setVisible(true);
    }//GEN-LAST:event_tbl_detailsComplaintsMouseClicked

//    method to immediately update the status value in the database
    private void updateStatusToRead(int rowIndex) {
        try {

            String id = model.getValueAt(rowIndex, 0).toString(); // Assuming the ID is in column index 0
            String sql = "UPDATE complaints SET status = 'read' WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, id);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(COD_Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void btnRefresh4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefresh4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRefresh4ActionPerformed

    private void btnPrint1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrint1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPrint1ActionPerformed

    private void btnBrowse1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowse1ActionPerformed

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
    }//GEN-LAST:event_btnBrowse1ActionPerformed

    private void txtSearchYearScoreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchYearScoreKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txtSearchYearScoreKeyTyped

    private void txtSearchAcademicYearKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchAcademicYearKeyTyped

        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txtSearchAcademicYearKeyTyped

    private void btnGenerateTranscriptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateTranscriptActionPerformed

        my_report();
    }//GEN-LAST:event_btnGenerateTranscriptActionPerformed

    private void lbl_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_logoutMouseClicked
        int a = JOptionPane.showConfirmDialog(null, "Do you really want to Logout?", "Logout?", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            setVisible(false);
            new LoginPage().setVisible(true);
        }
    }//GEN-LAST:event_lbl_logoutMouseClicked

    //Adjusts image to fit the JLabel
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
            java.util.logging.Logger.getLogger(COD_Home.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(COD_Home.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(COD_Home.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(COD_Home.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new COD_Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSMaterialButtonCircle btnAdd;
    private rojerusan.RSMaterialButtonCircle btnAddCourse;
    private rojerusan.RSMaterialButtonCircle btnAddScore;
    private rojerusan.RSMaterialButtonCircle btnBrowse;
    private rojerusan.RSMaterialButtonCircle btnBrowse1;
    private rojerusan.RSMaterialButtonCircle btnClear;
    private rojerusan.RSMaterialButtonCircle btnClearCourse;
    private rojerusan.RSMaterialButtonCircle btnClearMarksheet;
    private rojerusan.RSMaterialButtonCircle btnClearScore;
    private rojerusan.RSMaterialButtonCircle btnDelete;
    private rojerusan.RSMaterialButtonCircle btnGenerateTranscript;
    private rojerusan.RSMaterialButtonCircle btnPrint;
    private rojerusan.RSMaterialButtonCircle btnPrint1;
    private rojerusan.RSMaterialButtonCircle btnPrintCourse;
    private rojerusan.RSMaterialButtonCircle btnPrintMarkSheet;
    private rojerusan.RSMaterialButtonCircle btnPrintScore;
    private rojerusan.RSMaterialButtonCircle btnRefresh;
    private rojerusan.RSMaterialButtonCircle btnRefresh4;
    private rojerusan.RSMaterialButtonCircle btnRefreshComplaints;
    private rojerusan.RSMaterialButtonCircle btnRefreshCourse;
    private rojerusan.RSMaterialButtonCircle btnRefreshScore;
    private rojerusan.RSMaterialButtonCircle btnSearchMarksheet;
    private rojerusan.RSMaterialButtonCircle btnSearchScore;
    private rojerusan.RSMaterialButtonCircle btnSearchStudIDCourse;
    private rojerusan.RSMaterialButtonCircle btnUpdate;
    private rojerusan.RSMaterialButtonCircle btnUpdateScore;
    private rojerusan.RSComboMetro cbo1;
    private rojerusan.RSComboMetro cbo2;
    private rojerusan.RSComboMetro cbo3;
    private rojerusan.RSComboMetro cbo4;
    private rojerusan.RSComboMetro cbo5;
    private rojerusan.RSComboMetro cboGender;
    private rojerusan.RSComboMetro cboReason;
    private rojerusan.RSComboMetro cboSem;
    private com.toedter.calendar.JDateChooser jComplaintDate;
    private com.toedter.calendar.JDateChooser jDateDOB;
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
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
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
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelMarkSheetTranscript;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextScore1;
    private javax.swing.JTextField jTextScore2;
    private javax.swing.JTextField jTextScore3;
    private javax.swing.JTextField jTextScore4;
    private javax.swing.JTextField jTextScore5;
    private javax.swing.JLabel jlabelimage;
    private javax.swing.JLabel jlabelimageComplaints;
    private javax.swing.JLabel lblCummulative;
    private javax.swing.JLabel lbl_close1;
    private javax.swing.JLabel lbl_logo;
    private javax.swing.JLabel lbl_logout;
    private javax.swing.JLabel lbl_notification;
    private rojeru_san.complementos.RSTableMetro tbl_course;
    private rojeru_san.complementos.RSTableMetro tbl_details;
    private rojeru_san.complementos.RSTableMetro tbl_detailsComplaints;
    private rojeru_san.complementos.RSTableMetro tbl_detailsMarksSheet;
    private rojeru_san.complementos.RSTableMetro tbl_detailsScore;
    private javax.swing.JTextArea textDescription;
    private javax.swing.JPanel transcriptPanel;
    private app.bolivia.swing.JCTextField txtAddr1;
    private app.bolivia.swing.JCTextField txtComplaintID;
    private javax.swing.JLabel txtDate;
    private app.bolivia.swing.JCTextField txtEmail;
    private app.bolivia.swing.JCTextField txtFather;
    private app.bolivia.swing.JCTextField txtINID;
    private app.bolivia.swing.JCTextField txtMother;
    private app.bolivia.swing.JCTextField txtPhone;
    public static javax.swing.JTextField txtScoreCourse1;
    public static javax.swing.JTextField txtScoreCourse2;
    public static javax.swing.JTextField txtScoreCourse3;
    public static javax.swing.JTextField txtScoreCourse4;
    public static javax.swing.JTextField txtScoreCourse5;
    private app.bolivia.swing.JCTextField txtScoreINID;
    public static javax.swing.JTextField txtScoreSemester;
    public static javax.swing.JTextField txtScoreYear;
    private app.bolivia.swing.JCTextField txtSearchAcademicYear;
    private app.bolivia.swing.JCTextField txtSearchComplaints;
    private app.bolivia.swing.JCTextField txtSearchCourse;
    private app.bolivia.swing.JCTextField txtSearchIdScore;
    private app.bolivia.swing.JCTextField txtSearchMarkSheet;
    private app.bolivia.swing.JCTextField txtSearchScore;
    private app.bolivia.swing.JCTextField txtSearchSemesterScore;
    private app.bolivia.swing.JCTextField txtSearchStudID;
    private app.bolivia.swing.JCTextField txtSearchStudent;
    private app.bolivia.swing.JCTextField txtSearchYearScore;
    private app.bolivia.swing.JCTextField txtStudID;
    public static app.bolivia.swing.JCTextField txtStudIdScore;
    public static app.bolivia.swing.JCTextField txtStudId_course;
    private app.bolivia.swing.JCTextField txtStudName;
    private app.bolivia.swing.JCTextField txtStudentINID;
    private javax.swing.JLabel txtTime;
    private javax.swing.JTextArea txt_transcript;
    // End of variables declaration//GEN-END:variables
}
