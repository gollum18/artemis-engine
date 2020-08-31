package com.ae.items.consumables;

import com.ae.util.Flyweight;
import org.json.JSONObject;

public class PotionFlyweight extends Flyweight {
    private final int dId;
    private final String sName;

    public PotionFlyweight(JSONObject potionData) {
        dId = potionData.getInt(PotionDataKeys.POTION_ID);
        sName = potionData.getString(PotionDataKeys.POTION_NAME);
    }

    public int getId() { return dId; }

    public String getName() { return sName; }
}
