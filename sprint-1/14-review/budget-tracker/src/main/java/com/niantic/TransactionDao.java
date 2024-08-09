package com.niantic;

import com.niantic.models.Transaction;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

public class TransactionDao
{
    JdbcTemplate jdbcTemplate;

    public ArrayList<Transaction> getAllTransactions()
    {
        var transaction = new ArrayList<Transaction>();

        String sql = "";

        var row = jdbcTemplate.queryForRowSet(sql);

        while(row.next())
        {
            // if null values are allowed, this could be a problem
            Date date = row.getDate("transaction_date");
            if(date != null)
            {
                LocalDate transactionDate = date.toLocalDate();
            }
        }
        return transaction;
    }
}
