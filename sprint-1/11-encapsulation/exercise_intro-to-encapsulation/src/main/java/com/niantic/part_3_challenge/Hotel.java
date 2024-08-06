package com.niantic.part_3_challenge;

public class Hotel
{
    private int numberOfRooms;
    private int numberOfSuites;
    private int bookedRooms;
    private int bookedSuites;

    public Hotel(int numberOfRooms, int numberOfSuites)
    {
        this.numberOfRooms = numberOfRooms;
        this.numberOfSuites = numberOfSuites;
    }

    public Hotel(int numberOfRooms, int numberOfSuites, int bookedRooms, int bookedSuites)
    {
        this.bookedRooms =  bookedRooms;
        this.bookedSuites = bookedSuites;
    }

    public int getNumberOfRooms()
    {
        return numberOfRooms;
    }

    public int getNumberOfSuites()
    {
        return numberOfSuites;
    }

    public int getBookedRooms()
    {
        return bookedRooms;
    }

    public int getBookedSuites()
    {
        return bookedSuites;
    }

    public int getAvailableRooms()
    {
        return numberOfRooms - bookedRooms;
    }

    public int getAvailableSuites()
    {
        return numberOfSuites - bookedSuites;
    }

    public int makeReservations(int numberOfRooms, boolean isSuite)
    {
        if (isSuite)
        {
            if (numberOfRooms <= getAvailableSuites())
            {
                bookedSuites += numberOfRooms;
            }
        }
    }
}
