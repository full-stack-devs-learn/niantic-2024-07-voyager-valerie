package com.niantic;

public class Sword extends Weapon
{
    public Sword(String name, int damage) {
        super(name, damage);

    }

    @Override
    public int attack() {
        int addPercentCharged = Math.min(100, getPercentCharged() + 10);
        setPercentCharged(addPercentCharged);

        return getDamage();
    }

    @Override
    public int powerAttack() {
        int charge = getPercentCharged();
        int damage = attack();

        if(charge == 100)
        {
            damage = damage * 4;

            setPercentCharged(0);
            return damage;
        }
        else if (charge >= 50 && charge <= 90)
        {
            damage = damage * 2;
            charge = charge - 50;

            setPercentCharged(charge);
            return damage;
        }
        else
        {
            return damage;
        }
    }

    @Override
    public int getRange() {
        return 1;
    }
}
