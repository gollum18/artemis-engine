package com.ae.items.consumables;

import com.ae.resources.ResourceDataKeys;
import com.ae.util.flyweights.Flyweight;
import org.json.JSONObject;

public class ScrollFlyweight extends Flyweight {
    private final int dId;
    private final String sName;

    public ScrollFlyweight(JSONObject scrollData) {
        dId = scrollData.getInt(ResourceDataKeys.KEY_ID);
        sName = scrollData.getString(ResourceDataKeys.KEY_NAME);
    }

    public int getId() { return dId; }

    public String getName() { return sName; }
}
