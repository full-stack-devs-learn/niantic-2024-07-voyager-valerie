USE northwind;

-- write an update statement and change your hire date to 
-- Monday 2 weeks ago


SELECT *
FROM employees;

UPDATE employees
SET hire_date = '2024-07-15 00:00:00'
WHERE employee_id = 10;