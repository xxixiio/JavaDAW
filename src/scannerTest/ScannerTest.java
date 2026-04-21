package scannerTest;

import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();
        System.out.println("Text: " + text);

        System.out.print("Enter number: ");
        int num = sc.nextInt();
        System.out.println("Number: " + num);

        sc.close();
    }
}
