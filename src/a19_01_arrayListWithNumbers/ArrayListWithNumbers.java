package a19_01_arrayListWithNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ArrayListWithNumbers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayListWithNumbers arrayListWithNumbers = new ArrayListWithNumbers();

        List<Integer> list = Arrays.asList(1, 2, 3, 8, 3, 7, 15, 22, 25, -4, 5, 12, 2, 8, 15, 0);

        System.out.println("1. Total");
        System.out.println("2. Find positions");
        System.out.println("Choose option:");

        int option = sc.nextInt();

        if (option == 1) {
            System.out.println(arrayListWithNumbers.total(list));
        } else if (option == 2) {
            System.out.println("Enter number to find:");
            int numberToFind = sc.nextInt();

            System.out.println(arrayListWithNumbers.findPositions(list, numberToFind));
        }

    }

    public int total(List<Integer> list) {
        int sum = 0;
        for (int i : list) {
            sum += i;
        }
        return sum;
    }

    public List<Integer> findPositions(List<Integer> list, int number) {
        List<Integer> foundList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == number) foundList.add(i);
        }
        return foundList;
    }
}
