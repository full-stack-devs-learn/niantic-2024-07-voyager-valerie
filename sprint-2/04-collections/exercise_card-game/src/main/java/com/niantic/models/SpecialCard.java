package com.niantic.models;

public class SpecialCard extends Card
{
    private String type;

    public SpecialCard(String color, String type)
    {
        super(color, -1);
        this.type = type;
    }

    public String getType()
    {
        return type;
    }

    @Override
    public String toString()
    {
        return getColor() + " " + type;
    }
}
