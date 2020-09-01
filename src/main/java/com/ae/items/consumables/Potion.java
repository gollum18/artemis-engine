package com.ae.items.consumables;

import com.ae.util.flyweights.PotionFlyweight;

public class Potion extends Consumable {
    private final PotionFlyweight mFlyweight;

    public Potion(PotionFlyweight flyweight) {
        mFlyweight = flyweight;
    }

    public PotionFlyweight getFlyweight() { return mFlyweight; }
}
