package com.niantic.controllers.apis;

import com.niantic.models.Product;
import com.niantic.models.HttpError;
import com.niantic.services.LoggingService;
import com.niantic.services.ProductDao;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductsController
{
    private ProductDao productDao;
    private LoggingService logger;

    @Autowired
    public ProductsController(ProductDao productDao, LoggingService logger)
    {
        this.productDao = productDao;
        this.logger = logger;
    }

    @GetMapping("")
    public ResponseEntity<?> getAllProducts()
    {
        try
        {
            var products = productDao.getProducts();

            return ResponseEntity.ok(products);
        }
        catch (Exception e)
        {
            logger.logMessage(e.getMessage());

            var error = new HttpError(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Oops, something went wrong!");

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }

    }

    @GetMapping("{categoryId}")
    public ResponseEntity<?> getProductByCategory(@PathVariable int categoryId)
    {
        try
        {
            var product = productDao.getProductByCategory(categoryId);

            if(product == null)
            {
                logger.logMessage("Category with id " + categoryId + " not found.");
                // 404 not found
                var error = new HttpError(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.toString(), "Category " + categoryId + " is invalid");

                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
            }

            return ResponseEntity.ok(product);
        }
        catch (Exception e)
        {
            logger.logMessage(e.getMessage());
            // 500 internal server error
            var error = new HttpError(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Oops, something went wrong!");

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }
    }

    @GetMapping("{productId}")
    public ResponseEntity<?> getProductById(@PathVariable int productId)
    {
        try
        {
            var product = productDao.getProductById(productId);

            if(product == null)
            {
                logger.logMessage("Category with id " + productId + " not found.");
                // 404 not found
                var error = new HttpError(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.toString(), "Product " + productId + " is invalid");

                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
            }

            return ResponseEntity.ok(product);
        }
        catch (Exception e)
        {
            logger.logMessage(e.getMessage());
            // 500 internal server error
            var error = new HttpError(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Oops, something went wrong!");

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> addProduct(@RequestBody Product product)
    {
        try
        {
            var newProduct = productDao.addProduct(product);

            return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
        }
        catch (Exception e)
        {
            logger.logMessage(e.getMessage());

            var error = new HttpError(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), "Oops, something went wrong!");

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> updateProduct(@PathVariable int id, @RequestBody Product product)
    {
        try {
            var existingProduct = productDao.getProductById(id);

            if (existingProduct == null) {
                logger.logMessage("Product with id " + id + " not found.");

                var error = new HttpError(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), "Product with id " + id + " not found.");

                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
            }

            productDao.updateProduct(id, product);

            return ResponseEntity.noContent().build();
        }
        catch (Exception e)
        {
            logger.logMessage(e.getMessage());

            var error = new HttpError(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), "Oops, something went wrong!");

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> deleteProduct(@PathVariable int id)
    {
        try
        {
            var existingProduct = productDao.getProductById(id);

            if(existingProduct == null)
            {
                logger.logMessage("Product with id " + id + " not found.");

                var error = new HttpError(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), "Product with id " + id + " not found.");

                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
            }

            productDao.deleteProduct(id);

            return ResponseEntity.noContent().build();
        }
        catch (Exception e)
        {
            logger.logMessage(e.getMessage());

            var error = new HttpError(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), "Oops, something went wrong!");

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }


    }
}
