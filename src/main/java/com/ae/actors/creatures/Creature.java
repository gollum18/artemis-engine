package com.ae.actors.creatures;

import com.ae.actors.Actor;
import com.ae.util.flyweights.CreatureFlyweight;

public class Creature extends Actor {
    private CreatureFlyweight mFlyweight;

    public Creature(CreatureFlyweight flyweight) {
        mFlyweight = flyweight;
    }

    public CreatureFlyweight getFlyweight() { return mFlyweight; }
}
