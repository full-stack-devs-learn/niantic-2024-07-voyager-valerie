package com.niantic;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.text.Format;

import static java.util.FormatProcessor.FMT;

public class Main
{
    public static void main(String[] args)
    {
        // 1. Create a data source;
        BasicDataSource dataSource = new BasicDataSource();
        // local host = my computer
        dataSource.setUrl("jdbc:mysql://localhost:3306/sakila");
        dataSource.setUsername("valerie");
        dataSource.setPassword("ff@emFD4");

        // object to execute SQL statements
        var jdbcTemplate = new JdbcTemplate(dataSource);

        // 2. Execute a SQL statement
        String sql = """
                SELECT actor_id,
                    first_name,
                    last_name
                FROM actor;
                """;

        // .ForRowSet for query results with multiple rows
        var row = jdbcTemplate.queryForRowSet(sql);

        // 3. Loop thru rows and do something w/ the data

        while(row.next())
        {
            int actorId = row.getInt("actor_id");
            String firstName = row.getString("first_name");
            String lastName = row.getString("last_name");

            System.out.println(FMT."%5d\{actorId} %10s\{firstName} %15s\{lastName}");
        }
    }
}