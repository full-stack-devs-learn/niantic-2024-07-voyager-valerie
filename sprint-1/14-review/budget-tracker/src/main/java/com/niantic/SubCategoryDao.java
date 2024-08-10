package com.niantic;

import com.niantic.models.Subcategory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import java.util.ArrayList;

public class SubCategoryDao
{
    JdbcTemplate jdbcTemplate;

    public ArrayList<Subcategory> getSubCategoriesByCategory(int categoryId)
    {
        ArrayList<Subcategory> subCategories = new ArrayList<>();
        Subcategory subcategory = new Subcategory();

        String sql = """
                SELECT sub_category_id
                    , category_id
                    , sub_category_name
                    , description
                FROM subcategories
                WHERE category_id = ?;
                """;

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, categoryId);

        while(row.next()) {
            int subCategoryId = row.getInt("sub_category_id");
            int categorysId = row.getInt("category_id");
            String subCategoryName = row.getString("sub_category_name");
            String description = row.getString("description");

            subcategory.setSubCategoryId(subCategoryId);
            subcategory.setCategoryId(categoryId);
            subcategory.setSubCategoryName(subCategoryName);
            subcategory.setSubCategoryDescription(description);

            subCategories.add(subcategory);
        }
        return subCategories;
    }

    public Subcategory getSubCategoryById(int subCategoryId)
    {
        String sql = """
                SELECT sub_category_id
                    , category_id
                    , sub_category_name
                    , description
                FROM subcategories
                WHERE sub_category_id = ?;
                """;
        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, subCategoryId);

        int subCategorysId = row.getInt("subCategoryId");
        int categoryId = row.getInt("category_id");
        String subcategoryName = row.getString("sub_category_name");
        String description = row.getString("description");

        var subcategory = new Subcategory();

        subcategory.setSubCategoryId(subCategorysId);
        subcategory.setCategoryId(categoryId);
        subcategory.setSubCategoryName(subcategoryName);
        subcategory.setSubCategoryDescription(description);

        return subcategory;
    }

    public Subcategory getSubCategoryByName(String name)
    {
        var subcategory = new Subcategory();

        String sql = """
                SELECT sub_category_id
                    , category_id
                    , sub_category_name
                    , description
                FROM subcategories
                WHERE sub_category_name = ?;
                """;

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, name);

        while(row.next())
        {
            int subCategoryId = row.getInt("sub_category_id");
            int categoryId = row.getInt("category_id");
            String subCategoryName = row.getString("sub_category_name");
            String description = row.getString("description");

            subcategory.setSubCategoryId(subCategoryId);
            subcategory.setCategoryId(categoryId);
            subcategory.setSubCategoryName(subCategoryName);
            subcategory.setSubCategoryDescription(description);
        }
        return subcategory;
    }

    public void addSubCategory(Subcategory subcategory)
    {
        String sql = """
                INSERT INTO subcategories(sub_category_id
                    , category_id
                    , sub_category_name
                    , description
                VALUES(?, ?, ?, ?)
                """;

        jdbcTemplate.update(sql,
                subcategory.getSubCategoryId(),
                subcategory.getCategoryId(),
                subcategory.getSubCategoryName());
                subcategory.getSubCategoryDescription();
    }

    public void updateSubCategory(Subcategory subcategory)
    {
        String sql = """
                UPDATE subcategories
                SET sub_category_id
                    , category_id
                    , sub_category_name
                    , description
                WHERE sub_category_id = ?;
                """;

        jdbcTemplate.update(sql,
                subcategory.getSubCategoryId(),
                subcategory.getCategoryId(),
                subcategory.getSubCategoryName());
        subcategory.getSubCategoryDescription();
    }

    public void deleteSubCategory(int subCategoryId)
    {
        String sql = """
                DELETE FROM subcategories
                WHERE sub_category_id = ?;
                """;

        jdbcTemplate.update(sql, subCategoryId);
    }

}
