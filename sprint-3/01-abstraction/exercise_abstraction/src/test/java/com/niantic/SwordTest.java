package com.niantic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// maintains all the unit tests from WeaponTest
public class SwordTest {

    private Sword sword;

    @BeforeEach
    void setup(){
        sword = new Sword("Blasphemous Blade", 100);
        sword.setPercentCharged(0);
    }


    @Test
    public void attack_shouldIncrease_percentCharged()
    {
        int initialPercentCharged = sword.getPercentCharged();

        sword.attack();

        int expectedPercentCharged = Math.min(100, initialPercentCharged + 10);
        assertEquals(expectedPercentCharged, sword.getPercentCharged(), "percentCharged should increase by 10% after every attack, but percentCharged cannot exceed 100%.");
    }

    @Test
    public void powerAttack_shouldBe_quadrupledWithMaxPercentCharged()
    {
        sword.setPercentCharged(100);
        int baseDamage = sword.getDamage();
        int expectedDamage = baseDamage * 4;

        int actualDamage = sword.powerAttack();

        assertEquals(expectedDamage, actualDamage, "Damage should be quadrupled when percentCharge is 100.");
    }

    @Test
    public void powerAttack_should_returnRegularAttack_whenPercentCharged_lessThan50()
    {
        sword.setPercentCharged(0);

        int expectedDamage = sword.getDamage();

        assertEquals(expectedDamage, sword.powerAttack(), "Power attack should deal the same damage as a regular attack when percent charge is less than 50%.");
    }

    @Test
    public void powerAttack_should_reducePercentCharged_whenPercentCharged_greaterThan50_lessThan90()
    {
        sword.setPercentCharged(90);
        int expectedPercentCharged = sword.getPercentCharged() - 50;

        sword.powerAttack();

        int actualPercentCharged = sword.getPercentCharged();

        assertEquals(expectedPercentCharged, actualPercentCharged, "Percent charge should reduce by 50% when the charge is between 50-90%.");
    }

    @Test
    public void powerAttack_shouldBe_doubledWithMaxPercentCharged()
    {
        sword.setPercentCharged(50);
        int baseDamage = sword.getDamage();
        int expectedDamage = baseDamage * 2;

        int actualDamage = sword.powerAttack();

        assertEquals(expectedDamage, actualDamage, "Damage should be doubled with percentCharged between 50 and 90.");
        assertEquals(0, sword.getPercentCharged(), "PercentCharged should be reduced by 50% within this range.");
    }

    @Test
    public void powerAttack_shouldBe_normalAttack()
    {
        sword.setPercentCharged(25);
        int expectedDamage = sword.getDamage();

        int actualDamage = sword.powerAttack();

        assertEquals(expectedDamage, actualDamage, "Damage should be doubled with percentCharged between 50 and 90.");
        assertEquals(35, sword.getPercentCharged(), "PercentCharged should be reduced by 50% within this range.");
    }

    @Test
    public void getRange_shouldBe_one()
    {
        int expectedRange = 1;
        int actualRange = sword.getRange();

        assertEquals(expectedRange, actualRange, "Attack range should be 1 for sword users.");
    }
}
