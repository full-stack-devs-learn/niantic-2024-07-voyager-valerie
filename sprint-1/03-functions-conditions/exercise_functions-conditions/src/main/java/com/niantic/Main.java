package com.niantic;

import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        backyardBasketBall();
        clairesCookies();
        elliotsYardCare();
    }

    private static void backyardBasketBall()
    {
        BackyardBasketball ballGames = new BackyardBasketball();

        int gamesWon = 13;
        int gamesLost = 0;
        int winningPercentage = ballGames.calculateWinningPercentage(gamesWon, gamesLost);
        System.out.println("Winning percentage: " + winningPercentage);


        int shotPercentage = 70;
        int shotsTaken = 10;
        boolean isThree = false;
        int points = ballGames.calculatePointsScored(shotPercentage, shotsTaken, isThree);
        System.out.println("Points scored: " + points);

        //int shotPercentage = 50;
        int desiredScore = 10;
        //boolean isThree = true; // -> 8

        int shotsRequired = ballGames.calculateShotsRequired(shotPercentage, desiredScore, isThree);
        System.out.println("Shots required: " + shotsRequired);

    }

    private static void clairesCookies()
    {
        ClairesCookies orders = new ClairesCookies();

        double TAX_RATE = 0.0575;
        double cookiePrice = 12.95;
        int quantity = 1;

        double subtotal = orders.calculateSubtotal(quantity);
        System.out.println("Cookie price before tax: " + subtotal);


        //double orderCostAfterTax = orders.calculateTotal(quantity);
        //System.out.println("Cookie price after tax: " + orderCostAfterTax);

        int snickerDozen = 1;
        int chocolateDozen = 1;
        int frostedDozen = 1;

        double quickOrder = orders.calculateQuickOrder(snickerDozen, chocolateDozen, frostedDozen);
        System.out.println("Popular orders (tax factored): $" + quickOrder);

        //int quantity = 5;
        boolean hasChocolateChips = true;
        boolean hasFrosting = false;

        double customOrder = orders.calculateCustomOrder(quantity, hasChocolateChips, hasFrosting);
        System.out.println("Cost of customized cookies (including tax): $" + customOrder);
    }

    private static void elliotsYardCare()
    {

    }
}