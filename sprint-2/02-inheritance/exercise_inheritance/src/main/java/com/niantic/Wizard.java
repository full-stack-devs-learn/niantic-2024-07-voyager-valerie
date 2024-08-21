package com.niantic;

public class Wizard extends Character
{
    private int mana;


    public Wizard(String name, int health, int level, int experience, int mana)
    {
        super(name, health, level, experience);
        this.mana = mana;
    }

    public int getMana()
    {
        return mana;
    }

    public void increaseMana()
    {
        mana += 10;
    }


    @Override
    public String specialAbility()
    {
        return "Cast Spells";
    }

    public void castSpell(Character target)
    {
        // first check if the character was defeated
        if(isDefeated())
        {
            System.out.println(this.getName() + " was defeated and can't cast spells in the afterlife.");
            return;
        }

        // if they weren't defeated, check if they have enough mana to cast the spell
        if(mana >= 10)
        {
            mana -= 10;             // used spell, so use mana

            int spellDamage = 2 * attackDamage;     // spell does 2x normal attack dmg

            System.out.println(this.getName() + " casts a spell on " + target.getName());

            target.takeDamage(spellDamage);
        }
        else
        {
            System.out.println(this.getName() + " doesn't have enough mana to cast their spell.");
        }
    }

    public void regenerateMana(int amount)
    {
        if(!isDefeated())
        {
            mana += amount;
        }
        else
        {
            System.out.println(this.getName() + " was defeated and can't regenerate mana in the afterlife.");
            return;
        }

    }

    @Override
    public void levelUp()
    {
        super.levelUp();
        if(!isDefeated()) increaseMana();
    }

}
