package com.niantic.controllers;

import com.niantic.models.Category;
import com.niantic.services.CategoryDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

@Controller
public class CategoriesController
{
    CategoryDao categoryDao = new CategoryDao();

    //https://localhost:8080/categories
    @GetMapping("/categories")
    public String getAllCategories(Model model)
    {
        ArrayList<Category> categories = new ArrayList<>();

        StringBuilder builder = new StringBuilder();

        model.addAttribute("categories", categories);
        return "categories/index";
    }

    @GetMapping("/categories/{id}")
    public String getCategoryDetails(Model model, @PathVariable int id)
    {
        var category = categoryDao.getCategoryById(id);
        model.addAttribute("category", category);
        return "categories/details";
    }
}
