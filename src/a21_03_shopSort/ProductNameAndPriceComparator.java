package a21_03_shopSort;

import java.util.Comparator;

public class ProductNameAndPriceComparator implements Comparator<Product> {

    @Override
    public int compare(Product product, Product t1) {
        int nameCompare = product.getName().compareToIgnoreCase(t1.getName());

        return (nameCompare != 0)
                ? nameCompare
                : Float.compare(product.getPrice(), t1.getPrice());
    }
}