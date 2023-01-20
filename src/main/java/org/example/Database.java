package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class Database {
    private static Database instance;

    private Database() {

    }

    public static Database getInstance() {
        if(instance == null) {
            instance = new Database();
        }
        return instance;
    }
    public Connection getConnection() {
        String dbUrl = "jdbc:mysql://127.0.0.1:3306/mydb";
        String dbUser = "root";
        String dbPass = "Lolka911";
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public String sqlResponseReader(String sqlResponse) {
        StringBuilder response = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(sqlResponse))){
            while (bufferedReader.ready()) {
                response.append(bufferedReader.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return response.toString();
    }
}
