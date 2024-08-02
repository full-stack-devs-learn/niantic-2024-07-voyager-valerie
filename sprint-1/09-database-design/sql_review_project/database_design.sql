DROP DATABASE IF EXISTS transactions;
CREATE DATABASE transactions;
USE transactions;

CREATE TABLE person
(
    person_id INT NOT NULL AUTO_INCREMENT,
    person_name VARCHAR(20),
    PRIMARY KEY (person_id)
);

CREATE TABLE category
(
    category_id INT NOT NULL AUTO_INCREMENT,
    category_name VARCHAR(40),
    person_id INT NOT NULL,
    amount DECIMAL(10, 2),
    date DATETIME,
    category_order INT,
    PRIMARY KEY (category_id),
    FOREIGN KEY (person_id) REFERENCES person(person_id)
);

CREATE TABLE sub_category
(
    sub_category_id INT NOT NULL AUTO_INCREMENT,
    sub_category_name VARCHAR(40),
    category_id INT NOT NULL,
    notes VARCHAR(200),
    PRIMARY KEY (sub_category_id),
    FOREIGN KEY (category_id) REFERENCES category(category_id)
);

CREATE TABLE vendor
(
    vendor_id INT NOT NULL AUTO_INCREMENT,
    vendor_name VARCHAR(40),
    person_id INT NOT NULL,
    PRIMARY KEY (vendor_id),
    FOREIGN KEY (person_id) REFERENCES person(person_id)
);

-- seed data
INSERT INTO person(person_name)
VALUES ('John'),
	('Sarah');


INSERT INTO category(category_name, person_id, amount, date, category_order)
VALUES ('Housing', 1, 1200, '2024-05-01', 1),
	('Transportation', 2, 40, '2024-05-03', 2),
    ('Food', 1, 150, '2024-05-05', 3),
    ('Healthcare', 2, 20, '2024-05-07', 4),
    ('Entertainment', 1, 30, '2024-05-10', 5),
    ('Vacation/Travel', 2, 300, '2024-05-12', 6),
    ('Housing', 1, 100, '2024-05-15', 1),
    ('Transportation', 2, 20, '2024-05-17', 2),
    ('Food', 1, 25, '2024-05-20', 3),
    ('Healthcare', 2, 50, '2024-05-22', 4),
    ('Entertainment', 1, 15, '2024-05-24', 5),
    ('Vacation/Travel', 2, 200, '2024-05-28', 6),
    ('Housing', 2, 50, '2024-05-01', 1),
    ('Transportation', 1, 100, '2024-05-04', 2),
    ('Food', 2, 10, '2024-05-09', 3),
    ('Healthcare', 1, 15, '2024-05-14', 4),
    ('Entertainment', 2, 50, '2024-05-18', 5),
    ('Vacation/Travel', 1, 150, '2024-05-23', 6),
    ('Food', 2, 80, '2024-05-26', 3),
    ('Housing', 1, 60, '2024-05-30', 1),
    ('Housing', 1, 1300, '2024-06-01', 1),
    ('Transportation', 2, 60, '2024-06-03', 2),
    ('Food', 1, 200, '2024-06-10', 3),
    ('Healthcare', 2, 30, '2024-06-15', 4),
    ('Entertainment', 1, 40, '2024-06-20', 5),
    ('Vacation/Travel', 2, 350, '2024-06-25', 6),
    ('Housing', 1, 1100, '2024-07-01', 1),
    ('Transportation', 2, 50, '2024-07-05', 2),
    ('Food', 1, 180, '2024-07-10', 3),
    ('Healthcare', 2, 40, '2024-07-15', 4),
    ('Entertainment', 1, 25, '2024-07-20', 5),
    ('Vacation/Travel', 2, 300, '2024-07-25', 6),
    ('Housing', 2, 60, '2024-08-01', 1),
    ('Transportation', 1, 120, '2024-08-03', 2),
    ('Food', 2, 90, '2024-08-10', 3),
    ('Healthcare', 1, 25, '2024-08-15', 4),
    ('Entertainment', 2, 55, '2024-08-20', 5),
    ('Vacation/Travel', 1, 180, '2024-08-25', 6),
    ('Food', 1, 70, '2024-08-30', 3);


