package com.niantic.part_1_sakila_dtos;

public class Actor
{
    private int id;
    private String first_name;
    private String last_name;

    public Actor()
    {

    }

    public Actor(int id, String first_name, String last_name)
    {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public int getActorId()
    {
        return id;
    }

    public void setActorId(int id)
    {
        this.id = id;
    }

    public String getFirstName()
    {
        return first_name;
    }

    public void setFirstName(String first_name)
    {
        this.first_name = first_name;
    }

    public String getLastName()
    {
        return last_name;
    }

    public void setLastName(String last_name)
    {
        this.last_name = last_name;
    }

    public String getFullName()
    {
        return first_name + " " + last_name;
    }
}
