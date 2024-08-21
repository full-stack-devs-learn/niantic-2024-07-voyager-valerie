package com.niantic;

public class Knight extends Character
{
    private int armor;

    public Knight(String name, int health, int level, int experience, int armor)
    {
        super(name, health, level, experience);
        this.armor = armor;
    }

    public int getArmor()
    {
        return armor;
    }

    public void armorBasedOnWizardMana(Wizard wizard)
    {
        if(wizard != null)
        {
            this.armor = wizard.getMana();
        }
    }

    @Override
    public void levelUp()
    {
        super.levelUp();
        if(!isDefeated()) armor += 5;
    }

    @Override
    public void takeDamage(int damage)
    {
        // so long as the armor is greater than or equal to the damage received, the knight won't take any damage
        if(armor >= damage)
        {
            damage = 0;

        }
        // otherwise, the armor protects as much damage as it can for the knight, and the knight receives the rest with their health
        else
        {
            damage -= armor;        // absorb dmg
        }

        // remainder hits knight BUT armor can be reused, so they won't lose it
        super.takeDamage(damage);
    }

    @Override
    public String specialAbility()
    {
        return "Armor Shield";
    }
}
