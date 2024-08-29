-- 7. expensive products report

-- Display the most expensive product in each category

-- Columns to include:
-- Category Name
-- Product Name
-- Unit price

-- NOTE: you can combine INNER JOIN and sub queries in the
-- query if you would like

-- (8 rows - one per category)
-- Beverages        Cte de Blaye            263.5000
-- Condiments       Vegie-spread            43.9000
-- Confections      Sir Rodney's Marmalade  81.0000
-- Dairy Products   Raclette Courdavault    55.0000
-- Grains/Cereals   Gnocchi di nonna Alice  38.0000
-- Meat/Poultry     Thringer Rostbratwurst  123.7900
-- Produce          Manjimup Dried Apples   53.0000
-- Seafood          Carnarvon Tigers        62.5000


USE northwind;

-- cte
WITH max_prices AS (
		SELECT category_id,
			MAX(unit_price) AS max_price
		FROM products AS p
        GROUP BY category_id
	) 

SELECT c.category_name,
	p.product_name,
	p.unit_price
FROM products AS p
INNER JOIN categories AS c ON c.category_id = p.category_id
INNER JOIN max_prices AS m ON p.category_id = m.category_id
	AND p.unit_price = m.max_price
ORDER BY c.category_name, p.product_name;
