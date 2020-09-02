package com.ae.items.consumables;

import com.ae.items.consumables.ConsumableFlyweight;
import org.json.JSONObject;

public class PotionFlyweight extends ConsumableFlyweight {
    public PotionFlyweight(JSONObject potionData) {
        super(potionData);
    }
}
