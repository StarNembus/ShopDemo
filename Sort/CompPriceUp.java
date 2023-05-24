package ShopDemo.Sort;

import ShopDemo.Product;

import java.util.Comparator;

public class CompPriceUp implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return o1.getPrice() - o2.getPrice();
    }
}
