DROP DATABASE IF EXISTS transactions;

CREATE DATABASE transactions;

USE transactions;

CREATE TABLE person
(
	person_id INT NOT NULL AUTO_INCREMENT,
    person_name VARCHAR(20) NOT NULL,
    PRIMARY KEY (person_id)
);

CREATE TABLE category
(
	category_id INT NOT NULL,
    category_name VARCHAR(40) NOT NULL,
    person_id INT NOT NULL,
    amount DECIMAL(10, 2),
    date DATETIME,
    PRIMARY KEY (category_id),
    FOREIGN KEY (person_id) REFERENCES person (person_id)
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
    FOREIGN KEY (person_id) REFERENCES person (person_id)
);

INSERT INTO person(person_name)
VALUES ('John'),
	('Sarah');

INSERT INTO category(category_id, category_name, person_id, amount, date)
VALUES (1, 'Housing', 1, 1200, '2024-05-01'),
	(2, 'Transportation', 2, 40, '2024-05-03'),
    (3, 'Food', 1, 150, '2024-05-05'),
    (4, 'Healthcare', 2, 20, '2024-05-07'),
    (5, 'Entertainment', 1, 30, '2024-05-10'),
    (6, 'Vacation/Travel', 2, 300, '2024-05-12'),
    (1, 'Housing', 1, 100, '2024-05-15'),
    (2, 'Transportation', 2, 20, '2024-05-17'),
    (3, 'Food', 1, 25, '2024-05-20'),
    (4, 'Healthcare', 2, 50, '2024-05-22'),
    (5, 'Entertainment', 1, 15, '2024-05-24'),
    (6, 'Vacation/Travel', 2, 200, '2024-05-28'),
    (1, 'Housing', 2, 50, '2024-05-01'),
    (2, 'Transportation', 1, 100, '2024-05-04'),
    (3, 'Food', 2, 10, '2024-05-09'),
    (4, 'Healthcare', 1, 15, '2024-05-14'),
    (5, 'Entertainment', 2, 50, '2024-05-18'),
    (6, 'Vacation/Travel', 1, 150, '2024-05-23'),
    (3, 'Food', 2, 80, '2024-05-26'),
    (1, 'Housing', 1, 60, '2024-05-30');


INSERT INTO sub_category(sub_category_name, category_id, notes)
VALUES ('Rent', 1, 'Monthly rent payment'),
	('Gas', 2, 'Filled up the car''s tank'),
    ('Groceries', 3, 'Weekly grocery shopping'),
    ('Rx', 4, 'Prescription refill'),
    ('Movies', 5, 'Movie night out'),
    ('Flight', 6, 'Booked flight for upcoming trip'),
    ('Utilities', 1, 'Booked flight for upcoming trip'),
    ('Subway', 2, 'Monthly subway pass'),
    ('Restaurant', 3, 'Dinner with friends'),
    ('Dr Visit', 4, 'Routine check-up'),
    ('Netflix', 5, 'Monthly subscription fee'),
    ('Hotel', 6, 'Hotel booking for vacation'),
    ('Utilities', 1, 'Water bill payment'),
    ('Car maintanence', 2, 'Car oil change'),
    ('Snacks', 3, 'Snacks for movie night'),
    ('OTC Medicine', 4, 'Cold medicine'),
    ('Sports', 5, 'Tickets to a baseball game'),
    ('Car rental', 6, 'Rental car for trip'),
    ('Groceries', 3, 'Fresh produce and groceries');