package com.niantic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTests
{
    @Test
    public void add_shouldReturn_sumOfNumbers()
    {
        // arrange
        Calculator calculator = new Calculator();
        double firstNumber = 10;
        double secondNumber = 3;
        double expected = 13;

        // act
        double actual = calculator.add(firstNumber, secondNumber);

        // assert
        assertEquals(expected, actual);
    }
}