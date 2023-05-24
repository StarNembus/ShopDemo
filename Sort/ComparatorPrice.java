package ShopDemo.Sort;

import ShopDemo.Product;

import java.util.Comparator;

public class ComparatorPrice implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return o2.getPrice() - o1.getPrice();
    }
}
