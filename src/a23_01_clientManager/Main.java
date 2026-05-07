package a23_01_clientManager;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ClientManager clientManager = new ClientManager();

        Set<Client> clients = new HashSet<>();
        clients.add(new Client("0000001", "11111111A", "Bugs", "Bunny", "1111111", 0f));
        clients.add(new Client("0000002", "22222222B", "Marilyn", "Monroe", "2222222", 200.00f));
        clients.add(new Client("0000003", "33333333C", "Peter", "Pan", "3333333", 120.50f));
        clients.add(new Client("0000004", "44444444D", "Bart", "Simpson", "4444444", -150.25f));
        clients.add(new Client("0000005", "55555555E", "Mafalda", "Srta.", "5555555", 550.25f));
        clients.add(new Client("0000006", "66666666F", "Lisa", "Simpson", "6666666", 57.75f));
        clients.add(new Client("0000007", "77777777G", "Charlie", "Brown", "7777777", 0f));
        clients.add(new Client("0000008", "88888888H", "SpongeBob", "SquarePants", "8888888", 125.50f));
        clients.add(new Client("0000009", "99999999I", "Patrick", "Star", "9999999", 0f));
        clients.add(new Client("0000010", "10101010J", "Homer", "Simpson", "1212121", -1250.50f));
        clients.add(new Client("0000010", "11111111K", "Maggie", "Simpson", "1212121", 350.25f));
        clients.add(new Client("0000006", "66666666F", "Lisa", "Simpson", "6666666", 57.75f));
        clients.add(new Client("0000007", "77777777G", "Charlie", "Brown", "7777777", 0f));

        clientManager.setClients(clients);

        byte option = menu();

        while (option != 0) {
            if (option == 1) {
                clientManager.listClients();
            } else if (option == 2) {
                System.out.println("Enter account:");
                String account = scanner.nextLine();

                System.out.println("Enter dni:");
                String dni = scanner.nextLine();

                System.out.println(
                        clientManager.getClientByAccountAndDni(account, dni)
                );
            } else if (option == 3) {
                System.out.println("Enter account:");
                String account = scanner.nextLine();

                System.out.println("Enter dni:");
                String dni = scanner.nextLine();

                System.out.println("Enter name:");
                String name = scanner.nextLine();

                System.out.println("Enter surname:");
                String surname = scanner.nextLine();

                System.out.println("Enter phone:");
                String phone = scanner.nextLine();

                System.out.println("Enter balance:");
                float balance = scanner.nextFloat();
                scanner.nextLine();

                System.out.println(clientManager.addClient(
                        new Client(account, dni, name, surname, phone, balance)
                ));
            } else if (option == 4) {
                System.out.println("Enter account:");
                String account = scanner.nextLine();

                System.out.println("Enter dni:");
                String dni = scanner.nextLine();

                System.out.println("Enter name:");
                String name = scanner.nextLine();

                System.out.println("Enter surname:");
                String surname = scanner.nextLine();

                System.out.println("Enter phone:");
                String phone = scanner.nextLine();

                System.out.println("Enter balance:");
                float balance = scanner.nextFloat();
                scanner.nextLine();

                System.out.println(clientManager.updateClient(account, dni, new Client(
                        account, dni, name, surname, phone, balance
                )));

            } else if (option == 5) {
                System.out.println("Enter account:");
                String account = scanner.nextLine();

                System.out.println("Enter dni:");
                String dni = scanner.nextLine();

                System.out.println(
                        clientManager.removeClient(account, dni)
                );
            }

            option = menu();
        }
    }

    public static byte menu() {
        System.out.println("""
                MENU
                1. LIST CLIENTS
                2. GET CLIENT BY ACCOUNT AND DNI
                3. ADD NEW CLIENT
                4. UPDATE CLIENT BY ACCOUNT AND DNI
                5. REMOVE CLIENT BY ACCOUNT AND DNI
                0. EXIT
                OPTION?""");

        byte option = scanner.nextByte();
        scanner.nextLine();
        return option;
    }
}
