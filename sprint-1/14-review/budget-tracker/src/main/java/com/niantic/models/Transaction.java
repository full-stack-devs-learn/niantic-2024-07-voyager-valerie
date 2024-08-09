package com.niantic.models;

import java.time.LocalDate;

public class Transaction
{
    private double amount;
    private LocalDate date;
    private String memo;
    private String username;
    private String vendor;
    private String subcategory;

    public Transaction(double amount, LocalDate date, String memo, String username, String vendor, String subcategory)
    {
        this.amount = amount;
        this.date = date;
        this.memo = memo;
        this.username = username;
        this.vendor = vendor;
        this.subcategory = subcategory;
    }

    public Transaction()
    {
    }

    public double getAmount()
    {
        return amount;
    }

    public void setAmount(double amount)
    {
        this.amount = amount;
    }

    public LocalDate getDate()
    {
        return date;
    }

    public void setDate(LocalDate date)
    {
        this.date = date;
    }

    public String getMemo()
    {
        return memo;
    }

    public void setMemo(String memo)
    {
        this.memo = memo;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getVendor()
    {
        return vendor;
    }

    public void setVendor(String vendor)
    {
        this.vendor = vendor;
    }

    public String getSubcategory()
    {
        return subcategory;
    }

    public void setSubcategory(String subcategory)
    {
        this.subcategory = subcategory;
    }
}
