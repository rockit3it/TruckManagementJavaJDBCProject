package org.example;
import java.sql.*;

public class Practise {
    public static String LOAD_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static String URL = "jdbc:mysql://localhost:3306/class";

    public static String USERNAME = "root";
    public static String PASSWORD = "Ritesh123";
    public static void main(String[] args){
        try{
            Class.forName(LOAD_DRIVER);
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);


            String querry = "Select * from students";
            ResultSet resultSet = statement.executeQuery(querry);
            resultSet.first();
            while(resultSet.next()){
                Thread.sleep(5000);
                System.out.println(resultSet.getInt("roll_no"));
                System.out.println(resultSet.getString("name"));
                System.out.println(resultSet.getString("class"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }


    }
}
