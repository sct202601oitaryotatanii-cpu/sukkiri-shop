package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Product;

public class ProductDAO {

    private final String JDBC_URL =
        "jdbc:h2:tcp://localhost/~/sukkiriShop";
    private final String DB_USER = "sa";
    private final String DB_PASS = "";

    public List<Product> findAll() {
        List<Product> list = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(
                JDBC_URL, DB_USER, DB_PASS)) {

            String sql = "SELECT * FROM PRODUCTS";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            ResultSet rs = pStmt.executeQuery();

            while (rs.next()) {
                Product p = new Product(
                    rs.getInt("ID"),
                    rs.getString("NAME"),
                    rs.getInt("PRICE")
                );
                list.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public void insert(String name, int price) {
        // INSERT処理
    }

    public void delete(int id) {
        // DELETE処理
    }
}