package com.niantic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DaggerTest {
    private Dagger dagger;

    @BeforeEach
    void setup()
    {
        dagger = new Dagger("Tanto", 50, 25);

    }

    @Test
    public void attack_shouldBe_defaultDamage_and_IncreasePercentCharged()
    {
        dagger.setPercentCharged(70);
        int initialPercentCharged = dagger.getPercentCharged();

        dagger.attack();

        int expectedPercentCharged = Math.min(100, initialPercentCharged + 20);

        assertEquals(expectedPercentCharged, dagger.getPercentCharged());
    }

    @Test
    public void powerAttack_shouldReturn_tripledDamage()
    {
        dagger.setPercentCharged(100);

        int baseDamage = dagger.getDamage();
        int expectedDamage = baseDamage * 3;

        int actualDamage = dagger.powerAttack();

        assertEquals(expectedDamage, actualDamage, "The power attack should be 3x the normal attack.");
    }

    @Test
    public void powerAttack_should_reduceDaggerCount_byOne()
    {
        dagger.setPercentCharged(100);

        int expectedDaggerCount = 24;

        dagger.powerAttack();

        assertEquals(expectedDaggerCount, dagger.getDaggerCount(), "After using the power attack, the dagger count should decrease by 1.");
    }

    @Test
    public void powerAttack_should_resetPercentCharged()
    {
        dagger.setPercentCharged(100);

        dagger.powerAttack();

        assertEquals(0, dagger.getPercentCharged(), "Using the power attack should reset percent charged");
    }

    @Test
    public void getRange_shouldReturn_10()
    {
        int actualRange = dagger.getRange();
        int expectedRange = 10;

        assertEquals(expectedRange, actualRange, "Dagger range should be 10.");
    }
}
