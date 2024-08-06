package com.niantic.part_3_challenge;

public class Refrigerator {
    private int currentTemperature;
    private int maxCapacity;
    private int available;
    private boolean isDoorOpen;

    public Refrigerator(int currentTemperature, int maxCapacity) {
        this.currentTemperature = currentTemperature;
        this.maxCapacity = maxCapacity;
        this.isDoorOpen = false;    // by default, the door is closed
    }

    public int getCurrentTemperature() {
        return currentTemperature;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getAvailable() {
        return available;
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

    public void addItem(int capacity) {
        available = maxCapacity - capacity;
        if (isDoorOpen) {
            if (available >= capacity && available + capacity <= maxCapacity) {
                available -= capacity; // Decrease available space by the item's capacity b/c there's less available space
            }
        } else
        {
            System.out.println("You cannot add that item because the fridge does not have enough room.");
        }
    }

    public void removeItem(int capacity) {
        if (isDoorOpen) {
                available += capacity; // Increase available space by the item's capacity b/c there's more available space
        }
    }
}