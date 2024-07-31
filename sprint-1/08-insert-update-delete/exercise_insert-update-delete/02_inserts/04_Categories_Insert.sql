USE northwind;

-- Insert a new category into the Categories table
-- category name: Sporting Goods
-- description: All products that relate to recreational activities.
--              This includes equipment needed for team sports as well
--              as outdoor activities such as camping or river rafting.


SELECT *
FROM categories;


-- note: i was testing if sporting goods were auto incrementing properly, 
-- and i ended up creating duplicates, so the indexes are a little off


INSERT INTO categories(category_name, description)

VALUES 
(
	'Sporting Goods', 
    'All products that relate to recreational activities.
     This includes equipment needed for team sports as well
     as outdoor activities such as camping or river rafting.'
);