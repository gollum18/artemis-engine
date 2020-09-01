package com.ae.items.consumables;

import com.ae.util.flyweights.ScrollFlyweight;

public class Scroll extends Consumable {
    private final ScrollFlyweight mFlyweight;

    public Scroll(ScrollFlyweight flyweight) {
        mFlyweight = flyweight;
    }

    public ScrollFlyweight getFlyweight() { return mFlyweight; }
}
