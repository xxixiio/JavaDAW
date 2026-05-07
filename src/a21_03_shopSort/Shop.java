package a21_03_shopSort;

import java.util.ArrayList;
import java.util.Collections;
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

    public List<Product> listProductsNameAndSize(String text, Size size) {
        text = text.trim().toLowerCase();
        List<Product> filteredList = new ArrayList<>();
        for (Product p : products) {
            if (p.isActive() && p.getName().toLowerCase().contains(text) && size == p.getSize()) {
                filteredList.add(p);
            }
        }
        return filteredList;
    }

    public float totalActive() {
        float sum = 0.0f;
        for (Product p : products) {
            if (p.isActive()) sum += p.getPrice();
        }

        return sum;
    }

    public float totalBySize(Size size) {
        float sum = 0.0f;
        for (Product p : products) {
            if (p.getSize() == size) sum += p.getPrice();
        }

        return sum;
    }

    public float averageActive() {
        int c = 0;
        float sum = 0.0f;
        for (Product p : products) {
            if (p.isActive()) {
                c += 1;
                sum += p.getPrice();
            }
        }

        return sum / c;
    }

    public List<Product> sortByNameAndSize() {
        List<Product> sortedList = new ArrayList<>(products);
        Collections.sort(sortedList);
        return sortedList;
    }

    public List<Product> sortByPrice() {
        List<Product> sortedList = new ArrayList<>(products);
        sortedList.sort(new ProductPriceComparator());
        return sortedList;
    }

    public List<Product> sortByNameAndPrice() {
        List<Product> sortedList = new ArrayList<>(products);
        sortedList.sort(new ProductNameAndPriceComparator());
        return sortedList;
    }
}
