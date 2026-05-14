package a21_04_userManager;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        UserManager userManager = new UserManager();

        userManager.addUser(new User("alice@example.com", "1234", "Alice", "Smith", "1990-01-01"));
        userManager.addUser(new User("bob@example.com", "abcd", "Bob", "Jones", "1985-05-20"));
        userManager.addUser(new User("carol@example.com", "pass1", "Carol", "White", "1992-03-15"));
        userManager.addUser(new User("dave@example.com", "pass2", "Dave", "Brown", "1988-07-09"));
        userManager.addUser(new User("eve@example.com", "123abc", "Eve", "Davis", "1995-12-22"));
        userManager.addUser(new User("frank@example.com", "pwd123", "Frank", "Miller", "1983-10-30"));
        userManager.addUser(new User("grace@example.com", "gracepw", "Grace", "Wilson", "1991-06-14"));
        userManager.addUser(new User("heidi@example.com", "heidipw", "Heidi", "Moore", "1987-09-03"));
        userManager.addUser(new User("ivan@example.com", "ivan123", "Ivan", "Taylor", "1993-11-11"));
        userManager.addUser(new User("judy@example.com", "judy987", "Judy", "Anderson", "1994-04-07"));

        byte option;
        while ((option = menu()) != 0) {
            if (option == 1) {
                userManager.listUsers();
            } else if (option == 2) {
                System.out.println("Enter email:");
                String email = scanner.nextLine();

                System.out.println("Enter password:");
                String password = scanner.nextLine();

                System.out.println("Enter name:");
                String name = scanner.nextLine();

                System.out.println("Enter surname:");
                String surname = scanner.nextLine();

                System.out.println("Enter birth date (yyyy-mm-dd):");
                String birthDate = scanner.nextLine();

                System.out.println(userManager.addUser(new User(email, password, name, surname, birthDate)));
            } else if (option == 3) {
                System.out.println("Enter email:");
                String email = scanner.nextLine();

                System.out.println("Enter password:");
                String password = scanner.nextLine();

                System.out.println("Enter name:");
                String name = scanner.nextLine();

                System.out.println("Enter surname:");
                String surname = scanner.nextLine();

                System.out.println("Enter birth date (yyyy-mm-dd):");
                String birthDate = scanner.nextLine();

                System.out.println("Enter active (true/false):");
                boolean isActive = scanner.nextLine().equalsIgnoreCase("true");

                User updatedUser = new User(email, password, name, surname, birthDate);
                updatedUser.setActive(isActive);

                System.out.println(userManager.updateUser(email, updatedUser));
            } else if (option == 4) {
                System.out.println("Enter email:");
                String email = scanner.nextLine();

                System.out.println(userManager.removeUserByEmail(email));
            }
        }
    }

    protected static byte menu() {
        System.out.println("""
                MENU
                1. LIST ALL USERS
                2. ADD NEW USER
                3. UPDATE USER BY EMAIL
                4. REMOVE USER BY EMAIL
                0. EXIT
                OPTION?""");

        byte option = scanner.nextByte();
        scanner.nextLine();
        return option;
    }
}
