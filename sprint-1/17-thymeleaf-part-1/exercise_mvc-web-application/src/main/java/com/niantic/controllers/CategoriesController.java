package com.niantic.controllers;

import com.niantic.models.Category;
import com.niantic.services.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

@Controller
public class CategoriesController
{
    private CategoryDao categoryDao = new CategoryDao();

    //http://localhost:8080/categories
    @GetMapping("/categories")
    public String getAllCategories(Model model, String last)
    {
        ArrayList<Category> categories;

        if(last == null)
        {
            categories = categoryDao.getCategories();
        }
        else
        {
            categories = categoryDao.getCategoryByName(last);
        }

        model.addAttribute("categories", categories);
        return "categories/index";
    }

    @GetMapping("/categories/{id}")
    public String details(Model model, @PathVariable int id)
    {
        var category = categoryDao.getCategoryById(id);
        model.addAttribute("category", category);
        return "categories/details";
    }
}
