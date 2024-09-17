package com.niantic.models;

import java.util.List;

public class StudentStatistics
{
    private List<Integer> scores;

    public StudentStatistics(List<Integer> scores)
    {
        this.scores = scores;
    }

    public List<Integer> getScores()
    {
        return scores;
    }

    public double getLowScore() {
        return scores.stream().mapToInt(Integer::intValue).min().orElse(0);
    }

    public double getAverageScore() {
        return scores.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }

    public double getHighScore() {
        return scores.stream().mapToInt(Integer::intValue).max().orElse(0);
    }
}
