package ShopDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Shop {
    private List<Product> products;


    public Shop() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        if (products.contains(product)) {
            System.out.println("This id " + product + "exist");
        } else {
            product.setId(products.size() + 1);
            products.add(product);
        }
    }

    public Product getProductById(int productId) {
        for (Product p : products) {
            if (productId == p.getId()) {
                return p;
            }
        }
        return null;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void removeProduct(int productId) {
        products.remove(getProductById(productId));
    }

    public Product changeProduct(Product product) {
        if (!products.contains(product)) {
            addProduct(product);
            System.out.println("Product " + product + " add in list");
        }
        return products.set(products.indexOf(product), product);
    }

    @Override
    public String toString() {
        return "Shop{" +
                "products=" + products +
                '}';
    }
}
