USE northwind;

-- Insert 10 new products into the new Sporting Goods Category
-- You can leave the Supplier Id empty for now, but you need to include
-- the product name, category, price, units in stock (20), units on order (0)
-- and re-order level (10) for each product.

SELECT *
FROM products;

INSERT INTO products
(			product_name, 
			category_id, 
            unit_price, 
            units_in_stock, 
            units_on_order, 
            reorder_level
)

VALUES('Soccer Ball', 11, 15.99, 50, 10, 15),
	('Tennis Racket', 11, 89.99, 30, 5, 10),
    ('Baseball Glove', 11, 55, 40, 8, 12),
    ('Basketball', 11, 25.99, 60, 12, 20),
    ('Golf Club Set', 11, 299.99, 20, 4, 8),
    ('Running Shoes', 11, 79.99, 35, 7, 15),
    ('Yoga Mat', 11, 24.99, 45, 6, 10),
    ('Dumbbell Set', 11, 129.99, 25, 3, 7),
    ('Swim Goggles', 11, 12.99, 70, 15, 20),
    ('Hiking Backpack', 11, 99.99, 15, 2, 5)
;