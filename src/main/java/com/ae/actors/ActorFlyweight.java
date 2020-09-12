package com.ae.actors;

import com.ae.resources.ResourceDataKeys;
import com.ae.util.Flyweight;
import org.json.JSONObject;

public abstract class ActorFlyweight extends Flyweight {
    public final int dMaxHitpoints;
    public final int dMaxStamina;
    public final int dXpOnKill;
    public final int dLevel;

    public ActorFlyweight(JSONObject actorData) {
        super(actorData);
        // TODO: Most of these statistics need to scale with character level/game stage
        dMaxHitpoints = actorData.getInt(ResourceDataKeys.KEY_MAX_HITPOINTS);
        dMaxStamina = actorData.getInt(ResourceDataKeys.KEY_MAX_STAMINA);
        dXpOnKill = actorData.getInt(ResourceDataKeys.KEY_XP_ON_KILL);
        dLevel = actorData.getInt(ResourceDataKeys.KEY_BASE_LEVEL);
    }
}
