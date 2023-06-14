package ShopDemo;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Shop {
    private Set<Product> products;


    public Shop() {
        this.products = new LinkedHashSet<>();
    }

    public boolean addProduct(Product product) {
        if (getProductById(product.getId()) != null) {
            return false; // выкинуть ошибку
        }
        return products.add(product);
    }

    public Product getProductById(int productId) {

        return products.stream()
                .filter(p -> p.getId() == productId)
                .findFirst()
                .orElse(null);
    }


//        for (Product p : products) {
//            if (productId == p.getId()) {
//                return p;
//            }

//        return null;
//    }

    public Set<Product> getProducts() {
        return products;
    }

    public boolean removeProduct(int productId) {
        products.remove(getProductById(productId));
        return false;
    }

    // Проверить, отрабатывает некорректно
    public boolean changeProduct(Product product) {
        Product findProduct = getProductById(product.getId());
        if (findProduct == null){
            return false;
        }
        findProduct.setId(product.getId());
        findProduct.setName(product.getName());
        findProduct.setPrice(product.getPrice());
        return true;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "products=" + products +
                '}';
    }

}
