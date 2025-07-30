/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jdbcdemo;

import com.vvh.services.QuestionServices;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class Tester {
    public static void main(String[] args) throws SQLException {
        QuestionServices s = new QuestionServices();
        System.out.print(s.countProductByCateId(4));
        
    }
}
