package com.ae.actors;

import com.ae.util.Flyweight;
import org.json.JSONObject;

public class ActorFlyweight extends Flyweight {
    public ActorFlyweight(JSONObject actorData) {
        super(actorData);
    }
}
