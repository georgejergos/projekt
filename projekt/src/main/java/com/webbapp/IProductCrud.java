package com.webbapp;

import java.util.List;

public interface IProductCrud {
    public List<Product> getAllProducts();
    public Product getProductById(Integer id);
    public Product addProduct(Product product);
    public Product updateProduct(Product product);

    //public CartItem addToCart(CartItem cartItem);
    //public CartItem removeFromCart(CartItem cartItem);
    //public CartItem getCartItemBy(CartItem cartItem);
}
