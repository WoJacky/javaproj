package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
public class DataBaseConnector {
    public static final String Host = "jdbc:postgresql://snuffleupagus.db.elephantsql.com/jbpulprp";
    public static final String DATABASE = "jbpulprp";
    public static final String USERNAME = "jbpulprp";
    public static final String pass = "eY2oVdqT9iNPqnQZx_I052MU7a0Iq0mI";
    public Connection connection;

    public void connect() {
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(Host, USERNAME, pass);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }

    public void executeInsert(String sql) {
        try {
            Statement stm = this.connection.createStatement();
            stm.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Read
    public ResultSet executeSelect(String sql) {
        try {
            Statement stm = this.connection.createStatement();
            return stm.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    // Update
    public int executeUpdate(String sql) {
        try {
            Statement stm = this.connection.createStatement();
            return stm.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //Delete
    public int executeDelete(String sql) {
        try {
            Statement stm = this.connection.createStatement();
            return stm.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}