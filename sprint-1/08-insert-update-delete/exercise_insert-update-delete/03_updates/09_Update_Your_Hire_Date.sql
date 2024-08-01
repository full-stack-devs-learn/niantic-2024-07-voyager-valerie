USE northwind;

-- write an update statement and change your hire date to 
-- Monday 2 weeks ago


SELECT *
FROM employees;

UPDATE employees
SET hire_date = DATE_SUB(hire_date, INTERVAL 2 WEEK)
WHERE employee_id = 10;