
package db;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author EMMANUEL
 */
public class Select {
    public static ResultSet getData(String query)
    {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try
        {
            con = MyConnection.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(query);
            return rs;
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}
