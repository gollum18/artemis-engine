package com.ae.actors.humans;

import com.ae.actors.Actor;

public abstract class Human extends Actor {
    public Human(HumanFlyweight flyweight) { super(flyweight); }
}
