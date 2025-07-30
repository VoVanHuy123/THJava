/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.jdbcdemo;

import com.mysql.cj.jdbc.CallableStatement;
import com.vvh.pojo.Choice;
import com.vvh.pojo.Question;
import com.vvh.services.QuestionServices;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class JDBCDemo {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        Scan sc = new Scan();
//        QuestionServices s = new QuestionServices();
//        List<Question> ques = s.getQuestions("is");
//        for (var q : ques) {
//            System.out.println(q.getContent());
//            q.setChoices(s.getChoicesByQuesId(q.getId()));
//            for (int i = 0; i < q.getChoices().size(); i++) {
//                System.out.printf("%d - %s\n", i + 1, q.getChoices().get(i).getContent());
//            }
//        }
        Scanner sc = new Scanner(System.in);
        QuestionServices s = new QuestionServices();
        List<Question> ques = s.getQuestions("is");

        for (var q : ques) {
            System.out.println("Question: " + q.getContent());
            q.setChoices(s.getChoicesByQuesId(q.getId()));

            // Hiển thị đáp án
            for (int i = 0; i < q.getChoices().size(); i++) {
                System.out.printf("%d - %s\n", i + 1, q.getChoices().get(i).getContent());
            }

            // Yêu cầu người dùng chọn đáp án
            System.out.print("Your choice (number): ");
            int choice = sc.nextInt();

            // Kiểm tra đáp án đúng/sai
            if (choice >= 1 && choice <= q.getChoices().size()) {
                Choice selected = q.getChoices().get(choice - 1);
                if (selected.isCorrect()) {
                    System.out.println("Correct!");
                } else {
                    System.out.println("Wrong!");
                }
            } else {
                System.out.println("Invalid choice.");
            }

            System.out.println("--------------------------");
        }
        sc.close();

    }
}
