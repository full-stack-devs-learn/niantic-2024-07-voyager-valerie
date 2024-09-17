package com.niantic.models;

import java.util.ArrayList;
import java.util.List;

public class Student
{
    private String name;
    private StudentStatistics statistics;

    public Student(String name, StudentStatistics statistics)
    {
        this.name = name;
        this.statistics = statistics;
    }

    public Student()
    {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StudentStatistics getStatistics()
    {
        return statistics;
    }

}
