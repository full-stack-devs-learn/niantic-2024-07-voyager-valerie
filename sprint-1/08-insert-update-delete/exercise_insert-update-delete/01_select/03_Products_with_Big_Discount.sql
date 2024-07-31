USE northwind;

-- Use the customer_orders view that we created
-- return the: CompanyName, OrderDate, OrderId,
-- ProductName, SalesPrice, Quantity, Discount,
-- SubTotal, LineDiscount and LineTotal
-- for all orders where the line discount is

-- for all order line items with a LineDiscount that is more than $1000

-- sort the rows by discount highest to lowest


-- Expected: 8 Rows


SELECT company_name AS CompanyName, 
	order_date AS OrderDate,
    order_id AS OrderID,
    product_name AS ProductName,
    sales_price AS SalesPrice,
    quantity AS Quantity,
    discount AS Discount,
    sales_price * quantity AS Subtotal,
    sales_price * quantity * discount AS LineDiscount,
    (sales_price * quantity) - (sales_price * quantity * discount) AS LineTotal 
FROM customer_orders
WHERE sales_price * quantity * discount > 1000
ORDER BY Discount DESC;
