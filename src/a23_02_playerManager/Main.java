package a23_02_playerManager;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        PlayerManager playerManager = new PlayerManager();

        playerManager.addPlayer(new Player("Kylian", "Mbappé", (byte) 23, 1.78f, 80f, 0));
        playerManager.addPlayer(new Player("Sergi", "Busquets", (byte) 10, 1.89f, 85f, 10));
        playerManager.addPlayer(new Player("Mapi", "Leon", (byte) 26, 1.70f, 60f, 5));
        playerManager.addPlayer(new Player("Leo", "Messi", (byte) 34, 1.70f, 70f, 16));
        playerManager.addPlayer(new Player("Gerard", "Pique", (byte) 35, 1.94f, 84f, 30));
        playerManager.addPlayer(new Player("Alexia", "Putellas", (byte) 28, 1.65f, 58f, 0));
        playerManager.addPlayer(new Player("Alexia", "Putellas", (byte) 28, 1.65f, 60f, 22));
        playerManager.addPlayer(new Player("Gerard", "Pique", (byte) 35, 1.94f, 85f, 12));

        byte option = menu();

        while (option != 0) {
            if (option == 1) {
                playerManager.listPlayers();
            } else if (option == 2) {
                System.out.println("Enter name:");
                String name = scanner.nextLine();

                System.out.println("Enter surname:");
                String surname = scanner.nextLine();

                System.out.println("Enter age:");
                byte age = scanner.nextByte();
                scanner.nextLine();

                System.out.println(
                        playerManager.getPlayerByNameSurnameAndAge(name, surname, age)
                );
            } else if (option == 3) {
                System.out.println("Enter name:");
                String name = scanner.nextLine();

                System.out.println("Enter surname:");
                String surname = scanner.nextLine();

                System.out.println("Enter age:");
                byte age = scanner.nextByte();
                scanner.nextLine();

                System.out.println("Enter height:");
                float height = scanner.nextFloat();
                scanner.nextLine();

                System.out.println("Enter weight:");
                float weight = scanner.nextFloat();
                scanner.nextLine();

                System.out.println("Enter points:");
                int points = scanner.nextInt();
                scanner.nextLine();

                System.out.println(
                        playerManager.addPlayer(
                                new Player(name, surname, age, height, weight, points)
                        )
                );
            } else if (option == 4) {
                System.out.println("Enter name:");
                String name = scanner.nextLine();

                System.out.println("Enter surname:");
                String surname = scanner.nextLine();

                System.out.println("Enter age:");
                byte age = scanner.nextByte();
                scanner.nextLine();

                System.out.println("Enter height:");
                float height = scanner.nextFloat();
                scanner.nextLine();

                System.out.println("Enter weight:");
                float weight = scanner.nextFloat();
                scanner.nextLine();

                System.out.println("Enter points:");
                int points = scanner.nextInt();
                scanner.nextLine();

                System.out.println(
                        playerManager.updatePlayer(
                                name,
                                surname,
                                age,
                                new Player(name, surname, age, height, weight, points)
                        )
                );
            } else if (option == 5) {
                System.out.println("Enter name:");
                String name = scanner.nextLine();

                System.out.println("Enter surname:");
                String surname = scanner.nextLine();

                System.out.println("Enter age:");
                byte age = scanner.nextByte();
                scanner.nextLine();

                System.out.println(
                        playerManager.removePlayer(name, surname, age)
                );
            }

            option = menu();
        }
    }

    public static byte menu() {
        System.out.println("""
                MENU
                1. LIST PLAYERS
                2. GET PLAYER BY NAME, SURNAME AND AGE
                3. ADD NEW PLAYER
                4. UPDATE PLAYER BY NAME, SURNAME AND AGE
                5. REMOVE PLAYER BY NAME, SURNAME AND AGE
                0. EXIT
                OPTION?
                """);

        byte option = scanner.nextByte();
        scanner.nextLine();
        return option;
    }
}