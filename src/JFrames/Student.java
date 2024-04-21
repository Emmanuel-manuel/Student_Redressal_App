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
public class Student {

    Connection con = MyConnection.getConnection();
    PreparedStatement ps;

    //Get Table Maximum Row
    public int getMax() {
        int id = 0;
        Statement st;

        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select max(id) from student");

            while (rs.next()) {
                id = rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id + 1;
    }

    // Insert Data to the database into student table
    public void insert(int id, String stud_id, String sname, String date, String gender, String email,
            String phone, String father, String mother, String addr1, /*String imagePath*/ byte[] image) {
        String sql = "insert into student values(?,?,?,?,?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, stud_id);
            ps.setString(3, sname);
            ps.setString(4, date);
            ps.setString(5, gender);
            ps.setString(6, email);
            ps.setString(7, phone);
            ps.setString(8, father);
            ps.setString(9, mother);
            ps.setString(10, addr1);
//            ps.setString(11, addr2);
//            ps.setString(11, imagePath);

            ps.setBytes(11, image);

            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "New Student Added Successfully");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Check if Email Address already exists
    public boolean isEmailExist(String email) {
        try {
            ps = con.prepareStatement("SELECT * from student where email = ?");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    // Check if Phone Number already exists
    public boolean isPhoneExist(String phone) {
        try {
            ps = con.prepareStatement("SELECT * from student where phone = ?");
            ps.setString(1, phone);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    // Check if ID already exists
    public boolean isIdExist(int id) {
        try {
            ps = con.prepareStatement("SELECT * from student where id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    // Pull Data from database to the JTable
    public void getStudentValue(JTable table, String searchValue) {
        String sql = "select * from student where concat(id, student_id, name, email, phone)like ? order by id desc";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + searchValue + "%");
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            Object[] row;
            while (rs.next()) {
                row = new Object[11];
                row[0] = rs.getString(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getString(5);
                row[5] = rs.getString(6);
                row[6] = rs.getString(7);
                row[7] = rs.getString(8);
                row[8] = rs.getString(9);
                row[9] = rs.getString(10);
                row[10] = rs.getString(11);
//                row[11] = rs.getString(12);
                model.addRow(row);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Update Students Value
    public void update(int id, String stud_id, String sname, String date, String gender, String email,
            String phone, String father, String mother, String addr1, String imagePath) {
        String sql = "update student set student_id=?, name=?, date_of_birth=?,gender=?,email=?,phone=?,"
                + "father_name=?,mother_name=?,address1=?,image_path=? where id=?";
        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, stud_id);
            ps.setString(2, sname);
            ps.setString(3, date);
            ps.setString(4, gender);
            ps.setString(5, email);
            ps.setString(6, phone);
            ps.setString(7, father);
            ps.setString(8, mother);
            ps.setString(9, addr1);
//            ps.setString(10, addr2);
            ps.setString(10, imagePath);
            ps.setInt(11, id);

            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Student Updated Successfully");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Student's Data Delete
    public void delete(int id) {
        int yesOrNo = JOptionPane.showConfirmDialog(null, "Course and Score details of this Student will also be deleted", "Delete Student", JOptionPane.OK_CANCEL_OPTION, 0);

        if (yesOrNo == JOptionPane.OK_OPTION) {
            try {
                ps = con.prepareStatement("delete from student where id = ?");
                ps.setInt(1, id);

                if (ps.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "Student Deleted Successfully");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
