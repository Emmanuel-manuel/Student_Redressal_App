package JFrames;

import db.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author EMMANUEL
 */
public class Complaints {

    Connection con = MyConnection.getConnection();
    PreparedStatement ps;

    //Get Table Maximum Row
    public int getMax() {
        int id = 0;
        Statement st;

        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select max(id) from complaints");

            while (rs.next()) {
                id = rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Complaints.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id + 1;
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
            Logger.getLogger(Complaints.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    // Pull Data from database to the JTable
    public void getStudentValue(JTable table, String searchValue) {
        String sql = "select * from complaints where concat(id, complaint_date, reason, description, status)like ? order by id desc";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + searchValue + "%");
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            Object[] row;
            while (rs.next()) {
                row = new Object[6];
                row[0] = rs.getString(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
//                row[4] = rs.getString(5);
                // Retrieve the 'image' column as a byte array
                byte[] imageData = rs.getBytes(5);
                // Convert the byte array to an ImageIcon for display
                if (imageData != null) {
                    ImageIcon imageIcon = new ImageIcon(imageData);
                    row[4] = imageIcon;// Set image icon if image data is not null
                } else {
                     row[4] = "NULL"; // Set string "NULL" if image data is null
                }

                row[5] = rs.getString(6);

                model.addRow(row);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Complaints.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
