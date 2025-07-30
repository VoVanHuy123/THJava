/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vvh.services;

import com.mycompany.jdbcdemo.JdbcUnits;
import com.mysql.cj.jdbc.CallableStatement;
import com.vvh.pojo.Choice;
import com.vvh.pojo.Question;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class QuestionServices {

    public List<Question> getQuestions(String kw) throws SQLException {
        try ( Connection conn = JdbcUnits.getConn()) {
//            String kw = "is";
            CallableStatement stm = (CallableStatement) conn.prepareCall("{ CALL getQuestions(?) }");
            stm.setString(1, kw);
            
            List<Question> ques = new ArrayList<>();
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String content = rs.getString("content");
                ques.add(new Question(id,content));
//                System.out.printf("%s - %s\n", id, content);
            }
            return ques;
        }
    }
    public List<Choice> getChoicesByQuesId( String quesId) throws SQLException{
        try ( Connection conn = JdbcUnits.getConn()) {
//            String kw = "is";
            CallableStatement stm = (CallableStatement) conn.prepareCall("{ CALL getChoicesByQuesId(?) }");
            stm.setString(1, quesId);
            
            List<Choice> choices = new ArrayList<>();
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String content = rs.getString("content");
                boolean correct = rs.getBoolean("is_correct");
                choices.add(new Choice(id,content,correct));
//                System.out.printf("%s - %s\n", id, content);
            }
            return choices;
        }
    }
    public int countProduct() throws SQLException {
         try ( Connection conn = JdbcUnits.getConn()) {
//            String kw = "is";
            CallableStatement stm = (CallableStatement) conn.prepareCall("{ CALL countQues(?) }");
            stm.registerOutParameter(1,Types.INTEGER);
            stm.execute();
            return stm.getInt(1);
         }
    }
    public int countProductByCateId(int cateId) throws SQLException {
         try ( Connection conn = JdbcUnits.getConn()) {
//            String kw = "is";
            CallableStatement stm = (CallableStatement) conn.prepareCall("{ CALL countQuesByCateId(?,?) }");
            stm.setInt(1, cateId);
            stm.registerOutParameter(2,Types.INTEGER);
            stm.execute();
            return stm.getInt(2);
         }
    }
}
