-- 14. Top 5 ORDER totals: to get the order total you have to 
-- sum the LineTotal or each line item in the order
-- include the order_id and order_total
    -- you will need to perform some grouping
-- (Use the customer_orders View)

-- expected rows
-- QUICK-Stop,          10865,  Germany,    17250.00
-- Save-a-lot Markets,  11030,  USA,        16321.90
-- Hanari Carnes,       10981,  Brazil,     15810.00
-- Queen Cozinha,       10372,  Brazil,     12281.20
-- Mre Paillarde,       10424,  Canada,     11493.20


-- (5 rows)

SELECT company_name, 
	order_id,
	country, 
    SUM(sales_price * quantity) AS order_total
FROM customer_orders
GROUP BY company_name, order_id, country
ORDER BY SUM(sales_price * quantity) DESC
LIMIT 5;


