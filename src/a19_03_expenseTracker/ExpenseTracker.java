package a19_03_expenseTracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExpenseTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ExpenseTracker expenseTracker = new ExpenseTracker();

        List<Float> list = new ArrayList<>();
        float[] values = {
                12.5f, 13.55f, 23.5f, 123.45f, 122.52f, 113.46f,
                143.3f, 123.4f, 126.55f, 7.8f, 122.6f, 185.3f,
                210.59f, 1.99f, 155.0f, 55.4f, 254.35f, 122.55f,
                120.99f, 121.0f
        };

        for (float n : values) {
            list.add(n);
        }

        System.out.println("1. Total expenses");
        System.out.println("2. Total expenses above amount");
        System.out.println("3. Total expenses with tolerance");
        System.out.println("Choose option:");

        int option = sc.nextInt();

        if (option == 1) {
            System.out.printf("Total expenses: %.2f", expenseTracker.totalExpenses(list));
        } else if (option == 2) {
            System.out.println("Enter amount:");
            float amount = sc.nextFloat();

            System.out.printf("Expenses: %.2f", expenseTracker.totalAbove(list, amount));
        } else if (option == 3) {
            System.out.println("Enter value:");
            float value = sc.nextFloat();

            System.out.println("Enter tolerance:");
            float tolerance = sc.nextFloat();

            System.out.printf("Expenses: %.2f", expenseTracker.totalWithTolerance(list, value, tolerance));
        }
    }

    public double totalExpenses(List<Float> list) {
        double total = 0;
        for (double n : list) {
            total += n;
        }
        return total;
    }

    public float totalAbove(List<Float> list, float amount) {
        float total = 0;
        for (float n : list) {
            if (n >= amount) total += n;
        }
        return total;
    }

    public float totalWithTolerance(List<Float> list, float amount, float tolerance) {
        float total = 0;
        for (float n : list) {
            if (n >= amount - tolerance && n <= amount + tolerance) total += n;
        }
        return total;
    }

}
