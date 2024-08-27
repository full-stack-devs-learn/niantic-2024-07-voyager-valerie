-- 10. Count of films in each category
-- that GRACE MOSTEL has appeared in as an actress

-- include first_name, last_name, category_name, film_count

-- (11 rows)

USE sakila;

SELECT first_name,
	last_name,
    name,
    COUNT(fa.film_id) AS film_count
FROM actor AS a
INNER JOIN film_actor AS fa
	ON a.actor_id = fa.actor_id
INNER JOIN film_category AS fc
	ON fa.film_id = fc.film_id
INNER JOIN category AS c
	ON fc.category_id = c.category_id
WHERE first_name = 'GRACE' AND last_name = 'MOSTEL'
GROUP BY first_name, last_name, name;