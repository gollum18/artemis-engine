package com.ae.util.flyweights;

import org.json.JSONObject;

public class CreatureFlyweight extends Flyweight {
    public CreatureFlyweight(JSONObject creatureData) {
        super(creatureData);
    }
}
