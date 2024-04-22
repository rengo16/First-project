package com.mycompany.ecommercesystem;

class Cart {

    private int customerId;
    private int nProducts;
    private Product[] products;

    public Cart(int customerId, int nProducts) {
        this.customerId = Math.abs(customerId);
        this.nProducts = Math.abs(nProducts);
        products = new Product[nProducts];
    }

    public void setCustomerId(int customerId) {
        this.customerId = Math.abs(customerId);
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setnProducts(int nProducts) {
        this.nProducts = Math.abs(nProducts);
    }

    public int getnProducts() {
        return nProducts;
    }

    public void addProduct(Product product) {

        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = product;
                break;
            }
        }
    }

    public void removeProduct(Product product) {

        for (int i = 0; i < products.length; i++) {
            if (products[i] == product) {
                products[i] = null;
                this.nProducts--;
                break;
            }
        }
    }

    public float calculatePrice() {
        float totalPrice = 0;
        for (int i = 0; i < products.length; i++) {

            totalPrice = totalPrice + products[i].getPrice();

        }
        return totalPrice;
    }

    public Order placeOrder() {
        Order order = new Order(customerId, 1, products, calculatePrice());
        nProducts = 0;
        products = new Product[nProducts];
        return order;
    }
}
