package com.niantic.exercises;

import com.niantic.models.LineItem;
import com.niantic.services.FileLoader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.util.stream.Collectors;

public class Filters
{

    /*
    1) using Java Stream functions, filter the *lineItems* list to include only line items for the given company name

    hint: the company name should not be required to be the full name, but could be a partial name
     */
    public List<LineItem> filterByCompanyName(List<LineItem> lineItems, String companyName)
    {
        String lowerCaseCompanyName = companyName.toLowerCase();

        var companyLineItems = lineItems.stream()
                                .filter(lineItem -> lineItem.getCompanyName()
                                .toLowerCase().contains(lowerCaseCompanyName));

        return companyLineItems.toList();
    }

    /*
    2) using Java Stream functions, filter the *lineItems* list to include only line items for the given category name

    hint: the user may search by only a partial category name
     */
    public List<LineItem> filterByCategory(List<LineItem> lineItems, String categoryName)
    {
        String lowerCaseCategoryNames = categoryName.toLowerCase();

        var categoryLineItems = lineItems.stream()
                        .filter(lineItem -> lineItem.getCategoryName()
                        .toLowerCase().contains(lowerCaseCategoryNames))
                        .toList();

        return categoryLineItems;
    }

    /*
    3) using Java Stream functions, filter the *lineItems* list to include only line items for the given product name

    hint: the user may search by only a partial product name
     */
    public List<LineItem> filterByProduct(List<LineItem> lineItems, String productName)
    {
        String lowerCaseProductName = productName.toLowerCase();

        var productLineItems = lineItems.stream()
                .filter(lineItem -> lineItem.getProductName()
                        .toLowerCase().contains(lowerCaseProductName))
                        .toList();

        return productLineItems;
    }

    /*
    4) using Java Stream functions, filter the *lineItems* list to include only line items for the given order year

     */
    public List<LineItem> filterByYear(List<LineItem> lineItems, int year)
    {
        var yearLineItems = lineItems.stream()
                .filter(lineItem -> {
                    int years = lineItem.getOrderDate().getYear();
                    return years == year;
                })
                .collect(Collectors.toList());

        return yearLineItems;
    }


    /*
    5) using Java Stream functions, filter the *lineItems* list to include only line items for the given order id

     */
    public List<LineItem> filterByOrderId(List<LineItem> lineItems, int orderId)
    {
        var orderIdLineItems = lineItems.stream()
                .filter(lineItem -> {
                    int id = lineItem.getOrderId();
                    return id == orderId;
                })
                .collect(Collectors.toList());

        return orderIdLineItems;
    }
}
