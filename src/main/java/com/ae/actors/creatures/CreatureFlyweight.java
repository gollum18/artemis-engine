package com.ae.actors.creatures;

import com.ae.actors.ActorFlyweight;
import org.json.JSONObject;

public class CreatureFlyweight extends ActorFlyweight {
    public CreatureFlyweight(JSONObject creatureData) {
        super(creatureData);
    }
}
