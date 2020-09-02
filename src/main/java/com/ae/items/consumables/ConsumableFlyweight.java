package com.ae.items.consumables;

import com.ae.util.Flyweight;
import org.json.JSONObject;

public abstract class ConsumableFlyweight extends Flyweight {
    public ConsumableFlyweight(JSONObject consumableData) {
        super(consumableData);
    }
}
