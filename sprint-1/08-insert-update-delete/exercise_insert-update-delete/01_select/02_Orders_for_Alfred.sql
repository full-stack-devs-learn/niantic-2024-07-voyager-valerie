USE northwind;

-- Use the CustomerOrders view that we created
-- return the: CompanyName, OrderDate, OrderId,
-- ProductName, SalesPrice, Quantity, Discount and LineTotal
-- for all orders placed by 'Alfreds Futterkiste'

-- Hint: LineTotal is a calculated field based on
-- the SalesPrice, Quantity and Discount of each line item

-- the LineTotal for 'Rössle Sauerkraut' ordered on 2022-08-25
-- should be 513 (not 684)

-- Expected: 12 Rows


SELECT company_name AS CompanyName,
	order_date AS OrderDate,
    order_id AS OrderID,
    product_name AS ProductName, 
    sales_price AS SalesPrice, 
    quantity AS Quantity,
    discount AS Discount,
    (sales_price * quantity * (1 - discount)) AS LineTotal
FROM customer_orders
WHERE customer_id = 'ALFKI';

