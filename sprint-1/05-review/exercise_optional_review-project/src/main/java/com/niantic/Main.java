package com.niantic;

import java.util.Scanner;

public class Main
{
    private static Scanner userInput = new Scanner(System.in);
    private static int[] scores = new int[0];

    public static void main(String[] args)
    {
        while(true)
        {
            int choice = getHomeSelection();

            switch(choice)
            {
                case 1:
                    createNewTestScores();
                    break;
                case 2:
                    calculateAverage();
                    break;
                case 3:
                    findHighestScore();
                    break;
                case 4:
                    findLowestScore();
                    break;
                case 0:
                    System.out.println("Thanks for playing!");
                    System.out.println("Good bye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid selection!");
                    break;
            }
        }
    }

    public static int getHomeSelection()
    {
        System.out.println();
        System.out.println("Welcome to Score Calculator!");
        System.out.println("------------------------------");
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println("1) Enter new test scores");
        System.out.println("2) Calculate the class average");
        System.out.println("3) Find the highest score");
        System.out.println("4) Find the lowest score");
        System.out.println("0) Exit");

        System.out.println();

        System.out.print("Please select an option: ");
        return Integer.parseInt(userInput.nextLine());
    }

    private static void createNewTestScores()
    {
        System.out.println("How many test scores would you like to enter?");
        int numberOfTestScores = userInput.nextInt();     // collects the number of test scores the user wants to input --> helps us create the size of the array
        userInput.nextLine();

        scores = new int[numberOfTestScores];      // creates an array to carry all the test scores the user wants to input

        System.out.println("What are the test scores?");
        for (int i = 0; i < scores.length; i++) {
            scores[i] = userInput.nextInt();
        }
        userInput.nextLine();

        System.out.println("Perfect! I've received your scores and will return you to the main menu.");
    }

    private static void calculateAverage()
    {
        int sumOfScores = 0;
        for (int i = 0; i < scores.length; i++) {
            sumOfScores += scores[i];
        }
        int averageOfScores = sumOfScores / scores.length;

        System.out.println("Based on the scores you gave me, here is the class average: " + averageOfScores + "%");
    }

    private static void findHighestScore()
    {
        int highest = scores[0];
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > highest) {
                highest = scores[i];
            }
        }
        System.out.println("Highest score in the class: " + highest + "%");
    }

    private static void findLowestScore()
    {
        int lowest = scores[0];

        for (int i = 0; i < scores.length; i++) {
            if(scores[i] > lowest) {
                lowest = scores[i];
            }
        }
        System.out.println("Lowest score in the class: " + lowest + "%");
    }
}