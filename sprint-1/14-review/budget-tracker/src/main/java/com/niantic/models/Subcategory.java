package com.niantic.models;

public class Subcategory
{
    private int subCategoryId;
    private int categoryId;
    private String subCategoryName;
    private String subCategoryDescription;

    public Subcategory(int subCategoryId, int categoryId, String subCategoryName, String subCategoryDescription)
    {
        this.subCategoryId = subCategoryId;
        this.categoryId = categoryId;
        this.subCategoryName = subCategoryName;
        this.subCategoryDescription = subCategoryDescription;
    }

    public Subcategory()
    {
    }

    public int  getSubCategoryId() {return subCategoryId;}

    public void setSubCategoryId(int subCategoryId) {this.subCategoryId = subCategoryId;}

    public String getSubCategoryName() {return subCategoryName;}

    public int getCategoryId() {return categoryId;}

    public void setCategoryId(int categoryId) {this.categoryId = categoryId;}

    public void setSubCategoryName(String subCategoryName) {this.subCategoryName = subCategoryName;}

    public String getSubCategoryDescription() {return subCategoryDescription;}

    public void setSubCategoryDescription(String subCategoryDescription) {this.subCategoryDescription = subCategoryDescription;}
}
