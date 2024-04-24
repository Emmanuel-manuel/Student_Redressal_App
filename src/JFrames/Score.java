
package JFrames;

import db.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author EMMANUEL
 */
public class Score {
    
    Connection con = MyConnection.getConnection();
    PreparedStatement ps;

    //Get Table Maximum Row
    public int getMax() {
        int id = 0;
        Statement st;

        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select max(id) from score");

            while (rs.next()) {
                id = rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Score.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id + 1;
    }

    //Pulls ID of the student
    public boolean getDetails(String sid, int academicYear, int semesterNo) {
        try {
            ps = con.prepareStatement("select * from course where student_id = ? and academic_year = ? and semester = ?");
            ps.setString(1, sid);
            ps.setInt(2, academicYear);
            ps.setInt(3, semesterNo);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                COD_Home.txtStudIdScore.setText(rs.getString(2));
                COD_Home.txtScoreYear.setText(String.valueOf(rs.getInt(3)));
                COD_Home.txtScoreSemester.setText(String.valueOf(rs.getInt(4)));
                COD_Home.txtScoreCourse1.setText(rs.getString(5));
                COD_Home.txtScoreCourse2.setText(rs.getString(6));
                COD_Home.txtScoreCourse3.setText(rs.getString(7));
                COD_Home.txtScoreCourse4.setText(rs.getString(8));
                COD_Home.txtScoreCourse5.setText(rs.getString(9));
                return true;

            } else {
                JOptionPane.showMessageDialog(null, "No Student with that id, academic year or Semester Number exists");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Score.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    // Check if score ID already exists
    public boolean isIdExist(int id) {
        try {
            ps = con.prepareStatement("SELECT * from score where id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Score.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    // Check whether student ID or semester number already exists or not
    public boolean isSidSemesterExist(String sid, int academic_year, int semesterNo) {
        try {
            ps = con.prepareStatement("SELECT * from score where student_id = ? and academic_year = ? and semester = ?");
            ps.setString(1, sid);
            ps.setInt(2, academic_year);
            ps.setInt(3, semesterNo);
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Score.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    // Insert Data to the database into score table
    public void insert(int id, String student_id, int academic_year, int semester, String course1, String course2,
            String course3, String course4, String course5, double score1, double score2,
            double score3, double score4, double score5, double average) {
        String sql = "insert into score values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, student_id);
            ps.setInt(3, academic_year);
            ps.setInt(4, semester);
            ps.setString(5, course1);
            ps.setDouble(6, score1);
            ps.setString(7, course2);
            ps.setDouble(8, score2);
            ps.setString(9, course3);
            ps.setDouble(10, score3);
            ps.setString(11, course4);
            ps.setDouble(12, score4);
            ps.setString(13, course5);
            ps.setDouble(14, score5);
            ps.setDouble(15, average);

            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Scores Added Successfully");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Score.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Pull Data from database to the JTable
    public void getScoreValue(JTable table, String searchValue) {
        String sql = "select * from score where concat(id, student_id, academic_year, semester)like ? order by id desc";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + searchValue + "%");
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            Object[] row;
            while (rs.next()) {
                row = new Object[15];
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getInt(3);
                row[3] = rs.getInt(4);
                row[4] = rs.getString(5);
                row[5] = rs.getDouble(6);
                row[6] = rs.getString(7);
                row[7] = rs.getDouble(8);
                row[8] = rs.getString(9);
                row[9] = rs.getDouble(10);
                row[10] = rs.getString(11);
                row[11] = rs.getDouble(12);
                row[12] = rs.getString(13);
                row[13] = rs.getDouble(14);
                row[14] = rs.getDouble(15);

                model.addRow(row);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Score.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Update Scores Value
    public void update(int id, double score1, double score2, double score3, double score4, double score5, double average) {
        String sql = "update score set score1=?, score2=?, score3=?, score4=?, score5=?, average=? where id=?";
        try {
            ps = con.prepareStatement(sql);

            ps.setDouble(1, score1);
            ps.setDouble(2, score2);
            ps.setDouble(3, score3);
            ps.setDouble(4, score4);
            ps.setDouble(5, score5);
            ps.setDouble(6, average);
            
            ps.setInt(7, id);

            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Scores Updated Successfully");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Score.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
