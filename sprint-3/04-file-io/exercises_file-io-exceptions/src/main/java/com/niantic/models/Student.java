package com.niantic.models;

public class Student
{
    private String firstName;
    private String lastName;
    private int lowScore;
    private double avgScore;
    private int highScore;

    public Student(String firstName, String lastName, int lowScore, double avgScore, int highScore)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.lowScore = lowScore;
        this.avgScore = avgScore;
        this.highScore = highScore;
    }

    public Student()
    {
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    public double getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(double avgScore) {
        this.avgScore = avgScore;
    }

    public int getLowScore() {
        return lowScore;
    }

    public void setLowScore(int lowScore) {
        this.lowScore = lowScore;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

}
