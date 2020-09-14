package com.ae.util;

import org.json.JSONObject;

public abstract class Entity {

    protected final Flyweight mFlyweight;

    public Entity(Flyweight fw) {
        mFlyweight = fw;
    }

    public Entity(Flyweight fw, JSONObject entityData) {
        mFlyweight = fw;
    }

    public Flyweight getFlyweight() { return mFlyweight; }

}
