package a21_06_shoppingCart;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    public static final float TAX = 21.0f;
    private List<Product> cartProducts = new ArrayList<>();

    public Cart() {}

    public boolean addProduct(Product product) {
        if (!product.isActive()) return false;
        return cartProducts.add(product);
    }

    public boolean removeProduct(int id) {
        for (Product p : cartProducts) {
            if (p.getId() == id)
                return cartProducts.remove(p);
        }
        return false;
    }

    public List<Product> searchByName(String text) {
        text = text.trim().toLowerCase();
        List<Product> found = new ArrayList<>();
        for (Product p : cartProducts) {
            if (p.getName().trim().toLowerCase().contains(text))
                found.add(p);
        }
        return found;
    }

    public void showCart() {
        if (cartProducts.isEmpty()) System.out.println("Cart is empty");
        else cartProducts.forEach(System.out::println);
    }

    public float getTotal() {
        float sum = 0.0f;
        for (Product p : cartProducts) {
            sum += p.getPrice();
        }
        return sum;
    }

    public float getTax() {
        float total = getTotal();
        return total - (total / (1 + TAX / 100));
    }

    public void clearCart() {
        this.cartProducts = new ArrayList<>();
    }

    public List<Product> getCartProducts() {
        return cartProducts;
    }

    public void setCartProducts(List<Product> cartProducts) {
        this.cartProducts = cartProducts;
    }
}
