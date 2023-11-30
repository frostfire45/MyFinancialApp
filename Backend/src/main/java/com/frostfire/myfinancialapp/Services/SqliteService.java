package com.frostfire.myfinancialapp.Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqliteService {
    private String connectionString = null;
    public SqliteService(String connectionString){
        this.connectionString = connectionString;
    }
    public static void connect(){
        Connection conn = null;
        try {
            // DB Parameters
            String url = "jdbc:sqlite:C:\\Users\\d.huskey\\Documents\\JavaProject\\MyFinancialApp\\Backend\\db\\financialDB.db";
            conn = DriverManager.getConnection(url);
            System.out.println("Connection To SQLite has been established.");
        } catch (SQLException e){
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
}
