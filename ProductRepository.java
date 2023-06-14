package ShopDemo;

import java.util.List;

public interface ProductRepository {


    List getAllProducts();

    void getProductById(int id);

    Product saveProduct(Product product);


    boolean deleteProductById(int id);


    Product updateProduct(Product product);


}
