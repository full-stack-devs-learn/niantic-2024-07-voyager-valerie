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

DELETE FROM categories
WHERE category_id = 11;