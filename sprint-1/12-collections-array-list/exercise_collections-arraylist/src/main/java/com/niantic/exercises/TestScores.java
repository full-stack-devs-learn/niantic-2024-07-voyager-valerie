package com.niantic.exercises;

import com.niantic.models.TestScore;

import java.util.ArrayList;

public class TestScores
{

    /*
    1.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores and the name of a test - return all scores for the
        requested tests.
     */
    public ArrayList<TestScore> getScoresByTest(ArrayList<TestScore> testScores, String testName)
    {
        ArrayList<TestScore> scores = new ArrayList<>();

        for (TestScore score : testScores)
        {
            if (score.getTestName().equals(testName))
        {
            scores.add(score);
        }
        }
        return scores;
    }


    /*
    2.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores and the name of a student - return all scores for the
        requested student.
     */
    public ArrayList<TestScore> getScoresByStudent(ArrayList<TestScore> testScores, String student)
    {
        ArrayList<TestScore> studentScores = new ArrayList<>();

        for (TestScore score : testScores)
        {
            if (score.getStudentName().equals(student))
            {
                studentScores.add(score);
            }
        }

        return studentScores;
    }

    /*
    3.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the highest score.
     */
    public int getHighestScore(ArrayList<TestScore> testScores)
    {
        int highestScore = 0;

        for (TestScore score: testScores)
        {
            int currentScore = score.getScore();     // retrieving the value, so it's not an instance but an integer
            if (currentScore > highestScore)
            {
                highestScore = currentScore;
            }
        }
        return highestScore;
    }

    /*
    4.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the lowest score.
     */
    public int getLowestScore(ArrayList<TestScore> testScores)
    {
        int lowestScore = Integer.MAX_VALUE;    // to ensure that I'm actually finding the lowest value in the arraylist

        for (TestScore score : testScores)
        {
            int currentScore = score.getScore();  // the value we're using right now, as an integer and not an instance

            if (currentScore < lowestScore)
            {
                lowestScore = currentScore;
            }
        }
        return lowestScore;
    }

    /*
    5.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the average score.
     */
    public int getAverageScore(ArrayList<TestScore> testScores)
    {
        int sum = 0;       // what do all the numbers add up to?
        int count = 0;     // how many numbers are in this list?

        for (TestScore score : testScores)
        {
            int currentScore = score.getScore();    // retrieve score to help calculate sum
            sum += currentScore;                    // add the current value to sum
            count++;                                // represents the numbers we've iterated through
        }

        return sum / count;                         // computes average
    }

    /*
    6.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the highest score for the specified test name.
     */
    public int getHighestScoreByTest(ArrayList<TestScore> testScores, String testName)
    {
        int highestScore = 0;

        for (TestScore score : testScores)
        {
            int currentScore = score.getScore();

            if(score.getTestName().equals(testName) && (currentScore > highestScore))
            {
                highestScore = currentScore;
            }
        }

        return highestScore;
    }

    /*
    7.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the lowest score for the specified test name.
     */
    public int getLowestScoreByTest(ArrayList<TestScore> testScores, String testName)
    {
        int lowestScore = Integer.MAX_VALUE;   // initialized to max value to ensure the real min is found

        for (TestScore score : testScores)
        {
            int currentScore = score.getScore();

            if (score.getTestName().equals(testName) && currentScore < lowestScore)
            {
                lowestScore = currentScore;
            }
        }
        return lowestScore;
    }

    /*
    8.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the average score for the specified test name.
     */
    public int getAverageScoreByTest(ArrayList<TestScore> testScores, String testName)
    {
        int sum = 0;
        int count = 0;

        for (TestScore score : testScores)
        {
            int currentScore = score.getScore();

            if (score.getTestName().equals(testName))
            {
                sum += currentScore;
                count ++;
            }
        }

        return sum / count;
    }

    /*
    9.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the highest score for the specified student.
     */
    public int getHighestScoreByStudent(ArrayList<TestScore> testScores, String student)
    {
        int studentHighestScore = 0;

        for (TestScore score : testScores)
        {
            int currentScore = score.getScore();

            if (score.getStudentName().equals(student) && currentScore > studentHighestScore)
            {
                studentHighestScore = currentScore;
            }
        }
        return studentHighestScore;
    }

    /*
    10.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the lowest score for the specified student.
     */
    public int getLowestScoreByStudent(ArrayList<TestScore> testScores, String student)
    {
        int studentLowestScore = Integer.MAX_VALUE;

        for (TestScore score : testScores)
        {
            int currentScore = score.getScore();
            if(score.getStudentName().equals(student) && currentScore < studentLowestScore)
            {
                studentLowestScore = currentScore;
            }
        }

        return studentLowestScore;
    }

    /*
    11.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the average score for the specified student.
     */
    public int getAverageScoreByStudent(ArrayList<TestScore> testScores, String student)
    {
        int sum = 0;
        int count = 0;

        for (TestScore score : testScores)
        {
            int currentScore = score.getScore();
            if (score.getStudentName().equals(student))
            {
                sum += currentScore;
                count++;
            }
        }

        return sum / count;
    }
}
