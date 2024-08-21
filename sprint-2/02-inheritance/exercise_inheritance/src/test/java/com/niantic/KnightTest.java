package com.niantic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

public class KnightTest
{
    @Test
    public void getArmour_shouldReturn_wizardMana()
    {
        // arrange
        int mana = 50;
        int expectedArmor = mana;

        Wizard wizard = new Wizard("Gandalf", 80, 5, 150, mana);
        Knight knight = new Knight("Steve", 100, 1, 50, 20);

        // act
        knight.armorBasedOnWizardMana(wizard);
        int actualArmor = knight.getArmor();

        // assert
        assertEquals(expectedArmor, actualArmor, "Beacuse the knight's armor should be the same as the wizard's mana levels.");
    }

    @Test
    public void levelUp_shouldNot_increase_armorHealthOrMana_forDefeatedKnight()
    {
        // arrange
        int expectedHealth = 0;
        int expectedLevel = 3;
        int expectedArmor = 40;

        // act
        Knight knight = new Knight("Marco", expectedHealth, expectedLevel, 150, expectedArmor);
        knight.levelUp();

        // assert
        int actualHealth = knight.getHealth();
        int actualLevel = knight.getLevel();
        int actualArmor = knight.getArmor();

        assertEquals(expectedHealth, actualHealth, "Because the knight is defeated, so they should NOT have leveled up.");
        assertEquals(expectedLevel, actualLevel, "Because the knight is defeated, so they should NOT have leveled up.");
        assertEquals(expectedArmor, actualArmor, "Because the knight is defeated, so they should NOT have leveled up.");
    }

    @Test
    public void levelUp_shouldReturn_MoreArmorBy5()
    {
        // arrange
        int initialArmor = 50;
        int expectedArmor = initialArmor + 5;       // armor after lvling up

        // act
        Knight knight = new Knight("Reiner", 120, 5, 300, 50);
        knight.levelUp();           // should +5 from 50 = 55 here

        int actualArmor = knight.getArmor();

        // assert
        assertEquals(expectedArmor, actualArmor);
    }

    @Test
    public void takeDamage_shouldNotHappen_whenArmorIsGreaterThanOrEqualToDamageReceived()
    {
        // arrange
        int damage = 70;
        int armor = 80;
        int expectedHealth = 300;

        // act
        Knight knight = new Knight("Annie", expectedHealth, 10, 1000, armor);
        knight.takeDamage(damage);

        int actualHealth = knight.getHealth();

        // assert
        assertEquals(expectedHealth, actualHealth, "Because the knight should NOT take damage if their armor is stronger than the damage they took.");
    }

    @Test
    public void takeDamage_shouldHappen_whenArmorIsLessThanDamageReceived()
    {
        // arrange
        int damage = 100;
        int armor = 80;
        int initialHealth = 300;
        int expectedHealth = initialHealth - (damage - armor);

        // act
        // don't need to apply knight.takeDamage(damage) because the damage is dealt in the function
        Knight knight = new Knight("Annie", expectedHealth, 10, 1000, armor);

        int actualHealth = knight.getHealth();

        // assert
        assertEquals(expectedHealth, actualHealth, "Because the knight should take whatever damage their armor couldn't protect them from.");
    }
}
