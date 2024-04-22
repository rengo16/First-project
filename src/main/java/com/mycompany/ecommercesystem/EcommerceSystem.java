package com.mycompany.ecommercesystem;

import java.util.Scanner;

public class EcommerceSystem {

    public static void main(String[] args) {
        Scanner cs = new Scanner(System.in);
        ElectronicProduct ep = new ElectronicProduct(1, "Smartphone", 599.9f, "Samsung", 1);
        ClothingProduct cp = new ClothingProduct(2, "T-shirt", 19.99f, "Medium", "Cotton");
        BookProduct bp = new BookProduct(3, "OOP", 39.99f, "O'Reilly", "X Publications");
        System.out.println("Welcome to the E-Commerce System!");
        System.out.println("Please enter your id ");
        int customerId = cs.nextInt();
        System.out.println("Please enter your name ");
        String name = cs.next();
        System.out.println("Please enter your address ");
        String address = cs.next();
        System.out.println("How many products do you want to add to your cart?");
        int nProducts = cs.nextInt();
        Cart cart = new Cart(customerId, nProducts);
        for (int i = 0; i < nProducts; i++) {
            System.out.println("Which product would you like to add? 1- Smartphone 2- T-shirt 3- OOP");
            int choice = cs.nextInt();
            switch (choice) {
                case 1:
                    cart.addProduct(ep);
                    break;
                case 2:
                    cart.addProduct(cp);
                    break;
                case 3:
                    cart.addProduct(bp);
                    break;
                default:
                    System.out.println("Invalid choice, try again");
                    i--;
            }
        }
        double totalPrice = cart.calculatePrice();
        System.out.println("Your total is $" + totalPrice + ". Would you like to place the order? 1- Yes 2- No");
        int decision = cs.nextInt();
        if (decision == 1) {
            Order order = cart.placeOrder();
            order.printOrderInfo();
        } else {
            System.out.println("Order has been cancelled");
        }
    }
}
