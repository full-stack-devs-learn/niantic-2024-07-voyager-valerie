USE northwind;

-- You were just hired by Northwind Traders, Inc and 
-- you need to add yourself as a Sales Associate to the Employees table.
-- Inlcude your:
    -- full name
    -- job title
    -- preferred title (Mr, Mrs, etc)
    -- Birthday
    -- hire date: (today)
    -- home address
-- leave all other fields null by default


SELECT *
FROM employees;

INSERT INTO employees(
	last_name, 
	first_name, 
    title, 
    title_of_courtesy, 
    birth_date, 
    hire_date,
	address,
    notes
    
) VALUES (
	'Kuan',
    'Valerie',
    'Bootcamper',
    'Ms.',
    '2001-07-09 00:00:00',
    '2024-07-31 00:00:00',
    '123 Main Street',
    ''
);
