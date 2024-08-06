package com.niantic.part_3_challenge;

public class Refrigerator {
    private int currentTemperature;
    private int maxCapacity;
    private int availableCapacity;
    private boolean isDoorOpen;

    public Refrigerator(int currentTemperature, int maxCapacity) {
        this.currentTemperature = currentTemperature;
        this.availableCapacity = maxCapacity;
        this.isDoorOpen = false;    // by default, the door is closed
    }

    public int getCurrentTemperature() {
        return currentTemperature;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getAvailableCapacity() {
        return availableCapacity;
    }


    public void fridgeTemp()
    {
        if (-1 > currentTemperature || currentTemperature >= 35)
        {
            System.out.println("Invalid fridge temperature. Please choose a number between 0 and 35.");
        }
    }

    public boolean isDoorOpen() {
        return isDoorOpen;
    }

    public void openDoor() {
        isDoorOpen = true;
    }

    public void closeDoor() {
        isDoorOpen = false;
    }

    public boolean addItem(int capacity) {
        if (isDoorOpen) {
            if (capacity <= 0)
            {
                System.out.println(("Invalid item capacity."));
                return false;
            }
            if (availableCapacity >= capacity) {
                availableCapacity -= capacity; // Decrease available space by the item's capacity
                return true;
            }
            else
            {
                System.out.println("Not enough space to add item.");
                return false;
            }
        }
        else
        {
            System.out.println("The door is closed. Please open the door before adding any items.");
            return false;
        }
    }

    public void removeItem(int capacity) {
        if (isDoorOpen)
        {
            availableCapacity += capacity; // Increase available space by the item's capacity
        }
        else
        {
            System.out.println("The door is closed. Please open the door before removing any items.");

        }
    }
}
