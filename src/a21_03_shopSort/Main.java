package a21_03_shopSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Shop shop = initShop();

        byte option = menu();
        while (option != 0) {
            if (option == 1) {
                shop.listProducts();
            } else if (option == 2) {
                List<Product> list = shop.sortByNameAndSize();
                for (Product p : list) {
                    System.out.println(p);
                }
            } else if (option == 3) {
                List<Product> list = shop.sortByPrice();
                for (Product p : list) {
                    System.out.println(p);
                }
            } else if (option == 4) {
                List<Product> list = shop.sortByNameAndPrice();
                for (Product p : list) {
                    System.out.println(p);
                }
            }
            option = menu();
        }
    }

    private static byte menu() {
        System.out.println("""
                MENU
                1. LIST ALL PRODUCTS
                2. SORT BY NAME AND SIZE
                3. SORT BY PRICE
                4. SORT BY NAME AND PRICE
                0. EXIT
                OPTION?""");

        byte option = scanner.nextByte();
        scanner.nextLine();
        return option;
    }

    private static Size promptSize() {
        int input = scanner.nextInt() - 1;
        Size[] sizes = {Size.XXS, Size.XS, Size.S, Size.M, Size.L, Size.XL, Size.XXL};

        return sizes[input % sizes.length];
    }

    private static Shop initShop() {
        Shop shop = new Shop("Shop");
        List<Product> products = new ArrayList<>(Arrays.asList(
                new Product("TSHIRT", Size.XXS, 30.25f, true),
                new Product("CAP", Size.XS, 25.75f, true),
                new Product("TROUSERS", Size.S, 30.25f, true),
                new Product("SKIRT", Size.M, 28.25f, true),
                new Product("GLOVES", Size.L, 32.35f, true),
                new Product("TSHIRT", Size.XL, 23.79f, true),
                new Product("TSHIRT", Size.XXL, 35.25f, true),
                new Product("JACKET", Size.XL, 59.97f, true),
                new Product("TSHIRT", Size.XS, 29.95f, true),
                new Product("LONG-SHIRT", Size.XS, 20.56f, true),
                new Product("TANK-TSHIRT", Size.XL, 16.55f, true),
                new Product("TSHIRT", Size.M, 29.15f, true),
                new Product("TANK-TSHIRT", Size.XXL, 24.45f, true),
                new Product("TSHIRT", Size.XS, 32.5f, true),
                new Product("LONG-SHIRT", Size.XS, 32.7f, false),
                new Product("SHIRT", Size.XS, 34.5f, false),
                new Product("TSHIRT", Size.XS, 33.25f, false),
                new Product("SLEEVELESS-SHIRT", Size.XS, 32.5f, false),
                new Product("TSHIRT", Size.XS, 28.5f, false),
                new Product("TSHIRT", Size.S, 29.5f, false)
        ));

        shop.setProducts(products);
        return shop;
    }
}
