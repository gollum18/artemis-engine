package com.ae.actors.creatures;

import com.ae.actors.Actor;

public class Creature extends Actor {
    private final CreatureFlyweight mFlyweight;

    public Creature(CreatureFlyweight flyweight) {
        mFlyweight = flyweight;
    }

    public CreatureFlyweight getFlyweight() { return mFlyweight; }
}
