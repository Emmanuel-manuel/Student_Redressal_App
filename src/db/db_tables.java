/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo-x130
 */
public class db_tables {
    public static void main(String[] args)
    {
        Connection con = null;
        Statement st = null;
        try
        {
            con = MyConnection.getConnection();
            st = con.createStatement();
//            st.executeUpdate("create table users (id int(8), name varchar(200), role varchar(100), email varchar(200),password varchar(200),securityQuestion varchar(500),answer varchar(200),address varchar(200),status varchar(20) )");
          
//            st.executeUpdate("create table room (roomName varchar(20),roomType varchar(20),bed varchar(200),price int,status varchar(20) )");
           
//            st.executeUpdate("create table customer (id int,name varchar(200),mobileNumber varchar(20),nationality varchar(200),gender varchar(25),email varchar(200),idProof varchar(200),address varchar(500),checkin_date varchar(50),roomName varchar(100),bed varchar(30),roomType varchar(100),pricePerDay int,daysStayed int,totalAmount varchar(200),checkout_date varchar(50) )");

//            st.executeUpdate("create table product (product_id int(11), product_name varchar(255), price int(10), qty int(10), total_pp int(45), employee_Name varchar(255), date datetime )");

//            st.executeUpdate("Create table stocks (product_id int(11), product_name varchar(255), barcode int(45), description text, price int(11), qty int(100), supplier_Name varchar(255) )");
            
//            st.executeUpdate("Create table picks (id int(11), product_name varchar(255), barcode int(45), price int(10), qty int(10), employee_Name varchar(255) )");

//            st.executeUpdate("Create table hotel_store (id int(11), product_name varchar(255), description text, price int(11), qty int(11), total_pu int(11) )");
            
//            st.executeUpdate("Create table menu_hotel (id int(11), food_name varchar(255), unit_price varchar(11) )");
            
//            st.executeUpdate("Create table prepared_foods (id int(11), food_name varchar(255), Quantity varchar(11), unit_price varchar(10), date datetime )");

//            st.executeUpdate("Create table place_order (INID int(50), Food_Name varchar(255), qty int (11), Unit_Price int (11), Total_Price int (255), delivered_to varchar(255), time_to_deliver varchar(20), customer_details varchar(255), waiter_to_deliver varchar(255), date datetime, status varchar(20) ) ");
            
            st.executeUpdate("Create table waiter (waiterName varchar(255), gender varchar(11),status varchar(20) )");

//            st.executeUpdate("Create table payments (id int(11), food_name varchar(255), unit_price varchar(11), Quantity varchar(11), Total_Price int (255), customer_details varchar(255), waiter_to_deliver varchar(255), payment_mode varchar(255), date datetime(6) )");

            JOptionPane.showMessageDialog(null, "Table Created Successfully"); 
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        finally
        {
            try
            {
                con.close();
                st.close();
                
            }
        catch(Exception e)
        {}
        }
    }
           
}
