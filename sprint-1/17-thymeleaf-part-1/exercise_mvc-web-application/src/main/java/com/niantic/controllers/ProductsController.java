package com.niantic.controllers;

import com.niantic.models.Product;
import com.niantic.services.ProductDao;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

public class ProductsController
{
    private ProductDao productDao = new ProductDao();

/*    @GetMapping("/products")
    public String getAllProducts(Model model, @RequestParam(required = false) String last)
    {
        ArrayList<Product> products;

        if(last == null)
        {
            products = productDao.getAllProducts();
        }
    }*/
}
