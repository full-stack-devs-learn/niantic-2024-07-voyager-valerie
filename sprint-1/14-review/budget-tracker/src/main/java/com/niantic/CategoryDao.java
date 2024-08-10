package com.niantic;

import com.niantic.models.Category;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import java.util.ArrayList;

public class CategoryDao
{
    JdbcTemplate jdbcTemplate;

    public ArrayList<Category> getAllCategories()
    {
        ArrayList<Category> categories = new ArrayList<>();
        String sql = """
                SELECT category_id
                    , category_name
                    , description
                FROM categories;
                """;

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql);

        while (row.next())
        {
            int categoryId = row.getInt("category_id");
            String categoryName = row.getString("category_name");
            String description = row.getString("description");

            var category = new Category(categoryId, categoryName, description);

            categories.add(category);
        }
        return categories;
    }

    public Category getCategoryById(int categoryId)
    {
        var category = new Category();

        String sql = """
                SELECT category_id
                    , category_name
                    , description
                FROM categories
                WHERE category_id = ?;
                """;

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, categoryId);

        int categorysId = row.getInt("category_id");
        String categoryName = row.getString("category_name");
        String description = row.getString("description");

        category.setCategoryId(categorysId);
        category.setCategoryName(categoryName);
        category.setCategoryDescription(description);

        return category;
    }

    public Category getCategoryByName(String name)
    {
        var category = new Category();

        String sql = """
                SELECT category_id
                    , category_name
                    , description
                FROM categories
                WHERE category_name = ?;
                """;

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, name);

        int categorysId = row.getInt("category_id");
        String categoryName = row.getString("category_name");
        String description = row.getString("description");

        category.setCategoryId(categorysId);
        category.setCategoryName(categoryName);
        category.setCategoryDescription(description);

        return category;
    }

    public void addCategory(Category category)
    {
        String sql = """
                INSERT INTO categories(category_id
                    , category_name
                    , description)
                VALUES(?, ?, ?);
                """;

        jdbcTemplate.update(sql,
                category.getCategoryId(),
                category.getCategoryName(),
                category.getCategoryDescription());
    }

    public void updateCategory(Category category)
    {
        String sql = """
                UPDATE categories
                SET category_name = ?,
                    description = ?
                WHERE category_id = ?;
                """;

        jdbcTemplate.update(sql,
                category.getCategoryName(),
                category.getCategoryDescription(),
                category.getCategoryId());
    }

    public void deleteCategory(int categoryId)
    {
        String sql = """
                DELETE FROM categories
                WHERE category_id = ?;
                """;
        
        jdbcTemplate.update(sql, categoryId);
    }
}
