package com.ae.actors.creatures;

import com.ae.resources.ResourceDataKeys;
import com.ae.util.flyweights.Flyweight;
import org.json.JSONObject;

public class CreatureFlyweight extends Flyweight {
    private final int dId;
    private final String sName;

    public CreatureFlyweight(JSONObject creatureData) {
        dId = creatureData.getInt(ResourceDataKeys.KEY_ID);
        sName = creatureData.getString(ResourceDataKeys.KEY_NAME);
    }

    public int getId() { return dId; }

    public String getName() { return sName; }
}
