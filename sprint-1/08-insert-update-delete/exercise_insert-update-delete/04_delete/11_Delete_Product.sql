USE northwind;

-- delete one of your new sporting goods products
-- from the database
-- choose one that has not been purchased 

SELECT *
FROM products
WHERE category_id = 11;

WITH MinOrderCTE AS (
	SELECT MIN(units_on_order) AS MinOrder
    FROM products
    WHERE category_id = 11
),

DeleteCTE AS (
	SELECT product_id
    FROM products
    WHERE category_id = 11 
		AND units_on_order = (SELECT MinOrder FROM MinOrderCTE)
)

DELETE FROM products
WHERE product_id IN (SELECT product_id FROM DeleteCTE);