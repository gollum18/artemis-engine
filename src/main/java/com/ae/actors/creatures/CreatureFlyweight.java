package com.ae.actors.creatures;

import com.ae.util.Flyweight;
import org.json.JSONObject;

public class CreatureFlyweight extends Flyweight {
    private final int dId;
    private final String sName;

    public CreatureFlyweight(JSONObject creatureData) {
        dId = creatureData.getInt(CreatureDataKeys.CREATURE_ID);
        sName = creatureData.getString(CreatureDataKeys.CREATURE_NAME);
    }

    public int getId() { return dId; }

    public String getName() { return sName; }
}
