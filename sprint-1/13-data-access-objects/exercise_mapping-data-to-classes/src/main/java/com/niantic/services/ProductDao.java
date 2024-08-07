package com.niantic.services;

import com.niantic.models.Product;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;


// challenge
public class ProductDao
{
    private final JdbcTemplate jdbcTemplate;

    public ProductDao()
    {
        String databaseUrl = "jdbc:mysql://localhost:3306/northwind";
        String userName = "root";
        String password = "P@ssw0rd";
        DataSource dataSource = new BasicDataSource(){{
            setUrl(databaseUrl);
            setUsername(userName);
            setPassword(password);
        }};

        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /*
    Return a list of all Products with the specified categoryId
     */
    public ArrayList<Product> getProductsByCategory(int categoryId)
    {
        ArrayList<Product> productList = new ArrayList<>();      // holds all product info

        String sql = """
                SELECT product_id
                    , product_name
                    , unit_price
                FROM products
                WHERE category_id = ?;
        """;

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, categoryId);

        while(row.next())
        {
            int productId = row.getInt("product_id");
            String productName = row.getString("product_name");
            double productPrice = row.getDouble("unit_price");

            Product product = new Product();            // stores individual product info

            product.setProductId(productId);
            product.setProductName(productName);
            product.setUnitPrice(productPrice);

            productList.add(product);
        }
        return productList;
    }

    /*
    Find and return a Product by Id
     */
    public Product getProduct(int productId)
    {
        Product product = new Product();

        String sql = """
        SELECT product_id
            , product_name
            , quantity_per_unit
            , unit_price
            , units_in_stock
            , units_on_order
            , reorder_level
        FROM products
        WHERE product_id = ?;
    """;

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, productId);

        while(row.next()) {
            productId = row.getInt("product_id");
            String productName = row.getString("product_name");
            String quantityPerUnit = row.getString("quantity_per_unit");
            double productPrice = row.getDouble("unit_price");
            int inStock = row.getInt("units_in_stock");
            int onOrder = row.getInt("units_on_order");
            int reorderLevel = row.getInt("reorder_level");

            product.setProductId(productId);
            product.setProductName(productName);
            product.setQuantityPerUnit(quantityPerUnit);
            product.setUnitPrice(productPrice);
            product.setUnitsInStock(inStock);
            product.setUnitsOnOrder(onOrder);
            product.setReorderLevel(reorderLevel);
        }
        return product;
    }

    /*
    Add a new product
     */
    public void addProduct(Product product)
    {
    }

    /*
    Update product by Id
     */
    public void updateProduct(Product product)
    {
    }

    /*
    Delete a product by Id
     */
    public void deleteProduct(int id)
    {
    }

}
