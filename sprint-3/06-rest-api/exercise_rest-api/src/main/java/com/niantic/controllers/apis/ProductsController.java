package com.niantic.controllers.apis;

import com.niantic.models.Product;
import com.niantic.services.MySqlProductDao;
import com.niantic.services.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductsController
{
    private ProductDao productDao = new MySqlProductDao();

    @GetMapping("/api/products")
    public List<Product> getAllProducts()
    {
        return productDao.getProducts();
    }

    @GetMapping("/api/products/{categoryId}")
    public Product getProductByCategory(@PathVariable int categoryId)
    {
        return productDao.getProductByCategory(categoryId);
    }

    @GetMapping("/api/products/{productId}")
    public Product getProductById(@PathVariable int productId)
    {
        return productDao.getProductById(productId);
    }

    @PostMapping("/api/products")
    @ResponseStatus(HttpStatus.CREATED)
    public Product addProduct(@RequestBody Product product)
    {
        return productDao.addProduct(product);
    }

    @PutMapping("/api/products/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateProduct(@PathVariable int id, @RequestBody Product product)
    {
        productDao.updateProduct(id, product);
    }

    @DeleteMapping("/api/products/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable int id)
    {
        productDao.deleteProduct(id);
    }
}
