package com.ae.items.consumables;

import com.ae.items.ItemFlyweight;
import com.ae.resources.ResourceDataKeys;
import com.ae.util.Flyweight;
import org.json.JSONObject;

public abstract class ConsumableFlyweight extends ItemFlyweight {
    public final int dMaxCharges;

    public ConsumableFlyweight(JSONObject consumableData) {
        super(consumableData);
        dMaxCharges = consumableData.getInt(ResourceDataKeys.KEY_MAX_CHARGES);
    }
}
