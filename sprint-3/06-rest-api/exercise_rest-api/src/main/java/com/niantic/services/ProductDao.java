package com.niantic.services;

import com.niantic.models.Product;

import java.util.List;

public interface ProductDao
{
    List<Product> getProducts();

    Product getProductById(int id);

    Product addProduct(Product product);

    void updateProduct(int id, Product product);

    void deleteProduct(int id);
}
