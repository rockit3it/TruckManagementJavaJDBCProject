package org.example;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class App
{
    public static String LOAD_DRIVER="com.mysql.cj.jdbc.Driver";
    public static String URL = "jdbc:mysql://localhost:3306/student";
    public static String PASSWORD = "Ritesh123";
    public static String USERNAME = "root";
    public static void main( String[] args )
    {
        try {
            // load driver
            Class.forName(LOAD_DRIVER);
            // making connection
            Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);

            // create statement
            Statement statement = connection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE
            );
            // create querry
            String querry = "Select * from students";
            ResultSet resultSet = statement.executeQuery(querry);
            // result set is pointing to the first ro
            resultSet.last();
            System.out.println(resultSet.getString("name"));
            resultSet.moveToInsertRow();
            resultSet.updateString("name", "risa");
            connection.close();
        }
        catch (Exception E){
            E.printStackTrace();
        }

    }
}
