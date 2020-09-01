package com.ae.util.flyweights;

import org.json.JSONObject;

public class PotionFlyweight extends ConsumableFlyweight {
    public PotionFlyweight(JSONObject potionData) {
        super(potionData);
    }
}
