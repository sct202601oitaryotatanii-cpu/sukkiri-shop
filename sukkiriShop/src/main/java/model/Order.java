package model;

import java.util.List;

public class Order {
    private int id;
    private String userId;
    private int total;
    private List<OrderItem> items;

    public Order(int id, String userId, int total) {
        this.id = id;
        this.userId = userId;
        this.total = total;
    }

    public int getId() { return id; }
    public String getUserId() { return userId; }
    public int getTotal() { return total; }

    public List<OrderItem> getItems() { return items; }
    public void setItems(List<OrderItem> items) {
        this.items = items;
    }
}