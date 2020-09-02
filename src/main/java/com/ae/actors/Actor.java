package com.ae.actors;

import org.json.JSONObject;

public abstract class Actor {
    public final ActorFlyweight mFlyweight;

    public Actor(ActorFlyweight fw) { mFlyweight = fw; }

    public Actor(ActorFlyweight fw, JSONObject stateData) {
        mFlyweight = fw;
    }
}
