package com.niantic.part_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QuizTests
{
    @Test
    public void getPercent_shouldReturn_studentScoresByPercentage()
    {

        // arrange
        int score = 85;
        int possiblePoints = 100;
        int expected = 85;
        String studentName = "Gerald";

        // act
        Quiz quiz = new Quiz(possiblePoints, studentName);
        quiz.setScore(score);
        int actual = quiz.getPercent();

        // assert
        assertEquals(expected, actual, "Because the percentage should be calculated correctly. Did you allow the calculation to be a double, and convert the data type back to int after it was done calculating?");
    }

    @Test
    public void getLetterGrade_shouldReturn_studentGradesA_whenScoreGreaterThanOrEqualTo90()
    {
        // arrange
        int score = 90;
        int possibleScore = 100;
        String studentName = "Mako";
        String expectedLetterGrade = "A";

        // act
        Quiz quiz = new Quiz(possibleScore, studentName);
        quiz.setScore(score);
        String actualLetterGrade = quiz.getLetterGrade();

        // assert
        assertEquals(expectedLetterGrade, actualLetterGrade, "Because a student can only receive an 'A' if their score is greater than or equal to 90.");

    }


    @Test
    public void getLetterGrade_shouldReturn_studentGradesB_whenScoreGreaterThanOrEqualTo80()
    {
        // arrange
        int score = 80;
        int possibleScore = 100;
        String studentName = "Mako";
        String expectedLetterGrade = "B";

        // act
        Quiz quiz = new Quiz(possibleScore, studentName);
        quiz.setScore(score);
        String actualLetterGrade = quiz.getLetterGrade();

        // assert
        assertEquals(expectedLetterGrade, actualLetterGrade, "Because a student can only receive a 'B' if their score is less than 90 but greater than or equal to 80.");
    }

    @Test
    public void getLetterGrade_shouldReturn_studentGradesC_whenScoreGreaterThanOrEqualTo70()
    {
        // arrange
        int score = 70;
        int possibleScore = 100;
        String studentName = "Mako";
        String expectedLetterGrade = "C";

        // act
        Quiz quiz = new Quiz(possibleScore, studentName);
        quiz.setScore(score);
        String actualLetterGrade = quiz.getLetterGrade();

        // assert
        assertEquals(expectedLetterGrade, actualLetterGrade, "Because a student can only receive a 'C' if their score is less than 80 but greater than or equal to 70.");
    }

    @Test
    public void getLetterGrade_shouldReturn_studentGradesD_whenScoreGreaterThanOrEqualTo60()
    {
        // arrange
        int score = 60;
        int possibleScore = 100;
        String studentName = "Mako";
        String expectedLetterGrade = "D";

        // act
        Quiz quiz = new Quiz(possibleScore, studentName);
        quiz.setScore(score);
        String actualLetterGrade = quiz.getLetterGrade();

        // assert
        assertEquals(expectedLetterGrade, actualLetterGrade, "Because a student can only receive a 'D' if their score is less than 70 but greater than or equal to 60.");
    }

    @Test
    public void getLetterGrade_shouldReturn_studentGradesF_whenScoreLessThan60()
    {
        // arrange
        int score = 59;
        int possibleScore = 100;
        String studentName = "Mako";
        String expectedLetterGrade = "F";

        // act
        Quiz quiz = new Quiz(possibleScore, studentName);
        quiz.setScore(score);
        String actualLetterGrade = quiz.getLetterGrade();

        // assert
        assertEquals(expectedLetterGrade, actualLetterGrade, "Because a student can only receive a 'F' if their score is less than 60.");
    }

    @Test
    public void getPercent_shouldNotReturn_negativePercents()
    {
        // arrange
        int score = -1;
        int possibleScore = 100;
        String studentName = "Mako";
        int expectedPercent = 0;

        // act
        Quiz quiz = new Quiz(possibleScore, studentName);
        quiz.setScore(score);
        int actualPercent = quiz.getPercent();

        // assert
        assertEquals(expectedPercent, actualPercent, "Because a score cannot be negative. The lowest possible score is 0.");
    }


    @Test
    public void getPercent_shouldReturn_positivePercentsNoGreaterThan100()
    {
        // arrange
        int score = 500;
        int possibleScore = 100;
        String studentName = "Mako";
        int expectedPercent = 100;

        // act
        Quiz quiz = new Quiz(possibleScore, studentName);
        quiz.setScore(score);
        int actualPercent = quiz.getPercent();

        // assert
        assertEquals(expectedPercent, actualPercent, "Because a score can only be positive, but not greater than 100%.");
    }

}