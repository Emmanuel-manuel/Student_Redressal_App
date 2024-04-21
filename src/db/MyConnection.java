/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author EMMANUEL
 */
public class MyConnection {
    
    static Connection con = null;
    
    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_redressal","root","");
            
        } catch (Exception e){
            // handles error by printing where the error is emanating from
            e.printStackTrace();
            
        }
        // this returns the connection
        return con;
    }
    
}
