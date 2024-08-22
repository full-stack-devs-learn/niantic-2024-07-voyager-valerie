package com.niantic.exercises;

import com.niantic.models.LineItem;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class Reducers
{

    /*
    1) using one or more Java Stream functions calculate the total sales amount
       for all line items in the given list.

       hint: use the getLineTotal() method to calculate the sales total

     */
    public double totalSales(List<LineItem> lineItems)
    {
        double initialValue = 0.0;

        double total = lineItems.stream()
                .map(LineItem::getLineTotal)
                .reduce(initialValue, (sum, lineTotal) -> sum + lineTotal);

        return total;
    }

    /*
    2) using one or more Java Stream functions calculate the average sales amount
       per line items in the given list.

     */
    public double averageSalesPerLineItem(List<LineItem> lineItems)
    {
        double sumOfSale = lineItems.stream()
                .map(LineItem::getLineTotal)
                .reduce(0.0, Double::sum);

        long count = lineItems.size();

        return sumOfSale / count;
    }

    /*
    3) using one or more Java Stream functions calculate the average sales amount
       per items in the given list.

       hint: unlike problem number 2, we are not looking for the average of line totals
       we are looking for the average of each item (line items can have multiple quantities
       of a single item)

     */
    public double averageSalesPerItem(List<LineItem> lineItems)
    {
        return 0;
    }

    /*
    4) using one or more Java Stream functions calculate the total number
       of items that were purchased.

       hint: line items can have multiple quantities of an item

     */
    public int totalItemCount(List<LineItem> lineItems)
    {
        return 0;
    }

    /*
    5) using one or more Java Stream functions calculate the average number
       of items that were purchased per line item.

     */
    public double averageItemCount(List<LineItem> lineItems)
    {
        return 0;
    }

    /*
    6) using one or more Java Stream functions find the most expensive line item.

     */
    public double maxLineItem(List<LineItem> lineItems)
    {
        Optional<LineItem> maxLineItem = lineItems.stream()
                .max((item1, item2) -> Double.compare(item1.getLineTotal(), item2.getLineTotal()));

        return maxLineItem.map(LineItem::getLineTotal).orElseThrow(() -> new NoSuchElementException("No line items present"));
    }

    /*
    7) using one or more Java Stream functions find the least expensive line item.

        hint: the least expensive line item is not $0.00

     */
    public double minLineItem(List<LineItem> lineItems)
    {
        // Find the line item with the minimum line total
        Optional<LineItem> minLineItem = lineItems.stream()
                .min((item1, item2) -> Double.compare(item1.getLineTotal(), item2.getLineTotal()));

        // Return the minimum line total, or throw an exception if no line items exist
        return minLineItem.map(LineItem::getLineTotal).orElseThrow(() -> new NoSuchElementException("No line items present"));
    }

}
