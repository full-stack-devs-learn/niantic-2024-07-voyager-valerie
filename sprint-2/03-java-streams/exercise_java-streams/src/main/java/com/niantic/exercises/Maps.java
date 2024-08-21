package com.niantic.exercises;

import com.niantic.models.LineItem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Maps
{

    /*
    1) using a chain of Java Stream functions, convert the list of line items to
       a list of company names.

       The list should not have any duplicate values                                .distinct
       and the list should be sorted alphabetically (A-Z) by company name           .sorted()   leave as is, because by default it's A-Z

     */
    public List<String> mapCompanyNames(List<LineItem> lineItems)
    {
        var companyNames = lineItems.stream()
                            .map(lineItem -> lineItem.getCompanyName())
                            .distinct()
                            .sorted()
                            .toList();

        return companyNames;
    }

    /*
    2) using a chain of Java Stream functions, convert the list of line items to
       a list of category names.

       The list should not have any duplicate values                            .distinct
       and the list should be sorted alphabetically (A-Z) by category name      .sorted()

     */
    public List<String> mapCategories(List<LineItem> lineItems)
    {
        var categories = lineItems.stream()
                            .map(lineItem -> lineItem.getCategoryName())
                            .distinct()
                            .sorted()
                            .toList();

        return categories;
    }

    /*
    3) using a chain of Java Stream functions, convert the list of line items to
       a list of product names.

       The list should not have any duplicate values
       and the list should be sorted alphabetically (A-Z) by product name

     */
    public List<String> mapProducts(List<LineItem> lineItems)
    {
        var products = lineItems.stream()
                        .map(lineItem -> lineItem.getProductName())
                        .distinct()
                        .sorted()
                        .toList();

        return products;

    }

    /*
    4) using a chain of Java Stream functions, convert the list of line items to
       a list of order year.

       The list should not have any duplicate values                .distinct()
       and the list should be sorted numerically (0-9) by year      .sorted()

     */
    public List<String> mapYears(List<LineItem> lineItems)
    {
        List<String> years = lineItems.stream()
                                .map(lineItem -> lineItem.getOrderDate().getYear())
                                .distinct()
                                .sorted()
                                .map(String::valueOf)       // convert to string
                                .collect(Collectors.toList());

        return years;
    }

    /*
    5) using a chain of Java Stream functions, convert the list of line items to
       a list of order id.

       The list should not have any duplicate values
       and the list should be sorted numerically (0-9) by order id

     */
    public List<String> mapOrderIds(List<LineItem> lineItems)
    {
        List<String> orderId = lineItems.stream()
                                .map(lineItem -> lineItem.getOrderId())
                                .distinct()
                                .sorted()
                                .map(String::valueOf)
                                .collect(Collectors.toList());

        return orderId;
    }
}
