USE northwind;

-- Insert 10 new products into the new Sporting Goods Category
-- You can leave the Supplier Id empty for now, but you need to include
-- the product name, category, price, units in stock (20), units on order (0)
-- and re-order level (10) for each product.

SELECT *
FROM products
WHERE category_id = 9;

INSERT INTO products
(			product_name, 
			category_id, 
            unit_price, 
            units_in_stock, 
            units_on_order, 
            reorder_level
)

VALUES('Soccer Ball', 9, 15.99, 50, 10, 15),
	('Tennis Racket', 9, 89.99, 30, 5, 10),
    ('Baseball Glove', 9, 55, 40, 8, 12),
    ('Basketball', 9, 25.99, 60, 12, 20),
    ('Golf Club Set', 9, 299.99, 20, 4, 8),
    ('Running Shoes', 9, 79.99, 35, 7, 15),
    ('Yoga Mat', 9, 24.99, 45, 6, 10),
    ('Dumbbell Set', 9, 129.99, 25, 3, 7),
    ('Swim Goggles', 9, 12.99, 70, 15, 20),
    ('Hiking Backpack', 9, 99.99, 15, 2, 5)
;