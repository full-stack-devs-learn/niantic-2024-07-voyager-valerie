package com.niantic.part_2_objects;

public class MathTest
{
    private int score;
    private int possiblePoints;
    private String studentName;

    public MathTest(int possiblePoints, String studentName)
    {
        this.score = score;
    }

    public int getScore()
    {
        return score;
    }

    public void setScore(int score)
    {
        this.score = score;
    }

    public String getStudentName()
    {
        return studentName;
    }

    public int getPossiblePoints()
    {
        return possiblePoints;
    }

    public String getLetterGrade()
    {
        int percent = getPercent();

        if (percent > 89)
        {
            return "A";
        }
        else if (percent <= 89 && percent >= 80)
        {
            return "B";
        }
        else if (percent <= 79 && percent >= 70)
        {
            return "C";
        }
        else if (percent <= 69 && percent >= 60)
        {
            return "D";
        }
        else
        {
            return "F";
        }
    }

    public int getPercent()
    {
        return score;
    }
}
