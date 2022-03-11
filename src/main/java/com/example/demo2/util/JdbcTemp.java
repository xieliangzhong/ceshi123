package com.example.demo2.util;

import java.sql.*;

public class JdbcTemp {

        public static void main(String[] args) throws SQLException, ClassNotFoundException {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/test?serverTimezone=GMT%2B8";
            Connection con = DriverManager.getConnection(url, "root", "xlz241020");
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from user");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + ":" + resultSet.getString(2));
            }
            statement.close();
            con.close();
        }

}