package com.niantic;

public class Category
{
    private String categoryName;
    private String categoryDescription;

    public Category(String categoryName, String categoryDescription)
    {
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
    }

    public Category()
    {
    }

    public String getCategoryName(){return categoryName;}

    public void setCategoryName() {this.categoryName = categoryName;}

    public String getCategoryDescription(){return categoryDescription;}

    public void setCategoryDescription(){this.categoryDescription = categoryDescription;}


}
