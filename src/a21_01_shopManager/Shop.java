package a21_01_shopManager;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private String name;
    private List<Product> products = new ArrayList<>();

    public Shop(String name) {
        this.name = name;
    }

    public void listProducts() {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public boolean addProduct(Product product) {
        return products.add(product);
    }

    public boolean updateProduct(int id, Product product) {
        for (Product p : products) {
            if (p.getId() == id) {
                p.setName(product.getName());
                p.setSize(product.getSize());
                p.setPrice(product.getPrice());
                p.setActive(product.isActive());

                return true;
            }
        }

        return false;
    }

    public boolean removeProductById(int id) {
        for (Product p : products) {
            if (p.getId() == id)
                return products.remove(p);
        }
        return false;
    }

    public int numProducts() {
        return products.size();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
