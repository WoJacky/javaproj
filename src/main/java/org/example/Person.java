package org.example;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Person {
    Long id;
    String username;
    String pass;
    String email;
    Boolean enabled;

    public Person(long id, String username, String email, String pass, Boolean enabled) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.pass = pass;
        this.enabled = enabled;
    }
    public void create(DataBaseConnector dbc) {
        String insert = "Insert into person values ('" +
                this.username + "', '" +
                this.email + "', '" +
                this.pass + "', " +
                this.enabled.toString() + ", " +
                this.id + ")";
        dbc.executeInsert(insert);
    }
    public void read(DataBaseConnector dbc) throws SQLException {
        String sql = "SELECT * FROM person WHERE username = '" + this.username + "'";
        ResultSet rs = null;
        rs = dbc.executeSelect(sql);
        while (rs.next()) {
            long id = rs.getLong("id");
            String username = rs.getString("username");
            String email = rs.getString("email");
            String pass = rs.getString("password");
            boolean enabled = rs.getBoolean("enabled");
            Person p = new Person(id, username, email, pass, enabled);
            // przetwarzanie obiektu Person
            System.out.println("id: " + id + ", username: " + username + ", email: " + email + ", pass: " + pass + ", enabled: " + enabled);
        }
    }
    public void update(DataBaseConnector dbc) {
        String sql2 = "UPDATE person SET username = " + this.username + ",password = " + this.pass + ",email = " + this.email + "WHERE username = " + this.username;
        //String sql = "UPDATE person SET email = '" + this.email + "' WHERE username = '" + this.username + "'";
        int count = dbc.executeUpdate(sql2);
        System.out.println("Zmodyfikowano " + count + " rekordów.");
    }
    public void delete(DataBaseConnector dbc) {
        String sql = "DELETE FROM person WHERE username = '" + this.username + "'";
        int count = dbc.executeDelete(sql);
        System.out.println("Usunięto " + count + " rekordów.");
    }
}
