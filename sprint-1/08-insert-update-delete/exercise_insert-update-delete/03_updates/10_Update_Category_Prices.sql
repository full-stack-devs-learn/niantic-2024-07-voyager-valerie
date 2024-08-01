USE northwind;

-- Write a script that updates the price of all products 
-- within a category by a certain percent.
-- use variables to accept the Category name and the percent increase 



SET @CategoryID = 7
	, @PercentIncrease = 10
    , @NewRate = 1 + (@PercentIncrease / 100.0);

UPDATE products
SET unit_price = unit_price * @NewRate
WHERE category_id = @CategoryID;


SELECT *
FROM products
WHERE category_id = @CategoryID;