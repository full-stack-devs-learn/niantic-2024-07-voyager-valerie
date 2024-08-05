package com.niantic.part_2_objects;

public class Circle
{
    private final double PI = Math.PI;
    private int radius;

    public Circle()
    {

    }

    public Circle(int radius)
    {
        this.radius = radius;
    }

    public int getRadius()
    {
        return radius;
    }

    public void setRadius(int radius)
    {
        this.radius = radius;
    }

    public double getArea()
    {
        return PI * Math.pow(radius, 2.0);
    }

    public int getDiameter()
    {
        return 2 * radius;
    }

    public double getCircumference()
    {
        return 2 * PI * radius;
    }
}
