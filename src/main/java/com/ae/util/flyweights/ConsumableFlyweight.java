package com.ae.util.flyweights;

import org.json.JSONObject;

public abstract class ConsumableFlyweight extends Flyweight {
    public ConsumableFlyweight(JSONObject consumableData) {
        super(consumableData);
    }
}
