package ShopDemo;

import java.util.*;

public class MainShop {
    public static void main(String[] args) throws Exception {
        Shop shop = new Shop();
        Product p1 = new Product( "apple", 123);
        Product p2 = new Product( "orange", 123);
        Product p3 = new Product( "banana", 54);
        Product p6 = new Product( "tomato", 56);
        shop.addProduct(p1);
        shop.addProduct(p2);
        shop.addProduct(p3);
        shop.addProduct(p6);

        System.out.println(shop);

//        Set <Product> productSet = new TreeSet<>();
//        productSet.add(p1);
//        productSet.add(p2);
//        productSet.add(p3);
//        productSet.add(p6);
//        System.out.println(productSet);

        Stack<Product> productStack = new Stack<>();
        productStack.addAll(shop.getProducts());
        List<Product> sortByDate = new ArrayList<>();
        while (!productStack.isEmpty()) {
            sortByDate.add(productStack.pop());
        }
        System.out.println(sortByDate);
        shop.setProducts(sortByDate);
        System.out.println(sortByDate);
    }

}
