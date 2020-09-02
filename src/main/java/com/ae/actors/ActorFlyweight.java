package com.ae.actors;

import com.ae.resources.ResourceDataKeys;
import com.ae.util.Flyweight;
import org.json.JSONObject;

public class ActorFlyweight extends Flyweight {
    public final int dHitpoints;
    public final int dStamina;

    public ActorFlyweight(JSONObject actorData) {
        super(actorData);
        dHitpoints = actorData.getInt(ResourceDataKeys.KEY_HITPOINTS);
        dStamina = actorData.getInt(ResourceDataKeys.KEY_STAMINA);
    }
}
