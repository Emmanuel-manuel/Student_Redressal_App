package JFrames;

import db.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author EMMANUEL
 */
public class Course {

    Connection con = MyConnection.getConnection();
    PreparedStatement ps;

    //Get Table Maximum Row
    public int getMax() {
        int id = 0;
        Statement st;

        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select max(id) from course");

            while (rs.next()) {
                id = rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id + 1;
    }

    //Pulls ID of the student
    public boolean getSid(String sid) {
        try {
            ps = con.prepareStatement("select * from student where student_id = ?");
            ps.setString(1, sid);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                COD_Home.txtStudId_course.setText(String.valueOf(rs.getString(2)));
                
                return true;

            } else {
                JOptionPane.showMessageDialog(null, "No Student with that ID exists");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Course.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

 
// Method to count semesters for a student
    public int countSemesters(String sid, int academicYear) {
        int total = 0;
        try {
//            ps = con.prepareStatement("select count(*) as 'total' from course where student_id = ?");
            ps = con.prepareStatement("select count(*) as 'total_semesters' from course where student_id = ? AND academic_year = ?");
            ps.setString(1, sid);
            ps.setInt(2, academicYear);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
//                total = rs.getInt(1);
                total = rs.getInt(1);
            }
//            if (total == 2) {
            if (total >= 2) {
                JOptionPane.showMessageDialog(null, "This student has completed this academic year, proceed to the next");
                return -1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Course.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }
    // Check whether the Student has already taken this Semester or not
    public boolean isYearSemesterExist(String sid, int year, int semesterNo) {
        try {
            ps = con.prepareStatement("SELECT * from course where student_id = ? and academic_year = ? and semester = ?");
            ps.setString(1, sid);
            ps.setInt(2, year);
            ps.setInt(3, semesterNo);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    // Check whether the Student has already taken this Course or not
    public boolean isCourseExist(String sid, String courseNo, String course) {
        String sql = "SELECT * from course where student_id = ? and " + courseNo + " = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, sid);
            ps.setString(2, course);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    // Insert Data to the database into course table
    public void insert(int id, String sid, int year, int semester, String course1, String course2,
            String course3, String course4, String course5) {
        String sql = "insert into course values(?,?,?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, sid);
            ps.setInt(3, year);
            ps.setInt(4, semester);
            ps.setString(5, course1);
            ps.setString(6, course2);
            ps.setString(7, course3);
            ps.setString(8, course4);
            ps.setString(9, course5);

            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Course Units Added Successfully");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Course.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Pull Data from database to the JTable
    public void getCourseValue(JTable table, String searchValue) {
        String sql = "select * from course where concat(id, student_id, academic_year, semester)like ? order by id desc";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + searchValue + "%");
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            Object[] row;
            while (rs.next()) {
                row = new Object[9];
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getInt(3);
                row[3] = rs.getInt(4);
                row[4] = rs.getString(5);
                row[5] = rs.getString(6);
                row[6] = rs.getString(7);
                row[7] = rs.getString(8);
                row[8] = rs.getString(9);

                model.addRow(row);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Course.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
