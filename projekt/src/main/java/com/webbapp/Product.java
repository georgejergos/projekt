package com.webbapp;

public class Product {

    private int ProductId;
    private String ProductName;
    private double ProductPrice;
    private String ProductPicture;

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int productId) {
        ProductId = productId;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public double getProductPrice() {
        return ProductPrice;
    }

    public void setProductPrice(double productPrice) {
        ProductPrice = productPrice;
    }

    public String getProductPicture() {
        return ProductPicture;
    }

    public void setProductPicture(String productPicture) {
        ProductPicture = productPicture;
    }
}
