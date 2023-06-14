package ShopDemo;

import java.sql.*;
import java.util.Optional;

public class ConnectingJDBC {

    private static final String dbName = "postgres";
    private static final String dbPass = "postgres";
    private static final String connectionURL = "jdbc:postgresql://localhost:5432/postgres";

    public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(connectionURL, dbName, dbPass);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


//    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, SQLException {
//        String dbName = "postgres";
//        String dbPass = "postgres";
//        String connectionURL = "jdbc:postgresql://localhost:5432/postgres";
//        try {
//            Class.forName("org.postgresql.Driver");
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//        try(Connection connection = DriverManager.getConnection(connectionURL, dbName, dbPass);
//            Statement statement = connection.createStatement()) {
//            statement.executeUpdate("drop table Products");
//            statement.executeUpdate("create table Products (id SERIAL PRIMARY KEY, name VARCHAR(30) NOT NULL, price NUMERIC);");
//            statement.executeUpdate("insert into Products (name, price) values ('Apple', 123);");
//            statement.executeUpdate("insert into Products (name, price) values ('Orange', 99);");
//            statement.executeUpdate("insert into Products (name, price) values ('Tomato', 119);");
//            ResultSet = statement.executeQuery("select * from Products");
//            while(resultSet.next()) {
//                System.out.println(resultSet.getInt(1));
//                System.out.println(resultSet.getString(2));
//                System.out.println("--------");
//            }

}
