/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jdbcdemo;

import static com.mysql.cj.conf.PropertyKey.logger;
import java.lang.System.Logger.Level;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class JdbcUnits {
    static{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JdbcUnits.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    public static Connection getConn() throws SQLException {
//        return  DriverManager.getConnection("jdbc:mysql://localhost/englishdb","root","Admin@123");
    return DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/englishdb?useSSL=false&allowPublicKeyRetrieval=true",
        "root",
        "Admin@123");

    }
}
