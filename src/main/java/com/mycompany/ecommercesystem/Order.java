package com.mycompany.ecommercesystem;

public class Order {

    private int customerId;
    private int orderId;
    private Product[] products;
    private float totalPrice;

    public Order(int customerId, int orderId, Product[] products, float totalPrice) {
        this.customerId = Math.abs(customerId);
        this.orderId = Math.abs(orderId);
        this.products = products;
        this.totalPrice = Math.abs(totalPrice);
    }

    public void printOrderInfo() {System.out.println("Here's you order's summary: ");
    System.out.println("Order ID: " + orderId);
    
        
        System.out.println("Customer ID: " + customerId);
        
        System.out.println("Products:");
        for (Product product : products) {
            System.out.println(product.getName() + " - $" + product.getPrice());
        }
        System.out.println("Total Price: $" + totalPrice);
    }
}
