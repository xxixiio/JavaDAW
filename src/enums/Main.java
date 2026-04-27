package enums;

public class Main {
    static class Product {
        String name;
        float price;
        Color color;

        public Product(String name, float price, Color color) {
            this.name = name;
            this.price = price;
            this.color = color;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    ", color=" + color +
                    '}';
        }
    }

    public static void main(String[] args) {
        Color color1 = Color.RED;
        Color color2 = Color.BLUE;
        Color color3 = Color.MAGENTA;
        Color color4 = Color.BLUE;

        if (color2 == color4) {
            System.out.printf("%s equals %s%n", color2, color4);
        }

        if (color1 != color3) {
            System.out.printf("%s not equals %s%n", color1, color3);
        }

        Product product1 = new Product("New product", 0.99f, color1);
        Product product2 = new Product("New product 2", 10.99f, Color.BLACK);

        System.out.println(product1);
        System.out.println(product2);
    }
}
