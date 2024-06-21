package myproject;

//this class is for save data.like username,password.

import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;

    public Conn () {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");    //register in driver class.(my sql driver)
            c = DriverManager.getConnection("jdbc:mysql:///allahplzsave", "root", "allaht10");    //creat connection string 
            s = c.createStatement();   // create statement
        } catch (Exception e) {
            e.printStackTrace();  // print exceptipn
        }
    }
}