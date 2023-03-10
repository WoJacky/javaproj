package org.example;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        DataBaseConnector dbc = new DataBaseConnector();
        Scanner scanner = new Scanner(System.in);
        dbc.connect();

        boolean endOperation = false;
        scanner.nextLine();
        while (!endOperation) {
            System.out.println("****Wybierz opcję:****");
            System.out.println("1. Dodaj użytkownika");
            System.out.println("2. Odczytaj dane użytkownika o wskazanym id");
            System.out.println("3. Zaktualizuj dane");
            System.out.println("4. Usuń uzytkownika");
            System.out.println("********");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Podaj nazwę użytkownika: ");
                    String username = scanner.nextLine();
                    System.out.print("Podaj adres email: ");
                    String email = scanner.nextLine();
                    System.out.print("Podaj hasło: ");
                    String pass = scanner.nextLine();
                    System.out.print("Podaj stan aktywności (true/false): ");
                    boolean enabled = scanner.nextBoolean();
                    scanner.nextLine();
                    Person p = new Person(-1, username, email, pass, enabled);
                    p.create(dbc);
                    break;
                case 2:
                    System.out.print("Podaj nazwę użytkownika: ");
                    username = scanner.nextLine();
                    p = new Person(-1, username, "", "", false);
                    try {
                        p.read(dbc);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 3:
                    System.out.print("Podaj nazwę użytkownika: ");
                    String username2 = scanner.nextLine();
                    System.out.print("Podaj adres email: ");
                    String email2 = scanner.nextLine();
                    System.out.print("Podaj hasło: ");
                    String pass2 = scanner.nextLine();
                    System.out.print("Podaj stan aktywności (true/false): ");
                    boolean enabled2 = scanner.nextBoolean();
                    scanner.nextLine();
                    Person p2 = new Person(-1, username2, email2, pass2, enabled2);
                    p2.update(dbc);
                    break;
                case 4:
                    System.out.print("Podaj nazwę użytkownika: ");
                    username = scanner.nextLine();
                    p = new Person(-1, username, "", "", false);
                    p.delete(dbc);
                    break;
                case 5:
                    endOperation = true;
                    break;
            }
        }
    }
}