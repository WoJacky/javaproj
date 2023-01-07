package org.example;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        DataBaseConnector dbc = new DataBaseConnector();
        dbc.connect();
        dbc.executeInsert("insert into people values ('3','wsb','wsb@wsb.pl', '1234',true)");

        try {
            dbc.executeSelect("Select * from people");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}