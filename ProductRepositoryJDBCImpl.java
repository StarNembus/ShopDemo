package ShopDemo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static ShopDemo.ConnectingJDBC.getConnection;

public class ProductRepositoryJDBCImpl implements ProductRepository {
    private final Connection connection;

    public ProductRepositoryJDBCImpl() {
        this.connection = getConnection();
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select * from Products");
             while (resultSet.next()) {
                 int id = resultSet.getInt("id");
                 String name = resultSet.getString("name");
                 int price = resultSet.getInt("price");
                 products.add(new Product(id, name, price));
             }
            return products;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void getProductById(int id) {
        try {
            String sql = "select * from Products where products_id = " + id;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                Product product = new Product(name, price);
                product.setName(name);
                product.setPrice(price);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Product saveProduct(Product product) {
        String sql = "insert into Products(name, price) values (?, ?)";

        try {
//            connection.createStatement();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, product.getName());
            statement.setInt(2, product.getPrice());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;
    }

    @Override
    public boolean deleteProductById(int id) {
        try {
            String sql = "DELETE from Products WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public Product updateProduct(Product product) {
        try {
            PreparedStatement statement
                    = connection.prepareStatement("Update Products SET (name, price) = ( ?, ?)" +  "WHERE id = ?");
            statement.setString(1, product.getName());
            statement.setInt(2, product.getPrice());
            statement.setInt(3, product.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;
    }
}