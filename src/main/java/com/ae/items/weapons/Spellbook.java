package com.ae.items.weapons;

import com.ae.items.Wearable;
import com.ae.util.flyweights.SpellbookFlyweight;

/**
 *
 */
public class Spellbook extends Wearable {
    private final SpellbookFlyweight mFlyweight;

    public Spellbook(SpellbookFlyweight flyweight) {
        mFlyweight = flyweight;
    }

    public SpellbookFlyweight getFlyweight() { return mFlyweight; }
}