INSERT INTO sub_category(sub_category_name, category_id, notes)
VALUES ('Rent', 1, 'Monthly rent payment'),
	('Gas', 2, 'Filled up the car''s tank'),
    ('Groceries', 3, 'Weekly grocery shopping'),
    ('Rx', 4, 'Prescription refill'),
    ('Movies', 5, 'Movie night out'),
    ('Flight', 6, 'Booked flight for upcoming trip'),
    ('Utilities', 7, 'Electricity bill payment'),
    ('Subway', 8, 'Monthly subway pass'),
    ('Restaurant', 9, 'Dinner with friends'),
    ('Dr Visit', 10, 'Routine check-up'),
    ('Netflix', 11, 'Monthly subscription fee'),
    ('Hotel', 12, 'Hotel booking for vacation'),
    ('Utilities', 13, 'Water bill payment'),
    ('Car maintanence', 14, 'Car oil change'),
    ('Snacks', 15, 'Snacks for movie night'),
    ('OTC Medicine', 16, 'Cold medicine'),
    ('Sports', 17, 'Tickets to a baseball game'),
    ('Car rental', 18, 'Rental car for trip'),
    ('Groceries', 19, 'Fresh produce and groceries'),
    ('Utilities', 20, 'Internet service provider bill'),
    ('Rent', 1, 'Monthly rent payment for June'),
    ('Gas', 2, 'Fuel cost for June'),
    ('Groceries', 3, 'Monthly grocery shopping for June'),
    ('Rx', 4, 'Medical expenses for June'),
    ('Movies', 5, 'Cinema tickets for June'),
    ('Flight', 6, 'Flight booking for June vacation'),
    ('Utilities', 1, 'Electricity bill for June'),
    ('Subway', 2, 'Transportation pass for June'),
    ('Restaurant', 3, 'Dining out in June'),
    ('Dr Visit', 4, 'Check-up in June'),
    ('Netflix', 5, 'Subscription fee for June'),
    ('Hotel', 6, 'Hotel stay for June vacation'),
    ('Utilities', 1, 'Water bill for June'),
    ('Car maintenance', 2, 'Maintenance service for June'),
    ('Snacks', 3, 'Snacks bought in June'),
    ('OTC Medicine', 4, 'Over-the-counter medicine purchased in June'),
    ('Sports', 5, 'Baseball game tickets for June'),
    ('Car rental', 6, 'Car rental for June trip'),
    ('Groceries', 3, 'Fresh produce bought in June'),
    ('Utilities', 1, 'Internet bill for June'),
    ('Rent', 1, 'Monthly rent payment for July'),
    ('Gas', 2, 'Fuel cost for July'),
    ('Groceries', 3, 'Monthly grocery shopping for July'),
    ('Rx', 4, 'Medical expenses for July'),
    ('Movies', 5, 'Cinema tickets for July'),
    ('Flight', 6, 'Flight booking for July vacation'),
    ('Utilities', 1, 'Electricity bill for July'),
    ('Subway', 2, 'Transportation pass for July'),
    ('Restaurant', 3, 'Dining out in July'),
    ('Dr Visit', 4, 'Check-up in July'),
    ('Netflix', 5, 'Subscription fee for July'),
    ('Hotel', 6, 'Hotel stay for July vacation'),
    ('Utilities', 1, 'Water bill for July'),
    ('Car maintenance', 2, 'Maintenance service for July'),
    ('Snacks', 3, 'Snacks bought in July'),
    ('OTC Medicine', 4, 'Over-the-counter medicine purchased in July'),
    ('Sports', 5, 'Baseball game tickets for July'),
    ('Car rental', 6, 'Car rental for July trip'),
    ('Groceries', 3, 'Fresh produce bought in July'),
    ('Utilities', 1, 'Internet bill for July');

    
INSERT INTO vendor(vendor_name, person_id)
VALUES('Landlord Inc.', 1),
	('Shell Gas Station', 2),
    ('Fresh Mart', 1),
    ('CVS Pharmacy', 2),
    ('Cinemax Theater', 1),
    ('Delta Airlines', 2),
    ('Powerco', 1),
    ('Metro Transit', 2),
    ('Joe''s Diner', 2),
    ('HealthFirst Clinic', 2),
    ('Netflix', 1),
    ('Oceanfront Resort', 2),
    ('WaterWorks', 2),
    ('AutoWorks', 1),
    ('Snack Haven', 2),
    ('Pharmax', 1),
    ('Sports Arena', 2),
    ('Zoom Car Rentals', 1),
    ('Farmer''s Market', 2),
    ('FastNet', 1),
    ('Grocery Store', 1),
    ('Bookstore', 2),
    ('Gym', 1),
    ('Coffee Shop', 2),
    ('Spa', 1),
    ('Online Retailer', 2),
    ('Dry Cleaners', 1),
    ('Pharmacy', 2),
    ('Furniture Store', 1),
    ('Supermarket', 2),
    ('Car Dealership', 1),
    ('Pet Store', 2),
    ('Bike Shop', 1),
    ('Music Store', 2),
    ('Home Improvement Store', 1),
    ('Florist', 2),
    ('Craft Store', 1),
    ('Electronics Store', 2),
    ('Lawn Care Service', 1),
    ('Seasonal Decoration Store', 2);
    
