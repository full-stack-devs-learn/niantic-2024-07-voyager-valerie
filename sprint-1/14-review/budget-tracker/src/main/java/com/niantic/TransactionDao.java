package com.niantic;

import com.niantic.models.Transaction;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import java.sql.Date;
import java.util.ArrayList;

public class TransactionDao
{
    JdbcTemplate jdbcTemplate;

    public ArrayList<Transaction> getTransactionsBySubCategory(int subCategoryId)
    {
        var transactions = new ArrayList<Transaction>();

        String sql = """
                SELECT transaction_id
                    , user_id
                    , sub_category_id
                    , vendor_id
                    , date
                    , amount
                    , notes
                FROM transactions
                WHERE sub_category_id = ?;
                """;

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, subCategoryId);

        while(row.next()) {
            int transactionId = row.getInt("transaction_id");
            int subCategorysId = row.getInt("sub_category_id");
            int vendorId = row.getInt("vendor_id");
            LocalDate date = row.getDate("date").toLocalDate();
            double amount = row.getDouble("amount");
            String memo = row.getString("notes");

            Transaction transaction = new Transaction();

            transactions.add(transaction);
        }
        return transactions;
    }

    public Transaction getTransactionById (int transactionId)
    {
        String sql = """
                SELECT transaction_id
                    , user_id
                    , sub_category_id
                    , vendor_id
                    , date
                    , amount
                    , notes
                FROM transactions
                WHERE transaction_id = ?;
                """;

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, transactionId);

        int transactionsId = row.getInt("transaction_id");
        int userId = row.getInt("user_id");
        int subCategoryId = row.getInt("sub_category_id");
        Date date = row.getDate("transaction_date");
        double amount = row.getDouble("amount");
        String memo = row.getNString("notes");

        Transaction transaction = new Transaction();

        transaction.setTransactionId(transactionId);

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
                UPDATE transactions
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
                DELETE FROM transactions
                WHERE transaction_id = ?;
                """;

        jdbcTemplate.update(sql, transactionId);
    }
}
