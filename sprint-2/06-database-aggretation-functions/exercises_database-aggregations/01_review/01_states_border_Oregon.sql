USE northwind;

-- 1. The name, city, state, and postal code of all
-- Customers in the states that border Oregon.
-- (Use the Customers table)

-- The states are: Washington, Idaho and California.

-- There should be 2 columns
-- 1) the company_name
-- 2) the city name, state and postal code should be returned
--      as a single column called 'CityStateZip' and should contain
--      values such as "San Francisco, CA 94117".

-- Order the results alphabetically by city_state_zip.
-- (5 rows)

SELECT company_name,
	CONCAT(city, ', ', region, ' ', postal_code) AS city_state_zip
FROM customers
WHERE region IN ('WA', 'ID', 'CA')
ORDER BY CONCAT(city, ', ', region, ' ', postal_code);
