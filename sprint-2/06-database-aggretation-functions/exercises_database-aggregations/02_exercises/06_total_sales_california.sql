-- 6. The sum of all sales in California
-- sales_price * quantity -- don't worry about discount
-- (Use the customer_orders view)

-- (1 row) - $3490.02

SELECT SUM(sales_price * quantity)
FROM customer_orders
WHERE region = 'CA';


