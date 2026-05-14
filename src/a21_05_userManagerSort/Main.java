package a21_05_userManagerSort;

import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        UserManager userManager = new UserManager();

        userManager.addUser(new User("alice.smith@example.com", "1234", "Alice", "Smith", "1990-01-01"));
        userManager.addUser(new User("bob.jones@example.com", "abcd", "Bob", "Jones", "1985-05-20"));
        userManager.addUser(new User("carol.white@example.com", "pass1", "Carol", "White", "1992-03-15"));
        userManager.addUser(new User("dave.brown@example.com", "pass2", "Dave", "Brown", "1988-07-09"));
        userManager.addUser(new User("eve.davis@example.com", "123abc", "Eve", "Davis", "1995-12-22"));
        userManager.addUser(new User("frank.miller@example.com", "pwd123", "Frank", "Miller", "1983-10-30"));
        userManager.addUser(new User("grace.wilson@example.com", "gracepw", "Grace", "Wilson", "1991-06-14"));
        userManager.addUser(new User("heidi.moore@example.com", "heidipw", "Heidi", "Moore", "1987-09-03"));
        userManager.addUser(new User("ivan.taylor@example.com", "ivan123", "Ivan", "Taylor", "1993-11-11"));
        userManager.addUser(new User("judy.anderson@example.com", "judy987", "Judy", "Anderson", "1994-04-07"));
        userManager.addUser(new User("alice.anderson@example.com", "223anne", "Alice", "Anderson", "1994-04-07"));
        userManager.addUser(new User("john.smith@example.com", "xcydfe", "John", "Smith", "2000-05-05"));
        userManager.addUser(new User("john.anderson@example.com", "set678", "John", "Anderson", "1999-02-05"));
        userManager.addUser(new User("peter.anderson@example.com", "rtyfgw", "Peter", "Anderson", "2000-05-05"));

        byte option;
        while ((option = menu()) != 0) {
            if (option == 1) {
                userManager.listUsers();
            } else if (option == 2) {
                userManager.sortByNameAndSurname();
                userManager.getUsers().forEach(System.out::println);
            } else if (option == 3) {
                userManager.sortByEmail();
                userManager.getUsers().forEach(System.out::println);
            } else if (option == 4) {
                userManager.sortByBirthdateAndName();
                userManager.getUsers().forEach(System.out::println);
            }  else if (option == 5) {
                userManager.sortBySurnameAndName();
                userManager.getUsers().forEach(System.out::println);
            }
        }
    }

    protected static byte menu() {
        System.out.println("""
                MENU
                1. LIST ALL USERS
                2. SORT BY NAME AND SURNAME
                3. SORT BY EMAIL
                4. SORT BY BEIRTHDATE AND NAME
                5. SORT BY SURNAME AND NAME
                0. EXIT
                OPTION?""");

        byte option = scanner.nextByte();
        scanner.nextLine();
        return option;
    }
}
