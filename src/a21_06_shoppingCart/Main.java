package a21_06_shoppingCart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Shop shop = initShop();
        Cart cart = new Cart();

        byte option = menu();
        while (option != 0) {
            if (option == 1) {
                shop.listProducts();
            } else if (option == 2) {
                System.out.println("Enter product ID to add:");
                int id = scanner.nextInt();
                scanner.nextLine();

                Product product = shop.getProductById(id);
                if (product == null) {
                    System.out.println("Product not found");
                } else {
                    cart.addProduct(product);
                    System.out.println("Product added to cart");
                }
            } else if (option == 3) {
                cart.showCart();
            } else if (option == 4) {
                System.out.println("Enter product ID to remove:");
                int id = scanner.nextInt();
                scanner.nextLine();

                if (cart.removeProduct(id)) {
                    System.out.println("Product removed from cart");
                } else {
                    System.out.println("This id is not in the cart");
                }
            } else if (option == 5) {
                System.out.printf("Total: %.2f%n", cart.getTotal());
            } else if (option == 6) {
                System.out.printf("Tax: %.2f%n", cart.getTax());
            } else if (option == 7) {
                cart.clearCart();
                System.out.println("Cart cleared");
            }

            option = menu();
        }
    }

    private static byte menu() {
        System.out.println("""
                MENU
                1. LIST PRODUCTS (SHOP)
                2. ADD PRODUCT TO CART
                3. LIST CART
                4. REMOVE PRODUCT FROM CART
                5. CART TOTAL
                6. CART TAX (IVA 21%)
                7. CLEAR CART
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
