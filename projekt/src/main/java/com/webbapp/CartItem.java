package com.webbapp;

public class CartItem {
    private Product product;
    private int quantity;
    private double pay;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPay() {
        this.pay=product.getProductPrice()*getQuantity();
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }
    public CartItem(Product product) {
        this.product=product;
        this.quantity=1;
    }
    public CartItem(Product product, int quantity) {
        this.product=product;
        this.quantity=quantity;
    }
}
