package model;

public class OrderItem {
    private int productId;
    private int quantity;
    private String name;

    public OrderItem(int productId, int quantity, String name) {
        this.productId = productId;
        this.quantity = quantity;
        this.name = name;
    }

    public int getProductId() { return productId; }
    public int getQuantity() { return quantity; }
    public String getName() { return name; }
}