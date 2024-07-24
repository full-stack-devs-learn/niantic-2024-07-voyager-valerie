package com.niantic;

import java.util.Scanner;

public class BackyardBasketball
{
    public static void main(String[] args)
    {
        Scanner userInput = new Scanner(System.in);

        // variables for winning percentage
        int gamesWon;
        int gamesLost;

        // user fills info in about their wins and losses
        System.out.println("Enter team wins:");
        gamesWon = userInput.nextInt();
        userInput.nextLine();

        System.out.println("Enter team losses:");
        gamesLost = userInput.nextInt();
        userInput.nextLine();

        // calculate winning percentage based on user input

        int percentage = calculateWinningPercentage(gamesWon, gamesLost);
        System.out.println("Winning Percentage: " + percentage + "%");

        // variables for points scored
        int shotPercentage;
        int shotsTaken;
        boolean isThree;

        System.out.println("Enter the percentage of shots you made:");
        shotPercentage = userInput.nextInt();
        userInput.nextLine();

        System.out.println("Enter the number of shots you took:");
        shotsTaken = userInput.nextInt();
        userInput.nextLine();

        System.out.println("Write 'true' if 3 pointers were made, and 'false' if not:");
        isThree = userInput.nextBoolean();

        int points = calculatePointsScored(shotPercentage, shotsTaken, isThree);
        System.out.println("Points scored: " + points);


        // variables for calculateShotsRequired
        int desiredScore;   // only one bc reuse from the other function

        System.out.println("Desired score:");
        desiredScore = userInput.nextInt();
        userInput.nextLine();

        int shotsRequired = calculateShotsRequired(shotPercentage, desiredScore,isThree);
        System.out.println("Shots required: " + shotsRequired);

        userInput.close();
    }
    /*
     * Teams that play in the backyard league want to be able
     * to calculate their winning percentage.
     *
     * Each team knows how many games they have won and how many
     * games they have lost. When they call this function they
     * will provide their wins and losses.
     *
     * You need to perform the calculation and return their
     * winning percentage as a whole number.
     *
     * Example:
     * If a team has won 7 games and lost 3 games their winning
     * percentage is 70%.
     *
     * calculateWinningPercentage(7, 3) -> 70
     * calculateWinningPercentage(5, 5) -> 50
     * calculateWinningPercentage(5, 10) -> 33
     *
     */
    public static int calculateWinningPercentage(int gamesWon, int gamesLost)
    {
        double winningPercentage = ((double) gamesWon / (gamesWon + gamesLost)) * 100;    // for percentage

        return (int) Math.round(winningPercentage);
    }


    /*
     * The calculatePointsScored function should calculate
     * the number of points a player scored in a game.
     *
     * shotPercentage = the percent of shots made
     * shotsTaken = the number of shots the player took
     * isThree = if true, the player shot a 3 pointer otherwise a 2
     *
     * calculatePointsScored(70, 10, false) -> 14
     * calculatePointsScored(70, 10, true) -> 21
     * calculatePointsScored(67, 15, false) -> 20
     *
     */
    public static int calculatePointsScored(int shotPercentage, int shotsTaken, boolean isThree)
    {
        int points;

        if (isThree) {
            points = (int) (shotPercentage / 100) * shotsTaken * 3;

        } else {
            points = (shotPercentage / 100) * shotsTaken * 2;
        }

        return points;
    }


    /*
     * Calculate the minimum number of shots that are required
     * to score the desired number of points.
     *
     * shotPercentage = the estimated % of shots that will go in (whole number)
     * desiredScore = the number of points you want to score
     * isThree = if true, the player will shoot a 3 pointer otherwise a 2
     *
     * Example:
     * If a player has a 50% scoring average, and he wants to score 10 points,
     * how many shots will he have to take (if he is NOT shooting 3 pointers)
     *
     * calculateShotsRequired(50, 10, false) -> 10
     *
     * calculateShotsRequired(50, 10, true) -> 8
     * calculateShotsRequired(75, 15, true) -> 7
     * calculateShotsRequired(80, 18, true) -> 8
     * calculateShotsRequired(67, 24, false) -> 18     *
     *
     */
    public static int calculateShotsRequired(int shotPercentage, int desiredScore, boolean isThree)
    {
        int pointsPerShot;

        if (isThree) {
            pointsPerShot = 3;
        } else {
            pointsPerShot = 2;
        }

        // Calculate the minimum number of shots needed without considering accuracy
        int minShots = (int) Math.ceil((double) desiredScore / pointsPerShot);

        // Adjust shots based on shotPercentage
        double accuracy = 1.0 / ((double) shotPercentage / 100.0);
        int shotsRequired = (int) Math.ceil(minShots * accuracy);

        return shotsRequired;
    }

}