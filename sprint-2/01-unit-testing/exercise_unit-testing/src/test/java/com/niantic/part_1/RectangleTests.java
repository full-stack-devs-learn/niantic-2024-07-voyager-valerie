package com.niantic.part_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTests
{
    @Test
    public void getArea_shouldReturn_defaultValues()
    {
        Rectangle rectangle = new Rectangle();

        // arrange
        int width = 5;
        int height = 5;
        int expected = 25;

        // act
        int actual = rectangle.getArea(width, height);

        // assert
        assertEquals(expected, actual, "because the default values of 5 should still work.");
    }

    @Test
    public void getArea_shouldReturn_theProductOfPositiveNumbers()
    {
        Rectangle rectangle = new Rectangle();

        // arrange
        int width = 7;
        int height = 9;
        int expected = 63;

        // act
        int actual = rectangle.getArea(width, height);

        // assert
        assertEquals(expected, actual, "Because the area of a rectangle is found by multiplying the width by the height.");
    }

    @Test
    public void getArea_shouldReturn_zeroWhenMultiplied()
    {
        Rectangle rectangle = new Rectangle();

        // arrange
        int width = 0;
        int height = 9;
        int expected = 0;

        // act
        int actual = rectangle.getArea(width, height);

        // assert
        assertEquals(expected, actual, "Because the area of a rectangle when multipled by 0 is 0.");
    }

    @Test
    public void getArea_shouldNotReturn_theProductOfNegativeNumbers()
    {
        Rectangle rectangle = new Rectangle();

        // arrange
        int width = -5;
        int height = 10;
        int expected = 0;          // normally it would be w * h, but we can't return negative area

        // act
        int actual = rectangle.getArea(width, height);


        // assert
        assertEquals(expected, actual, "Because the area of a rectangle can't be negative, and both values must be greater than 0.");
    }

    @Test
    public void getPerimeter_shouldReturn_theSumOfTwoNumbersMultipliedByTwo()
    {
        Rectangle rectangle = new Rectangle();

        // arrange
        int width = 3;
        int height = 2;
        int expected = 10;

        // act
        int actual = rectangle.getPerimeter(width, height);

        // assert
        assertEquals(expected, actual, "Because the perimeter of a rectangle is 2 * (width + height)");
    }
}