package com.ae.items.consumables;

import com.ae.resources.ResourceDataKeys;
import com.ae.util.flyweights.Flyweight;
import org.json.JSONObject;

public class PotionFlyweight extends Flyweight {
    private final int dId;
    private final String sName;

    public PotionFlyweight(JSONObject potionData) {
        dId = potionData.getInt(ResourceDataKeys.KEY_ID);
        sName = potionData.getString(ResourceDataKeys.KEY_NAME);
    }

    public int getId() { return dId; }

    public String getName() { return sName; }
}
