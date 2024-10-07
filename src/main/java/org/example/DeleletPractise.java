package org.example;
import jdk.jfr.Threshold;

import java.sql.*;
import java.util.Scanner;

public class DeleletPractise {
    public static String LOAD_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static String URL = "jdbc:mysql://localhost:3306/class";
    public static String USERNAME = "root";
    public static String PASSWORD = "Ritesh123";

    public static void main(String[] args){
        try{
            Class.forName(LOAD_DRIVER);
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String querry = "delete from students where roll_no = ?";
            PreparedStatement preparestatement = connection.prepareStatement(querry);
            Scanner sc = new Scanner(System.in);
            int parameter =sc.nextInt();
            int roll_no_to_delete = sc.nextInt();
             preparestatement.setInt(parameter, roll_no_to_delete);
            int rowsImpacted = preparestatement.executeUpdate();
            System.out.println(rowsImpacted);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
