package com.ae.actors;

import com.ae.util.Entity;
import org.json.JSONObject;

public abstract class Actor extends Entity {
    public Actor(ActorFlyweight fw) {
        super(fw);
    }

    public Actor(ActorFlyweight fw, JSONObject stateData) {
        super(fw, stateData);
    }
}
