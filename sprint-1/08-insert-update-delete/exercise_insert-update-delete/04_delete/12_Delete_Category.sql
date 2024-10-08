USE northwind;

-- Delete the Sporting Goods Category from the database.

-- Why does it fail to delete?
	-- It fails to delete because there are items in the Sporting Goods category

-- What else needs to be done to fully delete the Category?
	-- I'll need to delete everything that classifies as a Sporting Good before I can delete it

-- Write a script that preforms all necessary steps to 
-- delete the category from the database.

-- The only user input should be a variable at the top of the 
-- script that holds the Category Name.
-- The script should do the rest

-- where sporting goods are located, but all the products classified as "sporting goods" need to be
-- removed first
SELECT *
FROM categories
WHERE category_id=9;

SELECT * 
FROM products
WHERE category_id=9;

-- these lines delete the products in 'Sporting Goods' and then the category overall.
-- but i need to turn it into a script.
DELETE FROM products
WHERE category_id = 9;

DELETE FROM categories
WHERE category_id = 9;