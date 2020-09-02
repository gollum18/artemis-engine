package com.ae.items.consumables;

public class Potion extends Consumable {
    private final PotionFlyweight mFlyweight;

    public Potion(PotionFlyweight flyweight) {
        mFlyweight = flyweight;
    }

    public PotionFlyweight getFlyweight() { return mFlyweight; }
}
