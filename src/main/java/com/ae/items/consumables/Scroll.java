package com.ae.items.consumables;

public class Scroll extends Consumable {
    private final ScrollFlyweight mFlyweight;

    public Scroll(ScrollFlyweight flyweight) {
        mFlyweight = flyweight;
    }

    public ScrollFlyweight getFlyweight() { return mFlyweight; }
}
