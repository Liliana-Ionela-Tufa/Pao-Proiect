package com.company.config;
import java.sql.*;

public class databaseConfig {
    private static final String  url = "jdbc:mysql://localhost:3306/pao";
    private static final String username = "root";
    private static final String password = "root";

    private static Connection connection;

    public static Connection getConnection() {
        try {
            if(connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(url, username, password);
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }


    public static void closeDatabaseConfig(){
        try{
            if(connection != null && !connection.isClosed()){
                connection.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
