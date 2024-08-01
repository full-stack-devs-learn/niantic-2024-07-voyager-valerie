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
    amount INT,
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
    person_id VARCHAR(20),
    PRIMARY KEY (vendor_id),
    FOREIGN KEY (person_id) REFERENCES person (person_id)
);

INSERT INTO person(person_name)
VALUES ('John'),
	('Sarah');

INSERT INTO category(category_name, amount, date)
VALUES ('Housing', 1200, '2024-05-01'),
	('Transportation', 40, '2024-05-03'),
    ('Food', 150, '2024-05-05'),
    ('Healthcare', 20, '2024-05-07'),
    ('Entertainment', 30, '2024-05-10'),
    ('Vacation/Travel', 300, '2024-05-12'),
    ('Housing', 100, '2024-05-15'),
    ('Transportation', 20, '2024-05-17'),
    ('Food', 25, '2024-05-20'),
    ('Healthcare', 50, '2024-05-22'),
    ('Entertainment', 15, '2024-05-24'),
    ('Vacation/Travel', 200, '2024-05-28'),
    ('Housing', 50, '2024-05-01'),
    ('Transportation', 100, '2024-05-04'),
    ('Food', 10, '2024-05-09');
