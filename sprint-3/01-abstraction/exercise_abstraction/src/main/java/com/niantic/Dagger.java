package com.niantic;

public class Dagger extends Weapon
{
    private int daggerCount;

    public Dagger(String name, int damage, int daggerCount) {
        super(name, damage);
        this.daggerCount = daggerCount;
    }

    public int getDaggerCount()
    {
        return daggerCount;
    }

    @Override
    public int attack()
    {
        int addPercentCharge = Math.min(100, getPercentCharged() + 20);
        setPercentCharged(addPercentCharge);

        return getDamage();
    }

    @Override
    public int powerAttack()
    {
        int charge = getPercentCharged();
        int baseDamage = getDamage();

        if (charge == 100)
        {
            daggerCount--;
            setPercentCharged(0);
            return baseDamage * 3;
        }
        else
        {
            return baseDamage;
        }
    }

    @Override
    public int getRange()
    {
        return 10;
    }
}
