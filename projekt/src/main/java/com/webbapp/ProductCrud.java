package com.webbapp;

import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
@Repository
public class ProductCrud implements IProductCrud{
private Connection con;
    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        //
        try{
            con= DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/SASCruyfmG","SASCruyfmG","NrhSdPrNpJ");
            Statement statement = con.createStatement();
            //statement = con.createStatement();
            String selectAllProducts = "SELECT * FROM Product";
            ResultSet resultSet = statement.executeQuery(selectAllProducts);
            while (resultSet.next()) {
                Product product = new Product();
                product.setProductId(resultSet.getInt("ProductID"));
                product.setProductName(resultSet.getString("ProductName"));
                product.setProductPrice(resultSet.getDouble("ProductPrice"));
                product.setProductPicture(resultSet.getString("ProductPicture"));
                products.add(product);
            }
            resultSet.close();
            statement.close();
            con.close();
            return products;
        }
        catch(Exception ex) {
            Logger.getLogger(ProductCrud.class.getName()).log(Level.SEVERE,null, ex);
        }
        return null;
    }

    @Override
    public Product getProductById(Integer ProductId) {

        try{
            con= DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/SASCruyfmG","SASCruyfmG","NrhSdPrNpJ");
            String SelectProductById = "SELECT * FROM Product WHERE ProductId=?";
            PreparedStatement statement = con.prepareStatement(SelectProductById);
            statement.setInt(1,ProductId);

            ResultSet resultSet = statement.executeQuery();
            Product product = new Product();
            while (resultSet.next()) {

                product.setProductId(resultSet.getInt("ProductId"));
                product.setProductName(resultSet.getString("ProductName"));
                product.setProductPrice(resultSet.getDouble("ProductPrice"));
                product.setProductPicture(resultSet.getString("ProductPicture"));

            }
            resultSet.close();
            statement.close();
            con.close();
            return product;
        } catch(Exception ex) {
            Logger.getLogger(ProductCrud.class.getName()).log(Level.SEVERE,null, ex);
        }
        return null;
    }
    @Override
    public Product addProduct(Product product) {
        try{
            con= DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/SASCruyfmG","SASCruyfmG","NrhSdPrNpJ");
            String addProduct = "INSERT INTO Product (ProductId=?, ProductName=?, ProductPicture=?, ProductPrice=?) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = con.prepareStatement (addProduct);

            statement.setInt(1, product.getProductId());
            statement.setString(2, product.getProductName());
            statement.setString(3, product.getProductPicture());
            statement.setDouble(4, product.getProductPrice());

            statement.execute();

            statement.close();
            con.close();
            return product;
        } catch(SQLException ex) {
            Logger.getLogger(ProductCrud.class.getName()).log(Level.SEVERE,null, ex);
        }
        return null;
    }

    @Override
    public Product updateProduct(Product product) {
        try{
            con= DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/SASCruyfmG","SASCruyfmG","NrhSdPrNpJ");
            String UpdateProduct = "UPDATE Product SET ProductName=?, ProductPrice=?, ProductPicture=? WHERE ProductId=?";
            PreparedStatement statement = con.prepareStatement (UpdateProduct);
            statement.setString(1, product.getProductName());
            statement.setDouble(2, product.getProductPrice());
            statement.setString(3, product.getProductPicture());
            statement.setInt(4, product.getProductId());

            statement.executeUpdate();

            statement.close();
            con.close();
            return product;
        } catch(SQLException ex) {
            Logger.getLogger(ProductCrud.class.getName()).log(Level.SEVERE,null, ex);
            }
      return null;
    }//end
}
