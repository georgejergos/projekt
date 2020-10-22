package com.webbapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
@Repository
@SessionScope

public class ShoppingCart {
private List<CartItem> cartItems=new ArrayList<>();

}