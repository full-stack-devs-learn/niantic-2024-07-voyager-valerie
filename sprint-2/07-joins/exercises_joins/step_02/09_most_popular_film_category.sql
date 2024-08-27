-- 9. Most Popular Film Categories
-- Return the total number of actors
-- who have acted in a category
-- sort most popular category to least

-- Columns: category_name, actor_count
--
-- (16 rows)

USE sakila;

SELECT name,
	COUNT(a.actor_id) AS actor_count
FROM film_category AS fc
INNER JOIN film_actor AS fa
	ON fc.film_id = fa.film_id
INNER JOIN film AS f
	ON fa.film_id = f.film_id
INNER JOIN actor AS a
	ON fa.actor_id = a.actor_id
INNER JOIN category AS c
	ON fc.category_id = c.category_id
GROUP BY name
ORDER BY actor_count DESC;

