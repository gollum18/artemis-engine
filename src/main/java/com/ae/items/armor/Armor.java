package com.ae.items.armor;

import com.ae.items.Wearable;
import com.ae.util.flyweights.ArmorFlyweight;

public class Armor extends Wearable {

    private final ArmorFlyweight mFlyweight;

    public Armor(ArmorFlyweight flyweight) {
        mFlyweight = flyweight;
    }

    public ArmorFlyweight getFlyweight() { return mFlyweight; }

}
