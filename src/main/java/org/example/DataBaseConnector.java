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
        System.out.println("Query added");
    }

    public void executeSelect(String sql) throws SQLException {
        Statement stmt = null;
        try {
            stmt = this.connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        while (rs.next()) {
            int id = rs.getInt("id");
            String username = rs.getString("username");
            String email = rs.getString("email");
            System.out.println("ID = " + id);
            System.out.println("NAME = " + username);
            System.out.println("AGE = " + email);
            System.out.println();
        }
    }
}
