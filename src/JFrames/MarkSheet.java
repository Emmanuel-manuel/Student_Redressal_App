package JFrames;

import db.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MarkSheet {

    Connection con = MyConnection.getConnection();
    PreparedStatement ps;

    // Check if score ID already exists
    public boolean isIdExist(String sid) {
        try {
            ps = con.prepareStatement("SELECT * from score where student_id = ?");
            ps.setString(1, sid);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(MarkSheet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    // Pull Data from database to the JTable
    public void getScoreValue(JTable table, String sid) {
        String sql = "select * from score where student_id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, sid);
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
            Logger.getLogger(MarkSheet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public double getCGPA(String sid){
        double cgpa = 0.0;
        Statement st;
        
        try{
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select avg(average) from score where student_id = "+sid+"");
            if(rs.next()){
                cgpa = rs.getDouble(1);
            }
                    
        } catch (SQLException ex) {
            Logger.getLogger(MarkSheet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cgpa;
    }
    
}
