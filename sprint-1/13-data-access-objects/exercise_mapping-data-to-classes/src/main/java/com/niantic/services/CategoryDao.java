package com.niantic.services;

import com.niantic.models.Category;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;

public class CategoryDao
{
    private final JdbcTemplate jdbcTemplate;

    public CategoryDao()
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

    // Template
    public ArrayList<Category> getCategories()
    {
        // create the empty ArrayList
        ArrayList<Category> categories = new ArrayList<>();

        // 1. build your query
        String sql = """
        SELECT category_id, category_name, description
        FROM categories
        """;

        // 2. execute the query
        SqlRowSet row = jdbcTemplate.queryForRowSet(sql);

        // 3. loop through the results (rows)
        //    create a category from each row and add it to the array list
        while(row.next())
        {
            int categoryId = row.getInt("category_id");
            String categoryName = row.getString("category_name");
            String description = row.getString("description");

            Category category = new Category(categoryId, categoryName, description);

            categories.add(category);
        }

        // return the ArrayList
        return categories;
    }

    /*
    Write a query to get a category by id.

    Execute the query, then return a Category object from the results
     */
    public Category getCategoryById(int userId)
    {
        Category category = new Category();

        String sql = """
                SELECT category_id
                    , category_name
                    , description
                FROM categories
                WHERE category_id = ?;
        """;

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, userId);

        while(row.next())
        {
            int categoryById = row.getInt("category_id");
            String categoryName = row.getString("category_name");
            String description = row.getString("description");

            category.setCategoryId(categoryById);
            category.setCategoryName(categoryName);
            category.setDescription(description);
        }
        return category;
    }

    /*
    Write an INSERT statement
    and insert a new category into the northwind database
    with the values that are provided by the user
     */
    public void addCategory(Category category)
    {
        String sql = """
                INSERT INTO categories(category_id, category_name, description)
                VALUES(?, ?, ?);
        """;

        jdbcTemplate.update(sql,
                category.getCategoryId(),
                category.getCategoryName(),
                category.getDescription());


    }

    /*
    Write an UPDATE statement -
    modify all values (except the category_id)
    for the specified category
     */
    public void updateCategory(Category category)
    {
        String sql = """
                UPDATE categories
                SET category_name = ?, description = ?
                WHERE category_id = ?;
                """;

        jdbcTemplate.update(sql,
                category.getCategoryName(),
                category.getDescription(),
                category.getCategoryId());
    }

    /*
    Write the code to DELETE the category
    with the specified ID
     */
    public void deleteCategory(int categoryId)
    {
        Category category = new Category();

        String sql = """
                DELETE FROM categories
                WHERE category_id = ?;
                """;
        jdbcTemplate.update(sql, category.getCategoryId());
    }


}
