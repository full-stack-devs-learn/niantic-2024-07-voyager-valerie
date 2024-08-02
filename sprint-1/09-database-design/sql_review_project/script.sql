
	-- script to add additional expenses, where user fills them in as the days go by
    SET @category_id = 40,
		@category_name = 'Food',
        @person_id = 2,
        @amount = 7,
        @date = '2024-06-01',
        @category_order = 3;
	
     SET @sub_category_name = 'Snacks', 
		 @category_id = 40, 
 		 @notes = 'Oolong milk tea';
         
	SET @vendor_name = 'Sunright Tea Studio', 
		@person_id = 2;    -- contributing expense to Sarah, who's an exisitng person in the db
    
    INSERT INTO person(person_name)
    VALUES
    (
        @person_name
    );
    
    INSERT INTO category(category_name, person_id, amount, date, category_order)
    VALUES
    (
		@category_name, 
        @person_id, 
        @amount, 
        @date, 
        @category_order
    );
    
    INSERT INTO sub_category(sub_category_name, category_id, notes)
    VALUES
    (
		@sub_category_name, 
        @category_id, 
        @notes
    );
    
    INSERT INTO vendor(vendor_name, person_id)
    VALUES
    (
		@vendor_name,
        @person_id
    );
    
    
    -- monthly expense breakdown, where user controls the month to view
    
    -- May Breakdown
    SET @month := 5;
    
    SELECT category_order,
		category_name,
		SUM(amount) AS category_total
    FROM category
    WHERE MONTH(date) = @month
    GROUP BY category_order, category_name;
    
    -- June Breakdown
    SET @month := 6;
    
    SELECT category_order,
		category_name,
		SUM(amount) AS category_total
    FROM category
    WHERE MONTH(date) = @month
    GROUP BY category_order, category_name;
    
    -- July Breakdown
    SET @month := 7;
    
    SELECT category_order,
		category_name,
		SUM(amount) AS category_total
    FROM category
    WHERE MONTH(date) = @month
    GROUP BY category_order, category_name;
    
    
    -- all sub-category expenses broken down in a category in a given month
     
    SET @category_used := 'Housing',
		@month := 5;
    
    SELECT category.category_name, sub_category.sub_category_name, amount, date
    FROM category
		JOIN sub_category ON category.category_id = sub_category.category_id
    WHERE category.category_name = @category_used AND MONTH(date) = @month;
    
    
    -- all transactions in a month made by person of choice
    
    SET @purchaser := 'Sarah',
		@month := 7;
    
    SELECT category_name, amount, date, person_name
    FROM category
		JOIN person ON category.person_id = person.person_id
    WHERE person_name = @purchaser AND month(date) = @month;
    
    
    -- all transactions made by person of choice in a year
    SET @purchaser := 'John',
		@year = 2024;
    
    SELECT category_name, amount, date, person_name
    FROM category
		JOIN person ON category.person_id = person.person_id
    WHERE person_name = @purchaser AND YEAR(date) = @year;
    
    
    -- identifying the expensive categories within a month, where the user defines "expensive"
    
    SET @expensive := 500,
		@month := 5;
    
    SELECT category_name, 
		SUM(amount) AS category_total
    FROM category
    WHERE MONTH(date) = @month
    GROUP BY category_name
    HAVING SUM(amount) > @expensive;
    
    -- identify expensive categories within a calendar year
	SET @year := 2024;
    
	SELECT category_name,
		SUM(amount) AS category_total
    FROM category
    WHERE YEAR(date) = @year
    GROUP BY category_name
    HAVING SUM(amount) > @expensive;
    
    