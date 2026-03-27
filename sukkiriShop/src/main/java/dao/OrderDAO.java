package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import model.CartItem;

public class OrderDAO {

    private final String JDBC_URL =
        "jdbc:h2:tcp://localhost/~/sukkiriShop";
    private final String DB_USER = "sa";
    private final String DB_PASS = "";

    public void insert(String userId, List<CartItem> cart) {

        try (Connection conn = DriverManager.getConnection(
                JDBC_URL, DB_USER, DB_PASS)) {

            conn.setAutoCommit(false); // ★トランザクション

            // ① 注文登録
            String sql1 = "INSERT INTO ORDERS(USER_ID, TOTAL) VALUES(?,?)";
            PreparedStatement pStmt1 =
                conn.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);

            int total = 0;
            for (CartItem item : cart) {
                total += item.getProduct().getPrice() * item.getQuantity();
            }

            pStmt1.setString(1, userId);
            pStmt1.setInt(2, total);
            pStmt1.executeUpdate();

            ResultSet rs = pStmt1.getGeneratedKeys();
            rs.next();
            int orderId = rs.getInt(1);

            // ② 明細登録
            String sql2 = "INSERT INTO ORDER_ITEMS(ORDER_ID, PRODUCT_ID, QUANTITY) VALUES(?,?,?)";
            PreparedStatement pStmt2 = conn.prepareStatement(sql2);

            for (CartItem item : cart) {
                pStmt2.setInt(1, orderId);
                pStmt2.setInt(2, item.getProduct().getId());
                pStmt2.setInt(3, item.getQuantity());
                pStmt2.executeUpdate();
            }

            conn.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}