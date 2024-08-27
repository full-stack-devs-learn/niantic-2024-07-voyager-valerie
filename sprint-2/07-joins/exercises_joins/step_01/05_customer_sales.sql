-- 5. The order details table includes the line item for each sale.
-- the Line Total is the SalesPrice * Quantity - Discount%.

-- I want a customer sales report
-- include customer names (company_name), and their total sales amount (after discount)
-- sorted by sales total highest to lowest

-- The first 3 rows should be
-- CompanyName			SalesTotal
-- QUICK-Stop			110277.31
-- Ernst Handel			104874.98
-- Save-a-lot Markets	104361.95

-- (89 rows)

USE northwind;

SELECT company_name,
	SUM((1 - discount) * (od.unit_price * quantity)) AS total_sales_amount
FROM products AS p
INNER JOIN order_details AS od
	ON p.product_id = od.product_id
INNER JOIN orders AS o
	ON od.order_id = o.order_id
INNER JOIN customers AS c
	ON o.customer_id = c.customer_id
GROUP BY company_name
ORDER BY total_sales_amount DESC;