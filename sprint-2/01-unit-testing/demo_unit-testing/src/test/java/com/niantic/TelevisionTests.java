package com.niantic;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class TelevisionTests
{
    private Television tv;

    @BeforeEach
    public void setup()
    {
        tv = new Television();
    }

    @Test
    public void newTv_shouldBeOff_whenCreated()
    {
        // arrange
        // act
        //Television tv = new Television();

        // assert
        assertFalse(tv.isOn(), "Because a new TV should be off.");
    }

    @Test
    public void togglePower_shouldTurnTvOn_WhenItIsOff()
    {
        // arrange
        //Television tv = new Television();
        int expectedChannel = 3;
        int expectedVolume = 2;

        // act
        tv.togglePower();

        // assert
        int actualChannel = tv.getCurrentChannel();
        int actualVolume = tv.getCurrentVolume();

        boolean isTvOn = tv.isOn();
        assertTrue(isTvOn, "Because the TV was off when I toggled the power.");
        assertEquals(expectedChannel, actualChannel, "Because the TV was just turned on.");
        assertEquals(expectedVolume, actualVolume, "Because the TV was just turned on.");
    }

    @Test
    public void changeChannel_shouldSucceed_whenChannelIsInRange()
    {
        // arrange
        int expectedChannel = 7;
        tv.togglePower();

        // act
        boolean didChannelChange = tv.changeChannel(expectedChannel);

        // assert
        assertTrue(didChannelChange, "Because the new channel was within the bounds of channels.");

        int actualChannel = tv.getCurrentChannel();
        assertEquals(expectedChannel, actualChannel, "Because the channel should have changed.");
    }

    @Test
    public void changeChannel_shouldFail_whenChannelIsAboveRange()
{
    // arrange
    int newChannel = 16;
    int expectedChannel = 3;
    tv.togglePower();

    // act
    boolean didChannelChange = tv.changeChannel(newChannel);

    int actualChannel = tv.getCurrentChannel();
    assertFalse(didChannelChange, "Because the new channel was not in the range of the available channels.");

    assertEquals(expectedChannel, actualChannel, "Because the channel needs to stay within the range of available channels.");
}
}