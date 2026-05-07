package a21_06_shoppingCart;

public class Product implements Comparable<Product> {
    private final int id;
    private String name;
    private Size size;
    private float price;
    private boolean active;

    static private int idNext = 1;

    public Product(String name, Size size, float price, boolean active) {
        this.id = idNext;
        this.name = name;
        this.size = size;
        this.price = price;
        this.active = active;

        idNext += 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Product [" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", price=" + price +
                ", active=" + active +
                ']';
    }

    @Override
    public int compareTo(Product product) {
        int nameCompare = this.getName().compareTo(product.getName());
        return (nameCompare != 0) ? nameCompare : Double.compare(this.getPrice(), product.getPrice());
    }
}
