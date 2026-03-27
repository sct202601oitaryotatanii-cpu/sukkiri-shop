package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Order;
import model.OrderItem;

public class OrderHistoryDAO {

    private final String JDBC_URL =
        "jdbc:h2:tcp://localhost/~/sukkiriShop";
    private final String DB_USER = "sa";
    private final String DB_PASS = "";

    public List<Order> findByUserId(String userId) {
        List<Order> orderList = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(
                JDBC_URL, DB_USER, DB_PASS)) {

            // 注文取得
            String sql1 = "SELECT * FROM ORDERS WHERE USER_ID = ?";
            PreparedStatement pStmt1 = conn.prepareStatement(sql1);
            pStmt1.setString(1, userId);

            ResultSet rs1 = pStmt1.executeQuery();

            while (rs1.next()) {
                Order order = new Order(
                    rs1.getInt("ID"),
                    rs1.getString("USER_ID"),
                    rs1.getInt("TOTAL")
                );

                // 明細取得
                String sql2 = "SELECT OI.PRODUCT_ID, OI.QUANTITY, P.NAME " +
                              "FROM ORDER_ITEMS OI " +
                              "JOIN PRODUCTS P ON OI.PRODUCT_ID = P.ID " +
                              "WHERE OI.ORDER_ID = ?";
                PreparedStatement pStmt2 = conn.prepareStatement(sql2);
                pStmt2.setInt(1, order.getId());

                ResultSet rs2 = pStmt2.executeQuery();

                List<OrderItem> items = new ArrayList<>();

                while (rs2.next()) {
                    items.add(new OrderItem(
                        rs2.getInt("PRODUCT_ID"),
                        rs2.getInt("QUANTITY"),
                        rs2.getString("NAME")
                    ));
                }

                order.setItems(items);
                orderList.add(order);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderList;
    }
}