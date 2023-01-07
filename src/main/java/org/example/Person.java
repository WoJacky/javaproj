package org.example;

public class Person {
    Long id;
    String username;
    String email;
    Boolean enabled;

    public Person(Long id, String username, String email, Boolean enabled) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.enabled = enabled;
    }
    public void save(DataBaseConnector dbc){
        String insert = "insert into values (" +
                "'" + this.username + "'" +
                "'" + this.email + "'" +
                "'" + this.enabled + "'";

        //dbc.executeInsert();
    }
}
