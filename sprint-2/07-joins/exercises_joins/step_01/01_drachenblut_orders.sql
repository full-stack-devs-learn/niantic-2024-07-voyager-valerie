-- 1. The Company Name, Order Id, Order Date and Shipped Date
-- for all orders that were placed by Drachenblut Delikatessen. 
-- Order the results by shipped date, newest to oldest.
-- (6 rows)

USE northwind;

SELECT company_name,
	order_id,
    order_date,
    shipped_date
FROM customers AS c
INNER JOIN orders AS o
	ON c.customer_id = o.customer_id
WHERE company_name = 'Drachenblut Delikatessen'
ORDER BY shipped_date DESC;