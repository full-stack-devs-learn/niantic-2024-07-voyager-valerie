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

        String sql = """
                """;

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

    public void addTransaction(Transaction transaction)
    {
        String sql = """
                INSERT INTO transactions(transaction_id
                    , user_id
                    , sub_category_id
                    , vendor_id
                     transaction_date
                     , amount
                     , notes)
                VALUES(?, ?, ?, ?, ?, ?, ?);
                """;

        jdbcTemplate.update(sql,
                transaction.getTransactionId(),
                transaction.getUserId(),
                transaction.getSubCategoryId(),
                transaction.getVendorId(),
                transaction.getDate(),
                transaction.getAmount(),
                transaction.getMemo());
    }

    public void updateTransaction(Transaction transaction)
    {
        String sql = """
                UPDATE transaction
                SET transaction_date = ?
                    , amount = ?
                    , notes = ?
                WHERE transaction_id = ?
                """;


        jdbcTemplate.update(sql,
                transaction.getDate(),
                transaction.getAmount(),
                transaction.getMemo(),
                transaction.getTransactionId());
    }

    public void deleteTransaction(int transactionId)
    {
        String sql = """
                DELETE FROM transaction
                WHERE transaction_id = ?;
                """;

        jdbcTemplate.update(sql, transactionId);
    }
}
