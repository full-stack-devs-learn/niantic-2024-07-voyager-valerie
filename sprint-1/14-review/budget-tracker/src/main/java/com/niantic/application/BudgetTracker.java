package com.niantic.application;

import com.niantic.models.*;

import com.niantic.TransactionDao;

import java.time.LocalDate;
import java.util.Scanner;

import static java.lang.StringTemplate.STR;

public class BudgetTracker
{
    Scanner userInput = new Scanner(System.in);

    TransactionDao transactionDao = new TransactionDao();

    public void run()
    {

        while(true)
        {
            int choice = homeScreenSelection();
            switch(choice)
            {
                case 1:
                    addTransaction();
                    break;
                //case 2:
                //    reportSelection();
                //    break;
                case 3:
                    addUser();
                    break;
               case 4:
                    addCategory();
                    break;
                case 5:
                    addSubcategory();
                    break;
                case 6:
                    addVendor();
                    break;
                case 0:
                    System.out.println();
                    System.out.println("Thank you for using Northwind!");
                    System.out.println("Goodbye");
                    System.out.println();
                    System.exit(0);
                default:
                    System.out.println("invalid selection");
                    break;
            }
        }

    }

    private int homeScreenSelection()
    {
        System.out.println();
        System.out.println("Budget Tracker");
        System.out.println("--------------------------------------");
        System.out.println("Home");
        System.out.println("--------------------------------------");
        System.out.println("Select from the following options:");
        System.out.println();
        System.out.println("  1) Add Transaction");
        System.out.println("  2) Reports");
        System.out.println("  3) Add User");
        System.out.println("  4) Add Category");
        System.out.println("  5) Add Sub Category");
        System.out.println("  6) Add Vendor");
        System.out.println("  0) Quit");
        System.out.println();

        System.out.print("Enter an option: ");
        return Integer.parseInt(userInput.nextLine());
    }

    private void addTransaction()
    {
        System.out.println("--------------------------------------");
        System.out.println("Add Transaction");
        System.out.println("--------------------------------------");
        System.out.println("Enter Transaction Information");
        System.out.println();

        int transactionId = getUserInt("Enter transaction id: ");
        int userId = getUserInt("Enter user id: ");
        int subCategoryId = getUserInt("Enter sub category id: ");
        int vendorId = getUserInt("Enter vendor id: ");
        LocalDate date = getUserDate("Enter transaction date: ");
        double amount = getUserDouble("Enter transaction amount: ");
        String memo = getUserString("Enter transaction memo: ");


        System.out.println();

        var transaction = new Transaction()
        {{
            setTransactionId(transactionId);
            setUserId(userId);
            setSubCategoryId(subCategoryId);
            setVendorId(vendorId);
            setDate(date);
            setAmount(amount);
            setMemo(memo);
        }};

        try
        {
            transactionDao.addTransaction(transaction);

            System.out.println(STR."\{transactionId} has been added.");
        }

        catch (Exception e)
        {
            System.out.println(STR."There was a problem adding \{transactionId}.");
        }

        waitForUser();
    }
/*
    private void displayReport()
    {
        while(true) {
            int options = reportSelection();
            switch (options)
            {
                case 1:
                    userTransactions();
                    break;

                case 2:
                    monthlyTransactions();
                    break;

                case 3:
                    yearlyTransactions();
                    break;

                case 4:
                    subcategoryTransactions();
                    break;

                case 5:
                    categoryTransactions();
                    break;

                case 0:
                    return;
                default:
                    System.out.println("Invalid selection. Please enter an integer included in the above options.");
            }
        }
    }
*/
    private int reportSelection()
    {
        System.out.println("--------------------------------------");
        System.out.println("Reports");
        System.out.println("--------------------------------------");
        System.out.println();
        System.out.println(" 1) Transactions By User");
        System.out.println(" 2) Transactions By Month");
        System.out.println(" 3) Transactions By Year");
        System.out.println(" 4) Transactions By Sub Category");
        System.out.println(" 5) Transactions By Category");
        System.out.println(" 0) Back");
        System.out.println();

        return getUserInt("Enter your selection: ");
    }

    /*private double userTransactions()
    {

    }

    private double monthlyTransactions()
    {

    }

    private double yearlyTransactions()
    {

    }

    private double subcategoryTransactions()
    {

    }

    private double categoryTransactions()
    {

    }
*/
    private void addUser()
    {
        System.out.println("--------------------------------------");
        System.out.println("Add User");
        System.out.println("--------------------------------------");
        System.out.println("Enter User Information");
        System.out.println();

        int userId = getUserInt("Enter user id: ");
        String username = getUserString("Enter user name: ");
        String firstName = getUserString("Enter first name: ");
        String lastName = getUserString("Enter last name: ");
        String phoneNumber = getUserString("Enter phone number: ");
        String email = getUserString("Enter email: ");

        System.out.println();

        var user = new User()
        {{
            setUserId(userId);
            setUsername(username);
            setFirstName(firstName);
            setLastName(lastName);
            setPhoneNumber(phoneNumber);
            setEmail(email);
        }};
    }

    private void addCategory()
    {
        System.out.println("--------------------------------------");
        System.out.println("Add Category");
        System.out.println("--------------------------------------");
        System.out.println("Enter Category Information");
        System.out.println();

        String categoryName = getUserString("Enter category name: ");
        String categoryDescription = getUserString("Enter description: ");

        var category =  new Category()
        {{
            setCategoryName();
            setCategoryDescription();
        }};
    }

    private void addSubcategory()
    {
        System.out.println("--------------------------------------");
        System.out.println("Add Sub Category");
        System.out.println("--------------------------------------");
        System.out.println("Enter Sub Category Information");
        System.out.println();

        int subCategoryId = getUserInt("Enter sub category id: ");
        int categoryId = getUserInt("Enter category id: ");
        String subCategoryName = getUserString("Enter sub category name: ");
        String subCategoryDescription = getUserString("Enter sub category description: ");

        var subCategory = new Subcategory()
        {{
            setSubCategoryId(subCategoryId);
            setCategoryId(categoryId);
            setSubCategoryName(subCategoryName);
            setSubCategoryDescription(subCategoryDescription);
        }};
    }

    private void addVendor()
    {
        System.out.println("--------------------------------------");
        System.out.println("Add Vendor");
        System.out.println("--------------------------------------");
        System.out.println("Enter Vendor Information");
        System.out.println();

        int vendorId = getUserInt("Enter vendor id: ");
        String vendorName = getUserString("Enter vendor name: ");
        String website = getUserString("Enter website url: ");

        var vendor = new Vendor()
        {{
            setVendorId(vendorId);
            setVendorName(vendorName);
            setWebsite(website);
        }};
    }

    private void waitForUser()
    {
        System.out.println();
        System.out.println("Press ENTER to continue");
        userInput.nextLine();
    }

    private String getUserString(String input)
    {
        System.out.println(input);
        return userInput.nextLine();
    }

    private LocalDate getUserDate(String input)
    {
        return LocalDate.parse(getUserString(input));
    }

    private int getUserInt(String input)
    {
        return Integer.parseInt(getUserString(input));
    }

    private double getUserDouble(String input)
    {
        return Double.parseDouble(getUserString(input));
    }
}
