package com.niantic.exercises;

import com.niantic.models.OrderLineItem;

import javax.swing.plaf.BorderUIResource;
import java.util.ArrayList;


/*
The exercises in this class are optional - this is the challenge exercise
 */
public class Order
{
    // this ArrayList is the container (shopping cart) for all items that are being ordered
    private ArrayList<OrderLineItem> shoppingCart = new ArrayList<>();

    public ArrayList<OrderLineItem> getShoppingCart()
    {
        return shoppingCart;
    }

    /*
    1. Add logic to allow a user to add an Item to a shopping cart
        - if the item already exists in the cart, update the quantity
        - search for a line item by name, and add the new quantity to the original quantity
     */
    public void addItem(OrderLineItem newItem)
    {
        OrderLineItem currentItem = null;

        for(OrderLineItem item : shoppingCart)
        {
            // if the item is already in the cart
            if (item.getProduct().equals(newItem.getProduct()))
            {
                // find the quantity already in cart and add the additional amount
                currentItem = item;
                int newQuantity = item.getQuantity() + newItem.getQuantity();    // increment quantity, if item already in shopping cart
                item.setQuantity(newQuantity);                                   // update the quantity
                continue;
            }
        }
        // if the item doesn't already exist in the cart, add it to the shopping cart
        shoppingCart.add(newItem);
    }

    /*
    2. Add logic to allow a user to add an Item to a shopping cart
        - search for a line item by name, and remove it from the list
     */
    public void removeItem(OrderLineItem removeItem)
    {
        shoppingCart.removeIf(item -> item.equals(removeItem));
    }

    /*
    3. Search for the highest priced item in the shopping cart and return the
        line item that contains that item.

        If the shopping cart is empty return null
     */
    public OrderLineItem findHighestPriceProduct()
    {
        if (shoppingCart.isEmpty())
        {
            return null;
        }

        double highestPriceSoFar = 0.0;                 // holds the highest price
        OrderLineItem productWithHighestPrice = null;   // holds the name of the product w/ highest price

        for (OrderLineItem item : shoppingCart)
        {
            double currentItem = item.getPrice();       // price of the product we're looking at rn
            if (currentItem > highestPriceSoFar)
            {
                highestPriceSoFar = currentItem;         // highest price encountered SO FAR
                productWithHighestPrice = item;
            }
        }
        return productWithHighestPrice;            // output the price of the most expensive product
    }

    /*
    4. Search for the most expensive line item in the shopping cart
        and return it

        If the shopping cart is empty return null
     */
    public OrderLineItem findMostExpensiveLineItem()
    {
        if (shoppingCart.isEmpty())
        {
            return null;
        }

        double mostExpensiveLinePrice = 0;
        OrderLineItem mostExpensiveLineItem = null;

        for (OrderLineItem item : shoppingCart)
        {
            double currentItemPrice = item.getPrice();
            int currentQuantity = item.getQuantity();

            // line item means quantity * price, not just the most expensive product
            double currentLinePrice = currentItemPrice * currentQuantity;

            if (currentLinePrice > mostExpensiveLinePrice)
            {
                mostExpensiveLinePrice = currentLinePrice;      // cost of most expensive item
                mostExpensiveLineItem = item;                       // name of most expensive item
            }
        }

        return mostExpensiveLineItem;           // output the name of the most expensive item
    }

    /*
    5. Calculate and return the order total
     */
    public double getOrderTotal()
    {
        // displays the cost of all the items in a shopping cart upon checkout
        double sumOfOrder = 0;

        for (OrderLineItem item : shoppingCart)
        {
            int itemsInCart = item.getQuantity();    // how many items are in the cart?
            double itemPrice = item.getPrice();      // how much do the products cost?

            double itemCost = itemsInCart * itemPrice;      // cost of each item type

            sumOfOrder += itemCost;
        }

        return sumOfOrder;
    }

    /*
    6. Return the total number of items in the cart
     */
    public int getTotalItemCount()
    {
        int itemCount = 0;

        for (OrderLineItem item : shoppingCart)
        {
            itemCount += item.getQuantity();
        }

        return itemCount;
    }

    /*
    7. Calculate the average price for all items in the shopping cart
     */
    public double getAveragePricePerItem()
    {
        int totalItemsInCart = 0;       // holds all the items in cart
        double totalPriceOfItems = 0;   // holds cost of all items in cart

        for (OrderLineItem item : shoppingCart)
        {
            double priceOfItem = item.getPrice();
            int quantityOfItem = item.getQuantity();

            double lineItemPrice = priceOfItem * quantityOfItem;   // cost of line item

            totalPriceOfItems += lineItemPrice;    // adds the price of all the items we've looked thru so far
            totalItemsInCart += quantityOfItem;    // holds the # of the current item, adding to total items in cart

        }    // at the end of the loop, we should have the total cost and items, so we can avg!
        return totalPriceOfItems / totalItemsInCart;
    }
}
