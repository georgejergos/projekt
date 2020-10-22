package com.webbapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.webbapp.IProductCrud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private Connection con;
    @Autowired
    private IProductCrud crud;
    public List<Product> getAllProducts(){
        return crud.getAllProducts();
    }
    public Product getProductById(Integer id){
        return crud.getProductById(id);
    }
    public Product addProduct(Product product){
        return crud.addProduct(product);
    }
    public Product updateProduct(Product product){
        return crud.updateProduct(product);
    }

  /*  public ShoppingCart addToCart(Integer cartId){
        CartItem item= get(CartId);
        if(item==null){
            CartItem.add(new CartItem())
        }
    }*/
}
