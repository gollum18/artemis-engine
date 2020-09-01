package com.ae.items.weapons;

import com.ae.items.Wearable;
import com.ae.util.flyweights.WeaponFlyweight;

public class Weapon extends Wearable {
    private final WeaponFlyweight mFlyweight;

    public Weapon(WeaponFlyweight flyweight) {
        mFlyweight = flyweight;
    }

    public WeaponFlyweight getFlyweight() { return mFlyweight; }
}
